# 💬 Chatting Application

A real-time desktop chat application built with **Core Java** using Swing, AWT, and Socket Programming. This app enables two users to communicate over a network through a clean and interactive GUI interface.

---

## 📌 Features

- Real-time one-to-one messaging over a network
- Clean and interactive GUI built with Java Swing & AWT
- Client-Server architecture using Socket Programming
- Smooth message exchange with timestamp display
- Lightweight — no external libraries or frameworks required

---

## 🛠️ Tech Stack

| Technology | Purpose |
|------------|---------|
| Core Java | Application logic |
| Java Swing | GUI components & layout |
| Java AWT | Event handling & graphics |
| Socket Programming | Network communication (Client-Server) |
| NetBeans IDE | Development environment |

---

## 📁 Project Structure

```
Chatting-Application/
├── src/
│   ├── Server.java       # Server-side socket logic & GUI
│   ├── Client.java       # Client-side socket logic & GUI
├── README.md
```

---

## 🚀 Getting Started

### Prerequisites

- Java JDK 8 or above
- NetBeans IDE (recommended) or any Java IDE

### Installation & Run

```bash
# Clone the repository
git clone https://github.com/bhoomi-wadhwani/Chatting-Application.git

# Open in NetBeans IDE
# File → Open Project → Select the cloned folder
```

### Running the App

1. **Start the Server first:**
   - Open and run `Server.java`
   - Server starts listening for incoming connections

2. **Start the Client:**
   - Open and run `Client.java`
   - Client connects to the server

3. **Start chatting!** 🎉

---

## 🖥️ How It Works

The application follows a **Client-Server architecture**:

```
[ Client GUI ] ←──── Socket Connection ────→ [ Server GUI ]
     |                                               |
  Sends message                             Receives & displays
  Receives reply                            Sends reply back
```

- The **Server** opens a `ServerSocket` on a specific port and waits for a client to connect
- The **Client** connects to the server using the host IP and port number
- Once connected, both sides can send and receive messages in real time through `InputStream` and `OutputStream`

---

## 📸 Key Functionalities

| Feature | Description |
|--------|-------------|
| Send Message | Type in the input field and press Enter or click Send |
| Receive Message | Incoming messages displayed instantly in the chat window |
| GUI Interface | Built entirely with Java Swing components |
| Connection | Established via Java Socket & ServerSocket classes |

---

## 🔮 Future Improvements

- [ ] Add multi-user / group chat support
- [ ] Add message timestamps
- [ ] Add user login with username
- [ ] Add emoji support
- [ ] Store chat history locally
- [ ] Add file sharing feature

---

## 👩‍💻 Author

**Bhoomi Wadhwani**  
BSc.IT Student | KC College, Bombay  
[GitHub](https://github.com/bhoomi-wadhwani) | [LinkedIn](https://www.linkedin.com/in/bhoomi-wadhwani-85789728b/)

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).
