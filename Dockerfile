FROM gustavofreze/kotlin-1.5.0 AS dev

ARG DIR='./build.gradle ./settings.gradle ./bin ./share'

RUN chmod +x ${DIR} \
    && rm -rf ${DIR}

COPY ./src ./src
COPY ./build.gradle.kts ./
COPY ./settings.gradle.kts ./

RUN ./gradlew

EXPOSE 80
