package dns.discover.service.repository;

import dns.discover.service.entity.Account;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * User Repository
 */
public interface UserRepository extends PagingAndSortingRepository<Account, Long> {
}