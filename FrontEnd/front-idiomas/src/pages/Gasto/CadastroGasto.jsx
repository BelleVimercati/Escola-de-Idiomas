import Container from "../../components/Container";
import CadastroGastoForm from "../../components/Cadastro/CadastroGasto";
import Header from "../../components/Header";

const CadastroGasto = () => {
  return (
    <div>
      <Header />
      <Container>
        <CadastroGastoForm />
      </Container>
    </div>
  );
};

export default CadastroGasto;
