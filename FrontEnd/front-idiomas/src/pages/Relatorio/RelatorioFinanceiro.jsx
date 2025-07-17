import { useState } from "react";
import styles from "../../styles/LoginForm.module.css";
import Input from "../../components/Input";
import Button from "../../components/Button";
import Container from "../../components/Container";
import Header from "../../components/Header";

const RelatorioFinanceiroPage = () => {
  const [tipoRelatorio, setTipoRelatorio] = useState("");
  const [mes, setMes] = useState("");
  const [ano, setAno] = useState("");
  const [resultado, setResultado] = useState(null);

  const handleGerarRelatorio = () => {
    let url = "http://localhost:8080/relatorios";

    if (tipoRelatorio === "mensal") {
      if (!mes || !ano) {
        alert("Informe o mês e o ano.");
        return;
      }
      url += `/mensal?mes=${mes}&ano=${ano}`;
    } else if (tipoRelatorio === "anual") {
      if (!ano) {
        alert("Informe o ano.");
        return;
      }
      url += `/anual?ano=${ano}`;
    } else {
      alert("Selecione um tipo de relatório.");
      return;
    }

    fetch(url)
      .then((res) => {
        if (!res.ok) throw new Error("Erro ao gerar relatório");
        return res.json();
      })
      .then((data) => setResultado(data))
      .catch((err) => alert("Erro: " + err.message));
  };

  return (
    <Container>
      <form className={styles.card} onSubmit={(e) => e.preventDefault()}>
        <h2 className={styles.title}>Relatório Financeiro</h2>

        <label className={styles.label}>Tipo de Relatório</label>
        <select
          className={styles.input}
          value={tipoRelatorio}
          onChange={(e) => {
            setTipoRelatorio(e.target.value);
            setResultado(null); // limpa relatório anterior
          }}
        >
          <option value="">-- Selecione --</option>
          <option value="mensal">Mensal</option>
          <option value="anual">Anual</option>
        </select>

        {tipoRelatorio === "mensal" && (
          <>
            <label className={styles.label}>Mês</label>
            <select
              className={styles.input}
              value={mes}
              onChange={(e) => setMes(e.target.value)}
            >
              <option value="">-- Selecione o mês --</option>
              {Array.from({ length: 12 }, (_, i) => (
                <option key={i + 1} value={i + 1}>
                  {i + 1}
                </option>
              ))}
            </select>
          </>
        )}

        {(tipoRelatorio === "mensal" || tipoRelatorio === "anual") && (
          <>
            <label className={styles.label}>Ano</label>
            <Input
              type="number"
              value={ano}
              onChange={(e) => setAno(e.target.value)}
            />
          </>
        )}

        <Button text="Gerar Relatório" onClick={handleGerarRelatorio} />
      </form>

      {resultado && (
        <div className={styles.card} style={{ marginTop: "20px" , marginLeft: "20px"}}>
          <h3 className={styles.title}>Resultado</h3>
          <pre style={{ whiteSpace: "pre-wrap" }}>
            {JSON.stringify(resultado, null, 2)}
          </pre>
        </div>
      )}
    </Container>
  );
};

export default RelatorioFinanceiroPage;
