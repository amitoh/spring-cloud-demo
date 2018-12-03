package spring.cloud.app.paymentservice.rest;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "payment-service")
public interface PaymentClient {

    @GetMapping("payment/message")
    String message();
}
