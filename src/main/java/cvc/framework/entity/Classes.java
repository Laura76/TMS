package cvc.framework.entity;

import java.util.Date;

/**
 *用户登陆实体类 
 */
public class Classes 
{
	//序号-班级名称-类别-教师-计划招生人数-当前人数-开班时间-结束时间-上课周期
	private String clid;
	private int ordernumber;
	private String clname;
	private String caname;
	private String tename;
	private int clenrolment;
	private int currenrolment;
	private Date clstarttime;
	private Date clendtime;
	private String ctcycle;
	private String caid;
	private String teid;
	private int cldelete;//0是该课程未删除，1是删除
	private String[] cycles;//数组里面每一项的格式为：1 begintime endtime,其中的1值得是周一，将这个数据插入到class time的数据库表中
	
	public Classes() {}
	public int getOrdernumber() {
		return ordernumber;
	}
	public void setOrdernumber(int ordernumber) {
		this.ordernumber = ordernumber;
	}
	public String getClname() {
		return clname;
	}
	public void setClname(String clname) {
		this.clname = clname;
	}
	public String getCaname() {
		return caname;
	}
	public void setCaname(String caname) {
		this.caname = caname;
	}
	public String getTename() {
		return tename;
	}
	public void setTename(String tename) {
		this.tename = tename;
	}
	public int getClenrolment() {
		return clenrolment;
	}
	public void setClenrolment(int clenrolment) {
		this.clenrolment = clenrolment;
	}
	public int getCurrenrolment() {
		return currenrolment;
	}
	public void setCurrenrolment(int currenrolment) {
		this.currenrolment = currenrolment;
	}
	public Date getClstarttime() {
		return clstarttime;
	}
	public void setClstarttime(Date clstarttime) {
		this.clstarttime = clstarttime;
	}
	public Date getClendtime() {
		return clendtime;
	}
	public void setClendtime(Date clendtime) {
		this.clendtime = clendtime;
	}
	public String getCtcycle() {
		return ctcycle;
	}
	public void setCtcycle(String ctcycle) {
		StringBuilder res=new StringBuilder();
		for(String str:ctcycle.split(",")) {
			switch(str) {
			case "0":res.append("周日,");break;
			case "1":res.append("周一,");break;
			case "2":res.append("周二,");break;
			case "3":res.append("周三,");break;
			case "4":res.append("周四,");break;
			case "5":res.append("周五,");break;
			case "6":res.append("周六,");break;
			}
		}
		this.ctcycle = res.toString();
	}
	public String getClid() {
		return clid;
	}
	public void setClid(String clid) {
		this.clid = clid;
	}
	public String getCaid() {
		return caid;
	}
	public void setCaid(String caid) {
		this.caid = caid;
	}
	public String getTeid() {
		return teid;
	}
	public void setTeid(String teid) {
		this.teid = teid;
	}
	public int getCldelete() {
		return cldelete;
	}
	public void setCldelete(int cldelete) {
		this.cldelete = cldelete;
	}
	public String[] getCycles() {
		return cycles;
	}
	public void setCycles(String[] cycles) {
		this.cycles = cycles;
	}
}
