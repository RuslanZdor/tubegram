# Pull base image.
FROM ubuntu:latest

RUN \
# Update
apt-get update -y && \
# Install Java
apt-get install default-jre -y

ADD ./target/tubegram-1.0.jar tubegram.jar

EXPOSE 8090

CMD java -jar tubegram.jar