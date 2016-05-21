package dns.discover.service.controller;

import dns.discover.service.entity.DnsRecord;
import dns.discover.service.service.DnsRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class DnsRecordController {

    @Autowired
    DnsRecordService dnsRecordService;

    /**
     * GET all DNS Records
     *
     * @return Return all DNS records
     */
    @RequestMapping(value = "/dnsrecords", method = GET)
    public Iterable<DnsRecord> getDnsRecords(){
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
        return dnsRecordService.editDnsRecord(dnsRecordId, dnsRecord);
    }

    /**
     * Delete specific DNS Record
     *
     * @param dnsRecordId Identification of Record you want to delete
     */
    @RequestMapping(value = "/dnsrecords/{dnsRecordId}", method = DELETE)
    public void deleteDnsRecord(@PathVariable Long dnsRecordId) {
        dnsRecordService.deleteDnsRecord(dnsRecordId);
    }

}
