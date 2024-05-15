# Most Wanted Fugitives Server

## Description

This is a server for the Most Wanted Fugitives Repository.
Its getting messages via RabbitMQ and storing them in the PostgresSQL.
Then creating an API endpoint to get the data from the database.(api/v1/fugitives)
Its now located on the http://64.226.75.81:8080.

## Installation

1. Clone the repository
2. Run `docker-compose up` in the root directory
3. The server is now running on http://localhost:8080
4. To stop the server run `docker-compose down`

## Usage

1. Get all fugitives: `GET /api/v1/fugitives`
2. Get a specific fugitive: `GET /api/v1/fugitives/{id}`
3. Get all fugitives by color: `GET /api/v1/fugitives/all/{color}`
4. Get count of all fugitives: `GET /api/v1/fugitives/count`
5. Get only image of fugitives: `GET /api/v1/fugitives/image/{id}`


# Future Improvements
1. Add more endpoints to get the data in different ways.
2. Add more data to the database.
3. Add more tests to the server.

