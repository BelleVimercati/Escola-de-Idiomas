import styles from "../styles/LoginForm.module.css";
import Input from "./Input";
import Button from "./Button";

const CadastroForm = () => {
  return (
    <div className={styles.card}>
      <h2 className={styles.title}>Cadastro de alunos</h2>

      <label className={styles.label}>Nome</label>
      <Input type="text" />

      <label className={styles.label}>Email</label>
      <Input type="email" />

      <label className={styles.label}>Matricula</label>
      <Input type="text" />

      <label className={styles.label}>Endereço</label>
      <Input type="text" />

      <label className={styles.label}>Telefone</label>
      <Input type="text" />

      <Button text="Cadastrar" />
    </div>
  );
};

export default CadastroForm;
