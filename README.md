# Employee-Service
paypal test
Postman Output
---------------
1)To get employee id

GET
localhost:8080/v1/bfs/employees/1

Response status: 200 OK
Body:
{
    "id": 1,
    "first_name": "Kiran",
    "last_name": "Hosur",
    "birth_date": "01-07-1992",
    "address_id": "1",
    "address": {
        "line1": "8th cross ",
        "city": "Bangalore",
        "state": "Karnataka",
        "country": "India",
        "zipcode": "560010"
    }
}

2) To create a new employee
POST
localhost:8080/v1/bfs/employees
Payload:
{
    "first_name": "Arun",
    "last_name": "Hosur",
    "birth_date": "01-16-1997",
    "address_id": "2",
    "address": {
        "line1": "11th main D block",
        "city": "Bangalore",
        "state": "Karnataka",
        "country": "India",
        "zipcode": "560010"
    }
}

Response status: 200 OK
Body:
{
    "id": 2,
    "first_name": "Arun",
    "last_name": "Hosur",
    "birth_date": "01-16-1997",
    "address_id": "2",
    "address": {
        "line1": "11th main D block",
        "city": "Bangalore",
        "state": "Karnataka",
        "country": "India",
        "zipcode": "560010"
    }
}

3) Bad Request validations
POST
localhost:8080/v1/bfs/employees
Payload:
{
    "first_name": "Testing save"
}

Response status: 400 Bad Request
Body: empty
