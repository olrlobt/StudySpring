package olrlobt.springcloudgateway.config;

import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.context.annotation.Bean;

@Bean
public DiscoveryClientRouteDefinitionLocator discoveryClientRouteDefinitionLocator(
	ReactiveDiscoveryClient discoveryClient, DiscoveryLocatorProperties properties) {
	return new DiscoveryClientRouteDefinitionLocator(discoveryClient, properties) {
		@Override
		protected Mono<RouteDefinition> convertToRouteDefinition(ServiceInstance instance) {
			// 여기서 인스턴스의 버전을 확인하고, 가장 높은 버전의 인스턴스 정보를 기반으로 라우트를 생성
			// 버전 비교 로직 추가 필요
		}
	};
}








