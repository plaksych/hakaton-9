import React from "react";
import styles from "./Home.module.scss";
import PopularPlaces from "../components/PopularPlaces";

const Home = () => {
  const [active, setActive] = React.useState(0);
  return (
    <div className={styles.root}>
      <div className={styles.booking}>
        <div className={styles.naigation}>
          <div className={styles.container}>
            <ul>
              <li
                onClick={() => setActive(0)}
                className={`${styles.text} ${active === 0 && styles.active}`}
              >
                Купить билеты
              </li>
              <li
                onClick={() => setActive(1)}
                className={`${styles.text} ${active === 1 && styles.active}`}
              >
                Проверить статус вашего рейса
              </li>
            </ul>
          </div>
        </div>
      </div>
      <PopularPlaces name={"travel"} />
      <PopularPlaces name={"way"} />
    </div>
  );
};

export default Home;
