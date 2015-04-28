package ro.teamnet.zth.api.em;

/**
 * Created by Adi on 28.04.2015.
 */
public enum QueryType {
    ;


    private String columnName;

    private Class columnType;

    private String dbName;

    private boolean isId;

    private Object value;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Class getColumnType() {
        return columnType;
    }

    public void setColumnType(Class columnType) {
        this.columnType = columnType;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public boolean isId() {
        return isId;
    }

    public void setIsId(boolean isId) {
        this.isId = isId;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
