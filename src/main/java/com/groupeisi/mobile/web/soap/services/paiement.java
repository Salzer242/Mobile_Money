package com.groupeisi.mobile.web.soap.services;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class paiement {
    int id;
    int amount;

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



}
