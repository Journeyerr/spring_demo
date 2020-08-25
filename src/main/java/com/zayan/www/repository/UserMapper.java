package com.zayan.www.repository;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zayan.www.model.dto.admin.user.UserListDTO;
import com.zayan.www.model.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zayan.www.model.form.admin.UserListForm;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author AnYuan
 * @since 2019-04-15
 */
public interface UserMapper extends BaseMapper<User> {

    IPage<UserListDTO> list(IPage iPage, @Param("listForm") UserListForm listForm);
}
