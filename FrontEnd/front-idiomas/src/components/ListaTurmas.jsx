import React, { useEffect, useState } from "react";
import styles from "../styles/Lista.module.css";

const ListaTurmas = () => {
  const [turmas, setTurmas] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/turmas")
      .then((res) => res.json())
      .then((data) => setTurmas(data))
      .catch((err) => console.error("Erro ao buscar turmas:", err));
  }, []);

  const handleEditar = (id) => {
    console.log("Editar turmas com ID:", id);
    // Aqui você pode redirecionar para a página de edição, ex:
    // navigate(`/professores/editar/${id}`);
  };

  const handleExcluir = (id) => {
    const confirmacao = window.confirm("Tem certeza que deseja excluir?");
    if (!confirmacao) return;

    fetch(`http://localhost:8080/turmas/${id}?funcionarioId=2`, {
      method: "DELETE",
    })
      .then(() => {
        setTurmas((prev) => prev.filter((prof) => prof.id !== id));
      })
      .catch((err) => console.error("Erro ao excluir turmas:", err));
  };

  return (
    <div className={styles.container}>
      <table className={styles.tabela}>
        <thead>
          <tr>
            <th>Identificador</th>
            <th>Idioma</th>
            <th>Nível</th>
            <th>Data de Início</th>
            <th>Valor (R$)</th>
            <th>Ações</th>
          </tr>
        </thead>
        <tbody>
          {turmas.map((turma) => (
            <tr key={turma.id}>
              <td>{turma.identificador}</td>
              <td>{turma.idioma}</td>
              <td>{turma.nivel}</td>
              <td>{turma.data}</td>
              <td>{turma.valor?.toFixed(2)}</td>
              <td>
                <button
                  className={styles.editar}
                  onClick={() => handleEditar(turma.id)}
                >
                  Editar
                </button>
                <button
                  className={styles.excluir}
                  onClick={() => handleExcluir(turma.id)}
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

export default ListaTurmas;
