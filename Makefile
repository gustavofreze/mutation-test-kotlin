DOCKER_RUN:=docker run --rm -it -v ${PWD}:/app -w /app gustavofreze/kotlin-1.5.0

configure:
	- ${DOCKER_RUN} ./gradlew wrapper --gradle-version=7.0 --distribution-type=bin

test-unit:
	- ${DOCKER_RUN} ./gradlew clean test

test-mutation:
	- ${DOCKER_RUN} ./gradlew pitest