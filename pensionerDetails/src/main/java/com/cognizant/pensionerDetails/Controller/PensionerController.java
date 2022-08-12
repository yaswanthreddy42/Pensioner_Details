package com.cognizant.pensionerDetails.Controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.pensionerDetails.Exception.PensionerExceptoin;
import com.cognizant.pensionerDetails.Model.BankDetail;
import com.cognizant.pensionerDetails.Model.PensionerDetails;
import com.cognizant.pensionerDetails.repository.PensionerDetailRepository;

@RestController
public class PensionerController {

	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(PensionerController.class);
	
	@Autowired
	private PensionerDetailRepository pensionerDetailRepository;

	@GetMapping("/HealthCheck")
	public String Home() {
		return "The server is good";
	}
	//used to get the Pensioner Details by AadharNUmber
	@GetMapping("/PensionerDetailByAadhaar/{aadhar}")
	public PensionerDetails getpensionerDetails(@PathVariable String aadhar) throws Exception {

		LOGGER.info("STARTED - savePensionerData");
		List<PensionerDetails> pensionlist = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/main/resources/Details.csv"));
			String lines = "";
			int n=10;
			while (((lines = br.readLine()) != null)){
				String[] line = lines.split(",");
				

				PensionerDetails pensionerDetails = new PensionerDetails();
				pensionerDetails.setAadharNumber(line[0]);
				pensionerDetails.setName(line[1]);
				pensionerDetails.setDateofBirth(line[2]);
				pensionerDetails.setPanNumber(line[3]);
				pensionerDetails.setSalary(Double.parseDouble(line[4]));
				pensionerDetails.setAllowances(Double.parseDouble(line[5]));
				pensionerDetails.setPensionType(line[6]);
				pensionerDetails.setBankDetail(new BankDetail(line[7], line[8], line[9]));
				pensionlist.add(pensionerDetails);
				n=line.length;
			}
			br.close();
		} catch (Exception e) {
			LOGGER.error("EXCEPTION - savePensionerData");
		}
		pensionerDetailRepository.saveAll(pensionlist);
		LOGGER.info("END - savePensionerData");

		PensionerDetails pensionerDetails = pensionerDetailRepository.findById(aadhar)
				.orElseThrow(() -> new PensionerExceptoin("Pensioner not found"));
		
		System.out.println(pensionerDetails);
		return pensionerDetails;
	}

}
