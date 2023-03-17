package org.ssu.edu.teachua.db.repository;

import org.ssu.edu.teachua.db.entities.Entity;
import java.sql.Connection;
import java.util.List;

public interface AbstractDAO<E extends Entity> {

    List<E> findAll(Connection con, boolean versionOfSearch) throws DBException, EntityException;
    E findElementById(Connection con, Integer id, boolean versionOfSearch) throws DBException, EntityException;
    List<E> findElementsBySQlRequest(Connection con, String SQLRequest, boolean versionOfSearch, Object...parameters) throws DBException, EntityException;
    
    Integer countAllElement (Connection con) throws DBException;
    Integer countAllElement (Connection con, String SQLRequest, Object...parameters) throws DBException;
}
