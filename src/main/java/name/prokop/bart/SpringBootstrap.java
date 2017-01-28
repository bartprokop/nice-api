package name.prokop.bart;

import name.prokop.bart.api.ApiComponentScanMarker;
import name.prokop.bart.config.ConfigComponentScanMarker;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @author Bart Prokop
 */
@Configuration
@ComponentScan(basePackageClasses = {ApiComponentScanMarker.class, ConfigComponentScanMarker.class})
public class SpringBootstrap {

}