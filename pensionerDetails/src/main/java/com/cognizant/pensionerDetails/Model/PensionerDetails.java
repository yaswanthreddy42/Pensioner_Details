package com.cognizant.pensionerDetails.Model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ApiModel(description = "PEnsioner Details")
//Pensioner Validations
public class PensionerDetails {
	@Id
	private String aadharNumber;
    @ApiModelProperty(notes = "Contains only alphabets")
	private String name;
	private String dateofBirth;
	private String panNumber;
	private double Salary;
	private double allowances;
	private String pensionType;
	@Embedded
	private BankDetail bankDetail;
	
}
