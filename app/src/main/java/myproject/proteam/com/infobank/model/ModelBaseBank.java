package myproject.proteam.com.infobank.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ModelBaseBank implements Serializable {

    @SerializedName("id")
    private String idDb;
    @SerializedName("title")
    private String titleDb;
    @SerializedName("regionId")
    private String regionIDb;
    @SerializedName("cityId")
    private String cityIdDb;
    @SerializedName("phone")
    private String phoneDb;
    @SerializedName("address")
    private String addressDb;
    @SerializedName("link")
    private String linkDb;

    public String getIdDb() {
        return idDb;
    }

    public void setIdDb(String idDb) {
        this.idDb = idDb;
    }

    public String getTitleDb() {
        return titleDb;
    }

    public void setTitleDb(String titleDb) {
        this.titleDb = titleDb;
    }

    public String getRegionIDb() {
        return regionIDb;
    }

    public void setRegionIDb(String regionIDb) {
        this.regionIDb = regionIDb;
    }

    public String getCityIdDb() {
        return cityIdDb;
    }

    public void setCityIdDb(String cityIdDb) {
        this.cityIdDb = cityIdDb;
    }

    public String getPhoneDb() {
        return phoneDb;
    }

    public void setPhoneDb(String phoneDb) {
        this.phoneDb = phoneDb;
    }

    public String getAddressDb() {
        return addressDb;
    }

    public void setAddressDb(String addressDb) {
        this.addressDb = addressDb;
    }

    public String getLinkDb() {
        return linkDb;
    }

    public void setLinkDb(String linkDb) {
        this.linkDb = linkDb;
    }

    @Override
    public String toString() {
        return "ModelBaseBank{" +
                "idDb='" + idDb + '\'' +
                ", titleDb='" + titleDb + '\'' +
                ", regionIDb='" + regionIDb + '\'' +
                ", cityIdDb='" + cityIdDb + '\'' +
                ", phoneDb='" + phoneDb + '\'' +
                ", addressDb='" + addressDb + '\'' +
                ", linkDb='" + linkDb + '\'' +
                '}';
    }
}
