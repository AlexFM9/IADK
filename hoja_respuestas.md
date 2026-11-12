# Hoja de Respuestas — Sistemas Basados en Agentes (Semana 8)

## 1. Datos de la sesión y reparto de roles

**Grupo:** G22

**Integrantes:**
- Carlos Guevara Ramilo
- Damian Gonzalez Sarmiento
- Carlota Marra Rodriguez
- Alexander Fontán Moreira

| Bloque | Modelador | Guía | Verificador | Secretario |
| :--- | :--- | :--- | :--- | :--- |
| **Bloque 0: Arranque** | Damian | Carlos | Alex | Carlota |
| **Bloque 1: Dos agentes y su estado de ánimo** | Damian | Carlos | Alex | Carlota |
| **Bloque 2: Saludos que dependen del ánimo** | Damian | Carlos | Alex | Carlota |
| **Bloque 3: Workspace y organización** | Damian | Carlos | Alex | Carlota |
| **Bloque 4: Cambiar el código y subirlo al modelo** | Damian | Carlos | Alex | Carlota |


---

## 2. Registro de progreso y trazas de ejecución

### Bloque 0: Arranque
- [x] Reparto inicial de roles del equipo.
- [x] Creación de la estructura del proyecto `saludos` con el ejemplo *Hello world*.
- [x] Configuración del control de versiones (Git) vinculado al repositorio remoto.
- [x] Comprobación inicial de ejecución con `./gradlew run`.

---

### Bloque 1: Dos agentes y su estado de ánimo
- [x] **Paso 1:** Añadida la operación atómica `turno(OpFeedbackParam<Integer> n)` en el artefacto `Counter.java`.
- [x] **Paso 2:** Ejecutado *AppLinker (AgentSpeak)* en el IADK para vincular la operación `turno` al modelo `specification.xml`.
- [x] **Paso 3:** Modificación del plan `greet` en `AgentSpeak code` para decidir `mood(happy)` o `mood(grumpy)` según paridad del turno.
- [x] **Paso 4:** Creación del *Deploy Diagram* (`pareja` con 2 instancias de `Greeter` con `DeploymentUnitByType`).
- [x] **Paso 5:** Generación de código y verificación de traza con ambos agentes despertándose con ánimos distintos.

---

### Bloque 2: Saludos que dependen del ánimo
- [x] Creación del objetivo `saludar` y plan `saludando` en `Greeter agent`.
- [x] Creación del diagrama `Saludando plan` con la tarea `enviar_saludo` y creencia `saludado`.
- [x] Creación del diagrama de interacción con mensajes `tell` (`saludo(M)` y `respuesta(M)`).
- [x] Reglas de respuesta modeladas con `AslCodeComponent` y satisfacción declarativa.

**Traza de ejecución obtenida:**
```text
[Cartago] Workspace env created.
[Cartago] artifact counter: tools.Counter() at env created.
[greeter2] join workspace /main/env: done
[greeter1] join workspace /main/env: done
[greeter2] focusing on artifact counter (at workspace /main/env) using namespace default
[greeter1] focusing on artifact counter (at workspace /main/env) using namespace default
[greeter2] focus on counter: done
[greeter1] focus on counter: done
[greeter1] Me despierto grumpy
[greeter2] Me despierto happy
[greeter2] Hola, greeter1. Que alegria verte!
[greeter1] Hmpf... hola, greeter2.
[greeter1] greeter2 me ha respondido de humor happy
[greeter2] greeter1 me ha respondido de humor grumpy
```

---

### Bloque 3: Workspace y organización
- [x] Workspace `env` creado y vinculado a `Counter` con `EContainsArtifact`.
- [x] Diagrama `Team organisation` creado con organización `saludo_org`, grupo `team`, rol `saludador`, esquema `saludo_sch` y misión `m_saludar`.
- [x] Obligación deontic (`WFParticipates`) asignada a `saludador` para la misión `m_saludar`.

