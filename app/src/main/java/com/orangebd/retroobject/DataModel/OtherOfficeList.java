package com.orangebd.retroobject.DataModel;

import java.util.List;

public class OtherOfficeList {
    private String name;
    private List<DataList>OfficeList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DataList> getOfficeList() {
        return OfficeList;
    }

    public void setOfficeList(List<DataList> officeList) {
        OfficeList = officeList;
    }
}
