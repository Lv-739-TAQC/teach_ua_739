package org.ssu.edu.teachua.db.repository;

import org.ssu.edu.teachua.db.entities.Entity;

import java.sql.Connection;
import java.util.List;

/**
 * Interface for generic read operations on a repository for a specific type.
 *
 * @author Kapustin Illia
 */
public interface AbstractDAO<E extends Entity> {
    /**
     * Returns all instances of the type.
     *
     * @param con             connection to database
     * @param versionOfSearch version of search when use join relationship
     * @return list of all entities
     * @throws DBException
     * @throws EntityException
     */
    List<E> findAll(Connection con, boolean versionOfSearch) throws DBException, EntityException;

    /**
     * Returns instance of the type after search by id.
     *
     * @param con             connection to database
     * @param id              id instance
     * @param versionOfSearch version of search when use join relationship
     * @return instance after search by id
     * @throws DBException
     * @throws EntityException
     */
    E findElementById(Connection con, Integer id, boolean versionOfSearch) throws DBException, EntityException;

    /**
     * Returns all instances of the type using SQL request for search
     *
     * @param con             connection to database
     * @param SQLRequest      SQL request for search
     * @param versionOfSearch version of search when use join relationship
     * @param parameters      list values for parameters in SQL request
     * @return list of all entities after SQL request
     * @throws DBException
     * @throws EntityException
     */
    List<E> findElementsBySQlRequest(Connection con, String SQLRequest, boolean versionOfSearch, Object... parameters) throws DBException, EntityException;
}
