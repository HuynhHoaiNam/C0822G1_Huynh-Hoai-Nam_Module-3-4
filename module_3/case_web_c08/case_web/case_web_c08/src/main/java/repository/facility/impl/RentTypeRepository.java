package repository.facility.impl;

import model.facility.RentType;
import repository.customer.BaseRepository;
import repository.facility.IRentTypeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentTypeRepository implements IRentTypeRepository {
    private  final  String SELECT_All_RT="select* from rent_type;";
    @Override
    public List<RentType> selectAllR() {
        List<RentType> rentTypeList=new ArrayList<>();
        Connection connection= BaseRepository.getConnectDB();
        try {
            PreparedStatement ps= connection.prepareStatement(SELECT_All_RT);
            ResultSet resultSet= ps.executeQuery();
            while (resultSet.next()){
                int id= resultSet.getInt("id");
                String name=resultSet.getString("name");
                RentType rentType = new RentType(id,name);
                rentTypeList.add(rentType);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rentTypeList;
    }
}
