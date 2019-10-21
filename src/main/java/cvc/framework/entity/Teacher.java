package cvc.framework.entity;
import java.util.Date;
import java.util.UUID;
public class Teacher{
	String teid;
	String tename;
	int tegender;
	String teidnumber;
	Date tebirthday;
	String teprofessional;
	String teeducation;
	Date teworkdate;
	//目前存的是头像图片的路径，如果直接存图片的base64编码应该也可以
	String tephoto;
	int tedelete;
	String caid;
	String caname;
	//生成简历的辅助属性
	Date clstarttime;
	Date clendtime;
	String clname;
	int stcount;
	//设置数据库为自动生成ID（如果没有设置的话暂时使用uuid代替）
	public String getTeid() {
		return teid;
	}
	public void setTeid(String teid) {
		this.teid = teid;
	}
	public String getTename() {
		return tename;
	}
	public void setTename(String tename) {
		this.tename = tename;
	}
	public int getTegender() {
		return tegender;
	}
	public void setTegender(int tegender) {
		this.tegender = tegender;
	}
	public String getTeidnumber() {
		return teidnumber;
	}
	public void setTeidnumber(String teidnumber) {
		this.teidnumber = teidnumber;
	}
	public Date getTebirthday() {
		return tebirthday;
	}
	public void setTebirthday(Date tebirthday) {
		this.tebirthday = tebirthday;
	}
	public String getTeprofessional() {
		return teprofessional;
	}
	public void setTeprofessional(String teprofessional) {
		this.teprofessional = teprofessional;
	}
	public String getTeeducation() {
		return teeducation;
	}
	public void setTeeducation(String teeducation) {
		this.teeducation = teeducation;
	}
	public Date getTeworkdate() {
		return teworkdate;
	}
	public void setTeworkdate(Date teworkdate) {
		this.teworkdate = teworkdate;
	}
	public String getTephoto() {
		return tephoto;
	}
	public void setTephoto(String tephoto) {
		this.tephoto = tephoto;
	}
	public int getTedelete() {
		return tedelete;
	}
	public void setTedelete(int tedelete) {
		this.tedelete = tedelete;
	}
	public String getCaid() {
		return caid;
	}
	public void setCaid(String caid) {
		this.caid = caid;
	}
	public String getCaname() {
		return caname;
	}
	public void setCaname(String caname) {
		this.caname = caname;
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
	public String getClname() {
		return clname;
	}
	public void setClname(String clname) {
		this.clname = clname;
	}
	public int getStcount() {
		return stcount;
	}
	public void setStcount(int stcount) {
		this.stcount = stcount;
	}
	
	
}