**Traza de ejecución obtenida:**
```text
[Moise] OrgBoard saludo_org created.
[Moise] scheme created: saludo_sch: saludo_sch using artifact SchemeBoard
[Moise] group created: saludo_org_group: saludo_org using artifact ora4mas.nopl.GroupBoard
[Moise] group created: team: team using artifact ora4mas.nopl.GroupBoard
[Cartago] Workspace env created.
[Cartago] artifact counter: tools.Counter() at env created.
[greeter1] join workspace /main/env: done
[greeter2] join workspace /main/env: done
[greeter2] focusing on artifact counter (at workspace /main/env) using namespace default
[greeter1] focusing on artifact counter (at workspace /main/env) using namespace default
[greeter1] focus on counter: done
[greeter2] focus on counter: done
[greeter1] focusing on artifact team (at workspace /main/saludo_org) using namespace default
[greeter2] focusing on artifact team (at workspace /main/saludo_org) using namespace default
[greeter1] focus on team: done
[greeter2] focus on team: done
[greeter1] focusing on artifact saludo_org (at workspace /main/saludo_org) using namespace default
[greeter2] focusing on artifact saludo_org (at workspace /main/saludo_org) using namespace default
[greeter1] focus on saludo_org: done
[greeter2] focus on saludo_org: done
[greeter1] Me despierto happy
[greeter1] I am obliged to commit to m_saludar on saludo_sch... doing so
[greeter2] I am obliged to commit to m_saludar on saludo_sch... doing so
[greeter2] Me despierto grumpy
[greeter2] Hmpf... hola, greeter1.
[greeter1] Hola, greeter2. Que alegria verte!
[greeter1] greeter2 me ha respondido de humor grumpy
[greeter2] greeter1 me ha respondido de humor happy
```

---

### Bloque 4: Cambiar el código y subirlo al modelo
- [x] Modificación en `greeter.asl` del saludo para `mood(happy)` por un texto personalizado.
- [x] Comprobación de la ejecución con el nuevo saludo en consola.
- [x] Sincronización del código hacia el modelo mediante *Code synchronizer (AgentSpeak)*.
- [x] Regeneración con el generador JaCaMo y verificación de que el cambio se preserva en el modelo.

**Traza de ejecución obtenida (con nuevo saludo preservado):**
```text
[Moise] OrgBoard saludo_org created.
[Moise] scheme created: saludo_sch: saludo_sch using artifact SchemeBoard
[Moise] group created: saludo_org_group: saludo_org using artifact ora4mas.nopl.GroupBoard
[Moise] group created: team: team using artifact ora4mas.nopl.GroupBoard
[Cartago] Workspace env created.
[Cartago] artifact counter: tools.Counter() at env created.
[greeter1] join workspace /main/env: done
[greeter2] join workspace /main/env: done
[greeter1] focusing on artifact counter (at workspace /main/env) using namespace default
[greeter2] focusing on artifact counter (at workspace /main/env) using namespace default
[greeter2] focus on counter: done
[greeter1] focus on counter: done
[greeter2] focusing on artifact team (at workspace /main/saludo_org) using namespace default
[greeter1] focusing on artifact team (at workspace /main/saludo_org) using namespace default
[greeter2] focus on team: done
[greeter1] focus on team: done
[greeter1] focusing on artifact saludo_org (at workspace /main/saludo_org) using namespace default
[greeter2] focusing on artifact saludo_org (at workspace /main/saludo_org) using namespace default
[greeter1] focus on saludo_org: done
[greeter2] focus on saludo_org: done
[greeter1] Me despierto happy
[greeter2] I am obliged to commit to m_saludar on saludo_sch... doing so
[greeter1] I am obliged to commit to m_saludar on saludo_sch... doing so
[greeter2] Me despierto grumpy
[greeter2] Hmpf... hola, greeter1.
[greeter1] Holiss, greeter2. Me alegro mucho muchisimo de verte hoy!
[greeter1] greeter2 me ha respondido de humor grumpy
[greeter2] greeter1 me ha respondido de humor happy
```

---

## 3. Respuestas a las preguntas de la práctica

### Pregunta 1 (Bloque 1)
> **Enunciado:** Sustituid `turno(N)` por `inc; ?count(N)` y ejecutad varias veces. ¿Qué ocurre a veces con el ánimo de los agentes y por qué? ¿Por qué lo evita `turno`?

