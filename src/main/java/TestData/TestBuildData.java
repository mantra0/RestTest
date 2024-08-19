package TestData;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import payload.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestBuildData {

    public RequestBody setData(List<Map<String, String>> map){
        double latitude = Double.parseDouble(map.get(6).get("Value"));
        double longitude = Double.parseDouble(map.get(7).get("Value"));
        int accuracy = Integer.parseInt(map.get(0).get("Value"));
        String name = map.get(1).get("Value");
        String address = map.get(2).get("Value");
        String phoneNumber = map.get(3).get("Value");
        String language = map.get(4).get("Value");
        String website = map.get(5).get("Value");
        String typeOne = map.get(8).get("Value");
        String typeTwo = map.get(9).get("Value");
        RequestBody requestBody = new RequestBody();
        RequestBody.Location location = new RequestBody.Location();
        location.setLat(latitude);
        location.setLng(longitude);

        ArrayList<String> types = new ArrayList<>();
        types.add(typeOne);
        types.add(typeTwo);

        requestBody.setAccuracy(accuracy);
        requestBody.setName(name);
        requestBody.setAddress(address);
        requestBody.setLanguage(language);
        requestBody.setWebsite(website);
        requestBody.setPhone_number(phoneNumber);
        requestBody.setLocation(location);
        requestBody.setTypes(types);
        return requestBody;
    }
}
