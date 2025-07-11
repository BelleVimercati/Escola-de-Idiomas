import React from "react";

const Container = ({ children }) => {
  return (
    <div
      style={{
        display: "flex",
        justifyContent: "center",
        alignItems: "center",
        backgroundColor: "#f5f4ff", // fundo claro
        minHeight: "100vh"
      }}
    >
      {children}
    </div>
  );
};

export default Container;
