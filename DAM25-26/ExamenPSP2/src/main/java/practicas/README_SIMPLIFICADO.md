# Prácticas de Programación de Comunicaciones en Red
## Versión Simplificada - Basada en el Material del PowerPoint

Este proyecto contiene las 6 actividades de la práctica, implementadas de forma **clara y sencilla** siguiendo los conceptos explicados en clase.

---

## 📚 ¿Qué aprenderás con cada actividad?

### **Actividad 1: Cliente-Servidor TCP Básico**
**Conceptos:** Socket TCP, ServerSocket, DataInputStream, DataOutputStream

El servidor cuenta los caracteres de las cadenas que envía el cliente.

**Archivos:** 
- `Actividad1_Servidor.java`
- `Actividad1_Cliente.java`

**Pasos del código:**
1. Servidor crea ServerSocket en un puerto
2. Servidor espera cliente con accept()
3. Se crean flujos de entrada/salida
4. Cliente envía cadenas, servidor responde con número de caracteres
5. Finaliza con asterisco (*)

---

### **Actividad 2: Comunicación Multicast UDP**
**Conceptos:** MulticastSocket, DatagramPacket, grupos multicast

Un servidor envía mensajes a todos los clientes conectados al grupo.

**Archivos:**
- `Actividad2_ServidorMulticast.java` (con interfaz gráfica)
- `Actividad2_ClienteMulticast.java` (con interfaz gráfica)

**Pasos del código:**
1. Servidor crea MulticastSocket
2. Clientes se unen al grupo multicast (225.0.0.1)
3. Servidor envía paquetes al grupo
4. Todos los clientes reciben los mensajes

---

### **Actividad 3: Envío de Objetos con UDP**
**Conceptos:** Serialización, ObjectOutputStream, ObjectInputStream, ByteArray

El servidor gestiona un array de alumnos y responde a consultas por ID.

**Archivos:**
- `Curso.java` (clase Serializable)
- `Alumno.java` (clase Serializable)
- `Actividad3_ServidorUDP.java`
- `Actividad3_ClienteUDP.java`

**Pasos del código:**
1. Cliente envía ID del alumno como String
2. Servidor busca el alumno en el array
3. Servidor convierte objeto a bytes con ByteArrayOutputStream
4. Cliente recibe bytes y los convierte a objeto con ByteArrayInputStream

---

### **Actividad 4: Envío de Objetos con TCP + Hilos**
**Conceptos:** Hilos, servidor multicliente, ObjectInputStream/ObjectOutputStream

Servidor que atiende múltiples clientes simultáneamente usando hilos.

**Archivos:**
- `Asignatura.java`
- `Especialidad.java`
- `Profesor.java`
- `Actividad4_ServidorTCP.java` (con hilos)
- `Actividad4_ClienteTCP.java`

**Pasos del código:**
1. Servidor acepta cliente en bucle infinito
2. Por cada cliente se crea un nuevo hilo (Thread)
3. El hilo se encarga de la comunicación con ese cliente
4. Servidor puede atender varios clientes a la vez

---

### **Actividad 5: Servidor con Hilos - Mayúsculas**
**Conceptos:** Hilos, puerto 44444, comunicación bidireccional

Servidor que convierte cadenas a mayúsculas. Cliente con interfaz gráfica.

**Archivos:**
- `Actividad5_Servidor.java`
- `Actividad5_Cliente.java` (con interfaz gráfica Swing)

**Pasos del código:**
1. Por cada cliente conectado se crea un hilo
2. El hilo muestra IP y puerto del cliente
3. Recibe cadenas y las devuelve en mayúsculas
4. Muestra mensaje cuando el cliente se desconecta

---

### **Actividad 6: MASTERMIND (Final Boss)**
**Conceptos:** Todo lo anterior + lógica de juego + objetos compartidos

Juego completo de Mastermind cliente-servidor.

**Archivos:**
- `RespuestaMastermind.java`
- `Actividad6_ServidorMastermind.java`
- `Actividad6_ClienteMastermind.java` (con interfaz gráfica)

**Cómo funciona:**
- Servidor genera combinación de 4 dígitos sin repetir
- Cada jugador tiene 10 intentos
- Servidor responde con:
  - **Aciertos:** números correctos en posición correcta
  - **Coincidencias:** números correctos en posición incorrecta
