# Ejercicio2JR_DEIN

## Descripción

    Ejercicio2JR_DEIN es una aplicación Java que gestiona una agenda de personas, utilizando conexiones a bases de datos y generación de informes con JasperReports. El proyecto incluye una interfaz gráfica construida con JavaFX.

## Estructura del Proyecto

    El proyecto está organizado según el siguiente paquete y estructura de archivos:

## Paquetes y Archivos Principales

    eu/andreatt/ejercicio2jr_dein/application
    
        Ejercicio2.java: Clase principal que inicializa la aplicación JavaFX.
    
    eu/andreatt/ejercicio2jr_dein/bbdd
    
        ConexionBD.java: Clase que gestiona la conexión a la base de datos.
    
    eu/andreatt/ejercicio2jr_dein/controller
    
        Ejercicio2Controller.java: Controlador principal de la aplicación, maneja los eventos y la lógica de la interfaz de usuario.
    
    eu/andreatt/ejercicio2jr_dein/util
    
        Propiedades.java: Clase para cargar y gestionar las propiedades de configuración desde el archivo configuration.properties.
    
    eu/andreatt/ejercicio2jr_dein/fxml
    
        Ejercicio2.fxml: Archivo de diseño de la interfaz de usuario construido con JavaFX.
    
    eu/andreatt/ejercicio2jr_dein/images
    
        agenda.png: Imagen utilizada en la interfaz.
        
        persona.png: Imagen representativa de las personas en la aplicación.
    
    eu/andreatt/ejercicio2jr_dein/jaspser
    
        ejercicio2_personas.jasper: Archivo compilado del informe principal.
        
        ejercicio2_personas.jrxml: Archivo fuente del informe principal.
        
        ejercicio2_personas_calculos.jasper: Informe compilado para cálculos adicionales.
        
        ejercicio2_personas_calculos.jrxml: Fuente del informe de cálculos adicionales.
        
        ejercicio2_personas_subinformes.jasper: Archivo compilado para informes secundarios.
        
        ejercicio2_personas_subinformes.jrxml: Fuente del informe de subinformes.
        
        subinforme_contactos.jasper: Archivo compilado del subinforme de contactos.
        
        subinforme_contactos.jrxml: Fuente del subinforme de contactos.
    
## Archivos de Configuración
    
    configuration.properties: Archivo de configuración que almacena información clave como la URL de la base de datos, usuario y contraseña.
    
    module-info.java: Archivo de configuración del módulo Java.
