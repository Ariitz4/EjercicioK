package es.aritzherrero.ejerciciok.Controlador;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.time.LocalDateTime;

/**
 * Controlador de la aplicación que se encarga de gestionar la lógica
 * del reloj visualizado en la interfaz gráfica.
 */
public class EjercicioK_Control implements Initializable {

    @FXML
    private ImageView imgDosPuntos1; // Imagen para el primer símbolo de dos puntos

    @FXML
    private ImageView imgDosPuntos2; // Imagen para el segundo símbolo de dos puntos

    @FXML
    private ImageView imgHora1; // Imagen para la primera cifra de la hora

    @FXML
    private ImageView imgHora2; // Imagen para la segunda cifra de la hora

    @FXML
    private ImageView imgMinuto1; // Imagen para la primera cifra del minuto

    @FXML
    private ImageView imgMinuto2; // Imagen para la segunda cifra del minuto

    @FXML
    private ImageView imgSegundo1; // Imagen para la primera cifra del segundo

    @FXML
    private ImageView imgSegundo2; // Imagen para la segunda cifra del segundo

    /**
     * Procedimiento que se llama al inicializar el controlador. Configura un Timer
     * que actualiza la hora, minutos y segundos cada segundo.
     *
     * @param arg0 URL del recurso FXML
     * @param arg1 ResourceBundle que contiene información localizable
     */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        LocalDateTime hora = LocalDateTime.now(); // Obtiene la hora actual
        TimerTask task = new TimerTask() {
            public void run() {
                // Obtiene la hora, minutos y segundos actuales
                int nHoras = new Date().getHours();
                int nMinuto = new Date().getMinutes();
                int nSegundo = new Date().getSeconds();

                // Calcula y actualiza las imágenes para hora, minutos y segundos
                calculaTiempo(nHoras, imgHora1, imgHora2);
                calculaTiempo(nMinuto, imgMinuto1, imgMinuto2);
                calculaTiempo(nSegundo, imgSegundo1, imgSegundo2);

                while (true) {
                    // Comprueba si hay cambios en la hora, minutos o segundos
                    int nHoraNueva = new Date().getHours();
                    int nMinutoNuevo = new Date().getMinutes();
                    int nSegundoNuevo = new Date().getSeconds();

                    // Actualiza la imagen de la hora si ha cambiado
                    if (nHoraNueva != nHoras) {
                        nHoras = nHoraNueva;
                        calculaTiempo(nHoras, imgHora1, imgHora2);
                    }
                    // Actualiza la imagen de los minutos si ha cambiado
                    if (nMinutoNuevo != nMinuto) {
                        nMinuto = nMinutoNuevo;
                        calculaTiempo(nMinuto, imgMinuto1, imgMinuto2);
                    }
                    // Actualiza la imagen de los segundos si ha cambiado
                    if (nSegundoNuevo != nSegundo) {
                        nSegundo = nSegundoNuevo;
                        calculaTiempo(nSegundo, imgSegundo1, imgSegundo2);
                    }
                }
            }
        };

        // Configura el Timer para que ejecute la tarea cada segundo
        Timer timer = new Timer("Timer");
        long delay = 1000L; // 1 segundo de retraso
        timer.schedule(task, delay); // Programa la tarea
    }

    /**
     * Calcula las cifras de tiempo y actualiza las imágenes correspondientes.
     *
     * @param t la cifra de tiempo (horas, minutos o segundos)
     * @param i1 la ImageView para la primera cifra
     * @param i2 la ImageView para la segunda cifra
     */
    private void calculaTiempo(int t, ImageView i1, ImageView i2) {
        int num1 = t % 10; // Obtiene el dígito de las unidades
        int num2 = (t - num1) / 10; // Obtiene el dígito de las decenas

        // Selecciona y actualiza las imágenes para los dígitos
        seleccionarImagen(num1, i2);
        seleccionarImagen(num2, i1);
    }

    /**
     * Selecciona la imagen correspondiente a un número y la establece en la ImageView.
     *
     * @param n el número del cual se desea seleccionar la imagen
     * @param i la ImageView en la que se establecerá la imagen
     */
    private void seleccionarImagen(int n, ImageView i) {
        switch (n) {
            case 1:
                i.setImage(new Image(getClass().getResource("/es/aritzherrero/ejerciciok/img/ONE.png").toString()));
                break;
            case 2:
                i.setImage(new Image(getClass().getResource("/es/aritzherrero/ejerciciok/img/TWO.png").toString()));
                break;
            case 3:
                i.setImage(new Image(getClass().getResource("/es/aritzherrero/ejerciciok/img/THREE.png").toString()));
                break;
            case 4:
                i.setImage(new Image(getClass().getResource("/es/aritzherrero/ejerciciok/img/FOUR.png").toString()));
                break;
            case 5:
                i.setImage(new Image(getClass().getResource("/es/aritzherrero/ejerciciok/img/FIVE.png").toString()));
                break;
            case 6:
                i.setImage(new Image(getClass().getResource("/es/aritzherrero/ejerciciok/img/SIX.png").toString()));
                break;
            case 7:
                i.setImage(new Image(getClass().getResource("/es/aritzherrero/ejerciciok/img/SEVEN.png").toString()));
                break;
            case 8:
                i.setImage(new Image(getClass().getResource("/es/aritzherrero/ejerciciok/img/EIGHT.png").toString()));
                break;
            case 9:
                i.setImage(new Image(getClass().getResource("/es/aritzherrero/ejerciciok/img/NINE.png").toString()));
                break;
            case 0:
                i.setImage(new Image(getClass().getResource("/es/aritzherrero/ejerciciok/img/ZERO.png").toString()));
                break;
        }
    }
}
