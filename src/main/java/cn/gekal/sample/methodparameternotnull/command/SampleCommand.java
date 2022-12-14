package cn.gekal.sample.methodparameternotnull.command;

import cn.gekal.sample.methodparameternotnull.service.SampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SampleCommand implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(SampleCommand.class);

    private final SampleService sampleService;

    public SampleCommand(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @Override
    public void run(String... args) {

        logger.info("test service.[args = {}]", args);

        this.sampleService.test("test");

        // test.param: null は許可されていません。
        this.sampleService.test(null);
    }
}
