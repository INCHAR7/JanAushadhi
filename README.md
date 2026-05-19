
# JanAushadhiFinder 💊

JanAushadhiFinder is an Android application designed to promote healthcare affordability by helping users find low-cost generic alternatives to expensive branded medicines, calculate financial savings, and navigate to the nearest generic drug retail outlets (Jan-Aushadhi Kendras).

## 🚀 Key Features

* **Fuzzy Search Engine:** Implements local string similarity matching leveraging the Levenshtein Distance algorithm. Handles minor user typos seamlessly across an optimized dataset of 500+ items.
* **Real-time Cost Comparison:** Dynamically computes price deltas between branded products and generic alternatives, immediately showing users their potential savings.
* **Interactive Store Locator:** Integrates the Google Maps SDK to map out local generic drug retail outlets within a target radius.
* **Automated Refill Reminders:** Provides an interactive scheduling layout featuring a built-in calendar workflow to assist users with monthly subscription and dosage planning.

---

## 🛠️ Tech Stack & Architecture

* **Language:** Kotlin
* **Development Environment:** Android Studio
* **UI Components:** XML (ConstraintLayout, RelativeLayout, Material Design Components, RecyclerView)
* **Database Foundations:** Room Database infrastructure for structured medicine schemas
* **External APIs & Tools:** * Google Play Services Maps SDK
    * Apache Commons Text (Levenshtein Similarity Logic)

---

## 📂 Project Structure Overview

```text
com.mindmatrix.janaushadhifinder/
│
├── MainActivity.kt            # Core UI hub, handles input tracking & savings evaluation
├── StoreLocatorActivity.kt    # Maps container view displaying local outlet coordinates
├── MedicineAdapter.kt         # Prepares card view bindings & stock inquiry interactions
├── FuzzySearchEngine.kt       # Houses string metric distance algorithms
├── Medicine.kt                # Declares the Room Entity data model structure
└── MockDatabase.kt            # Generates local inventory entries for performant queries
