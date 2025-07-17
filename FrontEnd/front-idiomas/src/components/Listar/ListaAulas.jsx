import React, { useEffect, useState } from "react";
import styles from "../../styles/Lista.module.css";
import { useNavigate } from "react-router-dom";

const ListaAulas = () => {
  const navigate = useNavigate();

  const handleAdicionar = () => {
    navigate("/aulas/novo");
  };

  const [aulas, setAulas] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/aulas")
      .then((res) => res.json())
      .then((data) => setAulas(data))
      .catch((err) => console.error("Erro ao buscar aulas:", err));
  }, []);

  const handleEditar = (id) => {
    navigate(`/aulas/${id}/editar`);
  };

  const handleExcluir = (id) => {
    const confirmacao = window.confirm("Tem certeza que deseja excluir?");
    if (!confirmacao) return;

    fetch(`http://localhost:8080/aulas/${id}?funcionarioId=3`, {
      method: "DELETE",
    })
      .then(() => {
        setAulas((prev) => prev.filter((aulas) => aulas.id !== id));
      })
      .catch((err) => console.error("Erro ao excluir aulas:", err));
  };

  return (
    <div className={styles.container}>
      <button className={styles.adicionar} onClick={handleAdicionar}>
        Adicionar
      </button>

      <table className={styles.tabela}>
        <thead>
          <tr>
            <th>Turma ID</th>
            <th>Professor</th>
            <th>Data da aula</th>
            <th>Ações</th>
          </tr>
        </thead>
        <tbody>
          {aulas.map((aula) => (
            <tr key={aula.id}>
              <td>
                {aula.turma
                  ? `${aula.turma.identificador} - ${aula.turma.idioma} (${aula.turma.nivel})`
                  : "Turma não vinculada"}
              </td>
              <td>
                {aula.professor
                  ? `${aula.professor.nome} - ${aula.professor.matricula}`
                  : "Professor não vinculado"}
              </td>
              <td>{aula.data}</td>
              <td>
                <button
                  className={styles.editar}
                  onClick={() => handleEditar(aula.id)}
                >
                  Editar
                </button>
                <button
                  className={styles.excluir}
                  onClick={() => handleExcluir(aula.id)}
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

export default ListaAulas;
