import React, { useEffect, useState } from "react";
import styles from "../../styles/Lista.module.css";
import { useNavigate } from "react-router-dom";

const ListaTurmas = () => {
  const navigate = useNavigate();
  const [turmas, setTurmas] = useState([]);
  const [alunosModal, setAlunosModal] = useState([]);
  const [modalAberto, setModalAberto] = useState(false);

  const handleAdicionar = () => {
    navigate("/turmas/novo");
  };

  useEffect(() => {
    fetch("http://localhost:8080/turmas")
      .then((res) => res.json())
      .then((data) => setTurmas(data))
      .catch((err) => console.error("Erro ao buscar turmas:", err));
  }, []);

  const handleEditar = (id) => {
    navigate(`/turmas/${id}/editar`);
  };

  const handleAdicionarTurma = (id) => {
    navigate(`/turmas/${id}/adicionar-aluno`);
  };

  const handleExcluir = (id) => {
    const confirmacao = window.confirm("Tem certeza que deseja excluir?");
    if (!confirmacao) return;

    fetch(`http://localhost:8080/turmas/${id}?funcionarioId=3`, {
      method: "DELETE",
    })
      .then(() => {
        setTurmas((prev) => prev.filter((prof) => prof.id !== id));
      })
      .catch((err) => console.error("Erro ao excluir turmas:", err));
  };

  const abrirModalAlunos = (turmaId) => {
    fetch(`http://localhost:8080/turmas/${turmaId}/alunos`)
      .then((res) => res.json())
      .then((alunos) => {
        setAlunosModal(alunos);
        setModalAberto(true);
      })
      .catch((err) => {
        console.error("Erro ao buscar alunos:", err);
        alert("Erro ao buscar alunos");
      });
  };

  return (
    <div className={styles.container}>
      <button className={styles.adicionar} onClick={handleAdicionar}>
        Adicionar
      </button>

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
                <button
                  className={styles.adicionar}
                  onClick={() => handleAdicionarTurma(turma.id)}
                >
                  Add Alunos
                </button>
                <button
                  className={styles.abrir}
                  onClick={() => abrirModalAlunos(turma.id)}
                >
                  Ver Alunos
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>

      {/* Modal */}
      {modalAberto && (
        <div
          className={styles.modalOverlay}
          onClick={() => setModalAberto(false)}
        >
          <div
            className={styles.modalContent}
            onClick={(e) => e.stopPropagation()}
          >
            <h2>Alunos da Turma</h2>
            <ul>
              {alunosModal.length === 0 ? (
                <li>Nenhum aluno nessa turma</li>
              ) : (
                alunosModal.map((aluno) => <li key={aluno.id}>{aluno.nome}</li>)
              )}
            </ul>
            <button
              className={styles.buttonModal}
              onClick={() => setModalAberto(false)}
            >
              Fechar
            </button>
          </div>
        </div>
      )}
    </div>
  );
};

export default ListaTurmas;
