package kr.taeu.springrabbitmq;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestMsgController {

    private final StreamBridge streamBridge;

    public TestMsgController(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestBody String message) {
        streamBridge.send("uppercase-out-0", message);
        return "success msg: " + message;
    }
}
