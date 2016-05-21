package dns.discover.service.repository;

import dns.discover.service.entity.Participation;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Account and Project relationship Repository
 */
public interface ParticipationRepository extends PagingAndSortingRepository<Participation, Long> {

}
