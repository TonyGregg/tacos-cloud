package sla.tacoscloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import sla.tacoscloud.web.OrderProps;

/**
 * Created by Antony Genil on 2019-11-26 at 20 04 for tacos-cloud
 **/

@Controller
@Slf4j
public class TacoController {

    @Autowired
    OrderProps orderProps;

    @GetMapping("/")
    public String getTacos() {
        log.info("Inside getTacos method. Page Size :: "+orderProps.getPageSize());
        return "Tacos";
    }
}
