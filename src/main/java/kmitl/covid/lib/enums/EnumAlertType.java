package kmitl.covid.lib.enums;

public enum EnumAlertType {
	ERROR("เกิดข้อผิดพลาด!", "\uF071", "ลองอีกครั้ง", "\uF01E"),
	WARNING("คำเตือน!", "\uF06A", "รับทราบ", "\uF00C"),
	SUCCESS("ดำเนินการสำเร็จ", "\uF06A", "รับทราบ", "\uF00C"),
	;
	EnumAlertType(String title, String iconTitle, String textConfirm, String iconConfirm) {
		this.title = title;
		this.iconTitle = iconTitle;
		this.textConfirm = textConfirm;
		this.iconConfirm = iconConfirm;
	}

	private final String title;
	private final String iconTitle;
	private final String textConfirm;
	private final String iconConfirm;

	public String getTitle() {
		return title;
	}
	public String getIconTitle() {
		return this.iconTitle;
	}
	public String getTextConfirm() {
		return this.textConfirm;
	}
	public String getIconConfirm() {
		return this.iconConfirm;
	}
}
