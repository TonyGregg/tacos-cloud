package sla.tacoscloud.web;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Created by Antony Genil Gregory on 12/7/2019 8:07 PM
 * For project : tacos-cloud
 **/
@Component
@Data
@ConfigurationProperties(prefix = "taco.orders")
@Validated
public class OrderProps {
    @Min(value = 5, message = "must be between 5 and 30")
    @Max(value = 30, message = "must be between 5 and 30")
    private int pageSize = 25;

}
