FROM openjdk:8

ENV PROJECT_HOME=/usr/src
RUN mkdir -p $PROJECT_HOME/activator $PROJECT_HOME/app

WORKDIR $PROJECT_WORKPLACE/activator
RUN curl -O https://downloads.typesafe.com/typesafe-activator/1.3.12/typesafe-activator-1.3.12.zip 
RUN unzip typesafe-activator-1.3.12.zip -d / && rm typesafe-activator-1.3.12.zip && chmod a+x /activator-dist-1.3.12/bin/activator

ENV PATH $PATH:/activator-1.3.12
COPY . $PROJECT_HOME/app
WORKDIR $PROJECT_HOME/app

EXPOSE 9000
CMD ["/activator-dist-1.3.12/bin/activator", "run"]
