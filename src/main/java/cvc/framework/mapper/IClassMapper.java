package cvc.framework.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import cvc.framework.entity.User;

@Mapper
public interface IClassMapper 
{

	@Select("select * from T_USER where username=#{username} and password=#{password}")
	@Results({
		@Result(column="username",property="username"),
		@Result(column="password",property="password"),
		@Result(column="isvalid",property="isvalid"),
	})
	public List<User> searchClass(String clname,String caname,String teacher);
}
