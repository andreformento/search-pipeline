#############
# Build App
FROM openjdk:9-slim as build

ENV APP_HOME=/root/dev/

RUN mkdir -p $APP_HOME/src/main/java
RUN mkdir -p $APP_HOME/src/main/resources
RUN mkdir -p $APP_HOME/src/test/java
RUN mkdir -p $APP_HOME/src/test/resources

WORKDIR $APP_HOME
COPY gradlew $APP_HOME
COPY gradle $APP_HOME/gradle
# download gradle
RUN ./gradlew --continue

# for cache all dependencies
RUN touch "class GradleCache {}" > $APP_HOME/src/main/java/GradleCache.java
RUN touch "name=value" > $APP_HOME/src/main/resources/gradlecache.properties
RUN touch "class GradleCacheTest {}" > $APP_HOME/src/test/java/GradleCacheTest.java
RUN touch "name=value" > $APP_HOME/src/test/resources/gradlecache.properties

COPY build.gradle $APP_HOME

# download dependencies
RUN ./gradlew build --continue

ADD src $APP_HOME/src
RUN ./gradlew build

#############
# Final image
FROM openjdk:9-slim
WORKDIR /root/
COPY --from=build /root/dev/build/libs/*.jar app.jar
EXPOSE 8080
CMD ["java","-jar","app.jar"]
