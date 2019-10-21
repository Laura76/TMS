package cvc.framework.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import cvc.framework.entity.Student;

@Mapper
public interface IStudentMapper 
{
	
	//注意：报班数量为0的学生也要显示
	@Select("select * "
			+ "from( "
			+ "(select  st.stid,st.stname,st.stidnumber,st.stgender,st.stbirthday,st.stphone  "
			+ "from T_STUDENTS st) a "
			+ "left join "
			+ "(select cs.stid,count(cs.clid) clcount "
			+ "from T_CLASSSTUDENTS cs "
			+ "group by cs.stid ) b "
			+ "on a.stid=b.stid "
			+ ")")
	@Results({
		@Result(column="stid",property="stid"),
		@Result(column="stname",property="stname"),
		@Result(column="stidnumber",property="stidnumber"),
		@Result(column="stbirthday",property="stbirthday"),
		@Result(column="stgender",property="stgender"),
		@Result(column="stphone",property="stphone"),
		@Result(column="clcount",property="clcount"),
	})
	public List<Student> searchAllStu();
	
	@Insert("insert into T_STUDENTS (stid,stname,stgender,stidnumber,stbirthday,stphone,stisdelete,stcreatetime) "
			+ "values"
			+ "("
			+ "#{stid},#{stname},#{stgender},#{stidnumber},#{stbirthday},#{stphone},#{stisdelete},#{stcreatetime} "
			+ ")")
	@Options(useGeneratedKeys = true,keyProperty = "stid",keyColumn = "STID")
	public int addStu(Student student);
}
