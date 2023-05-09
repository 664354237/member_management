package com.gx.member_management.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @描述: 主数据库配置
 * @作者: 黄鹤松
 * @日期: 2023/5/8 15:46
 **/

@Configuration
@ConfigurationProperties(prefix="spring.datasource.druid.db2")
@MapperScan(basePackages = {"com.gx.member_management.persistence.db2.**.mapper"}, sqlSessionFactoryRef = "sqlSessionFactory2")
public class db2Config {
    private String dialect;
    @Autowired(required = false)
    private DatabaseIdProvider databaseIdProvider;

    /**
     * 多数据源需要一下全部配置，但数据可以注释掉
     * @return
     */
    @Bean(name = "db2")
    @ConfigurationProperties(prefix = "spring.datasource.druid.db2")
    public DataSource db2() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name="sqlSessionTemplate2",destroyMethod="close")
    @Scope("prototype")
    public SqlSessionTemplate getSqlSessionTemplate()throws Exception {
        SqlSessionTemplate jdbcTemplate = new SqlSessionTemplate(sqlSessionFactory());
        return jdbcTemplate;
    }
    @Bean("sqlSessionFactory2")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        try{
            MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
            sqlSessionFactory.setDataSource(db2());
            PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            sqlSessionFactory.setConfigLocation(resolver.getResource("classpath:mybatis/mybatis-config.xml"));
            //兼容多种数据库处理
            sqlSessionFactory.setDatabaseIdProvider(databaseIdProvider);

            // 添加插件
//            sqlSessionFactory.setPlugins(new Interceptor[] { pageHelper,  new PaginationInterceptor() });
            List<Resource> tempList=new ArrayList<Resource>();
            Resource[] tempres=resolver.getResources("classpath*:mybatis/business2/*Mapper.xml");
            tempList.addAll(Arrays.asList(tempres));
            tempres=new Resource[tempList.size()];
            sqlSessionFactory.setMapperLocations(tempList.toArray(tempres));
            return sqlSessionFactory.getObject();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public String getDialect() {
        return dialect;
    }

    public void setDialect(String dialect) {
        this.dialect = dialect;
    }
}
