package ac.za.cput.factory;

import ac.za.cput.domain.Candidate;
import ac.za.cput.domain.Party;
import ac.za.cput.util.Misc;

public class PartyFactory {
    public static Party getParty(String name)
    {
        return new Party.Builder().partyId(Misc.randomUUID()).name(name).build();
    }
}
