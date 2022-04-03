module com.example.coviddesktopapplication {
	requires javafx.controls;
	requires javafx.fxml;


	opens com.example.coviddesktopapplication to javafx.fxml;
	exports com.example.coviddesktopapplication;
}