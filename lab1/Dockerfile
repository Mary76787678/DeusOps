FROM alpine

RUN apk update && \
    apk add nginx && \
    rm -rf /var/lib/apt/lists/*

USER nginx:nginx

COPY ./nginx/nginx.conf /etc/nginx/nginx.conf

CMD [ "nginx",  "-g", "daemon off;" ]