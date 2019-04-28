package ac.za.cput.repository;

public interface RepInterface <Obj, Id> {
    Obj create(Obj obj);
    Obj update(Obj obj);
    boolean delete(Id id);
    Obj read (Id id);
}
