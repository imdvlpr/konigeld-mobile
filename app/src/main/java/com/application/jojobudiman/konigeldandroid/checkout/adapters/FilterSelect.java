package com.application.jojobudiman.konigeldandroid.checkout.adapters;

public class FilterSelect {
    public String filtername;
    public int filterid, filterprice;


    public FilterSelect(String filtername, int filterprice, Integer filterid) {
        this.filtername = filtername;
        this.filterprice = filterprice;
        this.filterid = filterid;
    }

    public String getFiltername() {
        return filtername;
    }

    public Integer getFilterprice() {
        return filterprice;
    }

    public int getFilterid() {
        return filterid;
    }

    public void setFiltername(String name) {
        this.filtername = name;
    }

    public void setFilterprice(int name) {
        this.filterprice = name;
    }

    public void setFilterid(int name) {
        this.filterid = name;
    }

}