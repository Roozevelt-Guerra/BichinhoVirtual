package DAO;

import java.util.List;

public interface IDAO <T> {

    boolean inserir (T object);
    T buscar (int id);
    List<T> retornarTodos();
    void remover (int id);
    void atualizar (int id, T object);

}
