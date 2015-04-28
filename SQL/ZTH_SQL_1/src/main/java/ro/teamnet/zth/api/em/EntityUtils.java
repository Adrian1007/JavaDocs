package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Table;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by Adi on 28.04.2015.
 */
public class EntityUtils {
    private EntityUtils() {
        throw new UnsupportedOperationException();
    }

    public static String getTableName(Class entity) {
        return ((Table) entity.getAnnotation(Table.class)).name();
    }

    public static ArrayList<ColumnInfo> getColumns(Class entity) {
        ArrayList<ColumnInfo> ColumnInfos = new ArrayList<>();
        Field[] fields = entity.getDeclaredFields();
        for (Field f : fields) {
            Column c = f.getAnnotation(Column.class);
            if (c != null) {
                ColumnInfo coloana = new ColumnInfo();
                coloana.setColumnName(f.getName());
                coloana.setColumnType((f.getType()));
                coloana.setDbName(c.name());
                ColumnInfos.add(coloana);
            }
        }
        return ColumnInfos;
    }

    public static Object castFromSqlType (Object value, Class<?>wantedType) {
        if((value instanceof BigDecimal) && (wantedType == Integer.class)) {
            BigDecimal b = (BigDecimal)value;
            return  b.intValue();
        }
        return value;
    }

    public static ArrayList<Field> getFieldByAnnotations(Class clazz, Class annotations) {
        ArrayList<Field> coloane = new ArrayList<>();
        Field[] fields = clazz.getDeclaredFields();
        for(Field f: fields) {
            if (f.getAnnotation(annotations) != null) {
                coloane.add(f);
            }
        }
        return coloane;

    }
    public static Object getSqlValue(Object object) {
        return object;
    }
}
