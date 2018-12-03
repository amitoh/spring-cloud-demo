package spring.cloud.app.paymentservice.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import spring.cloud.app.paymentservice.rest.PaymentClient;

import java.net.URI;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private PaymentClient paymentClient;

    @HystrixCommand(fallbackMethod = "fallback", groupKey = "user",
            commandKey = "go", threadPoolKey = "user-pool")
    @GetMapping("go")
    public String go() {
        String entity = paymentClient.message();
        return "user service got " + entity;
    }

    public String fallback(Throwable hystrixCommand) {
        return "error";
    }

}
