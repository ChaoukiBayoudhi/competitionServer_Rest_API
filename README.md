# Competition Server Rest API

A model, repository, service and controller REST API.

## Tech stack

- Java 15, built with Maven
- Spring Boot 2.3.4.RELEASE
- Spring Web (REST controllers)
- Spring Data JPA (Hibernate)
- Spring Data REST
- Bean Validation
- Spring Boot Actuator
- Lombok
- PostgreSQL driver
- H2 database
- Database: PostgreSQL (`competitiondb` in `application.properties`)

## Data model

| Entity | Fields |
|---|---|
| `Team` | id, name, creationDate, nbPlayers, players, its_stadium, its_competion |
| `Player` | Code, Name, BithDay, T_shirt_Number, Position, photo, his_team |
| `Competition` | id, name, country, startDate, endDate, teamsOfCompetion |

## REST endpoints

Found in the controllers (`competitionController`, `stadiumController`, `TeamController`, `PlayerController`):

| Method | Path |
|---|---|
| GET | `/competitions/all` |
| GET | `/competitions/compettion/{id}` |
| POST | `/competitions/newcompetition` |
| PUT | `/competitions/competition/{id}` |
| DELETE | `/competitions/competition/{id}` |
| GET | `/stadiums/all` |
| GET | `/stadiums/stadium/{id}` |
| POST | `/stadiums/newstadium` |
| DELETE | `/stadiums/stadium/{id}` |
| PUT | `/stadiums/stadium/{id}` |
| GET | `/all` |
| POST | `/newteam` |
| GET | `/team/{id}` |
| DELETE | `/team/{id}` |
| PUT | `/team/{id}` |
| GET | `/players/player/{id}` |
| POST | `/players/player` |

## Project structure

- `tn.esb.j2ee.competitionServer`: CompetitionServerApplication
- `tn.esb.j2ee.competitionServer.Controllers`: PlayerController, TeamController, competitionController, stadiumController
- `tn.esb.j2ee.competitionServer.Models`: Competition, Player, Stadium, Team
- `tn.esb.j2ee.competitionServer.Repositories`: competitionRepository, playerRepository, stadiumRepository, teamRepository
- `tn.esb.j2ee.competitionServer.Services`: competitionService, playerService, stadiumService, teamService
- Tests: 1 test class

## How to run

Requirements: a JDK 15+ and Maven (or the included Maven wrapper).
Create the `competitiondb` database and set your own username and password in `src/main/resources/application.properties`.

```bash
./mvnw spring-boot:run
```

The API then listens on `http://localhost:9592`.

---

Author: [Chaouki Bayoudhi](https://github.com/ChaoukiBayoudhi)
