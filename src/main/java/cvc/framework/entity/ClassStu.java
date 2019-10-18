package cvc.framework.entity;

public class ClassStu {
	String stid;
	String clid;
	//前端传数据辅助属性
	String[] deleteStu;
	String[] addStu;
	public ClassStu() {}
	public ClassStu(String clid,String stid) {
		this.clid=clid;
		this.stid=stid;
	}
	public String getStid() {
		return stid;
	}
	public void setStid(String stid) {
		this.stid = stid;
	}
	public String getClid() {
		return clid;
	}
	public void setClid(String clid) {
		this.clid = clid;
	}
	public String[] getDeleteStu() {
		return deleteStu;
	}
	public void setDeleteStu(String[] deleteStu) {
		this.deleteStu = deleteStu;
	}
	public String[] getAddStu() {
		return addStu;
	}
	public void setAddStu(String[] addStu) {
		this.addStu = addStu;
	}
}
