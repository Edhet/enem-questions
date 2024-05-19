FROM node:lts-alpine3.19

RUN npm install -g http-server
WORKDIR /app
COPY ./front-end/package*.json ./
RUN npm install

COPY ./front-end/. .
RUN npm run build

EXPOSE 8080
CMD [ "http-server", "dist" ]