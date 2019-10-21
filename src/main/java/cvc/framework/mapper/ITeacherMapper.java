package cvc.framework.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import cvc.framework.entity.Teacher;

@Mapper
public interface ITeacherMapper 
{
	@Insert("insert into T_TEACHERS (tename,tegender,teidnumber,tebirthday,teprofessional,teeducation,teworkdate,tephoto,tedelete,caid) "
			+ "values"
			+ "("
			+ "#{tename},#{tegender},#{teidnumber},#{tebirthday},#{teprofessional},#{teeducation},#{teworkdate},#{tephoto},#{tedelete},#{caid}"
			+ ")")
	@Options(useGeneratedKeys = true,keyProperty = "teid",keyColumn = "TEID")
	//插入成功返回1
	public int addTe(Teacher teacher);
	@Select("select te.teid,te.tename,te.teidnumber,te.tegender,te.tebirthday,te.teworkdate,cate.caname "
			+ "from T_TEACHERS te,T_CATEGORY cate "
			+ "where te.caid=cate.caid ")
	@Results({
		@Result(column="tename",property="tename"),
		@Result(column="teidnumber",property="teidnumber"),
		@Result(column="tegender",property="tegender"),
		@Result(column="tebirthday",property="tebirthday"),
		@Result(column="teworkdate",property="teworkdate"),
		@Result(column="caname",property="caname"),
		@Result(column="teid",property="teid"),
	})
	public List<Teacher> searchAllTe();
	@Select("select * "
			+ "from T_TEACHERS te "
			+ "where te.teid=#{teid}  ")
	@Results({
		@Result(column="tename",property="tename"),
		@Result(column="tegender",property="tegender"),
		@Result(column="teprofessional",property="teprofessional"),
		@Result(column="teeducation",property="teeducation"),
		@Result(column="teidnumber",property="teidnumber"),
		@Result(column="tephoto",property="tephoto"),
	})
	public List<Teacher> downloadResume(String teid);
	
	@Select("select cl.clid,cl.clstarttime,cl.clendtime,cl.clname,cate.caname,count(cs.stid) stcount "
			+ "from T_CLASS cl,T_CLASSSTUDENTS cs ,T_CATEGORY cate "
			+ "where cl.teid=#{teid}  and cl.clid=cs.clid and cl.caid=cate.caid "
			+ "group by cl.clid,cl.clstarttime,cl.clendtime,cl.clname,cate.caname ")
	@Results({
		@Result(column="clstarttime",property="clstarttime"),
		@Result(column="clendtime",property="clendtime"),
		@Result(column="clname",property="clname"),
		@Result(column="stcount",property="stcount"),
		@Result(column="caname",property="caname"),
	})
	public List<Teacher> searchTeClass(String teid);
}
