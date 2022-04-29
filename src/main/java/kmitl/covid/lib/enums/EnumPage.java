package kmitl.covid.lib.enums;

import javafx.scene.Node;
import kmitl.covid.content.authentication.ForgotPasswordPage;
import kmitl.covid.content.authentication.LoginPage;
import kmitl.covid.content.authentication.RegisterPage;
import kmitl.covid.content.dashboard.DashboardPage;
import kmitl.covid.content.user.NotificationPage;
import kmitl.covid.content.vaccine.BookVaccineDetailPage;
import kmitl.covid.content.vaccine.BookVaccinePage;
import kmitl.covid.content.vaccine.BookVaccineSuccessPage;

public record EnumPage(EnumPageType pageType, Node page) {
	private static EnumPage LOGIN;
	private static EnumPage REGISTER;
	private static EnumPage FORGOTPASSWORD;
	private static EnumPage DASHBOARD;
	private static EnumPage NOTIFICATION;
	private static EnumPage BOOKVACCINE;
	private static EnumPage BOOKVACCINEDETAIL;
	private static EnumPage BOOKVACCINESUCCESS;

	public static EnumPage LOGIN() {
		if (EnumPage.LOGIN != null) return EnumPage.LOGIN;
		EnumPage.LOGIN = new EnumPage(EnumPageType.NONLOGGEDIN, LoginPage.getContent());
		return EnumPage.LOGIN;
	}
	public static EnumPage REGISTER() {
		if (EnumPage.REGISTER != null) return EnumPage.REGISTER;
		EnumPage.REGISTER = new EnumPage(EnumPageType.NONLOGGEDIN, RegisterPage.getContent());
		return EnumPage.REGISTER;
	}
	public static EnumPage FORGOTPASSWORD() {
		if (EnumPage.FORGOTPASSWORD != null) return EnumPage.FORGOTPASSWORD;
		EnumPage.FORGOTPASSWORD = new EnumPage(EnumPageType.NONLOGGEDIN, ForgotPasswordPage.getContent());
		return EnumPage.FORGOTPASSWORD;
	}
	public static EnumPage DASHBOARD() {
		if (EnumPage.DASHBOARD != null) return EnumPage.DASHBOARD;
		EnumPage.DASHBOARD = new EnumPage(EnumPageType.LOGGEDIN, DashboardPage.getContent());
		return EnumPage.DASHBOARD;
	}
	public static EnumPage NOTIFICATION() {
		if (EnumPage.NOTIFICATION != null) return EnumPage.NOTIFICATION;
		EnumPage.NOTIFICATION = new EnumPage(EnumPageType.LOGGEDIN, NotificationPage.getContent());
		return EnumPage.NOTIFICATION;
	}
	public static EnumPage BOOKVACCINE() {
		if (EnumPage.BOOKVACCINE != null) return EnumPage.BOOKVACCINE;
		EnumPage.BOOKVACCINE = new EnumPage(EnumPageType.LOGGEDIN, BookVaccinePage.getContent());
		return EnumPage.BOOKVACCINE;
	}
	public static EnumPage BOOKVACCINEDETAIL() {
		if (EnumPage.BOOKVACCINEDETAIL != null) return EnumPage.BOOKVACCINEDETAIL;
		EnumPage.BOOKVACCINEDETAIL = new EnumPage(EnumPageType.LOGGEDIN, BookVaccineDetailPage.getContent());
		return EnumPage.BOOKVACCINEDETAIL;
	}
	public static EnumPage BOOKVACCINESUCCESS() {
		if (EnumPage.BOOKVACCINESUCCESS != null) return EnumPage.BOOKVACCINESUCCESS;
		EnumPage.BOOKVACCINESUCCESS = new EnumPage(EnumPageType.LOGGEDIN, BookVaccineSuccessPage.getContent());
		return EnumPage.BOOKVACCINESUCCESS;
	}
}
