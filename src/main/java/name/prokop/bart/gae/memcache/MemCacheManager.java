package name.prokop.bart.gae.memcache;

import com.google.appengine.api.memcache.MemcacheService;
import com.google.appengine.api.memcache.MemcacheServiceFactory;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Logger;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.util.Assert;

/**
 *
 * @author Bart Prokop
 */
public class MemCacheManager implements CacheManager {

    private static final Logger LOGGER = Logger.getLogger(CacheManager.class.getName());
    private final ConcurrentMap<String, Cache> caches = new ConcurrentHashMap<>(16);

    @Override
    public Cache getCache(final String name) {
        Assert.notNull(name, "Cache name must not be null");
        if (caches.containsKey(name)) {
            return caches.get(name);
        }

        final Cache newCache = createNewCache(name);
        final Cache prevValue = caches.putIfAbsent(name, newCache);
        return prevValue != null ? prevValue : newCache;
    }

    @Override
    public Collection<String> getCacheNames() {
        return caches.keySet();
    }

    private Cache createNewCache(final String name) {
        MemcacheService memcacheService = MemcacheServiceFactory.getMemcacheService(name);
        return new MemCache(memcacheService);
    }

}
