package dns.discover.service.repository;

import dns.discover.service.entity.DnsRecord;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DnsRecordRepository extends PagingAndSortingRepository<DnsRecord, Long> {

}