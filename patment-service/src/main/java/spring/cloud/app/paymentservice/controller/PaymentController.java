package spring.cloud.app.paymentservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Value("${eureka.instance.instanceId}")
    private String instanceId;

    @GetMapping("message")
    public String message() {
        return "payment service " + instanceId;
    }

}
