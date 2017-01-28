package name.prokop.bart.config;

import java.util.logging.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * @author proko
 */
@Configuration
@EnableWebMvc
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

    public WebMvcConfiguration() {
        Logger.getLogger(WebMvcConfiguration.class.getName()).severe("HELLO");
    }

}
