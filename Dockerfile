FROM www.yusora.top/library/jdk1.8

EXPOSE 9090

COPY target/*.jar /app.jar

ENTRYPOINT ["java","-jar","/app.jar"]