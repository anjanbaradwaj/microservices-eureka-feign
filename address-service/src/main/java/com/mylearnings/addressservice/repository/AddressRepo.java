package com.mylearnings.addressservice.repository;

import com.mylearnings.addressservice.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer> {

    @Query(nativeQuery = true,
            value = "SELECT a.Id, a.City, a.State from demo.address a join demo.employee e " +
                    " on a.Employee_Id = e.Id where a.Employee_Id=:employeeId")
    Optional<Address> findAddressByEmployeeId(@Param("employeeId") int employeeId);
}
