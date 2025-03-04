# Google Sheets CRUD Android App

This is an Android application that enables CRUD (Create, Read, Update, Delete) operations on Google Sheets using the Google Sheets API. The backend is developed in **Kotlin**, the frontend is designed in **XML**, and the API is generated using **Google Apps Script (Java)**. The API returns data in **JSON format**, which is tested using **Postman**.

## Features
-  Create new entries in Google Sheets
-  Read and display data from Google Sheets
-  Update existing records
-  Delete records from Google Sheets
-  Uses Google Apps Script to generate a RESTful API

##  Tech Stack
- **Backend:** Kotlin (Android)
- **Frontend:** XML (Android Studio)
- **API:** Java (Google Apps Script)
- **API Testing:** Postman

##  Setup Guide

### 1 Clone the Repository
```sh
git clone https://github.com/your-username/your-repo.git
cd your-repo

### 2 Configure Google Sheets API

1. Create a **Google Sheet** and open **Extensions > Apps Script**.
2. Add a script to generate the API (refer to [`script.gs`](script.gs) in this repository).
3. Deploy the script as a **web app**:
   - Click **Deploy** > **New Deployment**.
   - Select **Web app** as the deployment type.
   - Set **Execute as** to `Me` and **Who has access** to `Anyone with the link`.
   - Click **Deploy** and **authorize** if prompted.
4. Copy the **API URL** from the deployment settings.
5. Use this URL in your Android app for API requests.
