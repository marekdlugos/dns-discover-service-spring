package dns.discover.service.repository;

import dns.discover.service.entity.Participation;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ParticipationRepository extends PagingAndSortingRepository<Participation, Long> {

}
