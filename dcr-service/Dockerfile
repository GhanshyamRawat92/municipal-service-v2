FROM maven:3.6.1-jdk-8-alpine as build

WORKDIR /app

COPY ./pom.xml .

COPY ./src ./src

RUN mvn -B -f /app/pom.xml dependency:go-offline


FROM openjdk:8-jdk-alpine

WORKDIR /opt/app

COPY  --from=build /app/target/*.jar /opt/app/*.jar

EXPOSE 8098

ENTRYPOINT ["java","-jar","/opt/app/*.jar"]


#COPY start.sh /usr/bin/start.sh

#RUN chmod +x /usr/bin/start.sh

#CMD ["/usr/bin/start.sh"]
