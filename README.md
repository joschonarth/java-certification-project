# 🎓 Certificação de Estudantes API

Esta API foi desenvolvida para gerenciar a geração de certificações para estudantes com base em seu desempenho em testes. O sistema permite que os estudantes respondam a um conjunto de questões e, se o desempenho for satisfatório, eles poderão obter uma certificação na tecnologia escolhida.

## 🛠️ Tecnologias Utilizadas

- ☕ **Java 17**
- 🌱 **Spring Boot**
- 🗃️ **Spring Data JPA**
- 🐘 **PostgreSQL**
- 🐳 **Docker**
- 📦 **Maven**
- 🔧 **Lombok**

## 💡 Funcionalidades

- 📊 **Avaliação de desempenho**: O estudante responde a um conjunto de questões, e o sistema avalia automaticamente seu desempenho.
<!-- - 🏅 **Geração de certificações**: Estudantes com desempenho satisfatório recebem uma certificação. -->
- 🏆 **Ranking dos melhores colocados**: O sistema gera um ranking dos 10 melhores estudantes, com base em suas pontuações.


## 🛠️ Pré-requisitos

Antes de rodar o projeto, certifique-se de ter os seguintes requisitos instalados:

- ☕ [Java 17](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- 📦 [Maven](https://maven.apache.org/download.cgi)
- 🐳 [Docker](https://www.docker.com/get-started)
- 🐘 [PostgreSQL](https://www.postgresql.org/download/)





```bash
Usuário pode fazer a prova

```



```java
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


```java
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