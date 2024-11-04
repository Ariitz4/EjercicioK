module es.aritzherrero.ejerciciok {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.aritzherrero.ejerciciok to javafx.fxml;
    exports es.aritzherrero.ejerciciok;
    opens es.aritzherrero.ejerciciok.Controlador to javafx.fxml;
}