package com.zayan.www.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author AnYuan
 * @since 2021-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SeckillOrder implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * id
     */
      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 订单no
     */
    private String no;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * skuNo
     */
    private Integer skuNo;

    /**
     * 唯一标识
     */
    private String traceId;
    /**
     * 订单状态
     */
    private String status;

    /**
     * 创建时间
     */
      @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdAt;

    /**
     * 更新时间
     */
      @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedAt;

    /**
     * 删除时间
     */
    private LocalDateTime deletedAt;


}
