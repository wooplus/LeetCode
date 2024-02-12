module com.example.leetcodeproblems {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.leetcodeproblems to javafx.fxml;
    exports com.example.leetcodeproblems;
}