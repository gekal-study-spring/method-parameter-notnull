package cn.gekal.sample.methodparameternotnull.service;

import jakarta.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class SampleService {

    private final Logger logger = LoggerFactory.getLogger(SampleService.class);

    public void test(@NotNull String param) {

        logger.info("test service.[param = {}]", param);
    }
}
