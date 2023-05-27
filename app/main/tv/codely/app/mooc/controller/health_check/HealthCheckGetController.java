package tv.codely.app.mooc.controller.health_check;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public final class HealthCheckGetController {

    @RequestMapping("/health-check")
    public Map<String, String> handle() {
        Map<String, String> status = new HashMap<>();
        status.put("status", "ok");

        return status;
    }
}
