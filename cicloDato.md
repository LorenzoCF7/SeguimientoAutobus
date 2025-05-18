# Ciclo de Vida del Dato en la App de Autobuses

## 1. Creación o Captura del Dato
La aplicación genera datos como la hora de llegada, ubicación o ID del autobús automáticamente durante la ejecución, simulando un sistema en tiempo real.

## 2. Almacenamiento
Los datos generados (por ejemplo, eventos de movimiento o paradas de autobús) se almacenan en un archivo CSV. Este registro persistente garantiza que la información pueda ser revisada o utilizada posteriormente.

## 3. Uso
Los datos almacenados se utilizan para representar visualmente el recorrido de los autobuses en la interfaz y para calcular eventos como llegadas a paradas, tiempos, etc.

## 4. Compartición
Aunque en esta versión la aplicación no comparte datos con sistemas externos, el CSV generado podría usarse para intercambiar información con otras aplicaciones o exportarla para análisis.

## 5. Archivado / Almacenamiento a Largo Plazo
El sistema guarda toda la información en el archivo CSV sin eliminarla, asegurando un almacenamiento a largo plazo que permite la trazabilidad de los eventos pasados.

## 6. Eliminación
Actualmente no se implementa un proceso de eliminación automática de los datos. Sin embargo, se podría añadir una opción para limpiar o archivar los CSV antiguos si fuera necesario.
