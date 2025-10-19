# 💳 ATMsimulator

**ATMsimulator** is an educational project that simulates the operation of an ATM and communicates with the **BankSim** server via gRPC.  
The goal is to practice client-server architecture, gRPC communication, and GUI development with Java Swing.

---

## 🚀 Features

- Login using card number and PIN
- Withdraw funds
- Validate user input and handle errors
- Communicate with **BankSim** server via gRPC
- User-friendly Swing interface

---

## ⚙️ How to Run

### Requirements
- Java 8+
- Maven
- Running Discovery server (**13.36.126.221:8001**)

### Run Options

#### 🔹 Run with arguments
```
java -jar target/ATMsimulator.jar <terminalId> <password> <signature> <currencyCode>
```
**Example:**
```
java -jar target/ATMsimulator.jar 683189 1123 u2hxY9zQhRF//dRQSfb66Q== EUR
```

#### 🔹 Interactive mode
```
java -jar target/ATMsimulator.jar
```
When started without arguments, the program will ask for:
- Currency (`EUR`, `USD`, `UAH`, `DKK`, `SEK`)
- Terminal credentials (ID, password, signature)

You can simply press **Enter** to use default values:
- Terminal ID: `683189`
- Password: `1123`
- Signature: `u2hxY9zQhRF//dRQSfb66Q==`

#### 🔹 Run via Maven
```
mvn clean package
mvn exec:java -Dexec.mainClass="edu.shtoiko.atmsimulator.terminal.Main" -Dexec.args="683189 1123 u2hxY9zQhRF//dRQSfb66Q== EUR"
```

> You can change the Discovery host or ports in  
> `edu.shtoiko.atmsimulator.terminal.Main` class.

---

## 🧠 Technologies

| Component | Technology |
|------------|-------------|
| Language | Java 8 |
| GUI | Swing |
| Communication | gRPC |
| Build Tool | Maven |

---

## 👨‍💻 Author

**Vasyl Shtoiko**  
🌐 [shtoiko.dev](https://shtoiko.dev)
