package cvut.ear.dns.repository;

import cvut.ear.dns.models.Participation;
import cvut.ear.dns.models.ParticipationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ParticipationRepository extends JpaRepository<Participation, ParticipationId> {
}
