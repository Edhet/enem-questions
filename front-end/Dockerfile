FROM node:alpine

WORKDIR /usr/src/app

COPY . /usr/src/app

RUN npm install

EXPOSE 4200

CMD ["npm", "run", "ng", "serve"]
