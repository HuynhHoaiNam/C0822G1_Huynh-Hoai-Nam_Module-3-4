package service.facilityService.impl;

import model.facility.Facility;
import repository.facility.IFacilityRepository;
import repository.facility.impl.FacilityRepository;
import service.facilityService.IFacilityService;

import java.util.List;

public class FacilityService implements IFacilityService {
    private IFacilityRepository facilityRepository=new FacilityRepository();

    @Override
    public List<Facility> selectAll() {
        return facilityRepository.selectAll();
    }

    @Override
    public boolean createF(Facility facility) {
        return facilityRepository.createF(facility);
    }

    @Override
    public boolean updateF(Facility facility) {
        return facilityRepository.updateF(facility);
    }

    @Override
    public boolean deleteF(int id) {
        return facilityRepository.deleteF(id);
    }

    @Override
    public List<Facility> findById(int id) {
        return facilityRepository.findById(id);
    }
}
