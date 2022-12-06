package repository.facility.impl;

import model.facility.Facility;
import model.facility.FacilityType;
import model.facility.RentType;
import repository.customer.BaseRepository;
import repository.facility.IFacilityRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacilityRepository implements IFacilityRepository {
    private final String SELECT_ALL = "select f.*, ft.name as name_facility_type , rt.name as name_rent_type from" +
            "facility_type ft join facility f on ft.id=f.facility_type_id" +
            "join rent_type rt on rt.id = f.rent_type_id;";


    @Override
    public List<Facility> selectAll() {
        List<Facility> facilityList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int area = resultSet.getInt("area");
                double cost = resultSet.getDouble("cost");
                int maxPeople = resultSet.getInt("max_people");
                String standardRoom = resultSet.getString("standard_room");
                String descriptionOtherConvenience = resultSet.getString("description_other_convenience");
                double poolArea = resultSet.getDouble("number_of_floors");
                int numberOfFloors = resultSet.getInt("number_of_floors");
                String facilityFree = resultSet.getString("facility_free");
                int idFacType = resultSet.getInt("facility_type_id");
                String nameFacType = resultSet.getString("name_facility_type");
                FacilityType facilityType = new FacilityType(idFacType, nameFacType);
                int idRentType = resultSet.getInt("rent_type_id");
                String nameRentType = resultSet.getString("name_rent_type");
                RentType rentType = new RentType(idRentType, nameRentType);
                Facility facility = new Facility(id, name, area, cost, maxPeople, standardRoom, descriptionOtherConvenience,
                        poolArea, numberOfFloors, facilityFree, facilityType, rentType);
                facilityList.add(facility);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return facilityList;
    }



    @Override
    public boolean createF(Facility facility) {
        return false;
    }

    @Override
    public boolean updateF(Facility facility) {
        return false;
    }

    @Override
    public boolean deleteF(int id) {
        return false;
    }

    @Override
    public List<Facility> findById(int id) {
        return null;
    }
}
