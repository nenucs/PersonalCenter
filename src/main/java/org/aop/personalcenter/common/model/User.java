package org.aop.personalcenter.common.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "TBL_USER")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    private int id;

    @TableField(value = "USER_ID")
    private String userId;

    private String name;

    private transient String password;
}
