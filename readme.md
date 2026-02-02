[LICENSE__BADGE]: https://img.shields.io/github/license/Fernanda-Kipper/Readme-Templates?style=for-the-badge
[JAVA_BADGE]: https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white
[SPRING_BADGE]: https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white
[PRS_BADGE]: https://img.shields.io/badge/PRs-welcome-green?style=for-the-badge

<h1 align="center" style="font-weight: bold;">API Rest Alexandria 💻</h1>

![spring][SPRING_BADGE]
![java][JAVA_BADGE]
![prs][PRS_BADGE]

<details open="open">
<summary>Table of Contents</summary>

- [🚀 Getting started](#started)
  - [Prerequisites](#prerequisites)
  - [Cloning](#cloning)
  - [Environment Variables](#environment-variables)
  - [Starting](#starting)
- [📍 API Endpoints](#routes)
  - [GET /authenticate](#get-auth-detail)
  - [POST /authenticate](#post-auth-detail)
- [🤝 Collaborators](#colab)
- [📫 Contribute](#contribute)

</details>

<p align="center">
  <b>
    REST API for managing books, authors, and publishers, built with Spring Boot and Spring Data JPA, inspired by the 
    <a href="https://en.wikipedia.org/wiki/Library_of_Alexandria">Library of Alexandria</a>.
  </b>
</p>

<h2 id="started">🧠 Concepts Applied in This Project</h2>
<h3>🔹 Spring & Persistence</h3>
<ul>
  <li>Spring Boot</li>
  <li>Spring Data JPA</li>
  <li>Hibernate</li>
  <li>MySQL</li>
  <li>Configuration using `application.properties`</li>
  <li>Database migrations and seeds</li>
  <li>Pagination</li>
</ul>
<h3>🔹 Architecture</h3>

<ul>
  <li>Layered architecture (Controller, Service, Repository)</li>
  <li>Dependency Injection</li>
  <li>Spring Beans and Components</li>
  <li>DTO (Data Transfer Object) pattern</li>
  <li>Java Records (when applicable)</li>
  <li>Docker and Docker Compose</li>
</ul>

<h3>🔹 Relationships</h3>
Database diagram: <br />
<img src="https://github.com/Emanuel-Marques/api-rest-alexandria/blob/main/src/main/resources/static/db-diagram.png?raw=true" />


<h2 id="started">🚀 Getting started</h2>

Here you describe how to run your project locally

<h3>Prerequisites</h3>

Here you list all prerequisites necessary for running your project. For example:

- [Java 17+](https://www.oracle.com/java/)
- [Maven](https://maven.apache.org/)
- [MySQL](https://www.mysql.com/)
- [Docker](https://www.docker.com/) (optional)

<h3>Cloning</h3>

How to clone your project

```bash
git clone https://github.com/Emanuel-Marques/api-rest-alexandria.git
```

<h3>Environment Variables</h2>

Use the `application.properties.example` as reference to create your configuration file `application.properties`

```yaml
spring.datasource.url=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
```

<h3>Starting</h3>

How to start your project:

<b>Using Maven: </b>

```bash
cd api-rest-alexandria
mvn spring-boot:run
```

<b> Or using Docker: </b>

```bash
cd api-rest-alexandria
docker-compose up
```

The application will be available at:
`http://localhost:8080/`

<h2 id="routes">📍 API Endpoints</h2>

Here you can list the main routes of your API, and what are their expected request bodies.


<h3>📘 Authors</h3>


<h2 id="colab">🤝 Collaborators</h2>

Special thank you for all people that contributed for this project.

<table>
  <tr>
    <td align="center">
      <a href="#">
        <img src="https://avatars.githubusercontent.com/u/70699733?v=4" width="100px;" alt="Emanuel Marques Profile Picture"/><br>
        <sub>
          <b>Emanuel Marques</b>
        </sub>
      </a>
    </td>
  </tr>
</table>

<h2 id="contribute">📫 Contribute</h2>

Here you will explain how other developers can contribute to your project. For example, explaining how can create their branches, which patterns to follow and how to open an pull request

1. `git clone https://github.com/Emanuel-Marques/api-rest-alexandria.git`
2. `git checkout -b feature/NAME`
3. Follow commit patterns
4. Open a Pull Request explaining the problem solved or feature made, if exists, append screenshot of visual modifications and wait for the review!

<h3>Documentations that might help</h3>

[📝 How to create a Pull Request](https://www.atlassian.com/br/git/tutorials/making-a-pull-request)

[💾 Commit pattern](https://gist.github.com/joshbuchea/6f47e86d2510bce28f8e7f42ae84c716)
