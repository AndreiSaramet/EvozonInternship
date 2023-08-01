package com.evozon.repository;

import com.evozon.model.Package;

import java.util.Collection;

public interface Repository {
    void save(final Collection<? extends Package> packages);

    Collection<? extends Package> read();
}
