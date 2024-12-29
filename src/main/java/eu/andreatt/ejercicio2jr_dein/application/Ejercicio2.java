package eu.andreatt.ejercicio2jr_dein.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Ejercicio2 extends Application {

        /**
         * La función {@code start} es el punto de entrada de la aplicación JavaFX.
         * Carga la interfaz desde un archivo FXML y establece las dimensiones mínimas de la ventana.
         *
         * @param stage El escenario principal (ventana) de la aplicación.
         * @throws IOException Si no se puede cargar el archivo FXML.
         */
        @Override
        public void start(Stage stage) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(Ejercicio2.class.getResource("/eu/andreatt/ejercicio2jr_dein/fxml/Ejercicio2.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 500, 450);
            stage.setMinHeight(300);
            stage.setMinWidth(350);
            stage.setResizable(false);
            stage.setTitle("INFORMES"); // Título de la ventana
            stage.setScene(scene);
            stage.show(); // Mostrar la ventana
        }

        /**
         * La función {@code main} es el punto de entrada estándar para lanzar la aplicación JavaFX.
         * Llama a la función {@code launch}, que es provisto por la clase {@code Application}.
         *
         * @param args Los argumentos de línea de comandos.
         */
        public static void main(String[] args) {
            launch();
        }

}
