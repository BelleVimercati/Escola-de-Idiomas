import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import styles from "../../styles/LoginForm.module.css";
import Input from "../../components/Input";
import Button from "../../components/Button";
import Container from "../../components/Container";

const CadastroAulaPage = () => {
  const navigate = useNavigate();

  const [data, setData] = useState("");
  const [inicio, setInicio] = useState("");
  const [fim, setFim] = useState("");
  const [professorId, setProfessorId] = useState("");
  const [turmaId, setTurmaId] = useState("");

  const [professores, setProfessores] = useState([]);
  const [turmas, setTurmas] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/professores")
      .then((res) => res.json())
      .then((data) => setProfessores(data))
      .catch((err) => alert("Erro ao carregar professores: " + err.message));

    fetch("http://localhost:8080/turmas")
      .then((res) => res.json())
      .then((data) => setTurmas(data))
      .catch((err) => alert("Erro ao carregar turmas: " + err.message));
  }, []);

  const handleSubmit = (e) => {
    e.preventDefault();

    const inicioCompleto = `${data}T${inicio}`;
    const fimCompleto = `${data}T${fim}`;

    const novaAula = {
      data,
      inicio: inicioCompleto,
      fim: fimCompleto,
      professor: {
        id: parseInt(professorId),
      },
      turma: {
        id: parseInt(turmaId),
      },
    };

    fetch(`http://localhost:8080/aulas?funcionarioId=3`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(novaAula),
    })
      .then((res) => {
        if (!res.ok) throw new Error("Erro ao cadastrar aula");
        return res.json();
      })
      .then(() => {
        alert("Aula cadastrada com sucesso!");
        navigate("/aulas");
      })
      .catch((err) => alert("Erro: " + err.message));
  };

  return (
    <Container>
      <form onSubmit={handleSubmit} className={styles.card}>
        <h2 className={styles.title}>Cadastro de Aula</h2>

        <label className={styles.label}>Data</label>
        <Input
          type="date"
          value={data}
          onChange={(e) => setData(e.target.value)}
          required
        />

        <label className={styles.label}>Início</label>
        <Input
          type="time"
          value={inicio}
          onChange={(e) => setInicio(e.target.value)}
          required
        />

        <label className={styles.label}>Fim</label>
        <Input
          type="time"
          value={fim}
          onChange={(e) => setFim(e.target.value)}
          required
        />

        <label className={styles.label}>Professor</label>
        <select
          className={styles.input}
          value={professorId}
          onChange={(e) => setProfessorId(e.target.value)}
          required
        >
          <option value="">-- Selecione um professor --</option>
          {professores.map((prof) => (
            <option key={prof.id} value={prof.id}>
              {prof.nome} (ID: {prof.id})
            </option>
          ))}
        </select>

        <label className={styles.label}>Turma</label>
        <select
          className={styles.input}
          value={turmaId}
          onChange={(e) => setTurmaId(e.target.value)}
          required
        >
          <option value="">-- Selecione uma turma --</option>
          {turmas.map((turma) => (
            <option key={turma.id} value={turma.id}>
              {turma.identificador} - {turma.idioma} ({turma.nivel})
            </option>
          ))}
        </select>

        <Button text="Cadastrar Aula" />
      </form>
    </Container>
  );
};

export default CadastroAulaPage;
