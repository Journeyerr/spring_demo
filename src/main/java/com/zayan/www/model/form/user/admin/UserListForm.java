package com.zayan.www.model.form.user.admin;

import lombok.Data;

@Data
public class UserListForm {

    private Integer page = 1;
    private Integer pageSize = 15;
}
