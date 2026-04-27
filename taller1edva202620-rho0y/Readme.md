[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/cg_QYLsV)
# Taller Programación III - Stack en Java

## Actividad
Implemente una clase `HistorialAcciones` utilizando la clase `Stack` de Java.

El sistema debe permitir registrar acciones de un editor de texto, consultar la última acción realizada, deshacer acciones, contar acciones almacenadas y mostrar el historial.

## Métodos obligatorios
- `registrarAccion(String accion)`
- `obtenerUltimaAccion()`
- `deshacerAccion()`
- `obtenerCantidadAcciones()`
- `estaVacio()`
- `mostrarHistorial()`

## Restricciones
- No registrar acciones nulas, vacías o con solo espacios.
- Si no hay acciones, devolver mensajes adecuados.
- Debe utilizarse obligatoriamente la clase `Stack` de Java.

## Mensajes esperados
- `Sin acciones`
- `Nada que deshacer`
- `Historial vacío`

## Estructura del proyecto
```text
src
 ├── main
 │    └── java
 │         └── HistorialAcciones.java
 └── test
      └── java
           └── HistorialAccionesTest.java
```

## Ejecución local
```bash
mvn test
```

## Sugerencia docente
En GitHub Classroom se recomienda proteger:
- `src/test/java/HistorialAccionesTest.java`
- `.github/workflows/classroom.yml`
- `pom.xml`
