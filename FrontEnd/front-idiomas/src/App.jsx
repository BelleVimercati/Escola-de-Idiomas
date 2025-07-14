import { BrowserRouter, Routes, Route } from "react-router-dom";
import ListaGastos from "./pages/Gasto/ListGastoPage";
import CadastroGasto from "./pages/Gasto/CadastroGasto";
import EditarGasto from "./pages/Gasto/EditarGastoPage";
import CadastroAlunosPage from "./pages/Alunos/CadastroAlunosPage";
import ListAlunoPage from "./pages/Alunos/ListAlunoPage";
import EditarAlunoPage from "./pages/Alunos/EditarAlunoPage";

import ListProfPage from "./pages/Professores/ListProfPage";
import CadastroProfPage from "./pages/Professores/CadastroProfPage";
import EditarProfPage from "./pages/Professores/EditarProfPage";

import ListTurmasPage from "./pages/Turmas/ListTurmasPage";
import CadastroTurmasPage from "./pages/Turmas/CadastroTurmasPage";
import EditarTurmasPage from "./pages/Turmas/EditarTurmasPage";
import AdicionarAlunoTurmaForm from "./pages/Turmas/AdicionarAlunosPage";

import RelatorioFinanceiroPage from "./pages/Relatorio/RelatorioFinanceiroPage";

import MainPage from "./pages/MainPage"
import ListaAulas from "./pages/Aulas/ListaAulaPage";
import CadastroAulasPage from "./pages/Aulas/CadastroAulasPage";



function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<MainPage />} />

        {/* Roda de Gastos */}
        <Route path="/gastos" element={<ListaGastos />} />
        <Route path="/gastos/novo" element={<CadastroGasto />} />
        <Route path="/gastos/:id/editar" element={<EditarGasto />} />

        {/* Rota de alunos */}
        <Route path="/alunos" element={<ListAlunoPage />} />
        <Route path="/alunos/novo" element={<CadastroAlunosPage />} />
        <Route path="/alunos/:id/editar" element={<EditarAlunoPage />} />

        {/* Rota de Professores */}
        <Route path="/professores" element={<ListProfPage />} />
        <Route path="/professores/novo" element={<CadastroProfPage />} />
        <Route path="/professores/:id/editar" element={<EditarProfPage />} />

        {/* Rota de Turmas */}
        <Route path="/turmas" element={<ListTurmasPage />} />
        <Route path="/turmas/novo" element={<CadastroTurmasPage />} />
        <Route path="/turmas/:id/editar" element={<EditarTurmasPage />} />
        <Route
          path="/turmas/:turmaId/adicionar-aluno"
          element={<AdicionarAlunoTurmaForm />}
        />

        {/* Rota de aulas */}
        <Route path="/aulas" element={<ListaAulas />} />
        <Route path="/aulas/novo" element={<CadastroAulasPage />} />

        <Route path="/relatorio" element={<RelatorioFinanceiroPage />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
