# How to Run Docker Compose file

1. Clone project
   1. make sure Java 21 is installed and in your PATH 
      1. [SDKMAN](https://sdkman.io/) is a great tool for managing multiple Java versions

1. Create application-secrets.yml and application-docker-secrets.yml in the src/main/resources folder using the example files

1. Set the DB_USER, DB_PASSWORD, and DB_ROOT Environment Variables by sourcing the export_db_config.sh script
   ```bash
      . ./export_db_config.sh
   ```

1. Remove any images of server or db from Docker

1. Test and Compile Project
   1. Start mysql server 
      ```bash 
      docker compose -f mysql-compose.yaml up -d
      ``` 
   
   2. Build the image
      ```bash 
      mvn package 
      ``` 
   
   3. Close down myql server
      ```bash 
      docker compose -f mysql-compose.yaml down
      ``` 

3. Start Main Docker Compose Project
    ```bash
    docker compose up --build -d
    ```
4. Call API endpoints
   - http://localhost:8080/kitties/hello
     - get request that returns a string to confirm server is running
   - http://localhost:8080/kitties/hello-kitty
     - post request to enter a new kitty into the database with the following body:
         ```json
         {
            "name": "Fluffy",
            "owner": "Mr. Fluffy",
            "eyeColor": "brown",
            "weight": 8.0,
            "intelligence": 6,
            "description": "likes to lay around in the sun"
         }
         ```
    - http://localhost:8080/kitties/name?name="Fluffy"
      - get request which returns information about Fluffy from the database
5. Shutdown Docker
    ```bash
    docker compose down --rmi local
    ```
