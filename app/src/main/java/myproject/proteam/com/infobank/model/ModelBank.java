package myproject.proteam.com.infobank.model;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.List;


public class ModelBank {
    @SerializedName("date")
    private String date;
    @SerializedName("organizations")
    private List<ModelBaseBank> organizations;
    @SerializedName("regions")
    private HashMap<String, String> regions;
    @SerializedName("cities")
    private HashMap<String, String> cities;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<ModelBaseBank> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<ModelBaseBank> organizations) {
        this.organizations = organizations;
    }

    public HashMap<String, String> getRegions() {
        return regions;
    }

    public void setRegions(HashMap<String, String> regions) {
        this.regions = regions;
    }

    public HashMap<String, String> getCities() {
        return cities;
    }

    public void setCities(HashMap<String, String> cities) {
        this.cities = cities;
    }
}
