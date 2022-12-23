package com.codegym.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;


public class UserDto implements Validator {

    private int id;

    @NotBlank(message = "Sai quy tắc tên")
    @Pattern(regexp = "\\D*", message = "Tên phải là chữ")
    @Size(min = 5, max = 45, message = "Tên từ 5 - 45 kí tự")
    private String name;


    @NotBlank(message = "Số điện thoại không được trống")
    @Pattern(regexp = "0\\d{9}", message = "Số điện thoại 0xxx xxx xxx")
    private String phoneNumber;

    @NotNull(message = "Tuổi không được trống")
    @Min(value = 18, message = "Tuổi phải lớn hơn 18")
    private int age;

    @NotBlank(message = "Email không được trống")
    @Pattern(regexp = "\\w+@\\w+.\\w+", message = "Email phải theo quy tắc xxx@xxx.xxx")
    private String email;

    public UserDto() {
    }

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
