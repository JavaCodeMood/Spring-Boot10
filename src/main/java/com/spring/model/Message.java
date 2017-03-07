package com.spring.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 实体层
 * @author dell
 *
 */
public class Message {
    private int id;
    private String ip;
    @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss.SSS")
    private Date insertDate;
    private String nickName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
