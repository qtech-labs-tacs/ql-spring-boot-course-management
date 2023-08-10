FROM openjdk:8

WORKDIR /home

COPY target/course-management-1.0.jar .

CMD ["java", "-jar" , "course-management-1.0.jar"]  
