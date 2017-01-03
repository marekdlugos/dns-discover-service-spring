package cvut.ear.dns.services.impl;

import cvut.ear.dns.models.DnsRecord;
import cvut.ear.dns.models.Project;
import cvut.ear.dns.repository.DnsRecordRepository;
import cvut.ear.dns.repository.PermissionRepository;
import cvut.ear.dns.repository.ProjectRepository;
import cvut.ear.dns.services.DnsRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Kuba on 30-Dec-16.
 */
@Service
@Transactional
public class DnsRecordServiceImpl implements DnsRecordService {

    static Logger LOG = LoggerFactory.getLogger(DnsRecordServiceImpl.class);

    private ProjectRepository projectRepository;
    private DnsRecordRepository dnsRecordRepository;

    @Autowired
    public void setProjectRepository(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Autowired
    public void setDnsRecordRepository(DnsRecordRepository dnsRecordRepository) {
        this.dnsRecordRepository = dnsRecordRepository;
    }

    @Override
    public void addDnsRecord(DnsRecord dnsRecord) {
        LOG.info("Add DnsRecord with zone:" +dnsRecord.getZone());
        dnsRecordRepository.save(dnsRecord);
    }

    @Override
    public DnsRecord getDnsRecord(Long id) {
        LOG.info("Get DnsRecord by id:" +id);
        return dnsRecordRepository.findOne(id);
    }

    @Override
    public void updateDnsRecord(DnsRecord dnsRecord) {
        LOG.info("Update DnsRecord with id:" +dnsRecord.getId());
        DnsRecord updated_dnsrecord = dnsRecordRepository.findOne(dnsRecord.getId());

        updated_dnsrecord.setData(dnsRecord.getData());
        updated_dnsrecord.setExpire(dnsRecord.getExpire());
        updated_dnsrecord.setHost(dnsRecord.getHost());
        updated_dnsrecord.setMinimum(dnsRecord.getMinimum());
        updated_dnsrecord.setMx_priority(dnsRecord.getMx_priority());
        updated_dnsrecord.setProject(dnsRecord.getProject());
        updated_dnsrecord.setRefresh(dnsRecord.getRefresh());
        updated_dnsrecord.setResp_person(dnsRecord.getResp_person());
        updated_dnsrecord.setSerial(dnsRecord.getSerial());
        updated_dnsrecord.setTtl(dnsRecord.getTtl());
        updated_dnsrecord.setType(dnsRecord.getType());
        updated_dnsrecord.setZone(dnsRecord.getZone());

        dnsRecordRepository.save(updated_dnsrecord);
    }

    @Override
    public void deleteDnsRecord(Long id) {
        LOG.info("delete DnsRecord with id:" +id);

        DnsRecord d_dnsrecord = dnsRecordRepository.findOne(id);

        if (d_dnsrecord != null){
            Project updated_project = projectRepository.findOne(getDnsRecord(id).getProject().getId());

            updated_project.getDnsRecords().remove(getDnsRecord(id));

            projectRepository.save(updated_project);
            dnsRecordRepository.delete(d_dnsrecord);
        }
    }

    @Override
    public List<DnsRecord> getDnsRecords() {
        return dnsRecordRepository.findAll();
    }
}
