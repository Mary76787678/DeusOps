FROM alpine AS builder

WORKDIR /app

RUN apk add maven --no-cache

COPY . .

RUN mvn package
###
FROM alpine

WORKDIR /app

RUN apk add openjdk21 --no-cache && \
    addgroup -S lab2 && \
    adduser -S lab2 -G lab2

USER lab2:lab2

COPY --from=builder /app/target/*.jar app.jar

CMD [ "java", "-jar", "app.jar" ] 