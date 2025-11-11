# Backend – Sito vetrina artista  
Backend realizzato con **Java 17** e **Spring Boot**.  
Gestisce i contenuti di un sito vetrina dedicato a un artista, con autenticazione e pannello di amministrazione per la gestione di opere, mostre e biografia.

## 🚀 Tecnologie principali
- Java 17  
- Spring Boot  
- Spring Web  
- Spring Data JPA  
- Spring Security (JWT)  
- PostgreSQL  
- Maven

---

## 📂 Struttura del progetto

| Cartella       | Descrizione |
|----------------|-------------|
| `controller`   | Endpoint REST |
| `dto`          | Oggetti di trasferimento dati |
| `enumeration`  | Enum per ruoli o stati |
| `exception`    | Gestione errori personalizzati |
| `model`        | Entità JPA |
| `repository`   | Accesso al database |
| `security`     | Configurazione JWT e filtri |
| `service`      | Logica di business |

## 📌 Entità
| Entità | Descrizione |
|--------|-------------|
| **User** | Rappresenta l'artista o l'amministratore. Con autenticazione può creare, modificare ed eliminare contenuti. |
| **Post** | Opere/elementi pubblicati nel sito. GET pubblico, CRUD autenticato. |
| **Mostre** | Eventi/esposizioni dell'artista. GET pubblico, CRUD autenticato. |
| **Bio** | Biografia dell'artista. Modificabile solo da utente autenticato. |
| **ApiError** | Risposta standardizzata in caso di errore. |

---

## 🔐 Sicurezza
- Tutti gli endpoint **GET** sono pubblici.
- Operazioni di creazione, modifica e cancellazione richiedono autenticazione via **JWT**.

---


## 🌐 Frontend
Il progetto frontend è disponibile qui:
  
👉 https://github.com/MicheleFamoso/luxFront

---

## 🎨 Sito pubblico
Il sito ufficiale dell’artista è raggiungibile al link:

👉 https://lucianofamoso.netlify.app/

---
## ✍️ Autore Michele Famoso
Backend realizzato per il sito ufficiale dell’artista, con gestione contenuti via ruolo admin e accesso pubblico alle opere.
