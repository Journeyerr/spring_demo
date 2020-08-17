package com.zayan.www;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

import java.util.Arrays;

/**
 * 自动生成实实体类、mapper、业务类
 * 需要注意：
 * 1. 核实数据库连接信息、代码生成路径、包名、需要生成的表名
 * 2. 代码生成完成后将自动生成的controller删除，将mapper.xml文件移动到resources/mapper目录下
 * 3. 如果表名为复数，将生成的相关代码改为单数形式，需要修改类名、类加注解@TableName注明原始表名、service接口名、service实现类名、repository下的mapper接口名、mapper.xml名
 * 4. 在生成的实体类的deleted_at字段上加@TableLogic注解实现自动逻辑删除及判断
 * 5. 将生成的service和serviceImpl文件移到对应功能的包下
 * 6. 完成后注释generateCode()方法上的@Test注解，避免误生成代码
 */
public class GenertorServiceEntity {

    /** 作者. */
    private static final String AUTHOR = "AnYuan";

    /** 数据库 .*/
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/spring_boot?characterEncoding=utf8&useSSL=false&allowMultiQueries=true" ;
    private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";

    /** 代码生成输出目录. */
    private static final String OUTPUT_DIR = "/Users/AnYuan/web/java/study/spring_demo/";
    /** 生成的包名 .*/
    private static final String PACKEGE_NAME = "com.zayan.www";

    /**
     * 根据表名生成对应的实体类，repository，service，controller（都是单表）
     * 注: repository.xml默认生成在mapper/xml下，需要手动移动到resource/mapper下
     */
    @Test
    public void generateCode() {
        generateByTables(PACKEGE_NAME, "shop");
    }

    private void generateByTables(String packageName, String... tableNames) {
        GlobalConfig globalConfig = new GlobalConfig();
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        StrategyConfig strategyConfig = new StrategyConfig();
        PackageConfig packageConfig = new PackageConfig();

        dataSourceConfig.setDbType(DbType.MYSQL)
                .setDriverName(DRIVER_NAME)
                .setUrl(DB_URL).setUsername(USERNAME)
                .setPassword(PASSWORD);

        strategyConfig.setCapitalMode(true)
                .setNaming(NamingStrategy.underline_to_camel) //下划线转驼峰
                .setEntityLombokModel(true)
                .setInclude(tableNames) //要生成代码的表名（可以是多个，以String数组表示）
                .setRestControllerStyle(true) //生成controller的注解为@RestController
                .setTableFillList(Arrays.asList(
                        new TableFill("created_at", FieldFill.INSERT),
                        new TableFill("updated_at",FieldFill.INSERT_UPDATE)));

        packageConfig.setParent(PACKEGE_NAME)
                .setMapper("repository")
                .setService("service")
//                .setController("controller")
                .setEntity("model.entity");

        globalConfig.setActiveRecord(false)
                .setAuthor(AUTHOR)
                .setOutputDir(OUTPUT_DIR+"/src/main/java")
                .setFileOverride(false)
                .setIdType(IdType.AUTO)     //主键策略
                .setServiceName("%sService")
                .setBaseResultMap(true)
                .setBaseColumnList(true);

        new AutoGenerator().setGlobalConfig(globalConfig).setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig).setPackageInfo(packageConfig)
                .execute();
    }
}
