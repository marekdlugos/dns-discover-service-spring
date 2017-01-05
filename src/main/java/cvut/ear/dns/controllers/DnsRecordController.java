package cvut.ear.dns.controllers;

import cvut.ear.dns.models.DnsRecord;
import cvut.ear.dns.services.DnsRecordService;
import cvut.ear.dns.services.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class DnsRecordController {

    private static final Logger DNSlog = LoggerFactory.getLogger(DnsRecordController.class);


    private DnsRecordService dnsRecordService;

    private ProjectService projectService;

    @Autowired
    public void setDnsRecordService(DnsRecordService dnsRecordService) {
        this.dnsRecordService = dnsRecordService;
    }
    @Autowired
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    /**
     * GET all DNS Records
     *
     * @return Return all DNS records
     */
    @RequestMapping(value = "/dnsrecords", method = GET)
    public List<DnsRecord> getDnsRecords(){
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
    @RequestMapping(value = "/dnsrecords/{projectId}", method = POST)
    public DnsRecord createDnsRecord(@RequestBody DnsRecord dnsRecord, @PathVariable Long projectId) {
        DNSlog.debug("POST create a new DNS Record, was called");
        dnsRecordService.addDnsRecord(dnsRecord);
        dnsRecordService.assignProjectToDnsRecord(projectService.getProject(projectId), dnsRecord);
        return dnsRecordService.getDnsRecord(dnsRecord.getId());
    }

    /**
     * Edit specific DNS Record
     *
     * @param dnsRecordId   Identification of Record you want to edit
     * @param dnsRecord     Edited DNS Record
     * @return              Return edited Record
     */
    @RequestMapping(value = "/dnsrecords/{dnsRecordId}/project/{projectId}", method = PUT)
    public DnsRecord editDnsRecord(@PathVariable Long dnsRecordId, @RequestBody DnsRecord dnsRecord, @PathVariable Long projectId) {
        DNSlog.debug("PUT edit DNS Record, was called");
        dnsRecord.setId(dnsRecordId);
        dnsRecordService.updateDnsRecord(dnsRecord);
        dnsRecordService.assignProjectToDnsRecord(projectService.getProject(projectId), dnsRecord);
        return dnsRecordService.getDnsRecord(dnsRecord.getId());
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
