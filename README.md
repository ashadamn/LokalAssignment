# 📱 Lokal Jobs App

A modern Android application built using Jetpack Compose, MVVM, and MVI architecture. The app presents a curated list of jobs fetched from a remote API, and allows users to bookmark and view jobs offline.

## ✨ Features

- 🔍 **Jobs Listing with Infinite Scroll**
  - Fetches data from: `https://testapi.getlokalapp.com/common/jobs?page=1`
  - Displays job title, location, salary, and phone number.
- 📄 **Detailed Job View**
  - Tapping a job card shows more detailed information on a separate screen.
- 📌 **Bookmark Jobs**
  - Users can bookmark jobs and view them later from the Bookmarks tab.
- 📶 **Offline Support**
  - Bookmarked jobs are stored in a local Room database for offline access.
- 🧭 **Bottom Navigation**
  - Two main sections: `Jobs` and `Bookmarks`.
- ⚙️ **Robust UI State Handling**
  - Loading, Error, and Empty states implemented for graceful UX.

---

## 🧱 Architecture

- **Clean Architecture** with distinct layers:
  - `Presentation` (Jetpack Compose + ViewModel)
  - `Domain` (UseCases and Util)
  - `Data` (Repository, Remote, Local)
- **MVVM + MVI Pattern**
  - Unidirectional data flow for scalable and maintainable UI logic.

---

## 📦 Tech Stack

| Category         | Libraries Used |
|------------------|----------------|
| UI               | Jetpack Compose, Material3 |
| State Management | ViewModel, MVI |
| DI               | Koin |
| Networking       | Ktor |
| Image Loading    | Coil (Ktor-backed) |
| Persistence      | Room |
| Navigation       | Navigation Compose |
| Others           | DataStore, Lifecycle KTX, JUnit, Espresso |

---

## 🔗 Libraries Used (with versions)

- **Compose BOM**: `2024.04.01`
- **Ktor**: `2.3.12`
- **Koin**: `3.6.0-alpha3`
- **Room**: `2.6.1`
- **Coil**: `3.0.0-alpha06`
- **Navigation**: `2.8.3`
- **Datastore**: `1.1.1`
- **Lifecycle Runtime KTX**: `2.8.7`

*(Check `libs.versions.toml` for the full list.)*

---

## 📽️ Demo

A walkthrough video is available here: [📺 Click to Watch Demo](https://drive.google.com/file/d/1tq4OtmrbKnD2ZyhxAxABaQ-puKhn5mWU/view?usp=sharing)  

---

