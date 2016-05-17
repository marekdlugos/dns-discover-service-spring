package sit.fel.cvut.repository;

import sit.fel.cvut.entity.DNSRecord;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DNSRecordRepository extends PagingAndSortingRepository<DNSRecord, Long> {

}