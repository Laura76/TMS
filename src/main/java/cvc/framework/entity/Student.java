package cvc.framework.entity;

import java.util.Date;
import java.util.UUID;

public class Student {
	private String stname;
	private int stage;
	private int stgender;
	private String clid;//为了判断该学员是否已在该班级，故特意制造的属性
	private String stid;
	private String stidnumber;
	private Date stbirthday;
	private String stphone;
	private int clcount;
	private Date stcreatetime;
	private int stisdelete;
	public Student() {}
	public Student(String stname ,String stidnumber,String stphone,Date stbirthday) {
		this.stname=stname;
		this.stidnumber=stidnumber;
		this.stphone=stphone;
		this.stbirthday=stbirthday;
	}
	public String getStname() {
		return stname;
	}
	public void setStname(String stname) {
		this.stname = stname;
	}
	public int getStage() {
		return stage;
	}
	public void setStage(int stage) {
		this.stage = stage;
	}
	public int getStgender() {
		return stgender;
	}
	public void setStgender(int stgender) {
		this.stgender = stgender;
	}
	public String getClid() {
		return clid;
	}
	public void setClid(String clid) {
		this.clid = clid;
	}
	//暂时自增一下，明天记得在数据库中把所有的表都修改掉
	public String getStid() {
		return stid;
	}
	public void setStid(String stid) {
		this.stid = stid;
	}
	public String getStidnumber() {
		return stidnumber;
	}
	public void setStidnumber(String stidnumber) {
		this.stidnumber = stidnumber;
	}
	public Date getStbirthday() {
		return stbirthday;
	}
	public void setStbirthday(Date stbirthday) {
		this.stbirthday = stbirthday;
	}
	public String getStphone() {
		return stphone;
	}
	public void setStphone(String stphone) {
		this.stphone = stphone;
	}
	public int getClcount() {
		return clcount;
	}
	public void setClcount(int clcount) {
		this.clcount = clcount;
	}
	public Date getStcreatetime() {
		return stcreatetime;
	}
	public void setStcreatetime(Date stcreatetime) {
		this.stcreatetime = stcreatetime;
	}
	public int getStdelete() {
		return stisdelete;
	}
	public void setStdelete(int stdelete) {
		this.stisdelete = stdelete;
	}
}
