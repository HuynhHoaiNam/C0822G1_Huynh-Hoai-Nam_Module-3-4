package com.codegym.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class SongDto {
    private int id;
    @NotEmpty(message = "Tên bài hát không được trống")
    @Max(800)
    @Pattern(regexp = "^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$", message = "Không được chứa kí tự đặc biệt")
    private String name;
    @NotEmpty(message = "Nhạc sĩ không được trống")
    @Max(300)
    @Pattern(regexp = "^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$", message = "Không được chứa kí tự đặc biệt")
    private String musician;

    @NotEmpty(message = "Thể loại không được trống")
    @Max(1000)
    @Pattern(regexp = "^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+[,]*)*$", message = "Không được chứa kí tự đặc biệt và có dấu phấy")
    private String category;

    public SongDto() {
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

    public String getMusician() {
        return musician;
    }

    public void setMusician(String musician) {
        this.musician = musician;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
