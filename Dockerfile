FROM adoptopenjdk:11-jre-hotspot as builder

# ARG JAR_FILE=build/libs/cephalopodwebsite-*.jar
# COPY ${JAR_FILE} app.jar
# RUN java -Djarmode=layertools -jar app.jar extract

COPY ./build/libs/cephalopodwebsite-*.jar /usr/app/

WORKDIR /usr/app
#
#FROM adoptopenjdk:11-jre-hotspot
#
#RUN mkdir /deployments \
#    && chown 1001 /deployments \
#    && chmod "g+rwX" /deployments \
#    && chown 1001:root /deployments
#
#COPY --chown=1001 --from=builder dependencies/ /deployments/
#COPY --chown=1001 --from=builder snapshot-dependencies/ /deployments/
#COPY --chown=1001 --from=builder spring-boot-loader/ /deployments/
#COPY --chown=1001 --from=builder application/ /deployments/

ENTRYPOINT ["java", "-jar", "/usr/app.jar"]
EXPOSE 8080
USER 1001
