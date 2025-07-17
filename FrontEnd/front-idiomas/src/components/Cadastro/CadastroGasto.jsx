import styles from "../../styles/LoginForm.module.css";
import Input from "./../Input";
import Button from "./../Button";
import { useState } from "react";

const CadastroGastoForm = () => {
  const [descricao, setDescricao] = useState("");
  const [valor, setValor] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();

    const novoGasto = {
      descricao,
      valor: parseFloat(valor),
    };

    fetch("http://localhost:8080/gastos?funcionarioId=4", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(novoGasto),
    })
      .then((res) => {
        if (!res.ok) throw new Error("Erro ao cadastrar gasto");
        alert("Gasto cadastrado com sucesso!");
        // Redirecionar ou limpar campos
        setDescricao("");
        setValor("");
      })
      .catch((err) => alert("Erro: " + err.message));
  };

  return (
    <form onSubmit={handleSubmit} className={styles.card}>
      <h2 className={styles.title}>Cadastrar gasto</h2>

      <label className={styles.label}>Descrição</label>
      <Input
        type="text"
        value={descricao}
        onChange={(e) => setDescricao(e.target.value)}
      />

      <label className={styles.label}>Valor (R$)</label>
      <Input
        type="number"
        step="0.01"
        value={valor}
        onChange={(e) => setValor(e.target.value)}
      />

      <Button text="Cadastrar" />
    </form>
  );
};

export default CadastroGastoForm;
