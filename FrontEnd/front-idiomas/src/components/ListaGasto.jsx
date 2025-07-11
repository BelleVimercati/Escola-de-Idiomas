import React, { useEffect, useState } from "react";
import styles from "../styles/Lista.module.css";
import { useNavigate } from "react-router-dom";

const ListaGastos = () => {
  const navigate = useNavigate();

  const handleAdicionar = () => {
    navigate("/gastos/novo");
  };

  const [gastos, setGastos] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/gastos")
      .then((res) => res.json())
      .then((data) => setGastos(data))
      .catch((err) => console.error("Erro ao buscar gastos:", err));
  }, []);

  const handleEditar = (id) => {
      navigate(`/gastos/${id}/editar`);
  };

  const handleExcluir = (id) => {
    const confirmacao = window.confirm("Tem certeza que deseja excluir?");
    if (!confirmacao) return;

    fetch(`http://localhost:8080/gastos/${id}?funcionarioId=1`, {
      method: "DELETE",
    })
      .then(() => {
        setGastos((prev) => prev.filter((gasto) => gasto.id !== id));
      })
      .catch((err) => console.error("Erro ao excluir gasto:", err));
  };

  return (
    <div className={styles.container}>
      <button className={styles.adicionar} onClick={handleAdicionar}>
        Adicionar
      </button>

      <table className={styles.tabela}>
        <thead>
          <tr>
            <th>Descrição</th>
            <th>Valor (R$)</th>
            <th>Data de laçamento</th>
            <th>Ações</th>
          </tr>
        </thead>
        <tbody>
          {gastos.map((gasto) => (
            <tr key={gasto.id}>
              <td>{gasto.descricao}</td>
              <td>{gasto.valor.toFixed(2)}</td>
              <td>{gasto.data}</td>
              <td>
                <button
                  className={styles.editar}
                  onClick={() => handleEditar(gasto.id)}
                >
                  Editar
                </button>
                <button
                  className={styles.excluir}
                  onClick={() => handleExcluir(gasto.id)}
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

export default ListaGastos;
