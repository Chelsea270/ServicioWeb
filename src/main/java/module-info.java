module org.test.servicioweb {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.fasterxml.jackson.databind;

    opens org.test.servicioweb to javafx.fxml;
    exports org.test.servicioweb;
}