# Training Center Registry

This project is a simple Spring Boot application for managing a registry of government-funded training centers. It provides APIs for creating new training centers and retrieving a list of all stored training centers.

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java Development Kit (JDK) installed (version 8 or higher)
- Apache Maven installed
- Git installed
- Your favorite IDE (e.g., IntelliJ IDEA, Eclipse)

## Getting Started

To get started with this project, follow these steps:

Clone the repository to your local machine or download it as ZIP

     ```sh
     git clone https://github.com/PawanKumarRanjan/Backend_Traini8_PawanKumarRanjan.git

## Usage

Use the Postman to fire the request in order to hit the endpoints of application

1. Creating a New Training Center

   To create a new training center, send a POST request to the following endpoint:
   http://localhost:8080/api/training-centers/create-center

   In the body of request enter the JSON data:
   {
      "centerName": "ABC Training Center",
      "centerCode": "ABC123DEF456",
      "address": {
        "detailedAddress": "A Block",
        "city": "New Delhi",
        "state": "Delhi",
        "pincode": "123456"
      },
      "studentCapacity": 200,
      "coursesOffered": ["Course A", "Course B", "Course C"],
      "contactEmail": "abc@gmail.com",
      "contactPhone": "1234567890"
   }

2. Getting All Training Centers

   To retrieve a list of all stored training centers, send a GET request to the following endpoint:
   http://localhost:8080/api/training-centers/get-all-centers
