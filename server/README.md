# How to Run Docker Compose file

1. Clone project
   1. make sure Java 21 is installed and in your PATH 
      1. [SDKMAN](https://sdkman.io/) is a great tool for managing multiple Java versions

1. Set Environment Variables:
   - DB_USER
   - DB_PASSWORD
   - DB_ROOT

1. Remove any images of server or db from Docker

1. Test and Compile Project
   1. Start mysql server by running ```bash docker compose -f mysql-compose.yaml up -d``` from the command line
   2. Run ```bash mvn verify``` from server root directory
   3. Tear down myql server by running ```bash docker compose -f mysql-compose.yaml down``` from the command line

2. Start Main Docker Compose Project

    ```bash
    docker compose up -d
    ```
3. Call API endpoints
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
4. Shutdown Docker

    ```bash
    docker compose down
    ```