package app.labs.dept.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import app.labs.dept.model.Dept;
import app.labs.dept.service.DeptService;

public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	DeptService deptService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Dept dept = deptService.getDeptInfo(Integer.parseInt(username)); // userid => deptno

		if (dept == null) {
			throw new UsernameNotFoundException("[" + username + "] 사용자를 찾을 수 없습니다.");
		}

		Map<Integer, String> roleMap = Map.of(10, "ROLE_ADMIN", 20, "ROLE_USER", 30, "ROLE_ADMIN", 40, "ROLE_USER");
		return null;
	}

}
