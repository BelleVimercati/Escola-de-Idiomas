import React, { useEffect, useState } from "react";
import styles from "../styles/Lista.module.css";

const ListaAlunos = () => {
  const [Alunos, setAlunos] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/alunos")
      .then((res) => res.json())
      .then((data) => setAlunos(data))
      .catch((err) => console.error("Erro ao buscar alunos:", err));
  }, []);

  const handleEditar = (id) => {
    console.log("Editar aluno com ID:", id);
    // Aqui você pode redirecionar para a página de edição, ex:
    // navigate(`/Alunos/editar/${id}`);
  };

  const handleExcluir = (id) => {
    const confirmacao = window.confirm("Tem certeza que deseja excluir?");
    if (!confirmacao) return;

    fetch(`http://localhost:8080/alunos/${id}`, {
      method: "DELETE",
    })
      .then(() => {
        setAlunos((prev) => prev.filter((prof) => prof.id !== id));
      })
      .catch((err) => console.error("Erro ao excluir aluno:", err));
  };

  return (
    <div className={styles.container}>
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
          {Alunos.map((prof) => (
            <tr key={prof.id}>
              <td>{prof.nome}</td>
              <td>{prof.matricula}</td>
              <td>{prof.email}</td>
              <td>
                <button
                  className={styles.editar}
                  onClick={() => handleEditar(prof.id)}
                >
                  Editar
                </button>
                <button
                  className={styles.excluir}
                  onClick={() => handleExcluir(prof.id)}
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
