# Customer Service Backend

A Spring Boot backend for managing customers and their additional details, with robust validation, error handling, and interactive API documentation (Swagger UI).

---

## **Features**

- **Customer Management:** Add, update, get, and delete customers.
- **Additional Details:** Add and update extra key-value details for each customer.
- **Validation:** All input is validated for correctness.
- **Database Migrations:** Uses Flyway for schema management.
- **API Documentation:** Swagger UI for interactive API exploration and testing.
- **PostgreSQL Database:** All data is stored in a relational database.

---

## **Tech Stack**

- Java 17+
- Spring Boot 3.x
- Spring Data JPA (Hibernate)
- PostgreSQL
- Flyway (DB migrations)
- Lombok (boilerplate reduction)
- Swagger/OpenAPI (API docs)

---

## **Getting Started**

### **1. Clone the Repository**
```sh
git clone <repo-url>
cd customer-service
```

### **2. Configure Database**

- Default DB: `customer`
- Default user: `postgres`
- Default password: `postgres`
- Change these in `src/main/resources/application.yml` if needed.

### **3. Run Database Migrations**
```sh
./gradlew migrateCustomer
```
This will create the required tables (`customer`, `additional_details`) and constraints.

### **4. Build and Run the Application**
```sh
./gradlew bootRun
```
The server will start on [http://localhost:8080](http://localhost:8080).

---

## **API Documentation**

Once the app is running, open [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)  
Here you can see, try, and test all APIs interactively.

---

## **Database Schema**

### **Customer Table**
| Column      | Type      | Description         |
|-------------|-----------|---------------------|
| id          | UUID      | Primary Key         |
| name        | varchar   | Customer Name       |
| email       | varchar   | Unique, not null    |
| is_active   | boolean   | Active status       |
| created_at  | timestamp | Creation time       |
| updated_at  | timestamp | Last update time    |

### **Additional Details Table**
| Column         | Type      | Description                |
|----------------|-----------|----------------------------|
| id             | UUID      | Primary Key                |
| user_id        | UUID      | Customer ID (foreign key)  |
| attribute_key  | varchar   | Key (e.g., "address")      |
| attribute_value| varchar   | Value (e.g., "Delhi")      |
| is_encrypted   | boolean   | Always true (default)      |
| created_at     | timestamp | Creation time              |
| updated_at     | timestamp | Last update time           |

**Unique Constraint:**  
A customer cannot have two additional details with the same key (`user_id + attribute_key` is unique).

---

## **API Usage**

### **Customer APIs**

#### **Add Customer**
- **POST** `/v1/customer`
- **Request Body:**
  ```json
  {
    "name": "Arsh",
    "email": "arsh@example.com",
    "isActive": true
  }
  ```

#### **Get Customer**
- **GET** `/v1/customer?userId=<customer-uuid>`

#### **Update Customer**
- **PUT** `/v1/customer/{id}`
- **Request Body:**
  ```json
  {
    "id": "customer-uuid",
    "updatedName": "New Name",
    "updatedEmail": "new@email.com",
    "updatedIsActive": false
  }
  ```

#### **Delete Customer**
- **DELETE** `/v1/customer/{id}`
- **Request Body:**
  ```json
  {
    "id": "customer-uuid"
  }
  ```

---

### **Additional Details APIs**

#### **Add Additional Details**
- **POST** `/v1/additionalDetail`
- **Request Body:**
  ```json
  {
    "userId": "customer-uuid",
    "isEncrypted": true,
    "additionalDetails": [
      {
        "attributeKey": "address",
        "attributeValue": "Delhi"
      },
      {
        "attributeKey": "phone",
        "attributeValue": "9876543210"
      }
    ]
  }
  ```

#### **Update Additional Detail**
- **PUT** `/v1/additionalDetail/update`
- **Request Body:**
  ```json
  {
    "userId": "customer-uuid",
    "attributeKey": "address",
    "updatedAttributeValue": "New Delhi"
  }
  ```

---

## **Validation & Error Handling**

- All APIs validate input (e.g., email format, required fields).
- Errors return clear messages and HTTP status codes.

---

## **Swagger UI Example**

- Go to [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- Try out any API, see request/response formats, and test live.

---

## **How it Works (Flow)**

1. **Customer APIs** let you manage customer records.
2. **Additional Details APIs** let you add/update extra info for each customer.
3. All data is stored in PostgreSQL, with schema managed by Flyway.
4. All APIs are documented and testable via Swagger UI.

---

## **Contributing**

- Fork, clone, and create a PR!
- For any issues, open a GitHub issue.

---

## **License**

MIT

---

**If you need more details or want to add more features (like authentication), see the code comments or open an issue!**
