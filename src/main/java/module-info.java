module se.iths.jhl.laboration3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens se.iths.jhl.laboration3 to javafx.fxml;
    exports se.iths.jhl.laboration3;
    exports se.iths.jhl.laboration3.Controller;
    opens se.iths.jhl.laboration3.Controller to javafx.fxml;
}