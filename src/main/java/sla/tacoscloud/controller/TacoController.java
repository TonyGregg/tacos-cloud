package sla.tacoscloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Antony Genil on 2019-11-26 at 20 04 for tacos-cloud
 **/

@Controller
@ConfigurationProperties(prefix = "taco.orders")
@Slf4j
public class TacoController {
    private int pageSize = 20;
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    @GetMapping("/")
    public String getTacos() {
        log.info("Inside getTacos method. Page Size "+pageSize);
        return "Tacos";
    }
}
