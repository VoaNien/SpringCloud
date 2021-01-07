package com.atguigu.springclou.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder locatorBuilder){
        RouteLocatorBuilder.Builder routes = locatorBuilder.routes();
        routes.route("path_route_atguigu",
                r->r.path("/guonei")
                        .uri("http://news.baidu.com/guonei")).build();
        routes.route("path_route_atguigu2",
                r->r.path("/guoji")
                        .uri("http://news.baidu.com/guoji")).build();
        return routes.build();
    }

}
