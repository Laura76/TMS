package cvc.framework.entity;

import java.util.Date;

//学员签到实体类
public class SignIn {
	String clid;
	String stid;
	Date sitime;
	int sistate;
	String stname;
	public String getClid() {
		return clid;
	}
	public void setClid(String clid) {
		this.clid = clid;
	}
	public String getStid() {
		return stid;
	}
	public void setStid(String stid) {
		this.stid = stid;
	}
	public Date getSitime() {
		return sitime;
	}
	public void setSitime(Date sitime) {
		this.sitime = sitime;
	}
	public int getSistate() {
		return sistate;
	}
	public void setSistate(int sistate) {
		this.sistate = sistate;
	}
	public String getStname() {
		return stname;
	}
	public void setStname(String stname) {
		this.stname = stname;
	}
}
