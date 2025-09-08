# Complaint Management Project - Blueprint & Features

## 📅 Date: 2025-09-08

## 📂 Blueprint of the Project

This project is designed to manage complaints raised by students within an educational institution. It provides a backend service to store and retrieve complaints, allowing students to raise issues and teachers or administrators to track and update their statuses.

### ✅ Project Structure

* **Backend:** Built with Spring Boot, connected to MySQL database.
* **Frontend:** To be built later (HTML/CSS/JavaScript or frameworks).

---

## 📘 Features to Implement

### 📚 Student Dashboard (Backend)

1. **Raise Complaint**

   * Endpoint: `POST /Student/Complaint`
   * Features:

     * Submit a new complaint with title, description, and category.
     * Automatically mark the complaint as "Raised".
     * Keep student identity anonymous.

2. **View Complaints**

   * Endpoint: `GET /Student/SeeComplaint`
   * Features:

     * Retrieve a list of all complaints.
     * Display status updates (e.g., Raised, In Progress, Resolved).
     * Ensure that student names are not exposed.

---

### 👩‍🏫 Teacher/Admin Dashboard (Backend)

1. **View Complaints**

   * Endpoint: `GET /Teacher/SeeComplaint`
   * Features:

     * Retrieve all complaints submitted by students.
     * View complaint details including title, description, category, and status.

2. **Update Complaint Status**

   * Endpoint: `PUT /Teacher/UpdateComplaintStatus`
   * Features:

     * Update the status of a complaint (e.g., from Raised to In Progress or Resolved).
     * Ensure that updates are recorded in the database.



## 📅 Date: 2025-09-08

## ✅ Work Summary

Today, I worked on the backend of the Complaint Management Project. I learned how to create models, repositories, services, and controllers using Spring Boot and connected them to a MySQL database. I implemented endpoints to raise and view complaints and tested the functionality using Postman.

## 📂 What I Implemented

### 1. Project Setup

* Created a Spring Boot project named `ComplaintManagementProject`.
* Structured packages into `Model`, `Repository`, `Service`, and `Controller`.
* Configured database connection using `application.properties`.

### 2. Complaint Model

* Defined fields like `id`, `title`, `description`, `category`, and `status`.
* Used annotations like `@Entity`, `@Id`, and `@GeneratedValue`.
* Added constructors to set default and parameter values.

### 3. Repository Layer

* Created `ComplaintRepository` by extending `JpaRepository<Complaint, Integer>`.
* Learned that `Complaint` is the entity and `Integer` is the type for the primary key.

### 4. Service Layer

* Created `ComplaintService` to manage complaint operations.
* Implemented methods to add complaints and retrieve all complaints.
* Used `@Autowired` to inject `ComplaintRepository`.

### 5. Controller Layer

* Developed endpoints:

  * `POST /Student/Complaint` to submit complaints.
  * `GET /Student/SeeComplaint` to view all complaints.
* Learned how to map requests and use request parameters.

## ❓ Questions I Faced and Solved

1. **Why is `Complaint` used in the repository and not `id`?**

   * Because `JpaRepository` needs the entity and the primary key type, not just the key.

2. **Why use constructors instead of methods?**

   * Constructors are used to create objects with initial values when a new instance is created.

3. **Why create a `Complaint` object in the service?**

   * We need an object to represent the complaint before saving it to the database.

4. **Why use `@Autowired` in the service?**

   * It automatically connects the repository to the service without extra coding.

5. **Why return `Complaint` from controller methods?**

   * Returning the object confirms that the complaint is successfully saved.

6. **Why use `@PostMapping` and `@GetMapping`?**

   * POST is for submitting new data, and GET is for retrieving existing data.

## 🚀 Troubleshooting

* Faced a `404` error because the URL had a newline character (`%0A`). Fixed it by checking the request URL carefully.


## 🧠 Lessons Learned

* Dependency injection simplifies the connection between components.
* Constructors are essential for initializing objects.
* Understanding how REST APIs communicate is key for building backend systems.
* Debugging common errors improves coding skills and attention to detail.

---

## ✅ Features Already Implemented

* ✅ Backend structure with models, repositories, services, and controllers.
* ✅ MySQL database connection with `Complaint` entity.
* ✅ Student endpoints for raising and viewing complaints.
* ✅ Proper use of dependency injection (`@Autowired`) and RESTful mappings (`@PostMapping`, `@GetMapping`).

---







