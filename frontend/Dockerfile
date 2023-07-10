# Dockerfile for Letterix frontend
FROM node:16-alpine as build
WORKDIR /app
COPY . .
RUN yarn install --network-timeout 600000
RUN yarn run build