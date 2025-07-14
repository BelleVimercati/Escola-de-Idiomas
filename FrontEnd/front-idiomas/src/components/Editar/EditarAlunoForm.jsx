import styles from "../../styles/LoginForm.module.css";
import Input from "../Input";
import Button from "../Button";
import { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";

const EditarAlunoForm = () => {
  const { id } = useParams();
  const navigate = useNavigate();

  const [nome, setNome] = useState("");
  const [email, setEmail] = useState("");
  const [matricula, setMatricula] = useState("");
  const [endereco, setEndereco] = useState("");
  const [telefone, setTelefone] = useState("");

  useEffect(() => {
    fetch(`http://localhost:8080/alunos/${id}`)
      .then((res) => res.json())
      .then((data) => {
        setNome(data.nome);
        setEmail(data.email);
        setMatricula(data.matricula);
        setEndereco(data.endereco);
        setTelefone(data.telefone);
      })
      .catch((err) => alert("Erro ao carregar aluno: " + err.message));
  }, [id]);

  const handleSubmit = (e) => {
    e.preventDefault();

    const alunoAtualizado = {
      nome,
      email,
      matricula: parseInt(matricula),
      endereco,
      telefone,
    };

    fetch(`http://localhost:8080/alunos/${id}?funcionarioId=2`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(alunoAtualizado),
    })
      .then((res) => {
        if (!res.ok) throw new Error("Erro ao editar aluno");
        alert("Aluno atualizado com sucesso!");
        navigate("/alunos");
      })
      .catch((err) => alert("Erro: " + err.message));
  };

  return (
    <form onSubmit={handleSubmit} className={styles.card}>
      <h2 className={styles.title}>Editar aluno</h2>

      <label className={styles.label}>Nome</label>
      <Input
        type="text"
        value={nome}
        onChange={(e) => setNome(e.target.value)}
      />

      <label className={styles.label}>Email</label>
      <Input
        type="email"
        value={email}
        onChange={(e) => setEmail(e.target.value)}
      />

      <label className={styles.label}>Matricula</label>
      <Input
        type="text"
        value={matricula}
        onChange={(e) => setMatricula(e.target.value)}
      />

      <label className={styles.label}>Endereço</label>
      <Input
        type="text"
        value={endereco}
        onChange={(e) => setEndereco(e.target.value)}
      />

      <label className={styles.label}>Telefone</label>
      <Input
        type="text"
        value={telefone}
        onChange={(e) => setTelefone(e.target.value)}
      />

      <Button text="Salvar alterações" />
    </form>
  );
};

export default EditarAlunoForm;
