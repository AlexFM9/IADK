# Hoja de Respuestas — Sistemas Basados en Agentes (Semana 8)

## 1. Datos del grupo y reparto de roles

**Grupo:** G`__`

**Integrantes:**
- 
- 
- 

| Bloque | Modelador | Guía | Verificador | Secretario | Explorador |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **Bloque 0: Arranque** | | | | | |
| **Bloque 1: Dos agentes y su estado de ánimo** | | | | | |
| **Bloque 2: Saludos que dependen del ánimo** | | | | | |
| **Bloque 3: Workspace y organización** | | | | | |
| **Bloque 4: Cambiar el código y subirlo al modelo** | | | | | |
| **Retos (opcional)** | | | | | |

### Registro de incidencias / errores durante la sesión
- 

---

## 2. Respuestas a las preguntas

### Pregunta 1 (Bloque 1)
> **Enunciado:** Sustituid `turno(N)` por `inc; ?count(N)` y ejecutad varias veces. ¿Qué ocurre a veces con el ánimo de los agentes y por qué? ¿Por qué lo evita `turno`?

**Respuesta:**
<!-- Escribir aquí la respuesta (condición de carrera entre inc y ?count(N) frente a atomicidad de la operación turno(N) en el artefacto CArtAgO) -->


---

### Pregunta 2 (Bloque 2)
> **Enunciado:** Cuando llega un saludo, ¿cómo elige Jason cuál de las dos reglas de `+saludo` ejecuta? ¿Qué pasaría si el agente creyera `mood(sleepy)` y no hubiera regla para ese ánimo?

**Respuesta:**
<!-- Escribir aquí la respuesta (evaluación del contexto de los planes relevantes en su base de creencias; fallo de evento / ningún plan aplicable si ninguna guarda se cumple) -->


---

### Pregunta 3 (Bloque 2)
> **Enunciado:** ¿Por qué el agente contesta con `respuesta(M)` y no con otro `saludo(M)`?

**Respuesta:**
<!-- Escribir aquí la respuesta (evitar un bucle infinito de saludos mutuos al disparar continuamente el evento +saludo(_)) -->


---

### Pregunta 4 (Bloque 3)
> **Enunciado:** Poned a 1 la cardinalidad de la misión `m_saludar`, regenerad y ejecutad varias veces. ¿Cuántos agentes reciben la obligación? Explicadlo con la especificación normativa de Moise y volved a dejarla en 2.

**Respuesta:**
<!-- Escribir aquí la respuesta (cardinalidad max="1" en la misión dentro del esquema Moise: en cuanto 1 agente o el máximo permitido de la misión se alcanza / se asigna la obligación según el límite de la misión) -->
