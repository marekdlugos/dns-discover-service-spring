package entity;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "dns_records")
public class DNSRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String zone;
    private String host;
    private int ttl;
    private String type;
    private int mx_priority;
    private String data;
    private String resp_person;
    private BigInteger serial;
    private int refresh;
    private int retry;
    private int expire;
    private int minimum;
    private Date created_at;
    private Date updated_at;

    /**
     * DNS Record Constructor
     * @param zone          DNS Zone (e.g. sample.com)
     * @param host          DNS Host (e.g. www or @)
     * @param ttl           TTL  (e.g. 86 400)
     * @param type          DNS Type (e.g. SOA / A / NS / MX)
     * @param mx_priority   mx_priority (e.g. NULL)
     * @param data          data (e.g. ns1.ns.com.)
     * @param resp_person   responsible person
     * @param serial        serial
     * @param refresh       refresh
     * @param retry         retry
     * @param expire        expire
     * @param minimum       minimum (e.g. 86 400)
     * @param created_at    Date and Time when the project was created
     * @param updated_at    Date and Time when the project was updated
     */
    public DNSRecord(String zone, String host, int ttl, String type, int mx_priority, String data, String resp_person, BigInteger serial, int refresh, int retry, int expire, int minimum, Date created_at, Date updated_at) {
        this.zone = zone;
        this.host = host;
        this.ttl = ttl;
        this.type = type;
        this.mx_priority = mx_priority;
        this.data = data;
        this.resp_person = resp_person;
        this.serial = serial;
        this.refresh = refresh;
        this.retry = retry;
        this.expire = expire;
        this.minimum = minimum;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    /**
     * DNS Record Constructor for JPA only
     */
    public DNSRecord() {
    }

    // Getters and Setters
    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getTtl() {
        return ttl;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMx_priority() {
        return mx_priority;
    }

    public void setMx_priority(int mx_priority) {
        this.mx_priority = mx_priority;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getResp_person() {
        return resp_person;
    }

    public void setResp_person(String resp_person) {
        this.resp_person = resp_person;
    }

    public BigInteger getSerial() {
        return serial;
    }

    public void setSerial(BigInteger serial) {
        this.serial = serial;
    }

    public int getRefresh() {
        return refresh;
    }

    public void setRefresh(int refresh) {
        this.refresh = refresh;
    }

    public int getRetry() {
        return retry;
    }

    public void setRetry(int retry) {
        this.retry = retry;
    }

    public int getExpire() {
        return expire;
    }

    public void setExpire(int expire) {
        this.expire = expire;
    }

    public int getMinimum() {
        return minimum;
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
}
