package com.example.exercisew8d4.Repository;

import com.example.exercisew8d4.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    Address findAddressById(Integer id);

}