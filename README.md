# 🎓 Certificação de Estudantes API

Esta API foi desenvolvida para gerenciar a geração de certificações para estudantes com base em seu desempenho em testes. O sistema permite que os estudantes respondam a um conjunto de questões e, se o desempenho for satisfatório, eles poderão obter uma certificação na tecnologia escolhida.

## 🛠️ Tecnologias Utilizadas

- ☕ **Java**: Linguagem principal utilizada para desenvolver a aplicação.
- 🌱 **Spring Boot**: Framework que facilita o desenvolvimento da aplicação, incluindo suporte a RESTful APIs.
- 🗃️ **Spring Data JPA**: Abstração que simplifica o acesso a dados, permitindo interações mais fáceis com o banco de dados.
- 🐘 **PostgreSQL**: Banco de dados relacional utilizado para armazenar as informações dos estudantes e das questões.
- 🐳 **Docker**: Plataforma que permite a criação, execução e gerenciamento de contêineres, facilitando a configuração do ambiente.
- 📦 **Maven**: Gerenciador de dependências e build da aplicação, utilizado para automatizar o processo de construção e gerenciamento de bibliotecas.
- 🔧 **Lombok**: Biblioteca que reduz a verbosidade do código, gerando automaticamente getters, setters e outros métodos.
- 📊 **DBeaver**: Ferramenta de gerenciamento de banco de dados, que permite visualizar e manipular dados de forma intuitiva.
- 📮 **Postman**: Ferramenta para testar APIs, permitindo enviar requisições e visualizar as respostas de forma fácil.

## 💡 Funcionalidades

- 📊 **Avaliação de desempenho**: O estudante responde a um conjunto de questões, e o sistema avalia automaticamente seu desempenho.
- 🏅 **Geração de certificações**: Estudantes com desempenho satisfatório recebem uma certificação.
- 🔎 **Verificação de certificação**: Permite verificar se um estudante já foi certificado em uma determinada tecnologia.
- 🏆 **Ranking dos melhores colocados**: O sistema gera um ranking dos 10 melhores estudantes, com base em suas pontuações.


## 🛠️ Pré-requisitos

Antes de rodar o projeto, certifique-se de ter os seguintes requisitos instalados:

