package name.prokop.bart;

import name.prokop.bart.api.ApiComponentScanMarker;
import name.prokop.bart.config.ConfigComponentScanMarker;
import name.prokop.bart.service.ServiceComponentScanMarker;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * This Java configuration class declares packages to be scanned by Spring
 * annotation configured Context.
 *
 * @author Bart Prokop
 */
@Configuration
@ComponentScan(basePackageClasses = {
    ApiComponentScanMarker.class,
    ConfigComponentScanMarker.class,
    ServiceComponentScanMarker.class
})
public class SpringBootstrap {
}
