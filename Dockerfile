FROM ubuntu:jammy as builder

RUN apt-get update && \
    apt-get install curl wget unzip zip maven -y

RUN curl -s "https://get.sdkman.io" | bash
RUN /bin/bash -c "source $HOME/.sdkman/bin/sdkman-init.sh; sdk install java 17.0.7-graal"


RUN mvn --version

COPY ./wzrd-annotation-processor /var/wzrd-annotation-processor
COPY ./ /var/wzrd-test-project
RUN export JAVA_HOME="$HOME/.sdkman/candidates/java/current" && \
    cd /var/wzrd-annotation-processor && \
    mvn clean install -DskipTests && \
    cd /var/wzrd-test-project && \
    mvn clean install -DskipTests


FROM ghcr.io/graalvm/graalvm-community:17.0.7-ol9 as run

ENV LANG en_US.UTF-8

RUN gu install ruby

COPY --from=builder /var/wzrd-test-project/target/wzrd-test-project-0.0.1-SNAPSHOT.jar /app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
