package service.facilityService;

import model.facility.Facility;

import java.util.List;

public interface IFacilityService {
    List<Facility> selectAll();

    boolean createF(Facility facility);

    boolean updateF(Facility facility);

    boolean deleteF(int id);

    List<Facility> findById(int id);
}
