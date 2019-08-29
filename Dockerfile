#FROM gradle
##FROM openjdk:8-jdk-alpine
##
##RUN apk add --no-cache bash && \
##    apk add --no-cache -t build-dependencies wget && \
##    cd /usr/lib && \
##    wget -q https://github.com/JetBrains/kotlin/releases/download/v1.3.50/kotlin-compiler-1.3.50.zip && \
##    unzip kotlin-compiler-*.zip && \
##    rm kotlin-compiler-*.zip && \
##    rm -f kotlinc/bin/*.bat && \
##    apk del --no-cache build-dependencies
##
##ENV PATH $PATH:/usr/lib/kotlinc/bin
##
##CMD ["kotlinc"]
#
#
#RUN mkdir /app
#WORKDIR /app
#ADD . /
#RUN gradle build

FROM gradle

RUN mkdir /app

WORKDIR /app

ADD . /app

RUN gradle build --no-daemon

RUN gradle bootRun


#COPY --chown=gradle:gradle . /home/gradle/src
#WORKDIR /home/gradle/src
#RUN gradle build --no-daemon
#
#FROM openjdk:8-jre-slim
#
#EXPOSE 8080
#
#RUN mkdir /app
#
#COPY --from=build /home/gradle/src/build/libs/*.jar /app/spring-boot-application.jar