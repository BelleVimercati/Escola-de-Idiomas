import { useState } from "react";
import axios from "axios";
import styles from "../styles/LoginForm.module.css";
import Input from "./Input";
import Button from "./Button";

const LoginForm = () => {
  const [email, setEmail] = useState("");
  const [senha, setSenha] = useState("");

  const handleLogin = async () => {
    try {
      const response = await axios.post(
        // eslint-disable-next-line no-undef
        `${process.env.REACT_APP_API_URL}/login`,
        {
          email,
          senha,
        }
      );
      console.log("Login bem-sucedido:", response.data);
      // redirecionar ou armazenar token, etc.
    } catch (error) {
      console.error("Erro ao fazer login:", error);
    }
  };

  return (
    <div className={styles.card}>
      <h2 className={styles.title}>
        Entre na sua conta<span>👋</span>
      </h2>

      <label className={styles.label}>Email</label>
      <Input
        type="email"
        placeholder="email@dominio.com"
        value={email}
        onChange={(e) => setEmail(e.target.value)}
      />

      <label className={styles.label}>Senha</label>
      <Input
        type="password"
        placeholder="************"
        value={senha}
        onChange={(e) => setSenha(e.target.value)}
      />

      <Button text="Login" onClick={handleLogin} />
    </div>
  );
};

export default LoginForm;
