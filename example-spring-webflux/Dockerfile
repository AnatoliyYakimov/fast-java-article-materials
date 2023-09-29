FROM maven:3.9.4-amazoncorretto-21 as build

WORKDIR /spring


ADD pom.xml pom.xml
RUN --mount=type=cache,target=~/.m2/repository/ \
    mvn package -Dmaven.test.skip -Declipselink.weave.skip

ADD src src
RUN --mount=type=cache,target=~/.m2/repository/ \
    mvn package -DskipTests

RUN echo "done!"

# 2nd stage, build the runtime image
FROM container-registry.oracle.com/java/openjdk:21
WORKDIR /spring

# Copy the binary built in the 1st stage
COPY --from=build /spring/target/*.jar ./application.jar
#COPY --from=build /spring/target/libs ./libs

CMD java $JAVA_OPTS -jar application.jar

EXPOSE 8080
