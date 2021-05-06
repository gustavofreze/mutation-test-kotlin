IMAGE=adoptopenjdk/openjdk11:alpine-slim
DOCKER_RUN:=docker run --rm -it -v ${PWD}:/usr/app -w /usr/app ${IMAGE}

configure:
	- ${DOCKER_RUN} ./gradlew wrapper --gradle-version=7.0 --distribution-type=bin

test-unit:
	- ${DOCKER_RUN} ./gradlew clean test

test-mutation:
	- ${DOCKER_RUN} ./gradlew pitest