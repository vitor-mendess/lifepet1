# 🐾 LifePet

## Integrantes

- Vitor Mendes da Silva — RM: 565376
- Aguinel Junior — RM: 564857
- Felipe da Silva — RM: 563485
- Henrique Gonçalves — RM 562086
- Leonardo Saavedra — RM: 562228

---

## Descrição do Projeto

O LifePet é uma API REST desenvolvida em Java com Spring Boot para auxiliar na continuidade do cuidado e acompanhamento da saúde dos pets.

A solução permite o gerenciamento de informações importantes relacionadas aos animais, como:

- cadastro de pets
- histórico médico
- medicamentos
- vacinas
- consultas
- responsáveis

O objetivo é reduzir esquecimentos, melhorar o acompanhamento preventivo e facilitar a relação entre tutores e clínicas veterinárias.

---

## Problema Resolvido

Atualmente muitos tutores acabam perdendo informações importantes como:

- datas de vacinação
- horários de medicamentos
- retornos veterinários
- histórico clínico

Isso prejudica a continuidade do cuidado do animal.

---

## Benefícios para o Negócio

- Maior acompanhamento preventivo
- Redução do abandono de tratamentos
- Melhor experiência para o tutor
- Fidelização de clínicas
- Centralização das informações do pet

---

## Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- H2 Database
- Maven
- Swagger/OpenAPI
- Bean Validation
- Cache
- GitHub

---

## Arquitetura do Projeto

A aplicação utiliza arquitetura em camadas:

- Controller
- Service
- Repository
- DTO
- Entity

Fluxo:

Cliente → Controller → Service → Repository → Banco

---

## Padrões de Projeto Utilizados

- Repository Pattern
- DTO Pattern
- Service Layer Pattern

---

## Funcionalidades

### Pets

- Cadastrar pet
- Buscar pet
- Atualizar pet
- Excluir pet

### Medicamentos

- Cadastrar medicamento
- Consultar medicamento
- Atualizar medicamento
- Excluir medicamento

### Vacinas

- Cadastrar vacina
- Consultar vacina
- Atualizar vacina
- Excluir vacina

### Consultas

- Cadastrar consulta
- Consultar consulta
- Atualizar consulta
- Excluir consulta

---

## Rotas da API

### Pet

```http
GET /pets
GET /pets/{id}
POST /pets
PUT /pets/{id}
DELETE /pets/{id}
```

### Medicamento

```http
GET /medicamentos
POST /medicamentos
PUT /medicamentos/{id}
DELETE /medicamentos/{id}
```

### Vacina

```http
GET /vacinas
POST /vacinas
PUT /vacinas/{id}
DELETE /vacinas/{id}
```



