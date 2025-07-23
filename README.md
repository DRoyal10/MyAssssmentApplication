#  MyAssssmentApplication

###  NIT3213 Final Android Assignment – Royal Dhakal (s8160992)

This Android app demonstrates:
-  API integration using Retrofit
-  Clean UI for Login, Dashboard, and Details screens
-  Dependency injection using Hilt
-  Clean code practices and structure
-  Unit testing for key logic

---

##  Features

### 1️⃣Login Screen
- Login using **first name** (username) and **student ID** (password)
- Makes POST request to:
  ```
  https://nit3213api.onrender.com/sydney/auth
  ```
- If successful, receives a `keypass` to fetch dashboard data
- Invalid login shows appropriate error messages

---

### 2️ Dashboard Screen
- Uses `keypass` from login to GET:
  ```
  https://nit3213api.onrender.com/dashboard/{keypass}
  ```
- Displays a **RecyclerView list** of entities
- Each item shows **summary info**
- Clicking an item opens the **Details screen**

---

### 3️ Details Screen
- Displays **full information** about the selected entity
- Includes name, culture, domain, parentage, description, etc.
- Scrollable layout with **Back** button

---

##  Setup Instructions

###  Prerequisites
- Android Studio Giraffe or newer
- Internet connection (for API)

###  How to Run

1. Clone or download the project:
   ```
   git clone https://github.com/royaldhakal/MyAssssmentApplication.git
   ```

2. Open in Android Studio

3. Sync Gradle (click **"Sync Project with Gradle Files"**)

4. Build & run on emulator or real Android device

---

## Technologies Used

| Tech        | Purpose                       |
|-------------|-------------------------------|
| Kotlin      | Main programming language     |
| Retrofit    | API calls (GET/POST)          |
| Gson        | JSON parsing                  |
| Hilt        | Dependency Injection          |
| RecyclerView| Displaying list of items      |
| ViewBinding | Safe access to views          |
| JUnit/Test  | Unit testing key components   |

---

##  Dependency Injection with Hilt

Hilt simplifies injecting objects like `ApiService` without manually creating them.

- Application class annotated with `@HiltAndroidApp`
- Module provides Retrofit instance
- Cleaner, testable code

---

##  Unit Tests

Includes 1 test class (`LoginRequestTest.kt`) for verifying login model logic.

```kotlin
@Test
fun testLoginRequestFields() {
    val request = LoginRequest("Royal", "s8160992")
    assertEquals("Royal", request.username)
    assertEquals("s8160992", request.password)
}
```

 You can run tests by right-clicking the test file and selecting **Run**.

---

##  Folder Structure

```
com.example.myassssmentapplication
│
├── MainActivity.kt
├── DashboardActivity.kt
├── DetailsActivity.kt
├── DashboardAdapter.kt
├── DashboardItem.kt
├── RetrofitClient.kt
├── ApiService.kt
├── AppModule.kt
├── LoginRequest.kt
├── LoginResponse.kt
├── activity_main.xml
├── activity_dashboard.xml
├── activity_details.xml
├── item_dashboard.xml
└── styles/themes etc.
```

---

##  Notes

- This project is **hardcoded for Sydney** endpoint (`/sydney/auth`)
- Change base URL or endpoint in `ApiService.kt` if needed
- Make sure **INTERNET permission** is declared in `AndroidManifest.xml`

---

##  Author

**Royal Dhakal**  
Student ID: `s8160992`  
Campus: Sydney  
Course: NIT3213 Android App Development
