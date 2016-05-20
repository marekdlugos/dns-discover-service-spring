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

    @Transactional
    public Iterable<DnsRecord> getDnsRecords(){
        return dnsRecordRepository.findAll();
    }

    @Transactional
    public DnsRecord getDnsRecord(Long dnsRecordId){
        return dnsRecordRepository.findOne(dnsRecordId);
    }

    @Transactional
    public void deleteDnsRecord(Long dnsRecordId){
        dnsRecordRepository.delete(dnsRecordId);
    }

    @Transactional
    public DnsRecord createDnsRecord(DnsRecord dnsRecordId){
        return dnsRecordRepository.save(dnsRecordId);
    }

    @Transactional
    public DnsRecord editDnsRecord(Long dnsRecordId, DnsRecord dnsRecord){
        dnsRecord.setId(dnsRecordId);
        return dnsRecordRepository.save(dnsRecord);
    }

}
