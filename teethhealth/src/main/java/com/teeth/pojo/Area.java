package com.teeth.pojo;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/4/12 0012
 * Time:8:28
 */
public class Area {
    private Integer id;
    private String name;
    private String code;
    private Integer cityId;

    public Area() {
    }

    public Area(Integer id, String name, String code, Integer cityId) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.cityId = cityId;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    @Override
    public String toString() {
        return "Area{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", cityId=" + cityId +
                '}';
    }
}
