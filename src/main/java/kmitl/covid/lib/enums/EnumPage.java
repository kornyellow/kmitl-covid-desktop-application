package kmitl.covid.lib.enums;

import javafx.scene.Node;
import kmitl.covid.content.authentication.ForgotPasswordPage;
import kmitl.covid.content.authentication.LoginPage;
import kmitl.covid.content.authentication.RegisterPage;
import kmitl.covid.content.dashboard.DashboardPage;
import kmitl.covid.content.user.NotificationPage;
import kmitl.covid.content.user.SettingPage;
import kmitl.covid.content.vaccine.BookVaccineDetailPage;
import kmitl.covid.content.vaccine.BookVaccinePage;

public record EnumPage(EnumPageType pageType, Node page) {
	public static EnumPage LOGIN() {
		return new EnumPage(EnumPageType.NONLOGGEDIN, LoginPage.getContent());
	}
	public static EnumPage REGISTER() {
		return new EnumPage(EnumPageType.NONLOGGEDIN, RegisterPage.getContent());
	}
	public static EnumPage FORGOTPASSWORD() {
		return new EnumPage(EnumPageType.NONLOGGEDIN, ForgotPasswordPage.getContent());
	}
	public static EnumPage DASHBOARD() {
		return new EnumPage(EnumPageType.LOGGEDIN, DashboardPage.getContent());
	}
	public static EnumPage SETTING() {
		return new EnumPage(EnumPageType.LOGGEDIN, SettingPage.getContent());
	}
	public static EnumPage NOTIFICATION() {
		return new EnumPage(EnumPageType.LOGGEDIN, NotificationPage.getContent());
	}
	public static EnumPage BOOKVACCINE() {
		return new EnumPage(EnumPageType.LOGGEDIN, BookVaccinePage.getContent());
	}
	public static EnumPage BOOKVACCINEDETAIL() {
		return new EnumPage(EnumPageType.LOGGEDIN, BookVaccineDetailPage.getContent());
	}
}
