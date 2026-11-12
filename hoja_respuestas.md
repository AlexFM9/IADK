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

---

## 2. Registro de progreso y cambios realizados

### Bloque 0: Arranque
- [x] Reparto inicial de roles del equipo.
- [x] Creación de la estructura del proyecto `saludos` con el ejemplo *Hello world*.
- [x] Configuración del control de versiones (Git) vinculado al repositorio remoto.
- [x] Comprobación inicial de ejecución con `./gradlew run`.

### Bloque 1: Dos agentes y su estado de ánimo
- [x] **Paso 1:** Añadida la operación atómica `turno(OpFeedbackParam<Integer> n)` en el artefacto `Counter.java` para incrementar y devolver el contador en una sola llamada.
- [x] **Paso 2:** Ejecutado *AppLinker (AgentSpeak)* en el IADK para vincular la operación `turno` al modelo `specification.xml`.
- [ ] **Paso 3:** Modificación del plan `greet` en `AgentSpeak code` para decidir `mood(happy)` o `mood(grumpy)` según paridad del turno.
- [ ] **Paso 4:** Creación del *Deploy Diagram* (`pareja` con 2 instancias de `Greeter`). La direccion de la fecha no pudo ser modificada. El initial state no se pudo configurar para que los agentes se saludaran.
- [ ] **Paso 5:** Generación de código y verificación de traza con ambos agentes.

### Bloque 2: Saludos que dependen del ánimo
- [ ] *Pendiente de inicio.*

### Bloque 3: Workspace y organización
- [ ] *Pendiente de inicio.*

### Bloque 4: Cambiar el código y subirlo al modelo
- [ ] *Pendiente de inicio.*

### Registro de incidencias / errores durante la sesión
- Ninguna incidencia crítica hasta el momento. Sincronización correcta de `Counter.java` y `specification.xml` desde el repositorio.

---

## 3. Respuestas a las preguntas de la práctica

### Pregunta 1 (Bloque 1)
> **Enunciado:** Sustituid `turno(N)` por `inc; ?count(N)` y ejecutad varias veces. ¿Qué ocurre a veces con el ánimo de los agentes y por qué? ¿Por qué lo evita `turno`?

**Respuesta preliminar / Guía:**
Antes se saludaban y ahora no.
Al descomponer la consulta en dos acciones separadas (`inc` seguido de `?count(N)`), se introduce una condición de carrera (*race condition*). Si los dos agentes ejecutan concurrentemente `inc` antes de que el primero consulte `?count(N)`, ambos agentes leerán el mismo valor actualizado del contador (por ejemplo, ambos leen 2). Como resultado, ambos adoptarán el mismo estado de ánimo (`grumpy` o `happy`). 
Antes:
[greeter2] Me despierto happy
[greeter1] Me despierto grumpy

Despues:
[greeter1] Me despierto grumpy
[greeter2] Me despierto grumpy
---

### Pregunta 2 (Bloque 2)
> **Enunciado:** Cuando llega un saludo, ¿cómo elige Jason cuál de las dos reglas de `+saludo` ejecuta? ¿Qué pasaría si el agente creyera `mood(sleepy)` y no hubiera regla para ese ánimo?

**Respuesta preliminar / Guía:**
Jason busca en su plan library todos los planes relevantes cuyo disparador coincida con el evento `+saludo(_)`. A continuación, evalúa el contexto (guarda) de cada uno contra su base de creencias actual (`mood(happy)` o `mood(grumpy)`) para seleccionar el plan aplicable. 

Si el agente tuviese la creencia `mood(sleepy)` y no existiese ninguna regla cuyo contexto admita `mood(sleepy)`, ninguna regla sería aplicable y el evento se descartaría (o generaría un fallo si fuese un subobjetivo).

---

### Pregunta 3 (Bloque 2)
> **Enunciado:** ¿Por qué el agente contesta con `respuesta(M)` y no con otro `saludo(M)`?

**Respuesta preliminar / Guía:**
Porque si respondiese con otro mensaje de tipo `saludo(M)`, el agente receptor volvería a disparar su plan `+saludo(_)`, enviando otro saludo de vuelta, provocando un bucle infinito de mensajes de saludo entre los dos agentes. Al utilizar `respuesta(M)`, el mensaje es capturado por el manejador específico `+respuesta(M)`, cerrando el protocolo de interacción y permitiendo que se dé por cumplido el objetivo con `+saludado`.

---

### Pregunta 4 (Bloque 3)
> **Enunciado:** Poned a 1 la cardinalidad de la misión `m_saludar`, regenerad y ejecutad varias veces. ¿Cuántos agentes reciben la obligación? Explicadlo con la especificación normativa de Moise y volved a dejarla en 2.

**Respuesta preliminar / Guía:**
Al establecer la cardinalidad máxima de la misión a 1 (`max="1"`), Moise limita a un único agente el compromiso simultáneo con dicha misión. Aunque la norma obligue a todos los agentes que desempeñan el rol `saludador` a comprometerse con la misión, el primer agente en comprometerse satura la cardinalidad del esquema, por lo que el segundo agente no recibe la obligación / no se le permite comprometerse con ella.
