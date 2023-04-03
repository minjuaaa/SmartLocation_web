package smartlocation.contracker;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import smartlocation.contracker.dto.gps;
import smartlocation.contracker.service.GpsService;

import java.util.List;

@Controller
@RequiredArgsConstructor

public class MainController {
    private final GpsService gpsService;

//    @GetMapping("/")
//    public List<gps> gps() {
//        return gpsService.getGpsList();
//    }

    @RequestMapping("/")
    public String main(Model model){


        List<gps> lista = gpsService.getList();
        gps gpslat01 = gpsService.getlatitude01();
        gps gpslng01 = gpsService.getlongtitude01();
        gps gpslat02 = gpsService.getlatitude02();
        gps gpslng02 = gpsService.getlongtitude02();

        model.addAttribute("lista", lista);
        model.addAttribute("gpslat01", gpslat01);
        model.addAttribute("gpslng01", gpslng01);
        model.addAttribute("gpslat02", gpslat02);
        model.addAttribute("gpslng02", gpslng02);
        return "index";
    }

}
