import Title from "../../components/Title";
import Header from "../../components/Header";
import Container2 from "../../components/Container2";
import ListaAlunos from "../../components/Listar/ListaAlunos";

const ListAlunoPage = () => {
  return (
    <div>
      <Header />
      <Container2>
        <Title>Alunos</Title>
        <ListaAlunos />
      </Container2>
    </div>
  );
};

export default ListAlunoPage;
