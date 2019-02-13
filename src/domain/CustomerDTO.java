package domain;

import lombok.Data;

public @Data class CustomerDTO {
	private String rnum,
				   customerID,
				   customerName,
				   password,
				   ssn,
				   photo,
				   phone,
				   city,
				   address,
				   postalcode;	
}
