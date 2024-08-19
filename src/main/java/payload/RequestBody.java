package payload;

import lombok.Data;

import java.util.List;

@Data
public class RequestBody {
    private Location location;
    private int accuracy;
    private String name;
    private String phone_number;
    private String address;
    private List<String> types;
    private String website;
    private String language;

    @Data
    public static class Location{
        private double lat;
        private double lng;
    }
}
