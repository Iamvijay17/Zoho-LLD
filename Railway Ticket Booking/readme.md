# Railway Ticket Reservation System

## ⏱ Duration
**Time Limit:** 2 Hours 30 Minutes

---

## 📌 Problem Statement
Design and implement a **Railway Ticket Reservation System** that allows users to **book**, **cancel**, and **view ticket details** based on predefined constraints and rules.

---

## 🚆 System Overview
The application simulates a railway reservation system with the following ticket categories:

| Ticket Type | Capacity |
|------------|----------|
| Confirmed Berths | 63 |
| RAC (Reservation Against Cancellation) | 18 (9 side-lower berths) |
| Waiting List | 10 |

- If waiting list exceeds **10**, booking must be denied with **"No tickets available"**.

---

## ✨ Functionalities

### 1️⃣ Book Ticket
Collect the following passenger details:
- **Name**
- **Age**
- **Gender**
- **Berth Preference**

#### Booking Rules:
- Children **below 5 years**:
  - No ticket allocated
  - Passenger details must be stored
- **Lower Berth Priority**:
  - Passengers aged **above 60**
  - Ladies traveling with children
- **RAC Allocation**:
  - RAC passengers must be assigned **side-lower berths**
- Booking order:
  1. Confirmed berth
  2. RAC
  3. Waiting list
  4. Reject booking if waiting list > 10

---

### 2️⃣ Cancel Ticket
When a ticket is cancelled:
- A **RAC ticket** is promoted to **Confirmed**
- A **Waiting List ticket** is promoted to **RAC**
- Waiting list count is reduced accordingly

---

### 3️⃣ Print Booked Tickets
- Display all booked tickets with complete passenger details
- Include:
  - Ticket status (Confirmed / RAC / Waiting List)
  - Berth allocation
- At the end, print:
  - **Total number of booked tickets**

---

### 4️⃣ Print Available Tickets
- Display all unoccupied tickets by category
- At the end, print:
  - **Total number of available tickets**

---

## 📊 Ticket Allocation Summary

| Category | Total | Allocated | Available |
|--------|-------|-----------|-----------|
| Confirmed | 63 | Dynamic | Dynamic |
| RAC | 18 | Dynamic | Dynamic |
| Waiting List | 10 | Dynamic | Dynamic |

---

## 🧠 Assumptions
- Only one passenger per booking request
- System runs in a single session (no persistence unless implemented)
- Input validation is handled
- Berth preferences are allocated only if available

---

## 🛠 Technologies (Optional)
- Language: Java / Python / C++ (as per implementation)
- Data Structures: Lists, Queues, Maps

---

## 📌 Expected Outcome
A fully functional railway ticket reservation system that:
- Handles bookings and cancellations correctly
- Maintains ticket priority rules
- Displays accurate booking and availability summaries

---

## ✅ Evaluation Criteria
- Correct implementation of rules
- Clean code structure
- Proper use of data structures
- User-friendly output formatting

---

**End of README**
