package ac.za.cput.service;

import ac.za.cput.domain.Party;

import java.util.List;
import java.util.Set;

public interface PartyService extends ServiceInterface<Party, String> {
    List<Party> getAll();
    Party findByName(String party);
}
