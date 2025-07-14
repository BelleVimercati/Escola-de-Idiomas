import ListaAulas from "../../components/ListaAulas";
import Container2 from "../../components/Container2";
import Header from "../../components/Header";
import Title from "../../components/Title";

const ListaAulasPage = () => {
  return (
    <div>
      <Header />
      <Container2>
        <Title>Alunos</Title>
        <ListaAulas />
      </Container2>
    </div>
  );
};

export default ListaAulasPage;
