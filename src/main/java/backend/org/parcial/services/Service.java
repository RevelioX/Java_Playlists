package backend.org.parcial.services;

import java.util.List;

public interface Service <T,ID>{

    public void add(T entity);
    public T getById(ID id);

    public List<T> getAll();

    public boolean update(T entity);

    public T delete (ID id);

}
