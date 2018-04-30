FROM java:8
VOLUME /tmp
ADD target/flozano.calculator-1.0-SNAPSHOT.jar calculator.jar
RUN bash -c 'touch /calculator.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /calculator.jar"]
