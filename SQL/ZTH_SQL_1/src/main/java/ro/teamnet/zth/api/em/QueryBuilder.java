package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.annotations.Column;

import java.util.List;

/**
 * Created by Adi on 29.04.2015.
 */
public class QueryBuilder {
    private Object tableName;
    private List<ColumnInfo> queryColumns;
    private QueryType queryType;
    private List<Condition> conditions;

    public QueryBuilder addCondition(Condition condition) {
        conditions.add(condition);
        return this;
    }

    public QueryBuilder setTableName(Object tableName) {
        this.tableName = tableName;
        return this;
    }

    public  QueryBuilder addQueryColumns(List<ColumnInfo> queryColumns) {
        this.queryColumns = queryColumns;
        return this;
    }

    public QueryBuilder setQueryType(QueryType queryType) {
        this.queryType = queryType;
        return this;
    }

    private String createSelectQuery() {
        StringBuilder select = new StringBuilder();
        select.append("SELECT ");
        for (ColumnInfo c : queryColumns) {
            select.append(c);
            select.append(",");
        }
        select.append("FROM " + tableName + " ");
        select.append("WHERE ");
        for (Condition i : conditions) {
            select.append(i.getColumnName() + "=" + i.getValue() + " AND ");
        }
        int val = select.indexOf("AND");
        select = select.replace(val,val + 3, "");
        return select.toString();
    }


    public String createDeleteQuery() {
        StringBuilder delete = new StringBuilder();
        delete.append("DELETE FROM " + tableName + " " + "WHERE");
        boolean bool = true;
        for(ColumnInfo i:queryColumns) {
            if(bool = false){
                delete.append(" AND ");
            }
            delete.append(i.getColumnName() + "=" + i.getValue());
            bool = false;
        }
        return delete.toString();
    }

    public String createUpdateQuery() {
        StringBuilder update = new StringBuilder();
        update.append("UPDATE " + tableName + " SET ");
        for(ColumnInfo i:queryColumns) {
            update.append(i.getColumnName() + "=" + i.getValue());
        }
        update.append(" WHERE ");
        for(Condition i:conditions) {
            update.append(i + " AND ");
        }
        int val = update.indexOf("AND");
        update = update.replace(val, val + 3, "");
        return update.toString();
    }

    public String createInsertQuery() {
        StringBuilder insert = new StringBuilder();
        insert.append("INSERT INTO " + tableName + "(");
        for(ColumnInfo i:queryColumns) {
            insert.append(i.getColumnName() + ",");
        }
        int val = insert.lastIndexOf(",");
        insert = insert.replace(val, val + 1, "");
        //insert = insert.replace(insert.lastIndexOf(","), insert.lastIndexOf(",") + 1, "");
        insert.append(") " + "VALUES (");
        for(ColumnInfo i:queryColumns) {
            insert.append(i.getValue() + ",");
        }
        val = insert.lastIndexOf(",");
        insert = insert.replace(val, val + 1, "");
        return insert.toString();
    }

    public String createQuery() {
        String s = null;
        if(QueryType.SELECT == queryType) {
            s = createSelectQuery();
        }

        if(QueryType.DELETE == queryType) {
            s = createDeleteQuery();
        }
        if(queryType.INSERT == queryType) {
            s = createInsertQuery();
        }
        if(queryType.UPDATE == queryType) {
            s = createUpdateQuery();
        }
        return s;
    }
}
