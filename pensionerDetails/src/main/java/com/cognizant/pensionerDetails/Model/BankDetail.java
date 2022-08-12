package com.cognizant.pensionerDetails.Model;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Embeddable
//BankDetails
public class BankDetail {

	private String bankName;
	private String accountNumber;
	private String bankType;
}
