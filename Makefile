DOCKER_COMPOSE := docker-compose -f docker-compose.yml
DOCKER_EXEC := docker exec -it mutation_test_kotlin bash

configure:
	${DOCKER_COMPOSE} up -d --build

test-unit:
	${DOCKER_EXEC} ./gradlew clean test

test-mutation:
	${DOCKER_EXEC} ./gradlew clean pitest

show-coverage:
	google-chrome build/reports/tests/test/index.html
