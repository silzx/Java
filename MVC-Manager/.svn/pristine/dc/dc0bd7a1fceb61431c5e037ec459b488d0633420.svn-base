package com.wzx.dto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

/**
 * @author 
 */
@Component
public class empDto implements Serializable {
    private String eid;//员工编号

    private String ename;//员工姓名
    
    private String epwd;//员工密码

    private String esex;//员工性别

    private String eage;//员工年龄

    private String did;//员工部门编号

    private String pid;//员工权限编号
    @DateTimeFormat(pattern = "yyyy-MM-dd") 
    private Date joindate;//员工入职日期
    @DateTimeFormat(pattern = "yyyy-MM-dd") 
    private Date modify;//最后修改时间
    
    private deptDto dept;//员工部门实体类对象
    
    private powerDto power;//员工权限实体类对象
    
    private String pic;//员工头像

    private static final long serialVersionUID = 1L;

    public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEsex() {
        return esex;
    }

    public void setEsex(String esex) {
        this.esex = esex;
    }

    public String getEage() {
        return eage;
    }

    public void setEage(String eage) {
        this.eage = eage;
    }
    
	public String getDid() {
		return did;
	}

	public void setDid(String did) {
		this.did = did;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public Date getJoindate() {
        return joindate;
    }

    public void setJoindate(Date joindate) {
        this.joindate = joindate;
    }

    public Date getModify() {
        return modify;
    }

    public void setModify(Date modify) {
        this.modify = modify;
    }

	public String getEpwd() {
		return epwd;
	}

	public void setEpwd(String epwd) {
		this.epwd = epwd;
	}

	public deptDto getDept() {
		return dept;
	}

	public void setDept(deptDto dept) {
		this.dept = dept;
	}

	public powerDto getPower() {
		return power;
	}

	public void setPower(powerDto power) {
		this.power = power;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}
	
    
}