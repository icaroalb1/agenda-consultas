# 🩺 Sistema de Agenda de Consultas

Projeto desenvolvido para a disciplina de **Java Advanced**, com o objetivo de aplicar conceitos de **API REST**, utilizando **Spring Boot**, **Gradle**, **JPA**, **DTO**, **Validação**, **HATEOAS** e **Swagger**.

---

## 🚀 Funcionalidades

- ✅ Cadastro de Pacientes
- ✅ Listagem e consulta de pacientes por ID
- ✅ Agendamento de Consultas
- ✅ Cancelamento de Consultas
- ✅ Validações automáticas (CPF, email, data futura)
- ✅ HATEOAS (links automáticos nos retornos)
- ✅ Documentação com Swagger (OpenAPI)

---

## 🛠 Tecnologias utilizadas

- Java 17
- Spring Boot
- Gradle
- Spring Data JPA
- H2 Database (em memória)
- Spring Validation
- Spring HATEOAS
- Springdoc OpenAPI (Swagger)
- Lombok

---

## 🔍 Como executar o projeto

### Pré-requisitos:
- JDK 17 instalado
- IntelliJ IDEA ou outra IDE Java
- Git instalado

### Passos:
- http://localhost:8080/swagger-ui/index.html#/


```bash
git clone https://github.com/icaroalb1/agenda-consultas.git
cd agenda-consultas
./gradlew bootRun
