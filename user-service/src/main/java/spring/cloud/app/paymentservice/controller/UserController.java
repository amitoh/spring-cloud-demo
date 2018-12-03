package spring.cloud.app.paymentservice.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback", groupKey = "user",
            commandKey = "user", threadPoolKey = "user-pool")
    @GetMapping("go")
    public String go() {
        String entity = restTemplate.getForObject(URI.create("http://payment-service/payment/message"), String.class);
        return "user service got " + entity;
    }

    public String fallback(Throwable hystrixCommand) {
        return "error";
    }

}
