module kmitl.covid {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	requires bcrypt;
	requires org.kordamp.bootstrapfx.core;

	opens kmitl.covid.launcher to javafx.fxml;
	exports kmitl.covid.launcher;
}