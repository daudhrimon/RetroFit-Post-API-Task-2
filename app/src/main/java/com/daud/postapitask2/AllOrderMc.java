package com.daud.postapitask2;

public class AllOrderMc {
    private String status;
    private int status_code;
    private String message;
    private DataMc data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataMc getData() {
        return data;
    }

    public void setData(DataMc data) {
        this.data = data;
    }
}
