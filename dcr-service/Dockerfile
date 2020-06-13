FROM maven:3.6.1-jdk-8-alpine as build

WORKDIR /app

# COPY [source] [destination]
COPY ./pom.xml . 
#or
# COPY ./pom.xml ./pom.xml

#COPY ./start.sh .

COPY ./src ./src

RUN mvn -B -f /app/pom.xml clean install

FROM openjdk:8-jdk-alpine

WORKDIR /opt/app

COPY --from=build /app/target/*.jar /opt/app/*.jar

#COPY --from=build /app/target/*.jar /opt/app/*.jar
#COPY --from=build /app/start.sh /opt/app/start.sh

EXPOSE 8098

#RUN chmod +x /opt/app/start.sh

#CMD ["/opt/app/start.sh"]

ENTRYPOINT ["java","-jar","/opt/app/*.jar"]


#COPY start.sh /usr/bin/start.sh

#RUN chmod +x /usr/bin/start.sh

#CMD ["/usr/bin/start.sh"]