**Respuesta:**
Al sustituir la operación atómica por dos acciones separadas (`inc` seguido de `?count(N)`), se produce una **condición de carrera** (*race condition*). Si los dos agentes ejecutan concurrentemente `inc` antes de que el primero consulte el valor con `?count(N)`, el contador se incrementa dos veces y ambos agentes leen posteriormente el mismo valor actualizado (por ejemplo, ambos leen `2`). Como consecuencia, ambos agentes adoptan exactamente el mismo estado de ánimo (`grumpy` o `happy`), perdiéndose la alternancia.

*Evidencia en las trazas:*
- **Con `turno(N)` (atómico):**
  ```text
  [greeter2] Me despierto happy
  [greeter1] Me despierto grumpy
  ```
- **Con `inc; ?count(N)` (no atómico, condición de carrera):**
  ```text
  [greeter1] Me despierto grumpy
  [greeter2] Me despierto grumpy
  ```

La operación `turno(N)` implementada en el artefacto CArtAgO evita este problema porque las operaciones anotadas con `@OPERATION` se ejecutan bajo **exclusión mutua** garantizada por el artefacto. El incremento del valor y la devolución del nuevo número en el parámetro de salida (`n.set(...)`) se realizan en una única transacción atómica e indivisible.

---

### Pregunta 2 (Bloque 2)
> **Enunciado:** Cuando llega un saludo, ¿cómo elige Jason cuál de las dos reglas de `+saludo` ejecuta? ¿Qué pasaría si el agente creyera `mood(sleepy)` y no hubiera regla para ese ánimo?

**Respuesta:**
Cuando un agente recibe un mensaje de saludo, Jason genera el evento correspondiente (`+saludo(_)`) y busca en su *Plan Library* todos los planes relevantes cuyo disparador coincida con dicho evento. A continuación, evalúa el **contexto** (la guarda lógica tras los dos puntos `:`) de cada plan frente a su Base de Creencias actual (`mood(happy)` o `mood(grumpy)`). El plan cuyo contexto se evalúe como verdadero se selecciona como plan aplicable y se añade a la pila de intenciones del agente.

Si el agente tuviese la creencia `mood(sleepy)` y no existiese ninguna regla cuyo contexto contemple dicho estado de ánimo, ninguna de las reglas resultaría aplicable. En consecuencia, el evento no se procesaría y se descartaría silenciosamente de la cola de eventos sin alterar las intenciones del agente.

---

### Pregunta 3 (Bloque 2)
> **Enunciado:** ¿Por qué el agente contesta con `respuesta(M)` y no con otro `saludo(M)`?

**Respuesta:**
Para **evitar un bucle infinito de mensajes**. Si el agente respondiese enviando otro `saludo(M)`, la recepción de ese mensaje dispararía nuevamente en el otro agente la regla `+saludo(_)`, respondiendo con otro saludo y manteniéndolos en un ciclo sin fin. 

Al contestar con `respuesta(M)`, el mensaje es atendido por el plan específico `+respuesta(M)[source(S)]`, el cual finaliza la interacción de forma limpia imprimiendo la confirmación y añadiendo la creencia `+saludado`, lo que permite satisfacer y dar por completado el objetivo declarativo `saludar`.

---

### Pregunta 4 (Bloque 3)
> **Enunciado:** Poned a 1 la cardinalidad de la misión `m_saludar`, regenerad y ejecutad varias veces. ¿Cuántos agentes reciben la obligación? Explicadlo con la especificación normativa de Moise y volved a dejarla en 2.

**Respuesta:**
Al establecer la cardinalidad máxima de la misión en 1 (`max="1"` en `m_saludar` dentro del esquema Moise), la especificación funcional y normativa del esquema restringe que **solo un único agente pueda estar comprometido con dicha misión a la vez**.

Aunque la norma obligue a todos los agentes que desempeñan el rol `saludador` a comprometerse con la misión `m_saludar`, en cuanto el primer agente asume la misión, el cupo máximo de la misión queda saturado. Por ello, el segundo agente no recibe la obligación (o el gestor normativo de Moise le deniega el compromiso), quedando únicamente un agente con la obligación de saludar.
