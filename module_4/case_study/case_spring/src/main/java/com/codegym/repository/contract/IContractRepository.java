package com.codegym.repository.contract;

import com.codegym.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IContractRepository extends JpaRepository<Contract, Integer> {

//    @Query(value = "select contract.id, contract.start_date, contract.end_date, contract.deposit, c.name, e.name, f.name\n" +
//            "from contract\n" +
//            "         join customer c on c.id = contract.customer_id\n" +
//            "         join employee e on e.id = contract.employee_id\n" +
//            "         join facility f on f.id = contract.facility_id", nativeQuery = true)
//    List<Contract> listCon();


}
