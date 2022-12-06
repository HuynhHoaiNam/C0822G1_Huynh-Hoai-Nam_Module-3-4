package service.facilityService.impl;

import model.facility.FacilityType;
import repository.facility.IFacilityTypeRepository;
import repository.facility.impl.FacilityTypeRepository;
import service.facilityService.IFacilityService;
import service.facilityService.IFacilityTypeService;

import java.util.List;

public class FacilityTypeService implements IFacilityTypeService {
    private IFacilityTypeRepository facilityTypeRepository = new FacilityTypeRepository();

    @Override
    public List<FacilityType> selectF() {
        return facilityTypeRepository.selectF();
    }
}
