package kmitl.covid.lib.enums;

public enum EnumAlertType {
	ERROR("เกิดข้อผิดพลาด!", "ลองอีกครั้ง"),
	WARNING("คำเตือน!", "รับทราบ"),
	SUCCESS("ดำเนินการสำเร็จ", "รับทราบ"),
	;
	EnumAlertType(String title, String textConfirm) {
		this.title = title;
		this.textConfirm = textConfirm;
	}

	private final String title;
	private final String textConfirm;

	public String getTitle() {
		return title;
	}
	public String getTextConfirm() {
		return this.textConfirm;
	}
}
