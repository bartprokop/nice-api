package name.prokop.bart.api;

import name.prokop.bart.model.MemCacheEntry;
import name.prokop.bart.service.MemCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author proko
 */
@RestController
@RequestMapping("/memcache")
public class MemCacheController {

    @Autowired
    private MemCacheService memCacheService;
    
    @RequestMapping(method = RequestMethod.GET)
    public MemCacheEntry get(String key) {
        return memCacheService.read(key);
    }
    @RequestMapping(method = RequestMethod.POST)
    public MemCacheEntry post(MemCacheEntry entry) {
        return memCacheService.write(entry);
    }
}
