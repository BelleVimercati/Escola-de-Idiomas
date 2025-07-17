import styles from "../styles/Header.module.css";
import { Link } from "react-router-dom";
import Button from "./Button";
import { useNavigate } from "react-router-dom";


const Header = () => {
  const navigate = useNavigate();
  const logout = () => {
    localStorage.removeItem("token");
    navigate("/");
  };

  return (
    <header className={styles.header}>
      <Link to="/main" className={styles.title}>
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
        <Link to="/gastos" className={styles.button}>
          Gastos
        </Link>
        <Button
          onClick={logout}
          className={styles.buttonLogout}
          text="Logout"
        ></Button>
      </nav>
    </header>
  );
};

export default Header;
