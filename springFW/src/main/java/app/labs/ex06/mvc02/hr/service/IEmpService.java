package app.labs.ex06.mvc02.hr.service;

import java.util.List;
import java.util.Map;

import app.labs.ex06.mvc02.hr.model.Emp;

public interface IEmpService {
	int getEmpCount();

	int getEmpCount(int deptId);

	List<Emp> getEmpList();

	Emp getEmpInfo(int empId);

	void insertEmp(Emp emp);

	void updateEmp(Emp emp);

	int deleteEmp(int empId, String email);

	List<Map<String, Object>> getAllDeptId();

	List<Map<String, Object>> getAllJobId();

	List<Map<String, Object>> getAllManagerId();
}
