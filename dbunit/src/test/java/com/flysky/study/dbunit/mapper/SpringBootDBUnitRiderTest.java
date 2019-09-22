package com.flysky.study.dbunit.mapper;

import com.flysky.study.dbunit.config.TransactionalDevTestConfig;
import com.github.database.rider.core.api.dataset.DataSetFormat;
import com.github.database.rider.core.api.exporter.DataSetExportConfig;
import com.github.database.rider.core.api.exporter.ExportDataSet;
import com.github.database.rider.core.exporter.DataSetExporter;
import com.github.database.rider.spring.api.DBRider;
import org.dbunit.DatabaseUnitException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
@DBRider
//@TransactionalDevTestConfig
public class SpringBootDBUnitRiderTest {
    @Test
    public void test() {
        System.out.println("00000000");
    }

    @Test
    @ExportDataSet(format = DataSetFormat.YML, includeTables = {"sys_user"}, outputName = "target/export/yml/sysUser.yml")
    public void export() {
        System.out.println(System.getProperty("user.dir") + "---------------");
    }

    @Test
    public void programmaticallyExport() throws SQLException, DatabaseUnitException {
        DataSetExportConfig config = new DataSetExportConfig();
        String root = System.getProperty("user.dir") + "/src/test/resources/datasets/";
        config.outputFileName(root + "systemLog.yml")
                .includeTables(new String[]{"system_log"})
                .dataSetFormat(DataSetFormat.YML);
        DataSetExporter
                .getInstance()
                .export(
                        dataSource.getConnection(),
                        config
                );
    }

    @Autowired
    private DataSource dataSource;
}
