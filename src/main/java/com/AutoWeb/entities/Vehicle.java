package com.AutoWeb.entities;

public class Vehicle {
    //veiculo
    
    private String model;
    private Integer manufactureyear; // Corrigido para manufactureyear
    private String plate;
    
    
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public int getManufactureYear() {
        return manufactureyear; // Corrigido para manufactureyear
    }
    public void setManufactureYear(Integer manufactureYear) {
        this.manufactureyear = manufactureYear; // Corrigido para manufactureyear
    }
    public String getPlate() {
        return plate;
    }
    public void setPlate(String plate) {
        this.plate = plate;
    }
    
}
