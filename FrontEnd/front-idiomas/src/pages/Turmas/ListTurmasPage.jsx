import Title from "../../components/Title";
import Header from "../../components/Header";
import Container2 from "../../components/Container2";
import ListaTurmas from "../../components/ListaTurmas";

const ListProfPage = () => {
  return (
    <div>
      <Header />
      <Container2>
        <Title>Turmas</Title>
        <ListaTurmas />
      </Container2>
    </div>
  );
};

export default ListProfPage;
