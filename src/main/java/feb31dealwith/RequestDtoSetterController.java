package feb31dealwith;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class RequestDtoSetterController {
    @PostMapping("/request/setter")
    public RequestSetterDTO postRequestSetter(@RequestBody RequestSetterDTO requestSetterDTO) {
        log.info("requestDto = {}",requestSetterDTO.toString());
        return requestSetterDTO;
    }

    @GetMapping(value = "/request/setter")
    public RequestSetterDTO getRequestSetter (RequestSetterDTO requestSetterDTO) {
        log.info("requestDto = {}", requestSetterDTO.toString());
        return requestSetterDTO;
    }
}
