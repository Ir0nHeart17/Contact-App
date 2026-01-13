  📱 Contacts Keeper
A modern, offline-first Android application built to demonstrate Clean Architecture, Reactive Programming, and the latest Jetpack Compose components.

🚀 Key Features
Full CRUD Operations: Seamlessly Create, Read, Update, and Delete contacts.

Persistent Storage: Data is stored locally using Room Database, ensuring your contacts are available offline.

Reactive Search: Real-time contact filtering as you type, powered by Kotlin Flow.

Dynamic Sorting: Toggle between sorting contacts by Name or Date of Creation.

Material 3 UI: A beautiful, responsive interface with support for Light and Dark Mode.


🛠 Tech Stack & Architecture
This project follows Google’s recommended architecture for scalable and maintainable apps.

Language: Kotlin

UI Framework: Jetpack Compose (Material 3)

Architecture: MVVM (Model-View-ViewModel)

Dependency Injection: Dagger Hilt

Local Database: Room SQLite

Asynchronous Flow: Kotlin Coroutines & StateFlow

Build Tool: Kotlin DSL (Gradle) with Version Catalog (libs.versions.toml)


🏗 Project Structure
The app is organized into a Clean Architecture structure:

data/: Contains the Database, DAOs, and Entity models.

di/: Hilt Modules for dependency injection.

presentation/: Compose Screens, ViewModels, and UI State management.

📸 Screenshots
<table>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/7e71e0d7-eb3f-4450-b3dc-e07c68c0164d" width="250" alt="App Icons"></td>
    <td><img src="https://github.com/user-attachments/assets/37c729b2-126a-4c27-b221-94946f0486cc" width="250" alt="Home Screen"></td>
    <td><img src="https://github.com/user-attachments/assets/369ed6d7-10ef-4fc7-b2b2-0c697726e3ea" width="250" alt="Add Screen"></td>
  </tr>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/dbf6efd1-a2b8-4d92-8fd3-1cfa0fecb792" width="250" alt="Add Screen Details"></td>
    <td><img src="https://github.com/user-attachments/assets/0f177642-0db4-4b34-90fe-2c4587c58c3b" width="250" alt="Home with Contact"></td>
    <td><img src="https://github.com/user-attachments/assets/c2f7380a-0945-41d2-b377-231f189d626b" width="250" alt="Home with Contacts"></td>
  </tr>
</table>

🧠 Technical Challenges & Learnings
1. Handling the "Overwriting Data" Bug
Challenge: Initially, adding a new contact would occasionally overwrite an existing one in the database instead of creating a fresh entry.

Solution: I identified that the issue stemmed from how Room's Primary Keys interact with Kotlin's default values. By ensuring the id was explicitly reset to 0 in the ViewModel before a "Save" operation, I allowed Room's autoGenerate = true property to correctly trigger for new entries.

2. Dependency Injection Lifecycle
Challenge: Managing the lifecycle of the ContactDatabase across different ViewModels and ensuring a single instance (Singleton) was used throughout the app.

Solution: Implemented Dagger Hilt to provide the database instance via a SingletonComponent. This not only simplified the ViewModel constructors but also ensured efficient memory usage and prevented database locking issues.

3. Reactive UI with StateFlow
Challenge: Ensuring the UI updated immediately when a user changed the sort order or entered a search query without manual refreshes.

Solution: Utilized flatMapLatest and combine operators in Kotlin Flow. This created a reactive pipeline where the UI automatically "observes" changes in the search text or sort boolean and re-queries the database instantly.





