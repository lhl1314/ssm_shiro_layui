package com.teeth.pojo;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/4/12 0012
 * Time:8:26
 */
public class Province {
    private Integer id;
    private String name;
    private String code;
    private Integer countryId;

    public Province() {
    }

    public Province(Integer id, String name, String code, Integer countryId) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.countryId = countryId;
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

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    @Override
    public String toString() {
        return "Province{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", countryId=" + countryId +
                '}';
    }
}
