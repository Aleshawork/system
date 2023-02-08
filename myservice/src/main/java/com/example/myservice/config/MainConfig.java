package com.example.myservice.config;

import com.example.myservice.filter.WebMetricFilter;
import com.example.myservice.monitoring.WebMetricsTagProvider;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.DispatcherType;

@Configuration
public class MainConfig {

    @Bean
    public FilterRegistrationBean<WebMetricFilter> webMetricFilter(MeterRegistry meterRegistry, WebMetricsTagProvider webMetricsTagProvider) {
        WebMetricFilter webMetricFilter = new WebMetricFilter(meterRegistry, webMetricsTagProvider);
        FilterRegistrationBean<WebMetricFilter> registration = new FilterRegistrationBean<>(webMetricFilter);
        registration.setDispatcherTypes(DispatcherType.REQUEST);
        return  registration;
    }

}
