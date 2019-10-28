package cvc.framework.mapper;


import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
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
			+ "from T_STUDENTS st where st.stisdelete=0) a "
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
	
	@InsertProvider(type = MyProvider.class, method = "batchInsert")
    public int batchInsert(List<Student> students);
	class MyProvider {
		/* 批量插入 */
        public String batchInsert(Map map) {
        	List<Student> students = (List<Student>) map.get("list");
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT ALL  ");
            for(int i=0;i<students.size();i++) {
            	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            	String dateString = formatter.format(students.get(i).getStbirthday());
            	sb.append(" INTO T_STUDENTS (stname,stidnumber,stphone,stbirthday,stisdelete) VALUES ");
            	sb.append(" ('"+students.get(i).getStname()+"','"+students.get(i).getStidnumber()+"','"+students.get(i).getStphone()+"',TO_DATE('"+dateString+""+"', 'yyyy-mm-dd'),'0') ");
            }
           sb.append(" SELECT 1 FROM DUAL ");
            return sb.toString();
        }
	}
}
