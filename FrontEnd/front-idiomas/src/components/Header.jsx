import styles from "../styles/Header.module.css";
import { Link } from "react-router-dom";

const Header = () => {
  return (
    <header className={styles.header}>
      <Link to="/" className={styles.title}>
        Sistema Escolar 📚
      </Link>

      <nav className={styles.nav}>
        <Link to="/professores" className={styles.button}>
          Professores
        </Link>
        <Link to="/turmas" className={styles.button}>
          Turmas
        </Link>
        <Link to="/aulas" className={styles.button}>
          Aulas
        </Link>
        <Link to="/alunos" className={styles.button}>
          Alunos
        </Link>
        <Link to="/relatorio" className={styles.button}>
          Relatorio
        </Link>
        <Link to="/logout" className={styles.button}>
          Sair
        </Link>
      </nav>
    </header>
  );
};

export default Header;
