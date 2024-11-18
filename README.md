# tbd-control-2

Control 2 de Taller de Bases de Datos desarrollado por el grupo 3.

# Integrantes
* [Aylin Castillo](https://github.com/cvstleee) (Desarrolladora DB)
* [Francisco Sanchez](https://github.com/Mellowzhong) (Desarrollador Frontend)
* [Alonso Sanhueza](https://github.com/AalSaa) (Desarrollador Backend)
* [Victor Varas](https://github.com/victorvaras) (Desarrollador Frontend)
* [Agustin Vera](https://github.com/Agustin-Vera) (Desarrollador Backend)

# Contenido
El repositorio incluye las siguientes carpetas principales:
* [Backend](https://github.com/AalSaa/tbd-control-2/tree/main/backend)
* [Frontend](https://github.com/AalSaa/tbd-control-2/tree/main/frontend)
* [Database](https://github.com/AalSaa/tbd-control-2/tree/main/database)

# Tecnologías requeridas
* Postgres 16.5
* JDK v17.0.13
* Spring Boot (Gradle + Java 17) v3.3.5
* Sql2o v1.6.0
* Spring Security v6.2.3
* Java-jwt v4.4.0
* Node.js v20.18.0 (LTS)
* Vite v5.4.10
* Vue v3.5.12
* Axios v1.7.7
* Intellij IDEA Ultimate 2024.2

# Pre-instalación
Asegúrese de tener instalados Postgres 16, JDK 17, Node.js e IntelliJ IDEA. Se recomienda utilizar las versiones mencionadas en las tecnologías requeridas.

# Instrucciones de instalación
1. Clonar el repositorio. Puede hacerlo usando el siguiente comando:
   ```sh
   git clone https://github.com/AalSaa/tbd-control-2
   ```
2. Ingresar a la carpeta raíz del repositorio clonado.
3. Ejecutar el script SQL:
  * Para Windows:
    - Copiar la ruta donde se encuentra el script, debería ser algo similar a esto:
      ```sh
      <ruta hacia el repositorio>/tbd-control-2/database/tables.sql
      ```
    - Ir a la ubicación de la carpeta bin de PostgreSQL, comúnmente es la siguiente:
      ```sh
      C:\Program Files\PostgreSQL\16\bin
      ```
    - Abrir una terminal en esa ruta y ejecutar el siguiente comando:
      ```sh
      psql -U <Usuario>  -h <Host> -p <Puerto> -f "<ruta hacia el repositorio>/tbd-control-2/database/tables.sql"
      ```
      Donde:
        - Usuario: Nombre del usuario administrador de PostgreSQL.
        - Host: Dirección IP del servidor.
        - Puerto: Puerto configurado para el servidor.
  
  * Para linux:
    - Abrir una terminal en la ruta donde se encuentra el script tables.sql y ejecutar el siguiente comando:
      ```sh
      psql -U <Usuario>  -h <Host> -p <Puerto> -f "tables.sql"
      ```
      Donde:
        - Usuario: Nombre del usuario administrador de PostgreSQL.
        - Host: Dirección IP del servidor.
        - Puerto: Puerto configurado para el servidor.
          
4. Abrir IntelliJ IDEA y seleccionar la opción "Abrir proyecto". Buscar la dirección del repositorio y seleccionar la carpeta backend.
5. Buscar el archivo BackendApplication.java e iniciarlo.
6. Abrir una terminal en la carpeta frontend y ejecutar los siguientes comandos:
  ```sh
  npm install
  ```
  Luego:
  ```sh
  npm run dev
  ```
7. Ir a su navegador web e ingresar la URL http://localhost:3000/
   
Con todos estos pasos, ya puede utilizar la aplicación web.


