package com.wen.po;

import java.sql.*;
import java.util.*;

public class Emp {

	private String ename;
	private Integer comm;
	private Integer mgr;
	private Integer empno;
	private String job;
	private java.sql.Timestamp hiredate;
	private Integer deptno;
	private Integer sal;


	public String getEname(){
		return ename;
	}
	public Integer getComm(){
		return comm;
	}
	public Integer getMgr(){
		return mgr;
	}
	public Integer getEmpno(){
		return empno;
	}
	public String getJob(){
		return job;
	}
	public java.sql.Timestamp getHiredate(){
		return hiredate;
	}
	public Integer getDeptno(){
		return deptno;
	}
	public Integer getSal(){
		return sal;
	}
	public void setEname(String ename){
		this.ename=ename;
	}
	public void setComm(Integer comm){
		this.comm=comm;
	}
	public void setMgr(Integer mgr){
		this.mgr=mgr;
	}
	public void setEmpno(Integer empno){
		this.empno=empno;
	}
	public void setJob(String job){
		this.job=job;
	}
	public void setHiredate(java.sql.Timestamp hiredate){
		this.hiredate=hiredate;
	}
	public void setDeptno(Integer deptno){
		this.deptno=deptno;
	}
	public void setSal(Integer sal){
		this.sal=sal;
	}
}
