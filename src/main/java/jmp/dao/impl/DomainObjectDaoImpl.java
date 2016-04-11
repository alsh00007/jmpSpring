package jmp.dao.impl;

import jmp.dao.DomainOjectDao;

import java.util.Collection;
import java.util.Set;

public class DomainObjectDaoImpl<T> implements DomainOjectDao<T> {

    private Set<T> storage;

    public DomainObjectDaoImpl(Set<T> storage) {
        this.storage = storage;
    }

    @Override
    public T save(T object) {
        storage.add(object);
        return object;
    }

    @Override
    public void remove(T object) {
        storage.remove(object);
    }

    @Override
    public Collection<T> getAll() {
        return storage;
    }
}
