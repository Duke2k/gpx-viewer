FROM openjdk:17
COPY target/gpx-viewer.jar /home
COPY target/classes/gpx /home/gpx
WORKDIR /home/
CMD ["java", "-jar", "./gpx-viewer.jar"]
EXPOSE 8080:8090/tcp
