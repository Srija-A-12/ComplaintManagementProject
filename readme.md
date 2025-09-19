# 📌 Complaint Management System

A **role-based Complaint Management System** built using **Spring Boot, Spring Security, MySQL, Tailwind CSS, and JavaScript**.
It allows **students** to submit complaints and **teachers (HOD/MAM)** to manage and update their status.

---

Perfect 👌 let’s add some **emojis** to make your GitHub README more engaging while still professional.
Here’s your **Backend + Database only role** section with emojis included:

---

## 👩‍💻 My Role & Contributions

I was responsible for the **Backend and Database Development** of this project.

* ⚙️ **Backend Development (Spring Boot + Spring Security + JPA)**

  * 🛠️ Implemented REST APIs for **student and teacher complaint management**.
  * 🏗️ Designed and developed the **Entity → Repository → Service → Controller** architecture.
  * 🔑 Built **user registration and login system** with email restrictions (`srmist.edu.in`) and **BCrypt password encryption**.
  * 🔒 Configured **Spring Security** for role-based access control (Student / Teacher).
  * 🚦 Added **custom authentication success handler** for redirecting users based on roles.

* 🗄️ **Database Design & Integration (MySQL)**

  * 📝 Designed relational schema for authentication, complaints, and complaint updates.
  * 🔄 Integrated database with **Spring Data JPA Repositories**.
  * 📌 Implemented queries for saving, updating, and fetching complaints.
  * ✅ Ensured **data consistency and referential integrity** across complaint and update tables.

* 🔗 **System Integration**

  * 🌐 Connected backend with database to ensure seamless data flow.
  * 🧪 Validated backend logic by testing endpoints with Postman.
  * 📊 Ensured that all data (user accounts, complaints, updates) is correctly stored and retrieved.

---

## 🚀 Features

* 👨‍🎓 **Student Role**

  * Register & login with `@srmist.edu.in` email
  * Submit new complaints
  * View submitted complaints with real-time status updates

* 👨‍🏫 **Teacher Role**

  * Login with assigned credentials
  * View all complaints submitted by students
  * Update complaint status (**In Progress, Resolved, Rejected**)
  * Search complaints by ID, category, or keyword
  * Filter complaints by category (Academics, Hostel, Canteen, etc.)

* 🔒 **Authentication & Security**

  * User registration with **encrypted passwords (BCrypt)**
  * Role-based redirection after login
  * Restricted endpoints for teacher/student
  * Spring Security-based session handling

* 🎨 **Frontend**

  * Clean and responsive UI using **Tailwind CSS**
  * Dynamic rendering of complaints with **JavaScript**
  * Smooth animations, search, filter, and toast notifications
  * Separate dashboards for Teacher and Student

---

## 🛠️ Tech Stack

**Backend:**

* Java 17
* Spring Boot 3+
* Spring Security
* Spring Data JPA
* MySQL Database

**Frontend:**

* HTML5, CSS3
* Tailwind CSS
* JavaScript (Vanilla JS, Fetch API)

**Tools:**

* Maven
* Postman (API Testing)
* Git & GitHub
* Eclipse

---

## ⚙️ Setup & Installation

### 1️⃣ Clone Repository

```bash
git clone https://github.com/your-username/ComplaintManagementSystem.git
cd ComplaintManagementSystem
```

### 2️⃣ Backend Setup

* Open project in IntelliJ IDEA / VS Code
* Configure `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/complaint
spring.datasource.username=Username
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Security
spring.security.user.roles=STUDENT,TEACHER
```

* Run Spring Boot application:

```bash
mvn spring-boot:run
```

### 3️⃣ Frontend Setup

* Open `frontend/login.html` in a browser
* Student login → `/Student.html`
* Teacher login → `/Teacher.html`

---

## 🔐 Security Flow

1. User registers with `@srmist.edu.in` email → Saved in DB (with role and encrypted password).
2. On login → Spring Security authenticates credentials.
3. Based on role:

   * `ROLE_STUDENT` → Redirected to **Student Dashboard**
   * `ROLE_TEACHER` → Redirected to **Teacher Dashboard**
4. Teachers can update complaints via PUT API → `/Head/UpdateComplaint`.
5. Students see real-time updated complaint status.

---

## 📸 Screenshots

### 🔹 Login 
<img width="2442" height="1147" alt="Screenshot 2025-09-19 222742" src="https://github.com/user-attachments/assets/78e5105e-20ad-4f46-801c-9b2b823c27e0" />

### 🔹 Register

<img width="2398" height="1150" alt="Screenshot 2025-09-19 222758" src="https://github.com/user-attachments/assets/0e4412ed-841d-4353-aadd-ce03dc9a0f22" />


### 🔹 Student Dashboard

<img width="2460" height="1155" alt="Screenshot 2025-09-19 222811" src="https://github.com/user-attachments/assets/3a13151f-6d7d-4b13-8370-580b453f5304" />

<img width="2380" height="1141" alt="Screenshot 2025-09-19 222848" src="https://github.com/user-attachments/assets/8c19020e-b808-48a8-a677-f4bdef09ae4d" />


### 🔹 Teacher Dashboard

<img width="2351" height="1136" alt="Screenshot 2025-09-19 222826" src="https://github.com/user-attachments/assets/5a1f9de0-5e4c-4e9f-b065-dc8a42c1d075" />


<img width="2283" height="1131" alt="Screenshot 2025-09-19 222927" src="https://github.com/user-attachments/assets/62097dad-e1b8-489d-b9e2-3465b288d154" />

---

## 📡 API Endpoints

### Authentication

| Method | Endpoint         | Description            |
| ------ | ---------------- | ---------------------- |
| POST   | `/auth/register` | Register new user      |
| POST   | `/auth/login`    | Login and authenticate |

### Student

| Method | Endpoint                | Description      |
| ------ | ----------------------- | ---------------- |
| POST   | `/Student/AddComplaint` | Submit complaint |
| GET    | `/Student/SeeComplaint` | View complaints  |

### Teacher

| Method | Endpoint                            | Description             |
| ------ | ----------------------------------- | ----------------------- |
| GET    | `/Head/SeeAllComplaints`            | View all complaints     |
| PUT    | `/Head/UpdateComplaint?id=&status=` | Update complaint status |

---

## 📖 How It Works (Flow)

1. User opens `login.html` → enters email & password
2. Backend checks credentials with **AuthenticationRepository**
3. If valid:

   * Student → redirect `/Student.html`
   * Teacher → redirect `/Teacher.html`
4. Complaints are fetched from `/Student/SeeComplaint` API and displayed
5. Teacher updates → API `/Head/UpdateComplaint` updates DB
6. Student sees updated status on their dashboard

---

## 🚀 Future Enhancements

* Email/SMS notifications for complaint updates
* Admin dashboard for analytics
* JWT authentication instead of session-based
* File upload (screenshots, documents) with complaints

---

## 👩‍💻 Author

**Srija A**
🔗 [GitHub Profile](https://github.com/Srija-A-12)

---

