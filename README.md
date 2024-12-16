# Aplicación de búsqueda en Google Maps 🗺️🌍📍
👥 Hecho por Enrique, Pablo y Santi

## Introducción

El objetivo de esta aplicación es crear una interfaz de búsqueda muy sencilla para Google Maps construida con Jetpack Compose. Los usuarios pueden ingresar una ubicación en la barra de búsqueda y la aplicación mostrará la ubicación correspondiente.

### Características

- **Barra de Búsqueda**: Permite a los usuarios ingresar una ubicación para buscar.
- **Botón de Enviar**: Permite enviar la ubicación introducida por el usuario.
- **Integración con Google Maps**: Muestra el mapa de la ubicación buscada.
- **MapView**: Utiliza `MapView` para mostrar el mapa dentro de una interfaz de Compose.
- **Actualización de Ubicación**: Actualiza el mapa con la ubicación buscada por el usuario.
- **Control de Zoom**: Habilita los controles de zoom en el mapa.

## Requisitos

- Android Studio
- API de Google Maps
- Conexión a Internet

## Instalación

1. Clona este repositorio.
2. Abre el proyecto en Android Studio.
3. Asegúrate de tener configuradas las claves de API de Google Maps en tu archivo `local.properties`:
    ```
    MAPS_KEY=TU_CLAVE_DE_API
    ```
4. Sincroniza el proyecto con Gradle.
5. Ejecuta la aplicación.

## Uso

1. Abre la aplicación.
2. Ingresa una ubicación en la barra de búsqueda.
3. Presiona el botón "Enviar".
4. El mapa se actualizará para mostrar la ubicación buscada.