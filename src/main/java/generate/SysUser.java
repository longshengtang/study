package generate;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * sys_user
 * @author 
 */
@Data
public class SysUser implements Serializable {
    private Integer id;

    private String name;

    private String userName;

    private String password;

    private Date createTime;

    private Date updateTime;

    private Integer testId;

    private static final long serialVersionUID = 1L;
}