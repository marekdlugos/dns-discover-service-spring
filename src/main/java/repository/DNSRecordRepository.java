package repository;

import entity.DNSRecord;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DNSRecordRepository extends PagingAndSortingRepository<DNSRecord, Long> {

}