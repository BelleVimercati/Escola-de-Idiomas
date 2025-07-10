import styles from "../styles/LoginForm.module.css";

const Input = ({ type, placeholder, value, onChange }) => {
  return (
    <input
      className={styles.input}
      type={type}
      placeholder={placeholder}
      value={value}
      onChange={onChange}
    />
  );
};

export default Input;
