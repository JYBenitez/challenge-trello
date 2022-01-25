# challenge-trello
This repo contains my approach to proposal challenge
## Requeriments to run
* Java sdk 15
* DB MySql
* Account in trello

### Data base Mysql
You should run script to create model. The script is [here](https://github.com/JYBenitez/challenge-trello/blob/c56e9f3ecee35ed0623871bbff42df93598ed7e3/src/main/resources/script/create-data-base#L1)

### Trello
You should create account in trello and get token to call apis. You can see abouat this [here](https://developer.atlassian.com/cloud/trello/guides/rest-api/api-introduction/)

## Development quick start

```
git clone git@github.com:JYBenitez/challenge-trello.git
cd challenge-trello
git checkout main
```
We recommend using [Intellij IDEA](https://www.jetbrains.com/es-es/idea/download/#section=windows)

### Setup
You'll need setup this keys in `application.properties`
* trello.api.key: It's the api key that you'll get when configure your trello dashboard
* trello.token:  It's the token that you'll get when configure your trello account
* trello.board.id: You should create a new board to its managnment. Into variable, you should identifier of board
* trello.list.unassignment: This variable identify your list where you wish save your assigment card
* trello.list.todo: This variable identify your "To-Do" list.
* trello.label.bug: This variable identify your "Bug" label in the board.
* trello.label.maintenance: This variable identify your "maintenance" label in the board.
* trello.label.test: This variable identify your "test" label in the board.
* trello.label.research: This variable identify your "research" label in the board.
* trello.mamber.id: This variable identify your member in the board, who'll receive issues.

```
trello.api.uri=https://api.trello.com/1/
trello.api.key=
trello.token=
trello.board.id=
trello.list.id=
trello.list.unassignment=
trello.list.todo=
trello.label.bug=
trello.label.maintenance=
trello.label.test=
trello.label.research=
trello.mamber.id=
```
### Preload data base
To run application is necessary basic information. this is easily created with "LoadDataBase" in main root project

## Api documentation
You can see documentation & examples in [here](https://documenter.getpostman.com/view/5634381/UVXqGDqA)
