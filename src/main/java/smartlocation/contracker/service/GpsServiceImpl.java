package smartlocation.contracker.service;


import smartlocation.contracker.dto.gps;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import smartlocation.contracker.dao.GpsMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GpsServiceImpl implements GpsService {
        private final GpsMapper gpsMapper;


    @Override
    public List<gps> getList(){
        return gpsMapper.getList();
    }



    @Override
    public gps getlongtitude01() { return gpsMapper.getlongtitude01(); }

    @Override
    public gps getlatitude01() { return gpsMapper.getlatitude01(); }

    @Override
    public gps getlongtitude02() { return gpsMapper.getlongtitude02(); }

    @Override
    public gps getlatitude02() { return gpsMapper.getlatitude02(); }
}

