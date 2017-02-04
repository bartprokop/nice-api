/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package name.prokop.bart.config;

import name.prokop.bart.gae.memcache.MemCacheManager;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author proko
 */
@Configuration
@EnableCaching
public class MemCacheConfiguration {
    
    @Bean
    public CacheManager cacheManager() {
        return new MemCacheManager();
    }
}
