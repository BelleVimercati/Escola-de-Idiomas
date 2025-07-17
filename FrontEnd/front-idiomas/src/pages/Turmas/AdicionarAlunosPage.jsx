import { useState, useEffect } from "react";
import { useParams, useNavigate } from "react-router-dom";
import styles from "../../styles/LoginForm.module.css";
import Input from "../../components/Input";
import Button from "../../components/Button";
import Container from "../../components/Container";

const AdicionarAlunoTurmaForm = () => {
  const { turmaId } = useParams();
  const navigate = useNavigate();
  const [alunoId, setAlunoId] = useState("");
  const [alunos, setAlunos] = useState([]);

  // Carrega todos os alunos disponíveis
  useEffect(() => {
    fetch("http://localhost:8080/alunos")
      .then((res) => res.json())
      .then((data) => setAlunos(data))
      .catch((err) => alert("Erro ao carregar alunos: " + err.message));
  }, []);

  const handleSubmit = (e) => {
    e.preventDefault();

    fetch(
      `http://localhost:8080/alunos/${alunoId}/adicionar-turma?turmaId=${turmaId}&funcionarioId=3`,
      {
        method: "PUT",
      }
    )
      .then((res) => {
        if (!res.ok) throw new Error("Erro ao adicionar aluno à turma");
        alert("Aluno adicionado à turma com sucesso!");
        navigate("/turmas");
      })
      .catch((err) => alert("Erro: " + err.message));
  };

  return (
    <Container>
      <form onSubmit={handleSubmit} className={styles.card}>
        <h2 className={styles.title}>Adicionar Aluno à Turma</h2>

        <label className={styles.label}>Selecione o Aluno</label>
        <select
          className={styles.input}
          value={alunoId}
          onChange={(e) => setAlunoId(e.target.value)}
          required
        >
          <option value="">-- Selecione um aluno --</option>
          {alunos.map((aluno) => (
            <option key={aluno.id} value={aluno.id}>
              {aluno.nome} (ID: {aluno.id})
            </option>
          ))}
        </select>

        <Button text="Adicionar" />
      </form>
    </Container>
  );
};

export default AdicionarAlunoTurmaForm;
