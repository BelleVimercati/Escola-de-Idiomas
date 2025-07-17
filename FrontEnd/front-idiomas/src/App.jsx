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

import MainPage from "./pages/MainPage";
import ListaAulas from "./pages/Aulas/ListaAulaPage";
import CadastroAulasPage from "./pages/Aulas/CadastroAulasPage";
import LoginPage from "./pages/LoginPage";
import PrivateRoute from "./components/PrivateRoute";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<LoginPage />} />

        {/* Rota protegida: MainPage */}
        <Route
          path="/main"
          element={
            <PrivateRoute>
              <MainPage />
            </PrivateRoute>
          }
        />

        {/* Gastos */}
        <Route
          path="/gastos"
          element={
            <PrivateRoute>
              <ListaGastos />
            </PrivateRoute>
          }
        />
        <Route
          path="/gastos/novo"
          element={
            <PrivateRoute>
              <CadastroGasto />
            </PrivateRoute>
          }
        />
        <Route
          path="/gastos/:id/editar"
          element={
            <PrivateRoute>
              <EditarGasto />
            </PrivateRoute>
          }
        />

        {/* Alunos */}
        <Route
          path="/alunos"
          element={
            <PrivateRoute>
              <ListAlunoPage />
            </PrivateRoute>
          }
        />
        <Route
          path="/alunos/novo"
          element={
            <PrivateRoute>
              <CadastroAlunosPage />
            </PrivateRoute>
          }
        />
        <Route
          path="/alunos/:id/editar"
          element={
            <PrivateRoute>
              <EditarAlunoPage />
            </PrivateRoute>
          }
        />

        {/* Professores */}
        <Route
          path="/professores"
          element={
            <PrivateRoute>
              <ListProfPage />
            </PrivateRoute>
          }
        />
        <Route
          path="/professores/novo"
          element={
            <PrivateRoute>
              <CadastroProfPage />
            </PrivateRoute>
          }
        />
        <Route
          path="/professores/:id/editar"
          element={
            <PrivateRoute>
              <EditarProfPage />
            </PrivateRoute>
          }
        />

        {/* Turmas */}
        <Route
          path="/turmas"
          element={
            <PrivateRoute>
              <ListTurmasPage />
            </PrivateRoute>
          }
        />
        <Route
          path="/turmas/novo"
          element={
            <PrivateRoute>
              <CadastroTurmasPage />
            </PrivateRoute>
          }
        />
        <Route
          path="/turmas/:id/editar"
          element={
            <PrivateRoute>
              <EditarTurmasPage />
            </PrivateRoute>
          }
        />
        <Route
          path="/turmas/:turmaId/adicionar-aluno"
          element={
            <PrivateRoute>
              <AdicionarAlunoTurmaForm />
            </PrivateRoute>
          }
        />

        {/* Aulas */}
        <Route
          path="/aulas"
          element={
            <PrivateRoute>
              <ListaAulas />
            </PrivateRoute>
          }
        />
        <Route
          path="/aulas/novo"
          element={
            <PrivateRoute>
              <CadastroAulasPage />
            </PrivateRoute>
          }
        />

        {/* Relatório */}
        <Route
          path="/relatorio"
          element={
            <PrivateRoute>
              <RelatorioFinanceiroPage />
            </PrivateRoute>
          }
        />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
