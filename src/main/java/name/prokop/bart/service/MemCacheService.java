package name.prokop.bart.service;

import name.prokop.bart.model.MemCacheEntry;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 *
 * @author proko
 */
@Service
@CacheConfig(cacheNames = {"mem_srv"})
public class MemCacheService {
    
    @Cacheable
    public MemCacheEntry read(String key) {
        return null;
    }
    
    @CachePut(key = "#entry.key")
    public MemCacheEntry write(MemCacheEntry entry) {
        return entry;
    }
    
}
