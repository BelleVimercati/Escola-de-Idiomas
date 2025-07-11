import Title from "../../components/Title";
import Header from "../../components/Header";
import Container2 from "../../components/Container2";
import ListaGasto from "../../components/ListaGasto"


const ListGastoPage = () => {
  return (
    <div>
      <Header />
      <Container2>
        <Title>Gastos</Title>
        <ListaGasto />
      </Container2>
    </div>
  );
};

export default ListGastoPage;
