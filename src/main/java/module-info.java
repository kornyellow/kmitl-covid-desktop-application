module kmitl.covid {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;

	opens kmitl.covid.launcher to javafx.fxml;
	exports kmitl.covid.launcher;
}