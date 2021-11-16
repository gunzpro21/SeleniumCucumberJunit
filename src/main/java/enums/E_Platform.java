package enums;


public enum E_Platform {
	WIN, WIN32, WIN64, MAC, LINUX;

	public static E_Platform getPlatformType(String platform) throws IllegalArgumentException {
		for (E_Platform p : values()) {
			if (p.toString().equalsIgnoreCase(platform)) {
				return p;
			}
		}
		throw invalidPlatform(platform);
		
	}

	private static IllegalArgumentException invalidPlatform(String platform) {
		return new IllegalArgumentException(("Invalid platform [" + platform + "]"));
	}

}
