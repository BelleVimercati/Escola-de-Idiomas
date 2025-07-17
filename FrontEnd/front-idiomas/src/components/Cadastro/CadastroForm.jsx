import styles from "../../styles/LoginForm.module.css";
import Input from "../Input";
import Button from "../Button";
import { useState } from "react";
import { useNavigate } from "react-router-dom";

const CadastroAlunoForm = () => {
  const navigate = useNavigate();

  const [nome, setNome] = useState("");
  const [email, setEmail] = useState("");
  const [senha, setSenha] = useState("");
  const [matricula, setMatricula] = useState("");
  const [endereco, setEndereco] = useState("");
  const [telefone, setTelefone] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();

    const novoAluno = {
      nome,
      email,
      senha,
      matricula: parseInt(matricula),
      endereco,
      telefone,
    };

    fetch("http://localhost:8080/alunos?funcionarioId=3", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(novoAluno),
    })
      .then((res) => {
        if (!res.ok) throw new Error("Erro ao cadastrar aluno");
        alert("Aluno cadastrado com sucesso!");
        navigate("/alunos"); // redirecionar para lista de alunos, se existir
      })
      .catch((err) => alert("Erro: " + err.message));
  };

  return (
    <form onSubmit={handleSubmit} className={styles.card}>
      <h2 className={styles.title}>Cadastro de alunos</h2>

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

      <label className={styles.label}>Senha</label>
      <Input
        type="password"
        value={senha}
        onChange={(e) => setSenha(e.target.value)}
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

      <Button text="Cadastrar" />
    </form>
  );
};

export default CadastroAlunoForm;
