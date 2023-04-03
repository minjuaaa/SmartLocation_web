package smartlocation.contracker.domain;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter @Setter
public class Task {

    private int taskId;
    private String place;
    private Timestamp time;
    private String cargoId;



}
