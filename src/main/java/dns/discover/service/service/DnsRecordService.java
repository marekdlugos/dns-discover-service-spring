package dns.discover.service.service;

import dns.discover.service.entity.DnsRecord;
import dns.discover.service.repository.DnsRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DnsRecordService {

    @Autowired
    DnsRecordRepository dnsRecordRepository;

    /**
     * Function finds all DNS Records
     * @return  Return all DNS Records in app
     */
    @Transactional
    public Iterable<DnsRecord> getDnsRecords(){
        return dnsRecordRepository.findAll();
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
        return dnsRecordRepository.save(dnsRecord);
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
        dnsRecord.setId(dnsRecordId);
        return dnsRecordRepository.save(dnsRecord);
    }

}
