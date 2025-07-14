import styles from "../../styles/LoginForm.module.css";
import Input from "../Input";
import Button from "../Button";
import { useState } from "react";
import { useNavigate } from "react-router-dom";

const CadastroTurmaForm = () => {
  const navigate = useNavigate();

  const [identificador, setIdentificador] = useState("");
  const [idioma, setIdioma] = useState("INGLES");
  const [nivel, setNivel] = useState("BASICO");
  const [data, setData] = useState("");
  const [inicio, setInicio] = useState("");
  const [fim, setFim] = useState("");
  const [valor, setValor] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();

    const novaTurma = {
      identificador,
      idioma,
      nivel,
      data,
      inicio,
      fim,
      valor: parseFloat(valor),
    };

    fetch("http://localhost:8080/turmas?funcionarioId=2", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(novaTurma),
    })
      .then((res) => {
        if (!res.ok) throw new Error("Erro ao cadastrar turma");
        alert("Turma cadastrada com sucesso!");
        navigate("/turmas");
      })
      .catch((err) => alert("Erro: " + err.message));
  };

  return (
    <form onSubmit={handleSubmit} className={styles.card}>
      <h2 className={styles.title}>Cadastro de Turma</h2>

      <label className={styles.label}>Identificador</label>
      <Input
        type="text"
        value={identificador}
        onChange={(e) => setIdentificador(e.target.value)}
      />

      <label className={styles.label}>Idioma</label>
      <select
        className={styles.input}
        value={idioma}
        onChange={(e) => setIdioma(e.target.value)}
      >
        <option value="INGLES">Inglês</option>
        <option value="ESPANHOL">Espanhol</option>
        <option value="FRANCES">Francês</option>
      </select>

      <label className={styles.label}>Nível</label>
      <select
        className={styles.input}
        value={nivel}
        onChange={(e) => setNivel(e.target.value)}
      >
        <option value="BASICO">Básico</option>
        <option value="INTERMEDIARIO">Intermediário</option>
        <option value="AVANCADO">Avançado</option>
      </select>

      <label className={styles.label}>Data (início das aulas)</label>
      <Input
        type="date"
        value={data}
        onChange={(e) => setData(e.target.value)}
      />

      <label className={styles.label}>Horário de Início</label>
      <Input
        type="datetime-local"
        value={inicio}
        onChange={(e) => setInicio(e.target.value)}
      />

      <label className={styles.label}>Horário de Fim</label>
      <Input
        type="datetime-local"
        value={fim}
        onChange={(e) => setFim(e.target.value)}
      />

      <label className={styles.label}>Valor</label>
      <Input
        type="number"
        step="0.01"
        value={valor}
        onChange={(e) => setValor(e.target.value)}
      />

      <Button text="Cadastrar Turma" />
    </form>
  );
};

export default CadastroTurmaForm;