- El juego termina cuando alguien acierta

---

## 🚀 Cómo Compilar y Ejecutar

### **Compilar todo de una vez:**
```bash
javac *.java
```

### **Compilar por actividad:**

**Actividad 1:**
```bash
javac Actividad1_Servidor.java Actividad1_Cliente.java
```

**Actividad 2:**
```bash
javac Actividad2_ServidorMulticast.java Actividad2_ClienteMulticast.java
```

**Actividad 3:**
```bash
javac Curso.java Alumno.java Actividad3_ServidorUDP.java Actividad3_ClienteUDP.java
```

**Actividad 4:**
```bash
javac Asignatura.java Especialidad.java Profesor.java Actividad4_ServidorTCP.java Actividad4_ClienteTCP.java
```

**Actividad 5:**
```bash
javac Actividad5_Servidor.java Actividad5_Cliente.java
```

**Actividad 6:**
```bash
javac RespuestaMastermind.java Actividad6_ServidorMastermind.java Actividad6_ClienteMastermind.java
```

---

## ▶️ Ejecutar (SIEMPRE ejecutar PRIMERO el servidor)

### **Actividad 1**
```bash
# Terminal 1 - Servidor
java Actividad1_Servidor

# Terminal 2 - Cliente
java Actividad1_Cliente
```

### **Actividad 2**
```bash
# Terminal 1 - Servidor
java Actividad2_ServidorMulticast

# Terminal 2, 3, 4... - Clientes (puedes abrir varios)
java Actividad2_ClienteMulticast
```

### **Actividad 3**
```bash
# Terminal 1 - Servidor
java Actividad3_ServidorUDP

# Terminal 2 - Cliente
java Actividad3_ClienteUDP
```

### **Actividad 4**
```bash
# Terminal 1 - Servidor
java Actividad4_ServidorTCP

# Terminal 2, 3... - Clientes (múltiples clientes)
java Actividad4_ClienteTCP
```

### **Actividad 5**
```bash
# Terminal 1 - Servidor
java Actividad5_Servidor

# Terminal 2, 3... - Clientes (múltiples clientes)
java Actividad5_Cliente
```

### **Actividad 6 - MASTERMIND**
```bash
# Terminal 1 - Servidor
java Actividad6_ServidorMastermind

# Terminal 2, 3... - Jugadores
java Actividad6_ClienteMastermind
```

---

## 📊 Resumen de Puertos

| Actividad | Puerto | Protocolo |
|-----------|--------|-----------|
| Actividad 1 | 6000 | TCP |
| Actividad 2 | 12345 | UDP Multicast |
| Actividad 3 | 9876 | UDP |
| Actividad 4 | 6000 | TCP |
| Actividad 5 | 44444 | TCP |
| Actividad 6 | 6000 | TCP |

---

## 🔍 Conceptos Importantes

### **TCP vs UDP**
- **TCP:** Conexión fiable, garantiza orden y entrega
- **UDP:** No garantiza entrega, más rápido

### **Serialización**
- Permite enviar objetos por la red
- La clase debe implementar `Serializable`

### **Hilos**
- Permiten atender múltiples clientes simultáneamente
- Cada cliente se atiende en un hilo separado

### **Flujos de Datos**
- **DataInputStream/DataOutputStream:** Para tipos primitivos (int, String...)
- **ObjectInputStream/ObjectOutputStream:** Para objetos

---

## ⚠️ Solución de Problemas

**"Address already in use"**
- Espera unos segundos o cambia el puerto en el código

**Error de conexión**
- Asegúrate de ejecutar primero el servidor
- Verifica que uses el puerto correcto

**No se ven las ventanas gráficas**
- Verifica que tienes Java con soporte GUI instalado

---

## 📝 Notas del Código

Todos los programas están:
- ✅ **Comentados línea por línea** para facilitar el aprendizaje
- ✅ **Simplificados** siguiendo el nivel del PowerPoint
- ✅ **Sin complejidad innecesaria** - solo lo esencial
- ✅ **Con manejo básico de errores**

---

**¡Éxito con las prácticas!** 🎓
