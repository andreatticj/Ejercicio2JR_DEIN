package eu.andreatt.ejercicio2jr_dein.controller;

import eu.andreatt.ejercicio2jr_dein.bbdd.ConexionBD;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

/**
 * Controlador principal para la interfaz de usuario del ejercicio 2.
 * Permite al usuario generar diferentes informes basados en las opciones seleccionadas.
 */
public class Ejercicio2Controller {

    @FXML
    private Button btnAceptar;

    @FXML
    private Button btnCancelar;

    @FXML
    private ToggleGroup personas;

    @FXML
    private RadioButton rbInformePersonas;

    @FXML
    private RadioButton rbInformePersonasCalculos;

    @FXML
    private RadioButton rbInforomePersoanasSubinformes;

    private ConexionBD conexionBD;

    /**
     * Función de inicialización que se ejecuta al cargar el controlador.
     * Establece la conexión a la base de datos.
     */
    @FXML
    public void initialize() {
        conexion();
    }

    /**
     * Función para inicializar la conexión a la base de datos.
     * Si ocurre un error, muestra un mensaje de alerta.
     */
    private void conexion() {
        try {
            conexionBD = new ConexionBD();
        } catch (Exception e) {
            generarVentana(Alert.AlertType.ERROR, "Error al conectar a la base de datos", "ERROR").show();
            System.out.println(e.getMessage());
        }
    }

    /**
     * Maneja el evento de clic en el botón "Aceptar".
     * Dependiendo de la opción seleccionada, abre el informe correspondiente.
     *
     * @param event El evento de clic en el botón.
     */
    @FXML
    void aceptar(ActionEvent event) {
        conexion();
        if (rbInformePersonas.isSelected()) {
            openReport("/eu/andreatt/ejercicio2jr_dein/jaspser/ejercicio2_personas.jasper");
        } else if (rbInformePersonasCalculos.isSelected()) {
            openReport("/eu/andreatt/ejercicio2jr_dein/jaspser/ejercicio2_personas_calculos.jasper");
        } else if (rbInforomePersoanasSubinformes.isSelected()) {
            openReport("/eu/andreatt/ejercicio2jr_dein/jaspser/ejercicio2_personas_subinformes.jasper");
        }
    }

    /**
     * Maneja el evento de clic en el botón "Cancelar".
     * Restablece todas las opciones de los radio buttons a su estado desmarcado.
     *
     * @param event El evento de clic en el botón.
     */
    @FXML
    void cancelar(ActionEvent event) {
        rbInformePersonas.setSelected(false);
        rbInformePersonasCalculos.setSelected(false);
        rbInforomePersoanasSubinformes.setSelected(false);
    }

    /**
     * Crea una ventana de alerta con el tipo de alerta, mensaje y título proporcionados.
     *
     * @param tipoDeAlerta El tipo de alerta (ej. ERROR, WARNING, etc.).
     * @param mensaje El mensaje que se mostrará en la alerta.
     * @param title El título de la ventana de alerta.
     * @return Una ventana de alerta configurada con los parámetros dados.
     */
    private Alert generarVentana(Alert.AlertType tipoDeAlerta, String mensaje, String title) {
        Alert alerta = new Alert(tipoDeAlerta);
        alerta.setContentText(mensaje);
        alerta.setHeaderText(null);
        alerta.setTitle(title);
        return alerta;
    }

    /**
     * Abre un informe JasperReports utilizando el archivo .jasper especificado.
     * También se configuran parámetros como la ruta de las imágenes y la ubicación de los archivos Jasper.
     *
     * @param reportPath La ruta del archivo Jasper que se desea abrir.
     */
    private void openReport(String reportPath) {
        try {
            // Carga el informe Jasper
            JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource(reportPath));

            // Obtiene la conexión a la base de datos
            Connection conn = conexionBD.getConexion();

            // Parámetros que se pasarán al reporte
            Map<String, Object> parameters = new HashMap<>();
            String imageBasePath = getClass().getResource("/eu/andreatt/ejercicio2jr_dein/images/").toString();
            String jasperBasePath = getClass().getResource("/eu/andreatt/ejercicio2jr_dein/jaspser/").toString();
            parameters.put("REPORT_IMAGE", imageBasePath);
            parameters.put("REPORT_jasper", jasperBasePath);

            // Llena el informe con los parámetros y la conexión
            JasperPrint jprint = JasperFillManager.fillReport(report, parameters, conn);

            // Muestra el informe al usuario
            JasperViewer viewer = new JasperViewer(jprint, false);
            viewer.setVisible(true);
        } catch (Exception e) {
            // En caso de error, muestra una alerta de error
            generarVentana(Alert.AlertType.ERROR, "Ha ocurrido un error al abrir el reporte", "ERROR").show();
            System.out.println(e.getMessage());
        }
    }
}