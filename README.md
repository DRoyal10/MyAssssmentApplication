 MyAssssmentApplication

NIT3213 Final Android Assignment – Royal Dhakal (s8160992)

This Android application demonstrates:
- Retrofit API integration
- Clean UI for Dashboard, Login, and Details screens
- Hilt dependency injection
- Clean code organization and practices
- Unit test for essential logic


Features

1️Login Screen
- Login with **first name** (username) and **student ID** (password)
- Posts request to:
  https://nit3213api.onrender.com/sydney/auth

- After successful login, receives a 'keypass' to fetch dashboard data
- Invalid login shows correct error messages



2️ Dashboard Screen
- Uses 'keypass' from login to GET:
javascript
https://nit3213api.onrender.com/dashboard/{keypass}
- Shows a 'RecyclerView list' of entities
- Each entry shows summary info
- Tapping an entry opens the Details screen



3️ Details Screen
- Shows full information about chosen entity
- Shows name, culture, domain, parentage, description, etc.
- Scrollable layout with Back button



4Setup Instructions

Prerequisites
- Android Studio Giraffe or later
- Internet connection (for API)

 How to Run

1. Clone or download the project form:

   git clone https://github.com/royaldhakal/MyAssssmentApplication.git

2. Open in Android Studio

3. Sync Gradle (click "Sync Project with Gradle Files")

4. Build & run on Android device


Technologies Used

| Tech        | Purpose                      |
|-------------|----------------------------|
| Kotlin      | Main programming language  |
| Retrofit    | API calls (GET/POST)       |
| Gson        | JSON Parsing               |
| Hilt        | Dependency Injection       |
| RecyclerView| Displaying list of items      |
| ViewBinding | Safe access to views        |
| JUnit/Test  | Unit tests of key components

Dependency Injection with Hilt

Hilt simplifies object injection like 'ApiService' without the need for manual creation.

- Application annotation with '@HiltAndroidApp'
- Module provides Retrofit object
- Cleaner and testable code



Unit Tests

Contains 1 test class (DashBoardItem.


@Test
    fun testDashboardItemProperties() {
        val item = DashboardItem(
            name = "Zeus",
            culture = "Greek",
            domain = "Sky and Thunder",
            symbol = "Thunderbolt",
            parentage = "Cronus and Rhea",
            romanEquivalent = "Jupiter",
            description = "King of the Olympian gods..."

To test, you can right-click on the test file and select "Run"



Folder Structure


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




Notes

- Project is hardcoded for Sydney endpoint (/sydney/auth)
- Update base URL or endpoint in 'ApiService.kt'
- Make sure INTERNET permission is declared in AndroidManifest.xml
- UI needs proper designing



Author

Royal Dhakal 
Student ID: s8160992
Course: NIT3213 Android App Development
