module com.management.schoolmanagement {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires java.mail;

    opens com.management.schoolmanagement to javafx.fxml;
    opens com.management.schoolmanagement.model to javafx.fxml;
    opens com.management.schoolmanagement.modelcontroller to javafx.fxml;
    exports com.management.schoolmanagement;
    exports com.management.schoolmanagement.modelcontroller;
    exports com.management.schoolmanagement.model;
}