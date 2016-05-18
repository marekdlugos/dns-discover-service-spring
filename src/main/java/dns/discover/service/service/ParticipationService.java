package dns.discover.service.service;

import dns.discover.service.entity.Participation;
import dns.discover.service.repository.ParticipationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParticipationService {

    @Autowired
    ParticipationRepository participationRepository;

}
