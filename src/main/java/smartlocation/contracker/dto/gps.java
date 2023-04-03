package smartlocation.contracker.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public class gps {
        private int userID;
        private String state;
        private String type;
        private String latitude;
        private String longtitude;
        private String timestamp;
    }

