package org.ssu.edu.teachua.db.repository;

import org.ssu.edu.teachua.db.entities.Entity;
import java.sql.Connection;
import java.util.List;

public interface AbstractDAO<E extends Entity> {

    public List<E> findAll(Connection con, boolean versionOfSearch) throws DBException, EntityException;
    public E findElementById(Connection con, Integer id, boolean versionOfSearch) throws DBException, EntityException;
    public List<E> findElementsBySQlRequest(Connection con, String SQLRequest, boolean versionOfSearch, Object...parameters) throws DBException, EntityException;
    
    public Integer countAllElement (Connection con) throws DBException;
    public Integer countAllElement (Connection con, String SQLRequest, Object...parameters) throws DBException;
}
