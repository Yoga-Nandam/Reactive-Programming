
# EMS using Spring Reactive Programming

The EMS service is built using Spring WebFlux Framework. Using this service CRUD of Employee can be performed.

## Authors

- [@Yoga-Nandam](https://github.com/Yoga-Nandam)


## API Reference

#### Post employee

```http
  POST /api/employees
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `Employee` | `Object` | **Required**. Employee object |

#### Get employee

```http
  GET /api/employees/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of employee to fetch |

#### Get all employees

```http
  GET /api/employees
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| NA      | `NA` | **Required**. NA |

```http
  PUT /api/employees/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of employee to fetch |
| `Employee` | `Object` | **Required**. Employee object |

#### Delete employee

```http
  Delete /api/employees/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of employee to fetch |


## Tech Stack

**Datebase:** MongoDB

**Server:** Spring WebFlux, Reactive Programming


## Installation

Install MongoDB server & Compass

```bash
  1). Download atleast MongoDB msi from  https://www.mongodb.com/try/download/community
  2). Install server by double clicking msi.
  3). CD to \MongoDB\Server\7.0\bin
  4). Create a folder in C:/data/db
  5). Type mongod in cmd to start the server
  6). Open Mongo Compass and connect to mongodb://localhost:27017

```

## Run Locally

Clone the project

```bash
  git clone https://link-to-project
```

Go to the project directory

```bash
  cd my-project
```

Install dependencies

```bash
  mvn clean install
```

Start the server

```bash
  mvn spring-boot:run
```

