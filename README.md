# 🐾 LifePet

Sistema web para gerenciamento de pets e acompanhamento de informações veterinárias. A plataforma permite que tutores cadastrem seus animais e solicitem consultas, enquanto veterinários podem gerenciar atendimentos e informações relacionadas à saúde dos pets.

## 🚀 Tecnologias utilizadas

### Backend
- Java 17
- Spring Boot 3
- Spring Security
- JWT (autenticação)
- Spring Data JPA
- Hibernate
- H2 Database
- Flyway
- Swagger / OpenAPI
- Maven

### Frontend
- React
- TypeScript
- Vite
- Axios
- React Router

## 👥 Perfis de usuário

O sistema possui dois perfis:

- **TUTOR:** pode acessar a plataforma, cadastrar seus pets e solicitar consultas.
- **VETERINÁRIO:** possui acesso às funcionalidades veterinárias, incluindo gerenciamento de consultas e informações de saúde dos animais.

A autenticação é realizada por meio de JWT, com controle de acesso utilizando Spring Security.

## ✨ Funcionalidades

- Cadastro e autenticação de usuários.
- Cadastro de pets.
- Agendamento de consultas.
- Gerenciamento de consultas.
- Cadastro e gerenciamento de medicamentos.
- Cadastro e acompanhamento de vacinas.
- Histórico veterinário dos pets.
- Controle de acesso por perfil.
- Documentação da API com Swagger.
- Versionamento do banco de dados com Flyway.

## 🛠️ Como executar o projeto localmente

### Pré-requisitos

- Java 17 ou superior.
- Maven.
- Node.js e npm.
- Git.

### 1. Clonar o repositório

```bash
git clone https://github.com/vitor-mendess/lifepet1.git
cd lifepet1
```

### 2. Executar o Backend

Abra o terminal na pasta `lifepet`:

```bash
cd lifepet
mvn spring-boot:run
```

O backend será iniciado em:

`http://localhost:8080`

### 3. Executar o Frontend

Em outro terminal, acesse a pasta `frontend`:

```bash
cd frontend
npm install
npm run dev
```

O frontend será iniciado pelo Vite, normalmente em:

`http://localhost:5173`

## 📚 Documentação da API

A documentação dos endpoints está disponível pelo Swagger:

`http://localhost:8080/swagger-ui/index.html`

## 🌐 Aplicação publicada

- **Frontend:** https://lifepet1.vercel.app
- **Backend:** https://lifepet1.onrender.com
- **Swagger:** https://lifepet1.onrender.com/swagger-ui/index.html

## 🗄️ Banco de dados

O projeto utiliza banco de dados H2 em memória no ambiente atual, com gerenciamento de versões e migrações por meio do Flyway.

## ☁️ Deploy e infraestrutura

- **GitHub:** versionamento e armazenamento do código-fonte.
- **Render:** hospedagem do backend.
- **Vercel:** hospedagem do frontend.

## 📚 Documentação do Projeto

A documentação técnica do LifePet apresenta a arquitetura da aplicação, as tecnologias utilizadas, as principais funcionalidades e a integração com as disciplinas do semestre.

📄 **[Acessar Documentação Técnica — 4ª Sprint (PDF)](Documenta%C3%A7%C3%A3o/LifePet_Documentacao_Tecnica_4_Sprint.pdf)**

## 👨‍💻 Integrantes

- Vitor Mendes da Silva — RM: 565376
- Aguinel Junior — RM: 564857
- Felipe da Silva — RM: 563485
- Henrique Gonçalves — RM: 562086
- Leonardo Saavedra — RM: 562229

---

**LifePet — Tecnologia e cuidado para a saúde dos pets.**