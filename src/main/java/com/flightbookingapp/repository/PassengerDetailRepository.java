package com.flightbookingapp.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.flightbookingapp.entity.PassengerDetails;

@Repository
public interface PassengerDetailRepository extends CrudRepository<PassengerDetails, Integer>{

    PassengerDetails findByEmailId(String emailId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM `PassengerDetails`  WHERE emailId = :emailId", nativeQuery = true)
    void deleteByEmailId(@Param("emailId") String emailId);


//    PassengerDetails deleteByEmailId(String emailId);
    @Transactional
    @Modifying
    @Query(value = "UPDATE `PassengerDetails` p SET p.fullName = :fullName, p.age = :age, p.mobileNumber = :mobileNumber, p.password = :password WHERE p.emailId = :emailId")
    void updatePassengerDetailsById(@Param("fullName") String  fullName,
                                    @Param("emailId") String emailId,
                                    @Param("mobileNumber") Long mobileNumber,
                                    @Param("password") String password,
                                    @Param("age") int age);

}

