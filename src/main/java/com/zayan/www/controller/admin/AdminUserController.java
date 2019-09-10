package com.zayan.www.controller.admin;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zayan.www.model.dto.user.admin.UserListDTO;
import com.zayan.www.model.form.user.admin.UserListForm;
import com.zayan.www.model.vo.BaseResult;
import com.zayan.www.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author AnYuan
 */

@RestController
@AllArgsConstructor
@RequestMapping("/admin/user")
public class AdminUserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public BaseResult users(@RequestBody UserListForm listForm){
        IPage<UserListDTO> users = userService.users(new Page(listForm.getPage(), listForm.getPageSize()), listForm);
        return BaseResult.success(users);
    }
}
