package repository.facility;

import model.facility.Facility;

import java.util.List;

public interface IFacilityRepository {
    List<Facility> selectAll();

    boolean createF(Facility facility);

    boolean updateF(Facility facility);

    boolean deleteF(int id);

    List<Facility> findById(int id);

    List<Facility> findManyField(String facilityName, String standardRoomFind);
}
