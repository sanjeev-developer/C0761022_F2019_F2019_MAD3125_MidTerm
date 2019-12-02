package com.midtermtest.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Data {

    @SerializedName("jsondata")
    @Expose
    private ArrayList<Jsondatum> jsondata = null;

    public ArrayList<Jsondatum> getJsondata() {
        return jsondata;
    }

    public void setJsondata(ArrayList<Jsondatum> jsondata) {
        this.jsondata = jsondata;
    }

}