package servlets;

import java.util.List;

public interface LabCRUDInterface<T> {
    public void create(T t);
    public List<T> read();
    public void  update(int id, T t);
    public void delete(int id);
}
