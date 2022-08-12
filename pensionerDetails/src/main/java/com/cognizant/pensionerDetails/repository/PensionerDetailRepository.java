package com.cognizant.pensionerDetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.pensionerDetails.Model.PensionerDetails;

@Repository
public interface PensionerDetailRepository extends JpaRepository<PensionerDetails, String> {

}
