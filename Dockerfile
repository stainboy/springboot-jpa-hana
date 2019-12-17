FROM gradle:6.0-jdk8 as builder
WORKDIR /workspace
COPY / /workspace/
RUN gradle build

FROM gcr.io/distroless/java:8 as runtime
CMD [ "/opt/app/demo.jar" ]
EXPOSE 8080
COPY --from=builder /workspace/build/libs/springboot-jpa-hana-0.1.0.jar /opt/app/demo.jar
