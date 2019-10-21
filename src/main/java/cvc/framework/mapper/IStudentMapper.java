package cvc.framework.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import cvc.framework.entity.Student;

@Mapper
public interface IStudentMapper 
{
	
	@Select("select  st.stid,st.stname,st.stidnumber,st.stgender,st.stbirthday,st.stphone,count(cs.clid) clcount "
			+ "from T_STUDENTS st,T_CLASSSTUDENTS cs "
			+ "where st.stid=cs.stid "
			+ "group by st.stid,st.stname,st.stidnumber,st.stgender,st.stbirthday,st.stphone ")
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
}
