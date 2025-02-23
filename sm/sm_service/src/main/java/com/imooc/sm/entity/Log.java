package com.imooc.sm.entity;

import java.util.Date;

public class Log {
    private Date oprTime;
    private String type;
    private String operator;
    private String moudle;
    private String operation;
    private String result;

    public Log(){

    }
    public Log(Date oprTime, String type, String operator, String moudle, String operation, String result) {
        this.oprTime = oprTime;
        this.type = type;
        this.operator = operator;
        this.moudle = moudle;
        this.operation = operation;
        this.result = result;
    }

    public Date getOprTime() {
        return oprTime;
    }

    public void setOprTime(Date oprTime) {
        this.oprTime = oprTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getMoudle() {
        return moudle;
    }

    public void setMoudle(String moudle) {
        this.moudle = moudle;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
