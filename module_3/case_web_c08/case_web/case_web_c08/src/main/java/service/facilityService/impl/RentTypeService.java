package service.facilityService.impl;

import model.facility.RentType;
import repository.facility.IFacilityTypeRepository;
import repository.facility.IRentTypeRepository;
import repository.facility.impl.RentTypeRepository;
import service.facilityService.IRentTypeService;

import java.util.List;

public class RentTypeService implements IRentTypeService {
    private IRentTypeRepository rentTypeRepository = new RentTypeRepository();

    @Override
    public List<RentType> selectAllR() {
        return rentTypeRepository.selectAllR();
    }
}
