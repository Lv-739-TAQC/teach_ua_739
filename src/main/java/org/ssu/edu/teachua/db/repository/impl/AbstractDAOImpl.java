package org.ssu.edu.teachua.db.repository.impl;


import org.ssu.edu.teachua.db.annotation.*;
import org.ssu.edu.teachua.db.entities.Entity;
import org.ssu.edu.teachua.db.repository.*;

import lombok.Getter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.*;

@Getter
public abstract class AbstractDAOImpl<E extends Entity> implements AbstractDAO<E> {

    Class entityClass;
    String nameDB;
    Map<String, AbstractDAOImpl> entitiesDaoImpl;

    private final String SQL_FIND_ELEMENT_BY_ID;
    private final String SQL_FIND_ALL_ELEMENTS;
    private final String SQL_COUNT_ELEMENT;

    private Connection cn = null;
    PreparedStatement ps = null;
    Statement st = null;
    ResultSet rs = null;

    public AbstractDAOImpl(Class<?> entityClass, Map<String, AbstractDAOImpl> entitiesDaoImpl) {
        this.entityClass = entityClass;
        this.entitiesDaoImpl = entitiesDaoImpl;
        nameDB = entityClass.getAnnotation(TableDB.class).name();

        SQL_FIND_ALL_ELEMENTS = String.format("select * from %s;",nameDB);
        SQL_FIND_ELEMENT_BY_ID = String.format("select * from %s where id = ? limit 1;",nameDB);
        SQL_COUNT_ELEMENT = String.format("select count(*) from %s",nameDB);
    }

