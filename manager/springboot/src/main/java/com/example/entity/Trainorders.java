package com.example.entity;

import java.io.Serializable;

/**
 * 角色用户父类
 */
public class Trainorders implements Serializable {
    private Integer id;
    /** 用户名 */
    private String name;
    /** 名称 */
    private String user_id;

    private String time;
    private String flyTime;
    /** 角色标识 */
    private String startAirport;
    /** 新密码 */
    private String endAirport ;
    private String timeSlot ;
    private Integer num;
    private double price;
    private double orderNo;
    private double status;

    private Integer ticketId;
    private String begin;
    private String userName;

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

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFlyTime() {
        return flyTime;
    }

    public void setFlyTime(String flyTime) {
        this.flyTime = flyTime;
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

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(double orderNo) {
        this.orderNo = orderNo;
    }

    public double getStatus() {
        return status;
    }

    public void setStatus(double status) {
        this.status = status;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
