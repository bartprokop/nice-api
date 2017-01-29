package name.prokop.bart.api;

import name.prokop.bart.model.PingResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Bart Prokop
 */
@RestController
@RequestMapping("/ping")
public class HelloWorld {

    @RequestMapping(method = RequestMethod.GET)
    public PingResponse get() {
        return new PingResponse();
    }
}
