package com.example.myservice.filter;

import com.example.myservice.monitoring.WebMetricsTagProvider;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Фильтр для мониторинга HTTP запросов
 */
public class WebMetricFilter extends OncePerRequestFilter {

    private final MeterRegistry meterRegistry;
    private final WebMetricsTagProvider tagProvider;

    public WebMetricFilter(MeterRegistry meterRegistry, WebMetricsTagProvider tagProvider) {
        this.meterRegistry = meterRegistry;
        this.tagProvider = tagProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            recordCounter(request, response);
            filterChain.doFilter(request, response);
        } catch (ServletException | IOException ex) {
            recordCounter(request, response);
            throw ex;
        }

    }

    public void recordCounter(HttpServletRequest request, HttpServletResponse response) {
        Counter.builder("myservice.api.http.request").tags(tagProvider.getApiTags(request))
                .register(meterRegistry)
                .increment();
    }
}
