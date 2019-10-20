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
	@Insert("insert into T_TEACHERS (teid,tename,tegender,teidnumber,tebirthday,teprofessional,teeducation,teworkdate,tephoto,tedelete,caid) "
			+ "values"
			+ "("
			+ "#{teid},#{tename},#{tegender},#{teidnumber},#{tebirthday},#{teprofessional},#{teeducation},#{teworkdate},#{tephoto},#{tedelete},#{caid}"
			+ ")")
	@Options(useGeneratedKeys = true,keyProperty = "teid",keyColumn = "TEID")
	//插入成功返回1
	public int addTe(Teacher teacher);
	@Select("select te.tename,te.teidnumber,te.tegender,te.tebirthday,te.teworkdate,cate.caname "
			+ "from T_TEACHERS te,T_CATEGORY cate "
			+ "where te.caid=cate.caid ")
	@Results({
		@Result(column="tename",property="tename"),
		@Result(column="teidnumber",property="teidnumber"),
		@Result(column="tegender",property="tegender"),
		@Result(column="tebirthday",property="tebirthday"),
		@Result(column="teworkdate",property="teworkdate"),
		@Result(column="caname",property="caname"),
	})
	public List<Teacher> searchAllTe();
}
