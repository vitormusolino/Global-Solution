# 🧩 Neuro Mentor – Documentação Técnica


API REST desenvolvida com Java 21 + Spring Boot 3, utilizando arquitetura em camadas, MySQL e testes unitários com JUnit + Mockito.

## 🔧 Arquitetura do Projeto
```bash
src/
 ├── controller/ → Endpoints REST
 ├── service/ → Regras de negócio
 ├── repository/ → Interfaces JPA
 ├── domain/ → Entidades
 ├── dto/ → Objetos de transferência
 └── exception/ → Tratamento de erros
```
 ---

## Padrões utilizados:

- DTO Pattern
- Service Layer,
- Repository Pattern,
- Exception Handling centralizado

---

## 🗄️ Banco de Dados

- MySQL 8
- ORM: Hibernate (Spring Data JPA)
- Configuração via application.yml
- ddl-auto: update para sincronizar o schema
- Inserções iniciais via data.sql

---
## ▶️ Como Executar o Projeto

A aplicação pode ser iniciada diretamente via Maven usando o comando:
```bash
mvn spring-boot:run
```
Requisitos:
- JDK 21 instalado
- Maven instalado
- MySQL rodando
---

## 🧬 Modelagem das Entidades
- Usuário
id, nome, email, senha, perfil

- Trilha
id, titulo, categoria, cargaHoraria, nivel

- Inscrição
id, usuarioId, trilhaId

---

## 🚀 Estrutura da API REST

- Controllers estruturados com @RestController
- Validações usando @Valid + Jakarta Validation
- Respostas com ResponseEntity
- CRUD completo para:
- Usuário
- Trilha
- Inscrição

---

## 🧯 Tratamento Global de Erros

Implementado com @ControllerAdvice
Respostas padronizadas seguindo HTTP Codes:
- 400 – erros de validação
- 404 – recurso não encontrado
- 500 – erros internos

---

## 🧪 Testes Unitários

Tecnologias utilizadas:
- JUnit 5
- Mockito (mock de repositórios)
Os testes cobrem:
- Métodos de serviço
- Fluxos positivos e negativos
- Verificação de comportamento (verify)
- Exemplo de teste (formato sintético):

when(repository.save(any())).thenReturn(usuario);
Usuario resultado = service.salvar(dto);
assertEquals("Ana", resultado.getNome());
verify(repository).save(any());

---

## 📦 Principais Dependências
```bash
spring-boot-starter-web
spring-boot-starter-data-jpa
spring-boot-starter-validation
mysql-connector-j
spring-boot-starter-test
mockito-core
```
---

## 🔄 Fluxo Interno da Aplicação
Controller → Service → Repository → MySQL

---

# 📊 Cobertura de Testes (Jacoco)
Gerado automaticamente ao rodar:
```bash
mvn test
```
