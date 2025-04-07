package com.example.entity;

import java.io.Serializable;

/**
 * 角色用户父类
 */
public class Busticket implements Serializable {
    private Integer id;
    /** 用户名 */
    private String name;
    /** 名称 */
    private String startTime;
    /** 密码 */
    private String endTime;
    /** 角色标识 */
    private String startAirport;
    /** 新密码 */
    private String endAirport ;
    private String startCity;
    private String endCity;
    /** 头像 */
    private double price;

    private String time;
    private Integer num;

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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStartAirport() {
        return startAirport;
    }

    public void setStartAirport(String startAirport) {
        this.startAirport = startAirport;
    }

    public String getEndAirport() {
        return endAirport;
    }

    public void setEndAirport(String endAirport) {
        this.endAirport = endAirport;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStartCity() {
        return startCity;
    }

    public void setStartCity(String startCity) {
        this.startCity = startCity;
    }

    public String getEndCity() {
        return endCity;
    }

    public void setEndCity(String endCity) {
        this.endCity = endCity;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
