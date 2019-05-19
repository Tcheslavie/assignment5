package ac.za.cput.repository.impl;

import ac.za.cput.domain.Party;
import ac.za.cput.domain.User;
import ac.za.cput.repository.PartyRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("PartyRep")
public class PartyRepImpl implements PartyRepository {
    private Set<Party> parties;
    private static PartyRepImpl repository = null;
    private PartyRepImpl()
    {
        parties = new HashSet<>();
    }

    public static PartyRepository getRepository()
    {
        if(repository==null) repository = new PartyRepImpl();
        return repository;
    }

    private Party findParty(String id)
    {
        for (Party parties : this.parties) {
            if (parties.getPartyId().equals(id)) {
                return parties;
            }
        }
        return null;
    }
    private Party updateParty(Party obj)
    {
        String id = obj.getPartyId();
        if(deleteParty(id))
        {
            this.parties.add(obj);
            return findParty(id);
        }
        return null;
    }

    private boolean deleteParty(String id)
    {
        for(Party party : (this).parties)
        {
            if(party.getPartyId().equals(id))
            {
                this.parties.remove(party);
                return true;
            }
        }
        return false;
    }

    @Override
    public Set<Party> getAll() {
        return this.parties;
    }

    @Override
    public Party create(Party party) {
        this.parties.add(party);
        return party;
    }

    @Override
    public Party update(Party party) {
        return updateParty(party);
    }

    @Override
    public boolean delete(String id) {
        return deleteParty(id);
    }

    @Override
    public Party read(String id) {
        return findParty(id);
    }

}
