1.- Descargar el proyecto de la ruta: https://github.com/danycaro147/gpo_salinas/tree/master
2.- Tener instalado maven en su version 3.X.X
3.- Tener instalado OpenJDK 17
4.- En mi caso, utilicé PostgreSQL como base de datos, lo cual es necesario para que el proyecto consuma información real.
5.- Una vez configurada la tecnología anterior, ejecutaremos los scripts de BD que se encuentran en la carpeta: database en la raíz del proyecto.
4.- Una vez descargado el proyecto con la tecnología instalada y configurado la base de datos con los scripts iniciales, nos iremos a la carpeta raíz del proyecto y abriremos una linea de comandos e ingresaremos lo siguiente:

    mvn clean compile
*Este comando nos permitirá descargar las librerias necesarias para el proyecto y generará una primera compilación.
5.- Al generar esa primera compilación, iremos al proyecto para cambiar el puerto o, en su caso, los valores necesarios para conectar el proyecto a la bd previamente generada.
5.- Una vez que las librearias fueron descargadas y se modificó la conexión a la base de datos, ingresaremos el siguiente comando:

    mvn spring-boot:run
*Este comando permitirá correr el proyecto en un entorno de desarrollo local.
