FROM tomcat:9.0-jdk8-openjdk-slim

ARG war_path=build/libs/*.war
RUN rm -rf /usr/local/tomcat/webapps
COPY ${war_path} /usr/local/tomcat/webapps/ROOT.war