    @Override
    public List<E> findElementsBySQlRequest(Connection con, String SQLRequest, boolean versionOfSearch, Object...parameters) throws DBException,EntityException {
        cn = con;
        List<E> allElements = new ArrayList<>();
        try {
            ps = cn.prepareStatement(SQLRequest);
            for (int i = 1; i<=parameters.length;i++){
                ps.setObject(i,parameters[i-1]);
            }
            rs = ps.executeQuery();
            while (!rs.isClosed() && rs.next()) {
                allElements.add(readNextElement(con, rs, versionOfSearch));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            throw new DBException(String.format("Exception while getting data from table %s method findElementsBySQlRequest",nameDB),e);
        } finally {
            close(rs);
            close(ps);
        }
        return allElements;
    }

    @Override
    public E findElementById(Connection con, Integer id, boolean versionOfSearch) throws DBException,EntityException {
        cn = con;
        E element = null;
        try {
            ps = cn.prepareStatement(SQL_FIND_ELEMENT_BY_ID);
            ps.setObject(1, id);
            rs = ps.executeQuery();
            if (!rs.isClosed() &&  rs.next()) {
                element = readNextElement(con, rs,versionOfSearch);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            throw new DBException(String.format("Exception while getting data from table %s method findElementById",nameDB),e);
        } finally {
            close(rs);
            close(ps);
        }
        return element;
    }

    @Override
    public List<E> findAll(Connection con, boolean versionOfSearch) throws DBException,EntityException{
        cn = con;
        List<E> allElemetns = new ArrayList<>();
        try {
            st = cn.createStatement();
            rs = st.executeQuery(SQL_FIND_ALL_ELEMENTS);
            while (!rs.isClosed() && rs.next()) {
                allElemetns.add(readNextElement(con, rs, versionOfSearch));
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            throw new DBException(String.format("Exception while getting data from table %s method findAll",nameDB),e);
        } finally {
            close(rs);
            close(st);
        }
        return allElemetns;
    }

    @Override
    public Integer countAllElement(Connection con) throws DBException{
        Integer count = 0;
        cn = con;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(SQL_COUNT_ELEMENT);
            if (!rs.isClosed() && rs.next()){
                count = rs.getInt(1);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            throw new DBException(String.format("Exception while count data from table %s method countAllElement",nameDB),e);
        } finally {
            close(rs);
            close(ps);
        }
        return count;
    }
    
    @Override
    public Integer countAllElement(Connection con, String SQLRequest, Object[] parameters) throws DBException{
        Integer count = 0;
        cn = con;
        try {
            ps = cn.prepareStatement(SQLRequest);
            for (int i = 1; i<=parameters.length;i++){
                ps.setObject(i,parameters[i-1]);
            }
            rs = ps.executeQuery();
            if (!rs.isClosed() && rs.next()){
                count = rs.getInt(1);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            throw new DBException(String.format("Exception while count data from table %s method countAllElement with parametrs",nameDB),e);
        } finally {
            close(rs);
            close(ps);
        }
        return count;
    }

    private E readNextElement(Connection con, ResultSet resultSet, boolean versionOfSearch) throws DBException,EntityException{
        E element = null;
        try {
            Constructor<E> cons = entityClass.getConstructor();
            element = (E) cons.newInstance();

            element.setId(resultSet.getInt("id"));
            for (Field field : entityClass.getDeclaredFields()){
                if (field.getAnnotation(Column.class) != null){
                    String nameColumnDB = field.getAnnotation(Column.class).name();

                    field.setAccessible(true);
                    field.set(element, resultSet.getObject(nameColumnDB,field.getType()));
                    continue;
                }
                if (field.getAnnotation(ManyToOne.class) != null && versionOfSearch){
                    String foreignColumnDB = field.getAnnotation(ManyToOne.class).foreignColumnDB();
                    Integer foriegnID = resultSet.getInt(foreignColumnDB);

                    AbstractDAOImpl foreignEntityDAOImpl = entitiesDaoImpl.get(field.getAnnotation(ManyToOne.class).foreignTable());

                    Object foreignElement = foreignEntityDAOImpl.findElementById(con, foriegnID,false);

                    field.setAccessible(true);
                    field.set(element, foreignElement);
                    continue;
                }
                if (field.getAnnotation(OneToMany.class) != null && versionOfSearch){
                    String foreignColumnDB = field.getAnnotation(OneToMany.class).mainColumnDB();
                    Integer elementId = element.getId();

                    AbstractDAOImpl foreignEntityDAOImpl = entitiesDaoImpl.get(field.getAnnotation(OneToMany.class).foreignTable());

                    Set<Object> setForeignElements = foreignEntityDAOImpl.FindAllForOneToMany(con, elementId, foreignColumnDB,false);

                    field.setAccessible(true);
                    field.set(element, setForeignElements);
                    continue;
                }
                if (field.getAnnotation(ManyToMany.class) != null && versionOfSearch){
                    Integer elementId = (Integer) element.getId();

                    String tableForManyToMany = field.getAnnotation(ManyToMany.class).tableForManyToMany();
                    String mainColumnDB = field.getAnnotation(ManyToMany.class).mainColumnDB();
                    String foreignColumnDB = field.getAnnotation(ManyToMany.class).foreignColumnDB();

                    AbstractDAOImpl foreignEntityDAOImpl = entitiesDaoImpl.get(field.getAnnotation(ManyToMany.class).foreignTable());

                    Set<Integer> idForeignElements = FindAllForManyToMany(con, elementId,tableForManyToMany,mainColumnDB,foreignColumnDB);
                    Set<Object> setForeignElements = new HashSet<>();
                    for(Integer idForeignElement : idForeignElements){
                        setForeignElements.add(foreignEntityDAOImpl.findElementById(con, idForeignElement,false));
                    }

                    field.setAccessible(true);
                    field.set(element, setForeignElements);
                    continue;
                }
            }
        } catch (InstantiationException /*cons.newInstance();*/
                | IllegalAccessException /*cons.newInstance();*/
                | InvocationTargetException /*cons.newInstance();*/
                | NoSuchMethodException /*entityClass.getConstructor();*/ e ) {
            throw new EntityException(String.format("Exception with work %s entity", entityClass.getName()),e);
        } catch (SQLException e){
            throw new DBException(String.format("Exception while getting data from table %s method readNextElement",nameDB),e);
        }
        return element;
    }

    private Set<E> FindAllForOneToMany(Connection con, Integer elementId, String foreignColumnDB, boolean versionOfSearch) throws DBException, EntityException{
        Set<E> setForeignElements = new HashSet<>();
        final String FIND_ALL_BY_FOREIGN_ID = String.format("select * from %s where %s = ?;",nameDB,foreignColumnDB);
        Connection innerCn = null;
        PreparedStatement innerPs = null;
        ResultSet resSet = null;
        try {
            innerCn = con;
            innerPs = innerCn.prepareStatement(FIND_ALL_BY_FOREIGN_ID);
            innerPs.setInt(1,elementId);
            resSet = innerPs.executeQuery();
            while (!resSet.isClosed() && resSet.next()) {
                setForeignElements.add(readNextElement(con, resSet,versionOfSearch));
            }
            resSet.close();
            innerPs.close();
        } catch (SQLException e) {
            throw new DBException(String.format("Exception while getting data from table %s method FindAllForOneToMany",nameDB),e);
        } finally {
            close(resSet);
            close(innerPs);
        }

        return setForeignElements;
    }

    private Set<Integer> FindAllForManyToMany(Connection con, Integer elementId, String tableForManyToMany, String mainColumnDB, String foreignColumnDB) throws DBException{
        Set<Integer> idForeignElements = new HashSet<>();
        final String FIND_ALL_IN_MToM_BY_FOREIGN_ID = String.format("select %s from %s where %s = ?;",foreignColumnDB,tableForManyToMany,mainColumnDB);
        Connection innerCn = null;
        PreparedStatement innerPs = null;
        ResultSet resSet = null;
        try {
            innerCn = con;
            innerPs = innerCn.prepareStatement(FIND_ALL_IN_MToM_BY_FOREIGN_ID);
            innerPs.setInt(1,elementId);
            resSet = innerPs.executeQuery();
            while (!resSet.isClosed() && resSet.next()){
                idForeignElements.add(resSet.getInt(foreignColumnDB));
            }
            resSet.close();
            innerPs.close();
       } catch (SQLException e) {
            throw new DBException(String.format("Exception while getting data from table %s method FindAllForManyToMany",nameDB),e);
       } finally {
            close(resSet);
            close(innerPs);
        }
        return idForeignElements;
    }

    private void close(PreparedStatement ps) throws DBException{
        if (ps != null){
            try {
                ps.close();
            } catch (SQLException e) {
                throw new DBException(String.format("Exception while close preparedStatement with table %s",nameDB),e);
            }
        }
    }
    private void close(Statement st) throws DBException{
        if (st != null){
            try {
                st.close();
            } catch (SQLException e) {
                throw new DBException(String.format("Exception while close statement with table %s",nameDB),e);
            }
        }
    }
    private void close(ResultSet rs) throws DBException{
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                throw new DBException(String.format("Exception while close resultSet with table %s",nameDB),e);
            }
        }
    }
}
