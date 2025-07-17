import styles from "../../styles/LoginForm.module.css";
import Input from "../Input";
import Button from "../Button";
import { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";

const EditarProfessorForm = () => {
  const { id } = useParams();
  const navigate = useNavigate();

  const [nome, setNome] = useState("");
  const [email, setEmail] = useState("");
  const [matricula, setMatricula] = useState("");
  const [endereco, setEndereco] = useState("");
  const [telefone, setTelefone] = useState("");
  const [salario, setSalario] = useState("");

  useEffect(() => {
    fetch(`http://localhost:8080/professores/${id}`)
      .then((res) => res.json())
      .then((data) => {
        setNome(data.nome);
        setEmail(data.email);
        setMatricula(data.matricula);
        setEndereco(data.endereco);
        setTelefone(data.telefone);
        setSalario(data.salario);
      })
      .catch((err) => alert("Erro ao carregar professor: " + err.message));
  }, [id]);

  const handleSubmit = (e) => {
    e.preventDefault();

    const professorAtualizado = {
      nome,
      email,
      matricula: parseInt(matricula),
      endereco,
      telefone,
      salario: parseFloat(salario),
    };

    fetch(`http://localhost:8080/professores/${id}`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(professorAtualizado),
    })
      .then((res) => {
        if (!res.ok) throw new Error("Erro ao editar professor");
        alert("Professor atualizado com sucesso!");
        navigate("/professores"); // ajuste conforme sua rota de listagem
      })
      .catch((err) => alert("Erro: " + err.message));
  };

  return (
    <form onSubmit={handleSubmit} className={styles.card}>
      <h2 className={styles.title}>Editar professor</h2>

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

      <label className={styles.label}>Matrícula</label>
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

      <label className={styles.label}>Salário</label>
      <Input
        type="number"
        step="0.01"
        value={salario}
        onChange={(e) => setSalario(e.target.value)}
      />

      <Button text="Salvar alterações" />
    </form>
  );
};

export default EditarProfessorForm;
