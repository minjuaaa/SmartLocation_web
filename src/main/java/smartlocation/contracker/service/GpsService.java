package smartlocation.contracker.service;

import smartlocation.contracker.dto.gps;

import java.util.List;

public interface GpsService {

    List<gps> getList();
    gps getlatitude01();
    gps getlongtitude01();

    gps getlatitude02();
    gps getlongtitude02();


}