package cn.waynechu.springcloud.gateway.filter.auth.type;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author zhuwei
 * @since 2020-03-07 23:28
 */
@Slf4j
public abstract class BaseAuthTypeFilter implements AuthTypeFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        return null;
    }
}
