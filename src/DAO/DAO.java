package DAO;

import java.util.ArrayList;
import java.util.List;

public class DAO<T> implements IDAO<T>{

    private ArrayList<T> database = new ArrayList<>();

    @Override
    public boolean inserir(T object) {
        return database.add(object);
    }

    @Override
    public T buscar(int id) {
        return database.get(id);
    }

    @Override
    public List<T> retornarTodos() {
        return new ArrayList<>(database);
    }

    @Override
    public void remover(int id) {
        database.remove(id);
    }

    @Override
    public void atualizar(int id, T object) {
        database.set(id, object);
    }
}
