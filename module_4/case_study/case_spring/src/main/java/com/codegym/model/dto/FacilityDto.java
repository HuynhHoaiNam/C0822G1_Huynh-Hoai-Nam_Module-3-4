package com.codegym.model.dto;

import com.codegym.model.facility.FacilityType;
import com.codegym.model.facility.RentType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class FacilityDto implements Validator {
    private int id;
    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "^([\b]*[a-z]*[ ])*([A-Z]*[a-z]*)$", message = "Tên không được chứa số và viết hoa chữ đầu")
    private String name;
    @NotNull(message = "Không được để trống or tất cả các kí tự là khoảng trắng")
    @Min(value = 0, message = "Diện tích phải lớn hơn 0")
//    ^\d+$(số dương)
    private double area;
    @NotNull(message = "Không được để trống or tất cả các kí tự là khoảng trắng")
    @Min(value = 0, message = "Giá phải là số nguyên dương")
    private double cost;
    @NotNull(message = "Không được để trống or tất cả các kí tự là khoảng trắng")
    @Min(value = 0, message = "Số người tối đa phải là số dương")
    private int maxPeople;
    private String standardRoom;
    private String descriptionOtherConvenience;
    @NotNull(message = "Không được để trống or tất cả các kí tự là khoảng trắng")
    @Min(value = 0, message = "Diện tích hồ bơi phải là số dương")
    private double poolArea;
    @NotNull(message = "Không được để trống or tất cả các kí tự là khoảng trắng")
    @Min(value = 0, message = "Số tầng phải là số dương")
    private int numberOfFloors;
    private String facilityFree;
    private FacilityType facilityType;
    private RentType rentType;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
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

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
