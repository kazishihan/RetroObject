
package com.orangebd.retroobject.DataModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataList {

    @SerializedName("division")
    @Expose
    private Integer division;
    @SerializedName("origin")
    @Expose
    private Integer origin;
    @SerializedName("district")
    @Expose
    private Integer district;
    @SerializedName("nameBn")
    @Expose
    private String nameBn;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("upazila")
    @Expose
    private Integer upazila;
    @SerializedName("ministry")
    @Expose
    private Integer ministry;
    @SerializedName("layer")
    @Expose
    private Integer layer;

    public Integer getDivision() {
        return division;
    }

    public void setDivision(Integer division) {
        this.division = division;
    }

    public Integer getOrigin() {
        return origin;
    }

    public void setOrigin(Integer origin) {
        this.origin = origin;
    }

    public Integer getDistrict() {
        return district;
    }

    public void setDistrict(Integer district) {
        this.district = district;
    }

    public String getNameBn() {
        return nameBn;
    }

    public void setNameBn(String nameBn) {
        this.nameBn = nameBn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUpazila() {
        return upazila;
    }

    public void setUpazila(Integer upazila) {
        this.upazila = upazila;
    }

    public Integer getMinistry() {
        return ministry;
    }

    public void setMinistry(Integer ministry) {
        this.ministry = ministry;
    }

    public Integer getLayer() {
        return layer;
    }

    public void setLayer(Integer layer) {
        this.layer = layer;
    }

}
