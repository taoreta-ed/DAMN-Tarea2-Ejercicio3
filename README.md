# Proyecto: calculadora2

Este proyecto consiste en una aplicación Android que incluye una calculadora y un cronómetro, con un menú principal para navegar entre ellas.

## Descripción de las Aplicaciones

### Menú Principal (MainActivity)

*   **Descripción:** El `MainActivity` actúa como el punto de entrada principal de la aplicación. Presenta un menú simple con dos botones: "Calculadora" y "Cronómetro".
*   **Funcionalidad:** Al presionar cada botón, se navega a la actividad correspondiente (Calculadora o Cronómetro).

### Calculadora (CalculatorActivity)

*   **Descripción:** La `CalculatorActivity` implementa una calculadora básica con las operaciones aritméticas fundamentales: suma, resta, multiplicación y división.
*   **Funcionalidad:**
    *   **Botones Numéricos (0-9):** Permiten ingresar números.
    *   **Botones de Operación (+, -, \*, /):** Permiten seleccionar la operación a realizar.
    *   **Botón Igual (=):** Calcula el resultado de la operación.
    *   **Botón AC:** Borra la pantalla y reinicia la calculadora.
    *   **Botón Decimal (.):** Permite ingresar números decimales.
    *   **Botón Menu:** Permite regresar al menú principal.
*   **Manejo de Errores:** La calculadora maneja la división por cero, mostrando 0 como resultado.

### Cronómetro (CronometroActivity)

*   **Descripción:** La `CronometroActivity` implementa un cronómetro que muestra el tiempo transcurrido en horas, minutos y segundos.
*   **Funcionalidad:**
    *   **Botón Iniciar/Pausar:** Inicia o pausa el cronómetro.
    *   **Botón Reiniciar:** Reinicia el cronómetro a 00:00:00.
    *   **Botón Menu:** Permite regresar al menú principal.
*   **Persistencia:** El cronómetro guarda su estado (tiempo y si está corriendo o no) cuando la actividad se pausa o se destruye, y lo restaura cuando se reanuda.

## Transiciones entre Actividades

Las transiciones entre actividades se manejan mediante `Intents`.

*   **Desde `MainActivity`:**
    *   Al hacer clic en el botón "Calculadora", se crea un `Intent` para iniciar `CalculatorActivity`.
    *   Al hacer clic en el botón "Cronómetro", se crea un `Intent` para iniciar `CronometroActivity`.
*   **Desde `CalculatorActivity`:**
    *   Al hacer clic en el botón "Menu", se crea un `Intent` para iniciar `MainActivity`.
*   **Desde `CronometroActivity`:**
    *   Al hacer clic en el botón "Menu", se crea un `Intent` para iniciar `MainActivity`.

En todos los casos, se utiliza el método `startActivity(intent)` para iniciar la nueva actividad.

## Instrucciones para Ejecutar y Probar las Aplicaciones

1.  **Requisitos:**
    *   Tener instalado Android Studio.
    *   Tener configurado un emulador de Android o un dispositivo físico conectado.
2.  **Clonar el Repositorio:**
    *   Si el proyecto está en un repositorio (por ejemplo, GitHub), clónalo en tu máquina local.
3.  **Abrir el Proyecto en Android Studio:**
    *   Abre Android Studio.
    *   Selecciona "Open" y busca la carpeta del proyecto.
4.  **Ejecutar la Aplicación:**
    *   Haz clic en el botón "Run" (el icono con una flecha verde).
    *   Selecciona el emulador o dispositivo donde quieres ejecutar la aplicación.
5.  **Probar las Aplicaciones:**
    *   **Menú Principal:** Verifica que los botones "Calculadora" y "Cronómetro" te lleven a las actividades correspondientes.
    *   **Calculadora:**
        *   Realiza diferentes operaciones aritméticas (suma, resta, multiplicación, división).
        *   Verifica que el botón AC borre la pantalla.
        *   Verifica que el botón decimal funcione correctamente.
        *   Prueba la división por cero.
        *   Verifica que el botón "Menu" te regrese al menú principal.
    *   **Cronómetro:**
        *   Inicia y pausa el cronómetro.
        *   Reinicia el cronómetro.
        *   Verifica que el tiempo se muestre correctamente.
        *   Verifica que el cronómetro guarde su estado al pausar la actividad (por ejemplo, al rotar la pantalla) y lo restaure al reanudarla.
        *   Verifica que el botón "Menu" te regrese al menú principal.

## Dependencias

*   androidx.core:core-ktx:1.15.0
*   androidx.core:core:1.15.0
*   androidx.annotation:annotation-experimental:1.4.1
*   androidx.lifecycle:lifecycle-runtime:2.6.2
*   androidx.versionedparcelable:versionedparcelable:1.1.1
*   androidx.appcompat:appcompat:1.7.0
*   androidx.activity:activity:1.10.0
*   androidx.lifecycle:lifecycle-viewmodel:2.6.2
*   androidx.lifecycle:lifecycle-viewmodel-savedstate:2.6.2
*   androidx.lifecycle:lifecycle-livedata-core:2.6.2
*   androidx.savedstate:savedstate:1.2.1
*   androidx.appcompat:appcompat-resources:1.7.0
*   androidx.vectordrawable:vectordrawable:1.1.0
*   androidx.vectordrawable:vectordrawable-animated:1.1.0
*   androidx.interpolator:interpolator:1.0.0
*   androidx.cursoradapter:cursoradapter:1.0.0
*   androidx.drawerlayout:drawerlayout:1.1.1
*   androidx.customview:customview:1.1.0
*   androidx.fragment:fragment:1.5.4
*   androidx.loader:loader:1.0.0
*   androidx.lifecycle:lifecycle-livedata:2.6.2
*   androidx.arch.core:core-runtime:2.2.0
*   androidx.viewpager:viewpager:1.0.0
*   androidx.cardview:cardview:1.0.0
*   androidx.coordinatorlayout:coordinatorlayout:1.1.0

## Autor

[Tu Nombre]