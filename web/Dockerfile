FROM nginx:1.20-alpine
ENV TZ Asia/Tokyo

RUN apk update

COPY nuxtjs-src/dist/ /usr/share/nginx/html/
COPY nginx/ /etc/nginx/