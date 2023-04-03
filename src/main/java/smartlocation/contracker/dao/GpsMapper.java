package smartlocation.contracker.dao;

import java.util.List;
import smartlocation.contracker.dto.gps;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface GpsMapper {


    List<gps> getList();



    gps getlatitude01();
    gps getlongtitude01();



    gps getlatitude02();
    gps getlongtitude02();
}