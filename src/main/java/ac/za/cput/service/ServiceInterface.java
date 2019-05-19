package ac.za.cput.service;

public interface ServiceInterface<Obj, Id> {
    Obj create(Obj obj);
    Obj update(Obj obj);
    boolean delete(Id id);
    Obj read (Id id);
}
