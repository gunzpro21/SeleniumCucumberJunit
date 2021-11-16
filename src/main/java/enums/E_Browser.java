package enums;


public enum E_Browser {
	FIREFOX, CHROME, IE;

	public static E_Browser getBrowserType(String browser) throws IllegalArgumentException {
		for (E_Browser b : values()) {
			if (b.toString().equalsIgnoreCase(browser)) {
				return b;
			}
		}
		throw browserNotFound(browser);
	}

	private static IllegalArgumentException browserNotFound(String browserName) {
		return new IllegalArgumentException(("Invalid browser [" + browserName + "]"));
	}
}
