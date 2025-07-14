import Header from "../components/Header";
import Container2 from "../components/Container2";
import styles from "../styles/Main.module.css";

const idiomas = ["Inglês", "Espanhol", "Francês"];
const niveis = ["Básico", "Intermediário", "Avançado"];

const MainPage = () => {
  return (
    <div>
      <Header />
      <Container2>
        <h1 className={styles.titulo}>Bem vindo à escolinha de PAS 👋</h1>

        <div style={{ display: "flex", gap: "50px", justifyContent: "center"}}>
          <div className={styles.card}>
            <h2>Idiomas oferecidos</h2>
            <ul>
              {idiomas.map((idioma, idx) => (
                <li key={idx}>{idioma}</li>
              ))}
            </ul>
          </div>
          <div className={styles.card}>
            <h2>Níveis disponíveis</h2>
            <ul>
              {niveis.map((nivel, idx) => (
                <li key={idx}>{nivel}</li>
              ))}
            </ul>
          </div>
        </div>
      </Container2>
    </div>
  );
};

export default MainPage;
