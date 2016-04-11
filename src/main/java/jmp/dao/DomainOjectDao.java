package jmp.dao;

import java.util.Collection;

public interface DomainOjectDao<T> {

        T save(T object);

        void remove(T object);

        Collection<T> getAll();
}
