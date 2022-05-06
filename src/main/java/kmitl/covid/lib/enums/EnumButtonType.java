package kmitl.covid.lib.enums;

public enum EnumButtonType {
	PRIMARY("btn-primary"),
	SUCCESS("btn-success"),
	WARNING("btn-warning"),
	DANGER("btn-danger"),
	INFO("btn-info"),
	EMPTY("btn-empty"),
	;
	EnumButtonType(String style) {
		this.style = style;
	}

	private final String style;

	public String getStyle() {
		return style;
	}
}
