package com.flysky.study.dbunit.mapper;

import org.dbunit.DBTestCase;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.FileOutputStream;
import java.io.IOException;

@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest
public class DBUnit extends DBTestCase {

    @Test
    public void testPartialExport() throws DataSetException, IOException {
        QueryDataSet queryDataSet = new QueryDataSet(databaseConnection);
        queryDataSet.addTable("system_log", "select * from system_log");
        FlatXmlDataSet.write(queryDataSet, new FileOutputStream("system_log.xml"));
    }

    @Resource
    DataSource dataSource;
    IDatabaseConnection databaseConnection;


    @Override
    protected IDataSet getDataSet() throws Exception {
        return databaseConnection.createDataSet();
    }

    @Before
    public void before() throws Exception{
            databaseConnection = new DatabaseConnection(dataSource.getConnection());
        
    }
}
