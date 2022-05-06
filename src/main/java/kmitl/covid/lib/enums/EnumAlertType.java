package kmitl.covid.lib.enums;

public enum EnumAlertType {
	ERROR("เกิดข้อผิดพลาด!", "\uF071", "ลองอีกครั้ง", "\uF01E", EnumButtonType.PRIMARY, "text-danger"),
	WARNING("คำเตือน!", "\uF06A", "รับทราบ", "\uF00C", EnumButtonType.SUCCESS, "text-warning"),
	SUCCESS("ดำเนินการสำเร็จ", "\uF06A", "รับทราบ", "\uF00C", EnumButtonType.SUCCESS, "text-success"),
	;
	EnumAlertType(
		String title, String iconTitle, String textConfirm,
		String iconConfirm, EnumButtonType buttonType, String titleColor) {
		this.title = title;
		this.iconTitle = iconTitle;
		this.textConfirm = textConfirm;
		this.iconConfirm = iconConfirm;
		this.buttonType = buttonType;
		this.titleColor = titleColor;
	}

	private final String title;
	private final String iconTitle;
	private final String textConfirm;
	private final String iconConfirm;
	private final EnumButtonType buttonType;
	private final String titleColor;

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
	public EnumButtonType getButtonType() {
		return this.buttonType;
	}
	public String getTitleColor() {
		return this.titleColor;
	}
}
