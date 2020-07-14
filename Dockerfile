FROM openjdk:8-jdk-alpine
ADD /build/libs/card-validator-*.jar card-validator.jar

# Make port 8007 available to the world outside this container
EXPOSE 8010


# Run the jar file 
ENTRYPOINT java -DAPI_PORT=${API_PORT} -DAPI_DATABASE_URL=${API_DATABASE_URL} -DAPI_DATABASE_NAME=${API_DATABASE_NAME} -DAPI_DATABASE_USERNAME=${API_DATABASE_USERNAME} -Duser.timezone=America/Sao_Paulo -Xms512m -Xmx512m -jar card-validator.jar