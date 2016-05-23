package dns.discover.service.controller;

import dns.discover.service.entity.DnsRecord;
import dns.discover.service.service.DnsRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class DnsRecordController {

    private static final Logger DNSlog = LoggerFactory.getLogger(DnsRecordController.class);

    @Autowired
    DnsRecordService dnsRecordService;

    /**
     * GET all DNS Records
     *
     * @return Return all DNS records
     */
    @RequestMapping(value = "/dnsrecords", method = GET)
    public Iterable<DnsRecord> getDnsRecords(){
        DNSlog.debug("GET DNS Records, was called");
        return dnsRecordService.getDnsRecords();
    }

    /**
     * GET a specific DNS Record
     *
     * @param dnsRecordId   Identification of DNS Record
     * @return              Return specific DNS Record
     */
    @RequestMapping(value = "/dnsrecords/{dnsRecordId}", method = GET)
    public DnsRecord getDnsRecord(@PathVariable Long dnsRecordId) {
        DNSlog.debug("GET a specific DNS Record, was called");
        return dnsRecordService.getDnsRecord(dnsRecordId);
    }


    /**
     * Create the new DNS Record
     *
     * @param dnsRecord DNS Record you want to create
     * @return          Return created DNS Record
     */
    @RequestMapping(value = "/dnsrecords", method = POST)
    public DnsRecord createDnsRecord(@RequestBody DnsRecord dnsRecord) {
        DNSlog.debug("POST create a new DNS Record, was called");
        return dnsRecordService.createDnsRecord(dnsRecord);
    }

    /**
     * Edit specific DNS Record
     *
     * @param dnsRecordId   Identification of Record you want to edit
     * @param dnsRecord     Edited DNS Record
     * @return              Return edited Record
     */
    @RequestMapping(value = "/dnsrecords/{dnsRecordId}", method = PUT)
    public DnsRecord editDnsRecord(@PathVariable Long dnsRecordId, @RequestBody DnsRecord dnsRecord) {
        DNSlog.debug("PUT edit DNS Record, was called");
        return dnsRecordService.editDnsRecord(dnsRecordId, dnsRecord);
    }

    /**
     * Delete specific DNS Record
     *
     * @param dnsRecordId Identification of Record you want to delete
     */
    @RequestMapping(value = "/dnsrecords/{dnsRecordId}", method = DELETE)
    public void deleteDnsRecord(@PathVariable Long dnsRecordId) {
        DNSlog.debug("DELETE DNS Record, was called");
        dnsRecordService.deleteDnsRecord(dnsRecordId);
    }

}
