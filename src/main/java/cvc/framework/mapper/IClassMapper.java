package cvc.framework.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import cvc.framework.entity.ClassTime;
import cvc.framework.entity.Classes;

@Mapper
public interface IClassMapper 
{
	//查询某些课-根据班级名称、某个具体类别
	@Select("select * from "
			+ "(select a.clid clid,a.clname clname,a.caname caname,a.tename tename,a.clenrolment clenrolment,b.currenrolment currenrolment,"
			+ "a.clstarttime clstarttime,a.clendtime clendtime "
			+ "from "
			+ "(select cl.CLID clid,cl.CLNAME clname,cate.CANAME caname,tea.TENAME tename,cl.CLENROLMENT clenrolment,"
			+ "to_char(cl.CLSTARTTIME, 'YYYY-MM-DD') clstarttime,"
			+ "to_char(cl.CLENDTIME, 'YYYY-MM-DD') clendtime "
			+ "from T_CLASS cl,T_TEACHERS tea,T_CATEGORY cate "
			+ "where cl.CLNAME=#{clname} and cl.CAID=cate.CAID and cate.CANAME=#{caname} "
			+ "and cl.TEID=tea.TEID ) a "
			+ "left join "
			+ "(select cl.CLID clid,count(stu.STID) currenrolment "
			+ "from T_CLASS cl,T_CLASSSTUDENTS stu "
			+ "where  cl.CLNAME=#{clname} and cl.CLID=stu.CLID "
			+ "group by cl.CLID ) b "
			+ "on a.clid=b.clid) one "
			+ "left join "
			+ "(select cl.CLID clid,wmsys.wm_concat(time.CTCYCLE) ctcycle"
			+ " from T_CLASS cl,T_CLASSTIME time"
			+ " where cl.CLID=time.CLID and cl.CLNAME=#{clname} "
			+ " group by cl.CLID "
			+ ") two "
			+ "on one.clid=two.clid ")
	@Results({
		@Result(column="clname",property="clname"),
		@Result(column="caname",property="caname"),
		@Result(column="tename",property="tename"),
		@Result(column="clenrolment",property="clenrolment"),
		@Result(column="currenrolment",property="currenrolment"),
		@Result(column="clstarttime",property="clstarttime"),
		@Result(column="clendtime",property="clendtime"),
		@Result(column="ctcycle",property="ctcycle"),
	})
	public List<Classes> searchClass(String clname,String caname);
	
	@Select("select * from T_CLASS where clname=#{clname}")
	@Results({
		@Result(column="clname",property="clname"),
		@Result(column="clenrolment",property="clenrolment"),
		@Result(column="clstarttime",property="clstarttime"),
		@Result(column="clendtime",property="clendtime"),
	})
	public List<Classes> searchAllClass(String clname,String teacher);
	
	@Insert("insert into T_CLASS (CAID,TEID,CLNAME,CLSTARTTIME,CLENDTIME,CLENROLMENT,CLDELETE) values"
			+ "("
			+ "#{caid},#{teid},#{clname},#{clstarttime},#{clendtime},#{clenrolment},#{cldelete}"
			+ ")")
	@Options(useGeneratedKeys = true,keyProperty = "clid",keyColumn = "CLID")
	//插入成功返回1
	public int addClass(Classes classes);
	
	@Insert("insert into T_CLASSTIME (CLID,CTBEGINTIME,CTENDTIME,CTCYCLE) values"
			+ "("
			+ "#{clid},#{ctbegintime},#{ctendtime},#{ctcycle}"
			+ ")")
	@Options(useGeneratedKeys = true,keyColumn = "ctid")
	//插入成功返回1
	public int addClassTime(ClassTime classtime);
	
	//今日有课
	@Select("select * from T_CLASS cl where cl.clstarttime<=#{todayTime} and cl.clendtime>=#{todayTime} "
			+ "and #{cycle} in( "
			+ "select ctcycle from T_CLASSTIME ct "
			+ "where ct.clid=cl.clid "
			+ ")")
	@Results({
		@Result(column="clname",property="clname"),
		@Result(column="clenrolment",property="clenrolment"),
		@Result(column="clstarttime",property="clstarttime"),
		@Result(column="clendtime",property="clendtime"),
	})
	public List<Classes> searchTodayClass(Date todayTime,int cycle);
}
