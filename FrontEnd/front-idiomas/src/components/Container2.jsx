const Container2 = ({ children }) => {
  return (
    <div
      style={{
        marginLeft: "40px",
        marginRight: "40px",
        minHeight: "100vh",
        width: "auto", // não 100vw para evitar overflow
        maxWidth: "100%", // garante que não ultrapasse o pai
        boxSizing: "border-box", // inclui margens/padding na largura
      }}
    >
      {children}
    </div>
  );
};

export default Container2;
