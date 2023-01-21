package com.groupeisi.mobile.web.soap.services;

import javax.jws.WebService;

@WebService
public class transaction {
    int id;
    int amount;
    int send_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getSend_id() {
        return send_id;
    }

    public void setSend_id(int send_id) {
        this.send_id = send_id;
    }

    public int getRecever_id() {
        return recever_id;
    }

    public void setRecever_id(int recever_id) {
        this.recever_id = recever_id;
    }

    int recever_id;
}
