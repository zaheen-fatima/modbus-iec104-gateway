# 🌐 IEC 60870-5-104 ↔️ Modbus Gateway using OpenMUC

Welcome to the **OpenMUC IEC 60870-5-104 Gateway Project** — a powerful Java-based OSGi application designed for industrial communication, data acquisition, and real-time monitoring of SCADA systems using the IEC 60870-5-104 protocol.

---

## 🌐 Protocol Overview

**IEC 60870-5-104** is a widely used telecontrol protocol in substations and smart grid environments. It enables seamless TCP/IP-based communication between control centers (Masters) and field devices (Slaves).

This project demonstrates a **lightweight, real-time gateway application** built on the **OpenMUC framework**, designed to seamlessly **read IEC 60870-5-104 data** and dynamically **write to Modbus** holding registers. It features clean OSGi modularity, reactive channel listeners, and a plug-and-play `channel.xml` configuration.

---

## 🚀 Key Features

- 📡 **Reads from IEC 60870-5-104** client via `iec_in` channel
- ⚙️ **Writes incremented values** to `iec_out` channel
- 🔁 **Data forwarding** from IEC 104 to Modbus using `serverMapping`
- 📦 Fully modular with **OSGi + OpenMUC** structure
- ✅ Clean shutdown using OSGi lifecycle annotations

---
## 🛠 Simulator Used: FreyrSCADA Client Master SCADA Simulator

![FreyrSCADA IEC 60870-5-104]

