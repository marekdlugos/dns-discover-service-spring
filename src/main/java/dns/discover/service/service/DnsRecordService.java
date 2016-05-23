package dns.discover.service.service;

import dns.discover.service.entity.DnsRecord;
import dns.discover.service.entity.Project;
import dns.discover.service.repository.DnsRecordRepository;
import dns.discover.service.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestPart;

import java.util.Arrays;

@Component
public class DnsRecordService {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    DnsRecordRepository dnsRecordRepository;

    /**
     * Function finds all DNS Records
     * @return  Return all DNS Records in app
     */
    @Transactional
    public Iterable<DnsRecord> getDnsRecords(){
        return dnsRecordRepository.findAll();

        // TODO: Plus return name of the project
    }

    /**
     * Function finds one, specific DNS Record based on identification value
     *
     * @param dnsRecordId   Identification of specific DNS Record you want to get
     * @return              Return specific DNS Record
     */
    @Transactional
    public DnsRecord getDnsRecord(Long dnsRecordId){
        return dnsRecordRepository.findOne(dnsRecordId);
    }

    /**
     * Function deletes specific DNS Record
     *
     * @param dnsRecordId   Identification of specific DNS Record you want to delete
     */
    @Transactional
    public void deleteDnsRecord(Long dnsRecordId){
        dnsRecordRepository.delete(dnsRecordId);
    }

    /**
     * Function creates a new DNS Record based on the object received
     *
     * @param dnsRecord A new DNS Record
     * @return          Created DNS Record
     */
    @Transactional
    public DnsRecord createDnsRecord(DnsRecord dnsRecord){

        // TODO: projectRepository save relationship to project

        return dnsRecordRepository.save(dnsRecord);
//        Project project = projectRepository.findOne(dnsRecord.project);
//        dnsRecord.setProject(project);
//        project.setDnsRecords(Arrays.asList(dnsRecord));

    }

    /**
     * Function allows to edit specific DNS Record
     *
     * @param dnsRecordId   Identification of DNS Record
     * @param dnsRecord     Edited DNS Record
     * @return              Return edited DNS Record
     */
    @Transactional
    public DnsRecord editDnsRecord(Long dnsRecordId, DnsRecord dnsRecord){

        // TODO: projectRepository update relationship on project
        dnsRecord.setId(dnsRecordId);
        return dnsRecordRepository.save(dnsRecord);

//        Project project = projectRepository.findOne(dnsRecord.project);
//        dnsRecord.setProject(project);
//        project.setDnsRecords(Arrays.asList(dnsRecord));
    }

}
