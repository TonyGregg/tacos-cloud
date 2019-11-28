package sla.tacoscloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Antony Genil on 2019-11-26 at 20 04 for tacos-cloud
 **/

@Controller
public class TacoController {
    @GetMapping("/")
    public String getTacos() {
        return "Tacos";
    }
}
