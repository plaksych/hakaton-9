import pandas as pd
from sklearn.compose import ColumnTransformer
from sklearn.preprocessing import OneHotEncoder
from sklearn.preprocessing import StandardScaler
from sklearn.pipeline import Pipeline
from sklearn.linear_model import LinearRegression
from sklearn.model_selection import train_test_split
from sklearn.metrics import mean_squared_error, mean_absolute_error

def preprocess_request(df: pd.DataFrame):
    def process_stops(src):
        stops, *other = src.split()
        stops = ''.join(list(filter(lambda y: y.isdigit(), src)))
        if len(stops) == 0:
            stops = '0'

        # if len(stops) > 1:
        #     print(stops, other[1:])

        return pd.Series((int(stops), ' '.join(other[1:])))

    df[['stop_count', 'stop_country']] = df['stop'].apply(process_stops)

    def convert_time_taken(src):
        h, m = src.split()
        h = ''.join(list(filter(lambda x: x.isdigit() or x in ('.'), h)))
        m = ''.join(list(filter(lambda x: x.isdigit() or x in ('.'), m)))
        if len(m) == 0:
            m = '0'
        return int(float(h) * 60 + float(m))

    df['time_taken'] = df['time_taken'].apply(convert_time_taken)

    def convert_dep_arr(src):
        # print(src)
        h, m = src.split(':')
        return int(h) * 60 + int(m)

    df['dep_time'] = df['dep_time'].apply(convert_dep_arr)
    df['arr_time'] = df['arr_time'].apply(convert_dep_arr)
    df = df.drop('stop', axis=1)
    def test_func(x):
        # print(x)
        return f'{x[0]}-{x[1]}'
    df['from_to_merged'] = df[['from', 'to']].apply(test_func, axis=1)
    return df

def preprocess_data(df: pd.DataFrame):
    df = preprocess_request(df)
    df['price'] = df['price'].apply(lambda x: int(x.replace(',', '')))
    return df

class AviaPricePredictor:
    def __init__(self) -> None:        
        self.ct = ColumnTransformer(
        transformers=[
            ('time_taken', StandardScaler(), ['time_taken']),
            ('dep_time', StandardScaler(), ['dep_time']),
            ('arr_time', StandardScaler(), ['arr_time']),
            
            ('airline', OneHotEncoder(), ['airline']),
            ('stop_country', OneHotEncoder(), ['stop_country']),
            # ('from_to_merged', OneHotEncoder(), ['from_to_merged']),

            # ('from', OneHotEncoder(), ['from']),
            # ('to', OneHotEncoder(), ['to']),
        ],
        remainder='passthrough'
        )

        self.model = Pipeline(steps=[
            ('preprocessor', self.ct),
            ('regressor', LinearRegression())
        ])

    def fit(self, X, y):
        return self.model.fit(X, y)

    def predict(self, X):
        return self.model.predict(X)