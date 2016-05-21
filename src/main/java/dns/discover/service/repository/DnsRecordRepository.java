package dns.discover.service.repository;

import dns.discover.service.entity.DnsRecord;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * DNS Record Repository
 */
public interface DnsRecordRepository extends PagingAndSortingRepository<DnsRecord, Long> {

}