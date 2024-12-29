module eu.andreatt.ejercicio2jr_dein {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens eu.andreatt.ejercicio2jr_dein to javafx.fxml;
    exports eu.andreatt.ejercicio2jr_dein;
}