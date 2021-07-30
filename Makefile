DOCKER_COMPOSE = docker-compose
DOCKER_EXEC = docker exec -it mutation-test-kotlin bash
GRADLEW = ${DOCKER_EXEC} ./gradlew

configure:
	@${DOCKER_COMPOSE} up -d --build
	@${GRADLEW}

test-unit:
	@${GRADLEW} test

test-mutation:
	@${GRADLEW} pitest
