package enums;

public enum CustomerSQL {
	SIGNUP, SIGNIN, LIST, ROW_COUNT;
	@Override
	public String toString() {
		StringBuffer query= new StringBuffer();		
	
		switch (this) {
		case SIGNUP:
			System.out.println("CustomerSQL에서 SIGNUP을 탐");
			query.append("INSERT INTO CUSTOMERS(CUSTOMER_ID, CUSTOMER_NAME, PASSWORD, ADDRESS, CITY, POSTALCODE, SSN)"
					+ " VALUES("
					+ " ?, ?, ?, ?, ?, ?, ?)");
					break;
					
		case SIGNIN:
			System.out.println("CustomerSQL에서 SIGNIN을 탐");
			query.append("SELECT * FROM CUSTOMERS\n"
					+ " WHERE CUSTOMER_ID LIKE ? AND PASSWORD LIKE ?");
					break;
		case LIST :
			System.out.println("CustomerSQL에서LIST을 탐");
			query.append("SELECT *\n" + 
					"FROM \n" + 
					"(SELECT ROWNUM RNUM, CU.* \n" + 
					"FROM CUSTOMERS CU\n" + 
					"ORDER BY RNUM DESC) \n" + 
					"WHERE RNUM BETWEEN ? AND ?\n");
					break;
		case ROW_COUNT:
			System.out.println("CustomerSQL에서 ROW_COUNT을 탐");
			query.append("SELECT COUNT(*) AS COUNT FROM CUSTOMERS");
			break;
					
		default:
			break;
		}
		return query.toString();
	}
}




