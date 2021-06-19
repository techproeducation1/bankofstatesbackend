FROM tomcat

COPY /home/legion/bankofstatesbackend/target/bankofStates-1.0.jar /usr/local/tomcat/webapps/

EXPOSE 8080

CMD [“catalina.sh”, “run”]
