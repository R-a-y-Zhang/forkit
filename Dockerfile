FROM phusion/baseimage
COPY forkit-kotlin/* $HOME/main/
RUN apt-get update && \
    apt -y install openjdk-8-jdk wget unzip && \
    wget https://services.gradle.org/distributions/gradle-3.4.1-bin.zip && \
    mkdir /opt/gradle && \
    unzip -d /opt/gradle gradle-3.4.1-bin.zip && \
    ln -s /opt/gradle/gradle-3.4.1/bin/gradle /bin/gradle && \
    cd main && \
    gradle && \
    cd libs && \
    java -jar forkit-1.0-SNAPSHOT.jar
EXPOSE 8080
