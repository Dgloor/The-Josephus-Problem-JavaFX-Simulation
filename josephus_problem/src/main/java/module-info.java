module app {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.base;
    requires javafx.media;
    requires com.jfoenix;
    opens app to javafx.fxml;
    exports app;
}
