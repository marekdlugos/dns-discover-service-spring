package cvut.ear.dns.services;

import cvut.ear.dns.models.DnsRecord;
import cvut.ear.dns.models.Project;

import java.util.List;

/**
 * Created by Kuba on 30-Dec-16.
 */
public interface DnsRecordService {

    void addDnsRecord(DnsRecord dnsRecord);
    DnsRecord getDnsRecord(Long id);
    void updateDnsRecord(DnsRecord dnsRecord);
    void deleteDnsRecord(Long id);
    List<DnsRecord> getDnsRecords();
    void assignProjectToDnsRecord(Project project, DnsRecord dnsRecord);
}
