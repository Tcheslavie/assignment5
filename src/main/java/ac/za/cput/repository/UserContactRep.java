package ac.za.cput.repository;

import ac.za.cput.domain.UserContact;

import java.util.Set;

public interface UserContactRep extends RepInterface<UserContact, String> {
    Set<UserContact> getAll();
}
