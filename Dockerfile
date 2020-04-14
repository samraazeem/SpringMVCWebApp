FROM tomcat:8.5-alpine
ADD target/SpringMVCWebApp.war /usr/local/tomcat/webapps/
EXPOSE 8085
CMD [ "catalina.sh", "run", "docker run -p 80:8085 SpringMVCWebApp" ] 