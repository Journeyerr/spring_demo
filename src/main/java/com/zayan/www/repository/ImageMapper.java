package com.zayan.www.repository;

import com.zayan.www.model.entity.Image;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author AnYuan
 * @since 2020-08-17
 */
public interface ImageMapper extends BaseMapper<Image> {

    List<Image> listByIds(@Param("ids") List<Integer> ids);
}
