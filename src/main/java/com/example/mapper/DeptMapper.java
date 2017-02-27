package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.domain.Dept;

@Mapper
public interface DeptMapper {
	
	@Select("select * from dept")
	List<Dept> selectAll();
	
	@Select("select * from dept where deptno=#{deptno}")
	Dept selectByDeptno(int deptno);
	
	@Insert("insert into dept values(#{deptno}, #{dname}, #{loc})")		//#{property}  property? get이나 set을 빼고 첫글자 소문자로
	int insert(Dept dept);
	
	@Update({"update dept",
			 "   set dname 	= #{dname},",
			 "       loc	= #{loc}",
			 " where deptno = #{deptno}"
			 })
	int updateByDept(Dept dept);
	
	@Delete({"delete from dept",
			 " where deptno = #{deptno}"
	})	
	int deleteByDeptno(int deptno);      //조건이 하나이기 때문에 Dept dept가 아니라 int deptno이다.
}

//Dao랑 같은 역할 - 조회하는 역할
