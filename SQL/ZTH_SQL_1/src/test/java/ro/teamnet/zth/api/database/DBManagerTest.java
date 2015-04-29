package ro.teamnet.zth.api.database;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Adi on 29.04.2015.
 */
public class DBManagerTest {
    @Test
    public void testDBMangaer() {
        assertNotNull(DBManager.getConnection());
    }
}
