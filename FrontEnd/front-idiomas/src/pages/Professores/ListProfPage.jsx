import Title from "../../components/Title";
import Header from "../../components/Header"
import Container2 from "../../components/Container2";
import ListaProfessores from "../../components/ListaProfessores";

const ListProfPage = () => {
  return (
    <div>
      <Header />
      <Container2>
        <Title>Professores</Title>
        <ListaProfessores/>
      </Container2>
    </div>
  );
};

export default ListProfPage;
