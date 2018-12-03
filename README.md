topology:

 - config server (pulls from git)
 - discovery server
 - 2 payment services (uses random port)
 - 1 user service (uses hystrix and feign client in order connect to payment service with circuit breaker)
 - 1 gateway (includes hystrix dashboard, load balancing using discovery server)

 * gateways can be loadbalanced using a hardware load balancer