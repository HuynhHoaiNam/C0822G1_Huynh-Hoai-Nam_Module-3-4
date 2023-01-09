package com.codegym.repository.contract;

import com.codegym.model.contract.AttachFacility;
import com.codegym.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IAttachFacilityRepository extends JpaRepository<AttachFacility, Integer> {

    @Query(value = "select attach_facility.*\n" +
            "from attach_facility\n" +
            "         join contract_detail cd on attach_facility.id = cd.attach_facility_id\n" +
            "         join contract c on cd.contract_id = c.id\n" +
            "where cd.contract_id = :id", nativeQuery = true)
    List<AttachFacility> showList(int id);
}
