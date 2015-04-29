package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.database.DBManager;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adi on 29.04.2015.
 */
public class EntityManagerImpl {

    @Override
    public <T> T findById(Class<EntityUtils> entityClass, int id) {
        Connection con = null;
        con = DBManager.getConnection();
        String nameTable = EntityUtils.getTableName(entityClass);
        ArrayList<ColumnInfo> nameColumns = EntityUtils.getColumns(entityClass);
        for(ColumnInfo i: nameColumns) {
            i.setValue(entityClass);
        }
        Condition c = new Condition();
        c.setValue(id);
        QueryBuilder qb = new QueryBuilder();
        qb.setTableName()

    }

    @Override
    public <T> List<T> findAll(Class<T> entityClass){
        return null;
    }

    @Override
    public <T> Object insert(T entity) {
        return null;
    }

    @Override
    public <T> Object insert(T entity) {
        return null;
    }

    @Override
    public <T> T update(T entity){
        return null;
    }

    @Override
    public void delete(Object entity) {
        return null;
    }

}
