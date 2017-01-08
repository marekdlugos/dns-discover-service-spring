package cvut.ear.dns.models;

import java.util.List;

/**
 * Created by Kuba on 08-Jan-17.
 */
public class ParticipationWrapper {

    private List<Participation> participations;

    public ParticipationWrapper(List<Participation> participations) {
        this.participations = participations;
    }

    public ParticipationWrapper() {
    }

    public List<Participation> getParticipations() {
        return participations;
    }

    public void setParticipations(List<Participation> participations) {
        this.participations = participations;
    }
}
