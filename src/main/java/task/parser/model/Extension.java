package task.parser.model;

public enum Extension {
	CSV("csv"),
	JSON("json");
	
	private String nameLowerCase;
	
	private Extension(String name) {
		nameLowerCase = name;
	}
	
	public String getNameLowerCase() {
		return nameLowerCase;
	}
}