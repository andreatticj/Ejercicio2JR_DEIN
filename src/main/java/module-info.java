module eu.andreatt.ejercicio2jr_dein {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires jasperreports;
    requires java.sql;

    // Opens the necessary packages for reflection
    opens eu.andreatt.ejercicio2jr_dein.controller to javafx.fxml;
    opens eu.andreatt.ejercicio2jr_dein.application to javafx.fxml;

    // Exports the packages you need to make accessible to other modules
    exports eu.andreatt.ejercicio2jr_dein.controller;
    exports eu.andreatt.ejercicio2jr_dein.application;
}
