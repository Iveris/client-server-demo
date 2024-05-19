# How to Run Docker Compose file

1. Set Environment Variables:
   - DB_USER
   - DB_PASSWORD
   - DB_ROOT

1. Remove any images of server or db from Docker

1. Start Docker

    ```bash
    docker compose up -d
    ```
1. Call API endpoints
   - http://localhost:8080/hello
     - get request that returns a string to confirm server is running
   - http://localhost:8080/hello-kitty
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
    - http://localhost:8080/name?name="Fluffy"
      - get request which returns information about Fluffy from the database
2. Shutdown Docker

    ```bash
    docker compose down
    ```