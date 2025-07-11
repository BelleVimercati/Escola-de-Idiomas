import { BrowserRouter, Routes, Route } from "react-router-dom";
import ListaGastos from "./pages/Gasto/ListGastoPage";
import CadastroGasto from "./pages/Gasto/CadastroGasto";
import EditarGasto from "./pages/Gasto/EditarGastoPage";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="" element={<ListaGastos />} />
        <Route path="/gastos/novo" element={<CadastroGasto />} />
        <Route path="/gastos/:id/editar" element={<EditarGasto />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
