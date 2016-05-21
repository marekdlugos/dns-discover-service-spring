package dns.discover.service.repository;

import dns.discover.service.entity.Role;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Role Repository
 */
public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {

}
