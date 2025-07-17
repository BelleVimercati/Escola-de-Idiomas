# 📚 Escola de Idiomas - Sistema de Gestão

Projeto full stack desenvolvido com **Spring Boot (Java)** no back-end e **ReactJS** no front-end, com o objetivo de gerenciar uma escola de idiomas. O sistema permite o cadastro e gerenciamento de alunos, turmas, funcionários e gastos.

---

## 💠 Tecnologias Utilizadas

### Back-End:

* Java 17+
* Spring Boot
* Spring Data JPA
* Spring Security (opcional)
* Hibernate
* MariaDB
* Maven
* Docker

### Front-End:

* ReactJS
* React Router DOM
* Axios
* CSS Modules

---

## 🧩 Funcionalidades

### 👨‍🏫 Funcionário

* Cadastro de funcionários
* Login (com ID e/ou JWT)
* Edição e exclusão

### 👩‍🎓 Aluno

* Cadastro de alunos
* Listagem de alunos por turma
* Edição e exclusão

### 📚 Turmas

* Cadastro de turmas (idioma, nível, data, valor etc.)
* Listagem de turmas
* Associação de alunos às turmas
* Exclusão e edição

### 💸 Gastos

* Cadastro de gastos por funcionário
* Listagem de todos os gastos
* Edição e exclusão

---

## 🔧 Como rodar o projeto

### 1. Clone o repositório:

```bash
git clone https://github.com/seu-usuario/escola-de-idiomas.git
cd escola-de-idiomas
```

---

### 2. Configuração do Back-End (Spring Boot)

#### ⚙️ Banco de dados

Configure o acesso ao banco no arquivo:

```
/src/main/resources/application.properties
```

Exemplo:

```properties
spring.datasource.url=jdbc:mariadb://localhost:3306/escola
spring.datasource.username=root
spring.datasource.password=123456
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

#### 🐳 Usando Docker

No terminal:

```bash
cd Escola-de-Idiomas/MariaDB
docker-compose up -d
```

---

### 3. Executando o Back-End

No diretório do back-end:

```bash
./mvnw spring-boot:run
```

A API ficará disponível em:
📍 `http://localhost:8080`

---

### 4. Executando o Front-End

No terminal:

```bash
cd front-idiomas
npm install
npm start
```

A interface ficará disponível em:
📍 `http://localhost:3000`

---

## 🧪 Exemplos de Endpoints

* `GET /turmas` → Lista todas as turmas
* `GET /turmas/{id}/alunos` → Lista alunos de uma turma
* `POST /gastos?funcionarioId=1` → Cadastra gasto vinculado a um funcionário
* `DELETE /turmas/{id}?funcionarioId=3` → Exclui turma com permissão

---

## 📁 Estrutura de Pastas

```
Escola-de-Idiomas/
│
├── back-end/ (Spring Boot)
│   ├── controller/
│   ├── model/
│   ├── repository/
│   └── service/
│
└── front-idiomas/ (React)
    ├── pages/
    ├── components/
    └── styles/
```

---

## 👩‍💼 Desenvolvido por

**Isabelle Pires Vimercati**
Projeto acadêmico de Projeto de Arquitetura de Software
🌐 [LinkedIn](https://www.linkedin.com/) | 📧 [isabelle@email.com](mailto:isabelle@email.com)

---

## 📝 Licença

Este projeto está licenciado sob a **MIT License**.
