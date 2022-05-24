package kmitl.covid.lib.methods.authentication;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import kmitl.covid.lib.korn.kornresource.KornFont;

public class CVNotification {
	public static VBox getNotificationLogin(){

		Label headerLable = new Label("เข้าสู่ระบบ");
		headerLable.setFont(KornFont.subHeaderBold);
		headerLable.setPadding(new Insets(0, 850, 60, 0));

		Label headerLable1 = new Label("คุณได้ทำการล็อคอินเข้าสู่ระบบ");
		headerLable1.setFont(KornFont.subHeaderNormal);
		headerLable1.setPadding(new Insets(25, 650, 0, 0));

		Label headerLable2 = new Label("20 พ.ค. 2565 เวลา 20:00");
		headerLable2.setFont(KornFont.subHeaderNormal);
		headerLable2.setPadding(new Insets(0, 0, 60, 750));

		Rectangle rectangle = new Rectangle();
		rectangle.setWidth(1080);
		rectangle.setHeight(130);
		rectangle.setFill(Color.LIGHTBLUE);
		rectangle.setArcHeight(105);
		rectangle.setArcWidth(50);

		StackPane layout = new StackPane(rectangle,headerLable,headerLable1,headerLable2);
		VBox header = new VBox();
		header.getChildren().add(layout);

		return header;
	}

	public static VBox getNotificationDataUpdate(){

		Label headerLable = new Label("ข้อมูลเปลี่ยนแปลง");
		headerLable.setFont(KornFont.subHeaderBold);
		headerLable.setPadding(new Insets(0, 770, 60, 0));

		Label headerLable1 = new Label("คุณได้ทำการเปลี่ยนข้อมูลเรียบร้อยเเล้ว");
		headerLable1.setFont(KornFont.subHeaderNormal);
		headerLable1.setPadding(new Insets(25, 570, 0, 0));

		Label headerLable2 = new Label("20 พ.ค. 2565 เวลา 20:10");
		headerLable2.setFont(KornFont.subHeaderNormal);
		headerLable2.setPadding(new Insets(0, 0, 60, 750));

		Rectangle rectangle = new Rectangle();
		rectangle.setWidth(1080);
		rectangle.setHeight(130);
		rectangle.setFill(Color.LIGHTBLUE);
		rectangle.setArcHeight(105);
		rectangle.setArcWidth(50);

		StackPane layout = new StackPane(rectangle,headerLable,headerLable1,headerLable2);
		VBox header = new VBox();
		header.getChildren().add(layout);

		return header;
	}

	public static VBox getNotificationBookVaccineDetail(){

		Label headerLable = new Label("การจองวัดซีน");
		headerLable.setFont(KornFont.subHeaderBold);
		headerLable.setPadding(new Insets(0, 800, 60, 0));

		Label headerLable1 = new Label("คุณได้ทำการจองวัดซีนไฟเซอร์เรียบร้อยเเล้ว");
		headerLable1.setFont(KornFont.subHeaderNormal);
		headerLable1.setPadding(new Insets(25, 510, 0, 0));

		Label headerLable2 = new Label("20 พ.ค. 2565 เวลา 20:20");
		headerLable2.setFont(KornFont.subHeaderNormal);
		headerLable2.setPadding(new Insets(0, 0, 60, 750));

		Rectangle rectangle = new Rectangle();
		rectangle.setWidth(1080);
		rectangle.setHeight(130);
		rectangle.setFill(Color.LIGHTBLUE);
		rectangle.setArcHeight(105);
		rectangle.setArcWidth(50);

		StackPane layout = new StackPane(rectangle,headerLable,headerLable1,headerLable2);
		VBox header = new VBox();
		header.getChildren().add(layout);

		return header;
	}

}
