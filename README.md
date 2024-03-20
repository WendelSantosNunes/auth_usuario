
<h1 align="center"> 
	auth_usuario
</h1>

<p align="center">
 <a href="#-sobre-o-projeto">Sobre</a> •
<a href="#-diagrama">Diagrama</a> •
 <a href="#-funcionalidades">Funcionalidades</a> •
 <a href="#-Configuração-do-ambiente">Configuração do ambiente</a> • 
 <a href="#-como-executar">Como executar</a> • 
 <a href="#-tecnologias">Tecnologias</a> 
</p>

---

### 🪐 Sobre o projeto

Este projeto é um back-end desenvolvido com o objetivo de implementar um sistema de autenticação utilizando JWT e 
Spring Security. Com isso, um usuário tem a capacidade de criar uma conta na API, fazer login, editar seus dados e, 
se for um administrador, excluir a conta. Para atingir esse objetivo, utilizamos o framework Spring Boot e a 
tecnologia JPA/Hibernate

---
### 👨‍💻 Diagrama

<p align="center">
  <img src="https://drive.google.com/uc?export=view&id=1SA1L08TiCTLJkpgqXzOZms-vYItKydVR" alt="Diagrama"/>
</p>

---

### 💻 Funcionalidades

- [x] **Para clientes não cadastrados:**
  - [x] Possibilidade de se cadastrar no sistema.
- [x] **Para clientes já cadastrados:**
  - [X] Capacidade de realizar login;
  - [X] Opção para atualizar suas próprias informações;
- [X] **Para administradores:**
  - [X] Capacidade de realizar login;
  - [X] Opção para atualizar suas próprias informações;
  - [X] Permissão para remover um cliente.

--- 

### 🎨 Configuração do ambiente

```bash

# Instalação do Java

## Para instalar o Java, visite o site oficial e baixe a versão que seja compatível com o seu ambiente de desenvolvimento. Siga as instruções fornecidas para instalar o Java em seu sistema.

https://www.java.com/pt-BR/download/

# Instalação da JDK 17

## Vamos usar o SDKMAN para instalar a JDK 17. Primeiro, instale o SDKMAN com o seguinte comando:

curl -s "<https://get.sdkman.io>" | bash

## Depois de instalar o SDKMAN, você pode instalar a JDK 17 com este comando:

sdk install java 17-open

## Para verificar se a JDK foi instalada corretamente, use o comando:

java --version

# Instalação do Maven 

## Para instalar o Maven, use o seguinte comando:

sdk install maven 3.1.5

## Você pode verificar a instalação do Maven com este comando:

mvn --version
 
# Instalação do Intellij Community

## Para instalar o IntelliJ IDEA Community, visite o site oficial e baixe a versão que seja compatível com o seu ambiente de desenvolvimento. Siga as instruções fornecidas para instalar o IntelliJ IDEA em seu sistema.


https://www.jetbrains.com/idea/download/?section=linux

```
---

### 🚀 Como executar

#### Pré-requisitos

Certifique-se de que todas as configurações do ambiente foram realizadas corretamente.

#### Execução

- Faça o download do projeto para o seu computador.

- Abra o IntelliJ IDEA Community.

- No menu principal, selecione a opção “Open”. Navegue até a pasta onde o projeto foi baixado e clique em “OK”.

- No projeto aberto, localize e clique no arquivo AuthApplication.java.

- Em seguida, selecione a opção “Run ‘AuthApplication’” para executar o projeto.

- Após a execução, o projeto estará acessível através do seguinte endereço: http://localhost:8080/

- A documentação das rotas com Swagger pode ser acessada em: http://localhost:8080/swagger-ui.html

### 🛠 Tecnologias

#### **Back-End**

- **[Java](https://docs.oracle.com/en/java/)**
- **[Spring Boot](https://spring.io/projects/spring-boot)**
- **[Spring Security](https://docs.spring.io/spring-security/reference/reactive/getting-started.html)**
- **[Swagger](https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api)**
- **[JWT](https://docs.spring.io/spring-security/reference/servlet/oauth2/resource-server/jwt.html)**
- **[MySql](https://spring.io/guides/gs/accessing-data-mysql)**
