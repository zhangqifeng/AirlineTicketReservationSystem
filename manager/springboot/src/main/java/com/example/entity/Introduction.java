package com.example.entity;

import java.io.Serializable;

/**
 * 公告信息表
*/
public class Introduction implements Serializable {
    private static final long serialVersionUID = 1L;

    /** ID */
    private Integer id;
    /** 标题 */
    private String name;
    /** 内容 */
    private String img;
    /** 创建时间 */
    private String content;
    /** 创建人 */

    private Integer comment;
    private Integer collect;
    private Integer views;
    private String time;
    private Integer userId;
    private String description;
    private String userName;
    private String userAvatar;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getComment() {
        return comment;
    }

    public void setComment(Integer comment) {
        this.comment = comment;
    }

    public Integer getCollect() {
        return collect;
    }

    public void setCollect(Integer collect) {
        this.collect = collect;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


}