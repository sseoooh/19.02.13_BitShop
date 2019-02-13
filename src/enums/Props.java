package enums;

public enum Props {
	ORA_DRIVER("oracle.jdbc.OracleDriver"),
	DB_USER("ORACLE"),
	DB_PASS("password"),
	DB_URL("jdbc:oracle:thin:@localhost:1521:xe");
	
	private String value;
	
	private Props(String value) {//생성자
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	
}