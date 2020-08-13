package com.zayan.www.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.time.LocalDateTime;


@Configuration
@EnableTransactionManagement
public class MybatisPlusConfig {

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    @Bean
    public MetaObjectHandler metaObjectHandler() {
        return new DateFillMetaObjectHandler();
    }

    @Slf4j
    public static class DateFillMetaObjectHandler implements MetaObjectHandler {

        /**
         * 插入时填充的字段.
         */
        private static final String INSERT_FIELD = "createdAt";

        /**
         * 插入和更新时都填充的字段.
         */
        private static final String INSERT_UPDATE_FIELD = "updatedAt";

        @Override
        public void insertFill(MetaObject metaObject) {
            LocalDateTime now = LocalDateTime.now();
            if (metaObject.hasGetter(INSERT_FIELD) && metaObject.getValue(INSERT_FIELD) == null) {
                setFieldValByName(INSERT_FIELD, now, metaObject);
            } else {
                log.info("【DateFillMetaObjectHandler.insertFill】公共字段填充失败,字段不存在或不为空.field={}", INSERT_FIELD);
            }
            if (metaObject.hasGetter(INSERT_UPDATE_FIELD) && metaObject.getValue(INSERT_UPDATE_FIELD) == null) {
                setFieldValByName(INSERT_UPDATE_FIELD, now, metaObject);
            } else {
                log.info("【DateFillMetaObjectHandler.insertFill】公共字段填充失败,字段不存在或不为空.field={}", INSERT_UPDATE_FIELD);
            }
        }

        @Override
        public void updateFill(MetaObject metaObject) {
            setFieldValByName(INSERT_UPDATE_FIELD, LocalDateTime.now(), metaObject);

        }
    }
}