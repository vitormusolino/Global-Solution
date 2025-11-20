##🧩 Neuro Mentor – Documentação Técnica

#API REST desenvolvida em Java 21 + Spring Boot 3, utilizando arquitetura em camadas, MySQL e testes unitários com JUnit + Mockito.

#📦 Arquitetura do Projeto
controller/  → Endpoints REST
service/     → Regras de negócio
repository/  → Interfaces JPA
domain/      → Entidades persistidas
dto/         → Objetos de transferência de dados
exception/   → Tratamento global de erros

#Principais padrões:

DTO Pattern

Service Layer Pattern

Repository Pattern

Exception Handling centralizado

#🗄️ Banco de Dados

MySQL 8

ORM: Hibernate + Spring Data JPA

Configuração via application.yml

ddl-auto: update para manter o schema sincronizado

data.sql para carga inicial

#🧬 Modelagem
Usuário
id, nome, email, senha, perfil

Trilha
id, titulo, categoria, cargaHoraria, nivel

Inscrição
id, usuarioId, trilhaId

#🚀 API REST

Controllers com @RestController, @RequestMapping

Validação com @Valid + Jakarta Validation

Respostas via ResponseEntity

Padrão CRUD para todas as entidades

#🧯 Tratamento de Erros

@ControllerAdvice para capturar exceções

Respostas padronizadas (400 / 404 / 500)

#🧪 Testes

JUnit 5 + Mockito

Mock de repositórios

Testes unitários nas Services

Verificação de comportamento (verify) e cenários de exceção

#🔧 Dependências Principais

spring-boot-starter-web

spring-boot-starter-data-jpa

spring-boot-starter-validation

mysql-connector-j

spring-boot-starter-test

mockito-core

🔄 Fluxo Interno
Controller → Service → Repository → MySQL


Controllers recebem DTOs, services processam e repositories persistem.
