import Header from "../../components/Header";
import Container from "../../components/Container";
import EditarProfessorForm from "../../components/Editar/EditarProfForm";

const EditarProfPage = () => {
  return (
    <div>
      <Header />
      <Container>
        <EditarProfessorForm />
      </Container>
    </div>
  );
};

export default EditarProfPage;
