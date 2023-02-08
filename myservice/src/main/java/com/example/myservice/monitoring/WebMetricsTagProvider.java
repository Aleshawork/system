package com.example.myservice.monitoring;

import io.micrometer.core.instrument.Tag;
import io.micrometer.core.instrument.Tags;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Component
public class WebMetricsTagProvider {

    public final String CONSUMER_HEADER_NAME = "User-Agent";
    public final String UNKNOWN = "UNKNOWN";

    public Iterable<Tag> getApiTags(HttpServletRequest request) {
        return Tags.of(getConsumerTag(request));

    }

    /**
     * Создает тэг с потребителем сервиса
     * @param request
     * @return
     */
    private Tag getConsumerTag(HttpServletRequest request) {
        return Tag.of("api.consumer", Optional.ofNullable(request.getHeader(CONSUMER_HEADER_NAME)).orElse(UNKNOWN));
    }


}
