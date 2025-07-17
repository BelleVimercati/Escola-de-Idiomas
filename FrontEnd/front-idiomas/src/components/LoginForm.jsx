import { useState } from "react";
import axios from "axios";
import styles from "../styles/LoginForm.module.css";
import Input from "./Input";
import Button from "./Button";
import {useNavigate } from "react-router-dom";


const LoginForm = () => {
  const [email, setEmail] = useState("");
  const [senha, setSenha] = useState("");
    const navigate = useNavigate();


  const handleLogin = async () => {
    try {
      const response = await axios.post(`http://localhost:8080/auth/login`, {
        email,
        senha,
      });

      const { token } = response.data;
      localStorage.setItem("token", token);

      navigate("/main");
    } catch (error) {
      console.error("Erro ao fazer login:", error);
      alert("Email ou senha inválidos");
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
