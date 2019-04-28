package ac.za.cput.factory;

import ac.za.cput.domain.Candidate;
import ac.za.cput.domain.Party;

public class PartyFactory {
    public static Party getParty(String partyId, String name, Candidate...candidates)
    {
        return new Party.Builder().partyId(partyId).name(name).candidates(candidates).build();
    }
}
