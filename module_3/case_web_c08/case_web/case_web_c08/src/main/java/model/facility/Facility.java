package model.facility;

public class Facility {
    private Integer id;
    private String name;
    private Integer area;
    private Double cost;
    private Integer maxPeople;
    private Integer rentTypeId;
    private Integer facilityTypeId;
    private String standardRoom;
    private  String descriptionOtherConvenience;
    private Double poolArea;
    private Integer numberOfFloors;
    private String facilityFree;
    private FacilityType facilityType;
    private RentType rentType;

    public Facility() {
    }



    public Facility(String name, Integer area, Double cost, Integer maxPeople, Integer rentTypeId, Integer facilityTypeId,
                    String standardRoom, String descriptionOtherConvenience, Double poolArea, Integer numberOfFloors,
                    String facilityFree) {
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.rentTypeId = rentTypeId;
        this.facilityTypeId = facilityTypeId;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.facilityFree = facilityFree;
    }

    public Facility(Integer id, String name, Integer area, Double cost, Integer maxPeople,
                    String standardRoom, String descriptionOtherConvenience, Double poolArea, Integer numberOfFloors,
                    String facilityFree, FacilityType facilityType, RentType rentType) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.facilityFree = facilityFree;
        this.facilityType = facilityType;
        this.rentType = rentType;
    }

    public Facility(Integer id, String name, Integer area, Double cost, Integer maxPeople, Integer rentTypeId, Integer facilityTypeId,
                    String standardRoom, String descriptionOtherConvenience, Double poolArea, Integer numberOfFloors, String facilityFree) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.rentTypeId = rentTypeId;
        this.facilityTypeId = facilityTypeId;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.facilityFree = facilityFree;
    }

    public Facility(Integer id, String name, Integer area, Double cost, Integer maxPeople, Integer rentTypeId, Integer facilityTypeId,
                    String standardRoom, String descriptionOtherConvenience, Double poolArea, Integer numberOfFloors,
                    String facilityFree, FacilityType facilityType, RentType rentType) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.rentTypeId = rentTypeId;
        this.facilityTypeId = facilityTypeId;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.facilityFree = facilityFree;
        this.facilityType = facilityType;
        this.rentType = rentType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    public Integer getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(Integer rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public Integer getFacilityTypeId() {
        return facilityTypeId;
    }

    public void setFacilityTypeId(Integer facilityTypeId) {
        this.facilityTypeId = facilityTypeId;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }
}
