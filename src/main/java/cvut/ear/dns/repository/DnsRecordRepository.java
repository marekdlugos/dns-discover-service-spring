package cvut.ear.dns.repository;

import cvut.ear.dns.models.DnsRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Jakub on 30.12.2016.
 */
@Repository
public interface DnsRecordRepository extends JpaRepository<DnsRecord, Long> {
}
