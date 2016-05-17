package sit.fel.cvut.repository;

import sit.fel.cvut.entity.Project;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {

}