package name.prokop.bart.model;

/**
 *
 * @author BPP
 */
public class PingResponse {
    private long id = 100L;
    private String sourceIpAddress = "127.0.0.1";
    private String reverseDomainLookup = "localhost";

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSourceIpAddress() {
        return sourceIpAddress;
    }

    public void setSourceIpAddress(String sourceIpAddress) {
        this.sourceIpAddress = sourceIpAddress;
    }

    public String getReverseDomainLookup() {
        return reverseDomainLookup;
    }

    public void setReverseDomainLookup(String reverseDomainLookup) {
        this.reverseDomainLookup = reverseDomainLookup;
    }
    
    
}
