package za.ac.cput.dogparlor.service;

public interface IService<T, ID> {

    T create(T t);
    T read(ID id);
    static T update(T t);
    static boolean delete(ID id);

}
