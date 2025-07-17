import styles from "../../styles/LoginForm.module.css";
import Input from "./../Input";
import Button from "./../Button";
import { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";

const EditarGastoForm = () => {
  const { id } = useParams();
  const navigate = useNavigate();
  const [descricao, setDescricao] = useState("");
  const [valor, setValor] = useState("");

  useEffect(() => {
    fetch(`http://localhost:8080/gastos/${id}`)
      .then((res) => res.json())
      .then((data) => {
        setDescricao(data.descricao);
        setValor(data.valor);
      })
      .catch((err) => alert("Erro ao carregar gasto: " + err.message));
  }, [id]);

  const handleSubmit = (e) => {
    e.preventDefault();

    const gastoAtualizado = {
      descricao,
      valor: parseFloat(valor),
    };

    fetch(`http://localhost:8080/gastos/${id}?funcionarioId=4`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(gastoAtualizado),
    })
      .then((res) => {
        if (!res.ok) throw new Error("Erro ao editar gasto");
        alert("Gasto atualizado com sucesso!");
        navigate("/gastos");
      })
      .catch((err) => alert("Erro: " + err.message));
  };

  return (
    <form onSubmit={handleSubmit} className={styles.card}>
      <h2 className={styles.title}>Editar gasto</h2>

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

      <Button text="Salvar alterações" />
    </form>
  );
};

export default EditarGastoForm;
