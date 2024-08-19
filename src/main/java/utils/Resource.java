package utils;

public enum Resource {

    AddPlaceApi("add/json"),
    GetPlaceApi("get/json");

    private String resource;

    Resource(String resource){
        this.resource = resource;
    }

    public String getResource(){
        return resource;
    }
}
