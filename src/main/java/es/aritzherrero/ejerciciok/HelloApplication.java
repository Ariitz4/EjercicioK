package es.aritzherrero.ejerciciok;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
/**
 * Clase principal de la aplicación que extiende de Application.
 * Esta clase se encarga de iniciar la interfaz gráfica de la aplicación.
 */
public class HelloApplication extends Application {

    /**
     * Procedimiento que se invoca al iniciar la aplicación.
     *
     * @param stage el escenario principal de la aplicación
     * @throws Exception si ocurre un error al cargar el archivo FXML
     */
    @Override
    public void start(Stage stage) throws Exception {
        // Establece el título de la ventana
        stage.setTitle("RELOJ");

        Pane root;
        try {
            // Carga el archivo FXML y lo convierte en un objeto Pane
            root = (Pane) FXMLLoader.load(getClass().getResource("/es/aritzherrero/ejerciciok/fxml/ejercicioK.fxml"));

            // Crea una nueva escena con el Pane cargado y establece sus dimensiones
            Scene scene = new Scene(root, 466, 400);
            stage.setScene(scene);

            // Establece las dimensiones mínimas y máximas de la ventana
            stage.setMinWidth(466);
            stage.setMinHeight(400);
            stage.setMaxWidth(466);
            stage.setMaxHeight(400);

            // Muestra la ventana
            stage.show();
        } catch (IOException e) {
            // Maneja la excepción si ocurre un error al cargar el archivo FXML
            System.out.println("La ventana no se abrió correctamente.");
            e.printStackTrace();
        }
    }

    /**
     * Procedimiento principal que se utiliza para iniciar la aplicación.
     *
     * @param args argumentos de línea de comandos
     */
    public static void main(String[] args) {
        launch(args);
    }
}