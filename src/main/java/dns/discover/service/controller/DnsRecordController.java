package dns.discover.service.controller;

import dns.discover.service.entity.DnsRecord;
import dns.discover.service.service.DnsRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.*;

public class DnsRecordController {

    @Autowired
    DnsRecordService dnsRecordService;

    @RequestMapping(value = "/dnsrecords")
    public Iterable<DnsRecord> getDnsRecords(){
        return dnsRecordService.getDnsRecords();
    }

    @RequestMapping(value = "/dnsrecords/{dnsRecordId}")
    public DnsRecord getDnsRecord(@PathVariable Long dnsRecordId) {
        return dnsRecordService.getDnsRecord(dnsRecordId);
    }

    @RequestMapping(value = "/dnsrecords", method = POST)
    public DnsRecord createDnsRecord(@RequestBody DnsRecord dnsRecord) {
        return dnsRecordService.createDnsRecord(dnsRecord);
    }

    @RequestMapping(value = "/dnsrecords/{dnsRecordId}", method = DELETE)
    public void deleteDnsRecord(@PathVariable Long dnsRecordId) {
        dnsRecordService.deleteDnsRecord(dnsRecordId);
    }

}
