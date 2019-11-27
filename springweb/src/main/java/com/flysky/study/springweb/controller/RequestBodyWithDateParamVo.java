package com.flysky.study.springweb.controller;

import java.util.Date;

public class RequestBodyWithDateParamVo {
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date validityDate;
//    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthDay;

    public Date getValidityDate() {
        return validityDate;
    }

    public void setValidityDate(Date validityDate) {
        this.validityDate = validityDate;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
}
