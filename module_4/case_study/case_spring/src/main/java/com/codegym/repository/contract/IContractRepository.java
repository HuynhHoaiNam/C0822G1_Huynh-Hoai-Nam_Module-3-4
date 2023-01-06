package com.codegym.repository.contract;

import com.codegym.model.contract.Contract;
import com.codegym.model.dto.IContractDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IContractRepository extends JpaRepository<Contract, Integer> {
    @Query(value = "select contract.id                                               as id,\n" +
            "       f.name                                                    as facilityName,\n" +
            "       c.name                                                    as customerName,\n" +
            "       contract.start_date                                       as startDate,\n" +
            "       contract.end_date                                         as endDate,\n" +
            "       contract.deposit                                          as deposit,\n" +
            "       sum(ifnull(cd.quantity * af.cost, 0)) + ifnull(f.cost, 0) as sumMoney\n" +
            "from contract\n" +
            "         left join contract_detail cd on contract.id = cd.contract_id\n" +
            "         left join attach_facility af on cd.attach_facility_id = af.id\n" +
            "         left join facility f on f.id = contract.facility_id\n" +
            "         left join customer c on c.id = contract.customer_id\n" +
            "group by contract.id\n" +
            "order by contract.id", nativeQuery = true)
    List<IContractDto> listCon();
}
