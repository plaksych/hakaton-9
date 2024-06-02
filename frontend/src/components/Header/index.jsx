import React from "react";
import styles from "./Header.module.scss";
import { Link } from "react-router-dom";

const Header = () => {
  console.log(styles);
  return (
    <header className={styles.root}>
      <div className={styles.container}>
        <div className={styles.navigation}>
          <ul>
            <li>Главная</li>
            <li>Популярные направления</li>
            <li>Личный кабинет</li>
          </ul>
        </div>
        <h1 className={styles.title}>Мы здесь ради вас!</h1>
      </div>
    </header>
  );
};

export default Header;
