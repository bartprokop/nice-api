package name.prokop.bart.gae.memcache;

import com.google.appengine.api.memcache.MemcacheService;
import java.util.concurrent.Callable;
import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.util.Assert;

/**
 *
 * @author proko
 */
public class MemCache implements Cache {

    private final MemcacheService memcacheService;

    MemCache(MemcacheService memcacheService) {
        this.memcacheService = memcacheService;
    }

    @Override
    public String getName() {
        return memcacheService.getNamespace();
    }

    @Override
    public Object getNativeCache() {
        return memcacheService;
    }

    @Override
    public ValueWrapper get(Object key) {
        Assert.notNull(key);
        Object val = memcacheService.get(key);
        if (val == null) {
            return null;
        }
        if (val == NullValue.INSTANCE) {
            val = null;
        }
        return new SimpleValueWrapper(val);
    }

    @Override
    public <T> T get(Object key, Class<T> type) {
        Assert.notNull(key);
        Object val = memcacheService.get(key);
        if (val == null || val == NullValue.INSTANCE) {
            return null;
        }
        return (T) val;
    }

    @Override
    public <T> T get(Object key, Callable<T> valueLoader) {
        Assert.notNull(key);
        Object val = memcacheService.get(key);
        if (val == null) {
            try {
                if (val == null) {
                    val = valueLoader.call();
                    put(key, val);
                }
            } catch (Exception e) {
                throw new ValueRetrievalException(key, valueLoader, e);
            }
        }

        if (val == NullValue.INSTANCE) {
            val = null;
        }
        return (T) val;
    }

    @Override
    public void put(Object key, Object value) {
        Assert.notNull(key);
        if (value == null) {
            value = NullValue.INSTANCE;
        }
        memcacheService.put(key, value);
    }

    @Override
    public ValueWrapper putIfAbsent(Object key, Object value) {
        Assert.notNull(key);
        if (value == null) {
            value = NullValue.INSTANCE;
        }
        boolean added = memcacheService.put(key, value, null, MemcacheService.SetPolicy.ADD_ONLY_IF_NOT_PRESENT);
        return added ? null : get(key);
    }

    @Override
    public void evict(Object key) {
        Assert.notNull(key);
        memcacheService.delete(key);
    }

    @Override
    public void clear() {
        // memcacheService.clearAll(); // Empties the cache of all values across all namespaces.
    }

}
