package cvc.framework.entity;

import java.util.Date;

/**
 *用户登陆实体类 
 */
public class Classes 
{
	private int ordernumber;
	private String clname;
	private String caname;
	private int clenrolment;
	private int currenrolment;
	private Date clstarttime;
	private Date clendtime;
	private int ctcircle;
	public Classes(int ordernumber,String clname,String caname,int clenrolment,int currenrolment,Date clstarttime,Date clendtime,int ctcircle) {
	}
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
	public int getCtcircle() {
		return ctcircle;
	}
	public void setCtcircle(int ctcircle) {
		this.ctcircle = ctcircle;
	}
	
}
