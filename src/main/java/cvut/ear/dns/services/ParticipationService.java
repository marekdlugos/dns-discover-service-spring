package cvut.ear.dns.services;

import cvut.ear.dns.models.Participation;
import cvut.ear.dns.models.ParticipationId;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ParticipationService {
    void addParticipation(Participation participation);
    Participation getParticiparion(ParticipationId particId);
    void updateParticiparion(Participation participarion);
    void deleteParticiparion(ParticipationId particId);
    List<Participation> getParticiparions();
}
