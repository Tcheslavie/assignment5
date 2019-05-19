package ac.za.cput.service;

import ac.za.cput.domain.Party;

import java.util.Set;

public interface PartyService extends ServiceInterface<Party, String> {
    Set<Party> getAll();
    Party findByName(String party);
}
