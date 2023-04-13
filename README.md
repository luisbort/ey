# ey
Ey Test

Data Base Model
    src/main/resources/DBModel/DB-model.png

Creation Schema and Tables
    src/main/resources/schema.sql

Script for Data Tables
    src/main/resources/data.sql


## How to get JWT (Token)
In Postman, create a new "POST" Request using this URL: http://localhost:8080/login

Body -> raw -> JSON

{ "email": "email-registered-in-database", "password": "password-nor-encrypted" }

In Response Header section will be the token in "Authorization" field. This Token can be used in all Headers for each request.




