package dns.discover.service.repository;

import dns.discover.service.entity.Account;
import dns.discover.service.entity.Participation;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Account and Project relationship Repository
 */
public interface ParticipationRepository extends PagingAndSortingRepository<Participation, Long> {

}
