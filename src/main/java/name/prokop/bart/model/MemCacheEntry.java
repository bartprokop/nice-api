package name.prokop.bart.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author proko
 */
public class MemCacheEntry implements Serializable {

    private String key;
    private String value;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.key);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MemCacheEntry other = (MemCacheEntry) obj;
        if (!Objects.equals(this.key, other.key)) {
            return false;
        }
        return true;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
