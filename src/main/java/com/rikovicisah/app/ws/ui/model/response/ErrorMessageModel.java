package com.rikovicisah.app.ws.ui.model.response;

import java.util.Date;

public class ErrorMessageModel {
    private Date date;
    private String message;

    public ErrorMessageModel(){}

    public ErrorMessageModel(Date date, String message) {
        this.date = date;
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
