package com.example.mapper;

import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Emp;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpMapperTests {
	
	@Autowired
	EmpMapper mapper;
	
	@Test
	public void test01_selectAll() {
		
		System.out.println("mapper " + mapper);
		List<Emp> list = mapper.selectAll();
		
		for (Emp e : list) {
			System.out.println(e.getEmpno() + ", " + e.getEname() + ", " + e.getJob() + ", " + e.getMgr() + ", " + 
							   e.getHiredate()+ ", " + e.getSal() + ", " + e.getComm() + ", " + e.getDeptno());
			
		}
	}
	
	@Test
	public void test02_selectByEmpno() {
		
		Emp e1 = mapper.selectByEmpno(7521);
		Emp e2 = mapper.selectByEmpno(7844);
		
		System.out.println("e1 = " + e1.getEmpno() + ", " + e1.getEname() + ", " + e1.getJob() + ", " + e1.getMgr() + ", " + 
							   		e1.getHiredate()+ ", " + e1.getSal() + ", " + e1.getComm() + ", " + e1.getDeptno());
		System.out.println("e2 = " + e2.getEmpno() + ", " + e2.getEname() + ", " + e2.getJob() + ", " + e2.getMgr() + ", " + 
				   					e2.getHiredate()+ ", " + e2.getSal() + ", " + e2.getComm() + ", " + e2.getDeptno());
	}
	
	@Test
	public void test03_insertByEmp() {
		Emp emp = new Emp();
		Date date = new Date(100, 9, 10);
		emp.setEmpno(7777);
		emp.setEname("CHOI");
		emp.setJob("MANAGER");
		emp.setMgr(7839);
		emp.setHiredate(date);
		emp.setSal(1000);
		emp.setComm(0);
		emp.setDeptno(20);
		
		try {
			int rtn = mapper.insertByEmp(emp);
			System.out.println("insert rtn = " + rtn);
		} catch (DuplicateKeyException e) {
			System.out.println("중복에러 empno = " + emp.getEmpno());
		}
	}
	
	@Test
	public void test04_updateByEmp() {
		Emp emp = new Emp();
		Date date = new Date(99, 5, 15);
		emp.setEmpno(7777);
		emp.setEname("CHOIH");
		emp.setJob("PRE");
		emp.setMgr(7566);
		emp.setHiredate(date);
		emp.setSal(3000);
		emp.setComm(1000);
		emp.setDeptno(30);
		
		int rtn = mapper.updateByEmp(emp);
		System.out.println("update rtn = " + rtn);
	}
	
	@Test
	public void test05_deleteByEmpno() {
		Emp emp = new Emp();
		emp.setEmpno(7777);
		
		int rtn = mapper.deleteByEmpno(7777);
		System.out.println("delete rtn = " + rtn);
	}
}
