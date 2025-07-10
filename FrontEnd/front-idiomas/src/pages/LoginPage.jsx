import styles from "../styles/LoginPage.module.css";
import Container from "../components/Container";
import LoginForm from "../components/LoginForm";

const LoginPage = () => {
  return (
    <div className={styles.TelaContainer}>
      <span className={styles.Span}>
        <div className={styles.textoContainer}>
          <p className={styles.texto}>Bem Vindo à Escola de Idiomas</p>
        </div>
      </span>
      <Container>
        <LoginForm />
      </Container>
    </div>
  );
};

export default LoginPage;
