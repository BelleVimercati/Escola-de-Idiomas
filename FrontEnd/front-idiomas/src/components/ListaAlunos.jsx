import React, { useEffect, useState } from "react";
import styles from "../styles/Lista.module.css";
import { useNavigate } from "react-router-dom";

const ListaAlunos = () => {
  const navigate = useNavigate();
  const [Alunos, setAlunos] = useState([]);

  const handleAdicionar = () => {
    navigate("/alunos/novo");
  };

  useEffect(() => {
    fetch("http://localhost:8080/alunos")
      .then((res) => res.json())
      .then((data) => setAlunos(data))
      .catch((err) => console.error("Erro ao buscar alunos:", err));
  }, []);

  const handleEditar = (id) => {
    navigate(`/alunos/${id}/editar`);
  };

  const handleExcluir = (id) => {
    const confirmacao = window.confirm("Tem certeza que deseja excluir?");
    if (!confirmacao) return;

    fetch(`http://localhost:8080/alunos/${id}?funcionarioId=2`, {
      method: "DELETE",
    })
      .then(() => {
        setAlunos((prev) => prev.filter((prof) => prof.id !== id));
      })
      .catch((err) => console.error("Erro ao excluir aluno:", err));
  };

  return (
    <div className={styles.container}>
      <button className={styles.adicionar} onClick={handleAdicionar}>
        Adicionar
      </button>
      <table className={styles.tabela}>
        <thead>
          <tr>
            <th>Nome</th>
            <th>Matrícula</th>
            <th>Email</th>
            <th>Ações</th>
          </tr>
        </thead>
        <tbody>
          {Alunos.map((aluno) => (
            <tr key={aluno.id}>
              <td>{aluno.nome}</td>
              <td>{aluno.matricula}</td>
              <td>{aluno.email}</td>
              <td>
                <button
                  className={styles.editar}
                  onClick={() => handleEditar(aluno.id)}
                >
                  Editar
                </button>
                <button
                  className={styles.excluir}
                  onClick={() => handleExcluir(aluno.id)}
                >
                  Excluir
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ListaAlunos;
