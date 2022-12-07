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
    private final String SELECT_ALL_FACILITY = "select f.*, ft.name as name_facility_type , rt.name as name_rent_type " +
            "from facility_type ft join facility f on ft.id=f.facility_type_id join rent_type rt on rt.id = f.rent_type_id;";
    private final String FIND_MANY_FIELD = "select f.*, ft.name as name_facility_type , rt.name as name_rent_type from facility_type ft join facility f on ft.id=f.facility_type_id join rent_type rt on rt.id = f.rent_type_id where f.name like ? and f.standard_room like ?;";
    private final String INSERT_FACILITY = "INSERT INTO `furama_resort_web_C08`.`facility` \n" +
            "( `name`, `area`, `cost`, `max_peolpe`, `standard_room`, `description_other_convenience`, `pool_area`, `number_of_floors`, `facility_free`, `rent_type_id`, `facility_type_id`)\n" +
            " VALUES (?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?);";

    @Override
    public List<Facility> selectAll() {
        List<Facility> facilityList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL_FACILITY);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int area = resultSet.getInt("area");
                double cost = resultSet.getDouble("cost");
                int maxPeople = resultSet.getInt("max_peolpe");
                String standardRoom = resultSet.getString("standard_room");
                String descriptionOtherConvenience = resultSet.getString("description_other_convenience");
                double poolArea = resultSet.getDouble("pool_area");
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
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_FACILITY);
            ps.setString(1, facility.getName());
            ps.setInt(2, facility.getArea());
            ps.setDouble(3, facility.getCost());
            ps.setInt(4, facility.getMaxPeople());
            ps.setString(5, facility.getStandardRoom());
            ps.setString(6, facility.getDescriptionOtherConvenience());
            ps.setDouble(7, facility.getPoolArea());
            ps.setInt(8, facility.getNumberOfFloors());
            ps.setString(9, facility.getFacilityFree());
            ps.setInt(10, facility.getRentTypeId());
            ps.setInt(11, facility.getFacilityTypeId());
            return ps.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
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

    @Override
    public List<Facility> findManyField(String facilityName, String standardRoomFind) {
        List<Facility> facilityList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(FIND_MANY_FIELD);
            ps.setString(1, "%" + facilityName + "%");
            ps.setString(2, "%" + standardRoomFind + "%");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int area = resultSet.getInt("area");
                double cost = resultSet.getDouble("cost");
                int maxPeople = resultSet.getInt("max_peolpe");
                String standardRoom = resultSet.getString("standard_room");
                String descriptionOtherConvenience = resultSet.getString("description_other_convenience");
                double poolArea = resultSet.getDouble("pool_area");
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
}
