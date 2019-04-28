package ac.za.cput.repository;

import ac.za.cput.domain.Party;

import java.util.Set;

public interface PartyRepository extends RepInterface<Party, String> {
    Set<Party> getAll();
    Party findByName(String party);
}
