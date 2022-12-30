package com.codegym.repository.facility;

import com.codegym.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IFacilityRepository extends JpaRepository<Facility, Integer> {

    @Query(value = "select * from facility join facility_type ft on ft.id = facility.facility_type_id where ft.name like concat( '%',:nameInput,'%')", nativeQuery = true)
    Page<Facility> listAndSearch(Pageable pageable, @Param("nameInput") String name, @Param("facilityType") String facilityType);
}
