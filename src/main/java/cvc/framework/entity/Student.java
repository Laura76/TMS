package cvc.framework.entity;

public class Student {
	private String stname;
	private int stage;
	private int stgender;
	private String clid;//为了判断该学员是否已在该班级，故特意制造的属性
	private String stid;
	public Student() {}
	public Student(String stname,int stage) {
		this.stname=stname;
		this.stage=stage;
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
	public String getStid() {
		return stid;
	}
	public void setStid(String stid) {
		this.stid = stid;
	}
}
