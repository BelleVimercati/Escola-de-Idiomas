import styles from "../styles/Header.module.css";

const Header = () => {
  return (
    <header className={styles.header}>
      <h1 className={styles.title}>Sistema Escolar 📚</h1>
      <nav className={styles.nav}>
        <a className={styles.button}>Professores</a>
        <a className={styles.button}>Turmas</a>
        <a className={styles.button}>Aulas</a>
        <a className={styles.button}>Alunos</a>
        <a className={styles.button} >Sair</a>
      </nav>
    </header>
  );
};

export default Header;
