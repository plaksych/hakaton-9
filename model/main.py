from mymodel import *
    

df = pd.read_csv('data/cleaned-dataset.csv')
# df = preprocess_data(df)
# df.to_csv('cleaned-dataset.csv')

model = AviaPricePredictor()

X = df[['airline', 'dep_time', 'time_taken', 'stop_count', 'arr_time', 'stop_country']]
X = X.fillna('none')
y = df['price']  # Target variable to be predicted
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=0)
# X_train, y_train = X, y

model.fit(X_train, y_train)

import flask

app = flask.Flask(__name__)

@app.route('/predict')
def predict_route():
    data = {}
    for key, value in flask.request.args.items():
        data[key] = [value]
    
    for key in 'date,airline,ch_code,dep_time,from,time_taken,stop,arr_time,to'.split(','):
        if key not in data.keys():
            return str(f'key {key} required!')
        
    df = pd.DataFrame(data)
    df = preprocess_request(df)
    df = df[['airline', 'dep_time', 'time_taken', 'stop_count', 'arr_time', 'stop_country']]
    if df['stop_country'][0] == '':
        df['stop_country'][0] = 'none'

    try:
        return flask.jsonify(list(model.predict(df)))
    except Exception as exc:
        return str(exc)

if __name__ == '__main__':
    app.run(debug=True)