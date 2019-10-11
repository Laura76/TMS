package cvc.framework.entity;

import java.util.Date;

public class ClassTime {
	//上课时间实体类-某课程的ID-某课程某天的开始时间-某课程某天的结束时间-某课程的上课周期 
	private String clid;
	private Date ctbegintime;
	private Date ctendtime;
	private int ctcycle;
	public ClassTime() {}
	public ClassTime(String clid,Date ctbegintime,Date ctendtime,int ctcycle) {
		this.clid=clid;
		this.ctbegintime=ctbegintime;
		this.ctendtime=ctendtime;
		this.ctcycle=ctcycle;
	}
	public String getClid() {
		return clid;
	}
	public void setClid(String clid) {
		this.clid = clid;
	}
	public Date getCtbegintime() {
		return ctbegintime;
	}
	public void setCtbegintime(Date ctbegintime) {
		this.ctbegintime = ctbegintime;
	}
	public Date getCtendtime() {
		return ctendtime;
	}
	public void setCtendtime(Date ctendtime) {
		this.ctendtime = ctendtime;
	}
	public int getCtcycle() {
		return ctcycle;
	}
	public void setCtcycle(int ctcycle) {
		this.ctcycle = ctcycle;
	}
}
