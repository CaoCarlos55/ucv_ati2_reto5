# Reto 5 - parte 2

Practica Laboratorio (3): TDD y Pruebas Unitarias con Spring Boot

---
## Mis conclusiones:

Despues de realizar el laboratorio paso a paso, siguiendo las indicaciones, podemos responder las preguntas planteada durante la actividad:
1.  Al inicio, escribimos código y luego el test, pero esta no es una aplicación de la estrategia TDD. Para hacer uso correctamente de la metodología, primero debemos escribir la prueba, verla fallar y solo entonces implementar el código mínimo para que pase. Esto cambia totalmente la forma de pensar y diseñar una solución.
2.  Existe una clara separación entre `src/main` que contiene el codigo que se despliega y `src/test` que contiene el código para verificar la funcionalidad. Con Gradle gestionando estas carpetas se permite asegurar que las pruebas no "ensucien" el producto final.
3.  Para probar el `CategoryController` de forma aislada, fue indispensable usar **Mocks** para simular el `CategoryService`. Si usara el servicio real, estaría haciendo una prueba de integración y no unitaria, perdiendo el control sobre qué estoy probando exactamente.
4.  Una de las mejores experiencias fue refactorizar el código. Gracias a que tenía un test en verde, pude optimizar el código con la seguridad de que, si rompía algo, la prueba me avisaría inmediatamente.



Recomendaciones para un Colega, si piensas realizar este laboratorio, te dejo estos consejos:

* **No te saltes el fallo:**  La logica de la gran mayoria es escribir el código de una vez, pero si no ves el test fallar primero, no puedes estar seguro de que tu prueba realmente sirve para algo.
* **Verifica todo el objeto:** No te conformes con verificar el tamaño de la lista (`assert size`). Asegúrate de verificar también el contenido (IDs, nombres y descripciones) para garantizar que los datos son íntegros.
* **Refresca Gradle:** Si al agregar dependencias (como JUnit o Mockito) el IDE no las reconoce, ve a la pestaña de Gradle y dale a "Reload". Me pasó y es necesario para sincronizar las librerías. 


#### TODO: Algunas tareas pendientes o mejoras futuras para el proyecto:

* Agregar pruebas para casos de error (ej. excepciones controladas).
* Implementar la lógica real en `CategoryService` conectando a una base de datos.

---
### Evidencias

**Configuración inicial y creación del proyecto Spring Boot con Gradle en IntelliJ:**
![img-1](img/Reto5-1.png)

**Carga de dependencias en build.gradle y construcción exitosa del proyecto:**
![img-2](img/Reto5-2.png)

**Implementación de la clase CategoryController con los endpoints básicos /hello y /categories:**
![img-3](img/Reto5-3.png)

**Primera ejecución exitosa de las pruebas unitarias para los métodos básicos:**
![img-4](img/Reto5-4.png)

**Log de consola confirmando "BUILD SUCCESSFUL" tras la ejecución de los tests:**
![img-5](img/Reto5-5.png)

**Reporte HTML generado por Gradle mostrando un 100% de éxito en las pruebas:**
![img-6](img/Reto5-6.png)

**Modificación intencional del código (cambio a "Hola") para provocar un fallo en el test:**
![img-7](img/Reto5-7.png)

**Visualización del fallo del test detectando la discrepancia entre el valor esperado y el actual:**
![img-8](img/Reto5-8.png)

**Reporte HTML actualizando el estado a 50% de éxito debido al error inducido:**
![img-9](img/Reto5-9.png)

**Implementación del test avanzado verificando la lista de categorías, IDs y descripciones:**
![img-10](img/Reto5-10.png)

**Ejecución del test con el coverage para visualizar las clases:**
![img-12](img/Reto5-12.png)

**Modificación con el try - catch y ejecución de la prueba:**
![img-13](img/Reto5-13.png)

**Visualización de la prueba anterior, la nueva duración despues de la modificación:**
![img-14](img/Reto5-14.png)

**Reporte final de Gradle con el coverage:**
![img-15](img/Reto5-15.png)

**Modifique la función de "Hello" para que la ejecución final sea exitosa en todas las pruebas unitarias con el Mockito configurado**
![img-16](img/Reto5-16.png)

**Añadiendo las dos nuevas pruebas solicitadas en el reto**
![img-17](img/Reto5-17.png)

