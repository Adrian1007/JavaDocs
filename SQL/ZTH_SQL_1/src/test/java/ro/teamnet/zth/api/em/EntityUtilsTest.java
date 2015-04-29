package ro.teamnet.zth.api.em;

import org.junit.Assert;
import org.junit.Test;
import ro.teamnet.zth.appl.domain.Departament;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Adi on 28.04.2015.
 */
public class EntityUtilsTest {

    @Test
    public void testGetTableNameMethod() {
        Departament department = new Departament();
        String tableName = EntityUtils.getTableName(Departament.class);
        assertEquals("Table name should be departments", "departments", tableName);
    }
}