- ☕ [Java 17](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- 📦 [Maven](https://maven.apache.org/download.cgi)
- 🐳 [Docker](https://www.docker.com/get-started)
- 🐘 [PostgreSQL](https://www.postgresql.org/download/)

## 🚀 Como Rodar o Projeto

📌 **1. Clone o repositório**:

```bash
git clone https://github.com/joschonarth/java-certification-project
```

📌 **2. Entre no diretório do projeto**:

```bash
cd java-certification-project
```

📌 **3. Executar o contêiner do PostgreSQL**: O contêiner será configurado automaticamente com a imagem `bitnami/postgresql:13.16.0` ao rodar o comando:

```bash
docker-compose up -d
```

Você poderá alterar a versão da imagem conforme preferir. Para isso, consulte a imagem oficial no site do Docker Hub: [bitnami/postgresql](https://hub.docker.com/r/bitnami/postgresql/tags).

📌 **4. Compile e execute o projeto usando o Maven**:

```bash
mvn spring-boot:run
```

📌 **5. Adicione as questões ao banco de dados**: Para inserir as questões no banco de dados, execute a classe CreateSeed usando o Maven:

```bash
mvn exec:java
```

Você pode alterar e adicionar questões no arquivo `src/main/resources/create.sql` conforme necessário.

## 🌐 Acesso à API
A API estará disponível em: [http://localhost:8080](http://localhost:8080)

## 🔗 Endpoints

### 📄 Obter Questões
- **Descrição**: Retorna um conjunto de questões com alternativas baseadas na tecnologia escolhida.
- **Método**: `GET`
- **Endpoint**: `/questions/technology/{technology}`

🌐 **Exemplo de Requisição**: `http://localhost:8080/questions/technology/JAVA`

📄 **Exemplo de Resposta:**

```json
[
    {
        "id": "b0ec9e6b-721c-43c7-9432-4d0b6eb15b01",
        "technology": "JAVA",
        "description": "Explique o conceito de polimorfismo em Java.",
        "alternatives": [
            {
                "id": "1da0f5dd-7a02-4c34-8c60-4648b55141f2",
                "description": "Herança simples"
            },
            {
                "id": "9da03a4e-3c8d-4a32-87e1-9898938435c2",
                "description": "Sobrecarga de métodos"
            },
            {
                "id": "f8e6e9b3-199b-4f0d-97ce-7e5bdc080da9",
                "description": "Capacidade de um objeto de assumir várias formas"
            }
        ]
    }
]
```

### 📝 Enviar Respostas para Certificação

- **Descrição**: Recebe as respostas dos estudantes para a avaliação e gera a certificação se o desempenho for satisfatório.
- **Método**: `POST`
- **Endpoint**: `/students/certification/answer`


**🌐 Exemplo de Requisição:**

```json
{
    "email": "joschonarth@gmail.com",
    "technology": "JAVA",
    "questionsAnswers": [
        {
            "questionID" : "c5f02721-6dc3-4fa6-b46d-6f2e8dca9c66",
            "alternativeID": "bafdf631-6edf-482a-bda9-7dce1efb1890"
        },
        {
            "questionID" : "b0ec9e6b-721c-43c7-9432-4d0b6eb15b01",
            "alternativeID": "1da0f5dd-7a02-4c34-8c60-4648b55141f2"
        },
        {
            "questionID" : "f85e9434-1711-4e02-9f9e-7831aa5c743a",
            "alternativeID": "d3e51a56-9b97-4bb8-9827-8bcf89f4b276"
        }
    ]
}
```

**📄 Exemplo de Resposta:**

```json
{
    "id": "37277a90-5209-47cd-a491-d03ea134cf2f",
    "studentID": "028a1617-4c22-47c0-b3f6-718db9feb1b0",
    "technology": "JAVA",
    "grade": 2,
    "createdAt": "2024-10-25T18:49:21.614685",
    "studentEntity": null,
    "answersCertificationsEntities": [
        {
            "id": "22a1f8fc-0eef-4496-a1ac-e08b72f836a4",
            "certificationID": "37277a90-5209-47cd-a491-d03ea134cf2f",
            "studentID": "028a1617-4c22-47c0-b3f6-718db9feb1b0",
            "studentEntity": null,
            "questionID": "c5f02721-6dc3-4fa6-b46d-6f2e8dca9c66",
            "answerID": "bafdf631-6edf-482a-bda9-7dce1efb1890",
            "createdAt": "2024-10-25T18:49:21.63558",
            "correct": true
        },
        {
            "id": "5435b1b5-315b-4b7e-9fc3-6a07cacb5f46",
            "certificationID": "37277a90-5209-47cd-a491-d03ea134cf2f",
            "studentID": "028a1617-4c22-47c0-b3f6-718db9feb1b0",
            "studentEntity": null,
            "questionID": "b0ec9e6b-721c-43c7-9432-4d0b6eb15b01",
            "answerID": "1da0f5dd-7a02-4c34-8c60-4648b55141f2",
            "createdAt": "2024-10-25T18:49:21.639505",
            "correct": false
        },
        {
            "id": "f6237808-e979-4322-8e84-e7c7cbfaed9c",
            "certificationID": "37277a90-5209-47cd-a491-d03ea134cf2f",
            "studentID": "028a1617-4c22-47c0-b3f6-718db9feb1b0",
            "studentEntity": null,
            "questionID": "f85e9434-1711-4e02-9f9e-7831aa5c743a",
            "answerID": "d3e51a56-9b97-4bb8-9827-8bcf89f4b276",
            "createdAt": "2024-10-25T18:49:21.641847",
            "correct": true
        }
    ]
}
```

## 🔍 Verificar Certificação

- **Descrição**: Verifica se o estudante já obteve certificação em uma tecnologia específica.
- **Método**: `POST`
- **Endpoint**: `/students/verifyCertification`

**🌐 Exemplo de Requisição**:

```json
{
    "email": "joschonarth@gmail.com",
    "technology": "JAVA"
}
```

**📄 Exemplo de Resposta:**

```json
"Usuário já fez a prova"
```

## 🏆 Obter Ranking dos 10 Melhores

- **Descrição**: Retorna o ranking dos 10 estudantes com as maiores pontuações.
- **Método**: `GET`
- **Endpoint**: `/ranking/top10`

**🌐 Exemplo de Requisição**: `http://localhost:8080/ranking/top10`

**📄 Exemplo de Resposta:**

```json
[
    {
        "id": "37277a90-5209-47cd-a491-d03ea134cf2f",
        "studentID": "028a1617-4c22-47c0-b3f6-718db9feb1b0",
        "technology": "JAVA",
        "grade": 2,
        "createdAt": "2024-10-25T18:49:21.614685",
        "studentEntity": {
            "id": "028a1617-4c22-47c0-b3f6-718db9feb1b0",
            "email": "joschonarth@gmail.com",
            "createdAt": "2024-10-25T18:49:21.576053"
        },
        "answersCertificationsEntities": []
    },
    {
        "id": "c3f6fc8c-b73c-45fb-a074-b7d07b8094fd",
        "studentID": "512fcd4e-f74a-4b1f-908b-92ff3fb4d6a3",
        "technology": "JAVA",
        "grade": 1,
        "createdAt": "2024-10-25T18:52:39.588055",
        "studentEntity": {
            "id": "512fcd4e-f74a-4b1f-908b-92ff3fb4d6a3",
            "email": "maria@gmail.com",
            "createdAt": "2024-10-25T18:52:39.558053"
        },
        "answersCertificationsEntities": []
    }
]
```

## 📚 Documentações e Links Importantes

- 🌱 [Spring Boot Documentation](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/) - Documentação oficial do Spring Boot.
- 🐳 [Docker Documentation](https://docs.docker.com/) - Documentação oficial do Docker.
- 🐘 [Imagem do PostgreSQL](https://hub.docker.com/r/bitnami/postgresql/tags) - Acesse aqui para consultar a imagem do PostgreSQL no Docker Hub.
- 📮 [Postman Download](https://www.postman.com/downloads/) - Baixe o Postman, a ferramenta para testar APIs.
- 📊 [DBeaver Download](https://dbeaver.io/download/) - Baixe o DBeaver, a ferramenta de gerenciamento de banco de dados.

## 🤝 Contribuindo

Se você deseja contribuir com o projeto, fique à vontade para abrir uma pull request ou uma issue.

## 📞 Contato 

<div>
    <a href="https://www.linkedin.com/in/joschonarth/" target="_blank"><img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" target="_blank"></a>
    <a href="mailto:joschonarth@gmail.com" target="_blank"><img src="https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white" target="_blank"></a>
</div>