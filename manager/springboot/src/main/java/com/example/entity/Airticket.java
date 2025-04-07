package com.example.entity;

import java.io.Serializable;

/**
 * 飞机票信息表
 */
public class Airticket implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String img;
    private String time;
    private String startTime;
    private String endTime;
    private String startAirport;
    private String endAirport;
    private String startCity;
    private String endCity;
    private Double price;
    private Integer num;

    private String left;
    private String right;


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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
    public String getEndCity() {
        return endCity;
    }

    public void setEndCity(String endCity) {
        this.endCity = endCity;
    }

    public String getStartCity() {
        return startCity;
    }

    public void setStartCity(String startCity) {
        this.startCity = startCity;
    }
    public String getLeft() {
        return left;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }


}