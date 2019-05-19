package ac.za.cput.service;

import ac.za.cput.domain.UserContact;

import java.util.Set;

public interface UserContactService extends ServiceInterface<UserContact, String> {
    Set<UserContact> getAll();
}
