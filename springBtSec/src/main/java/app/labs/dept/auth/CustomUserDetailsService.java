package app.labs.dept.auth;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import app.labs.dept.model.Dept;
import app.labs.dept.service.DeptService;
import lombok.extern.slf4j.Slf4j;

// 2. UserDetails 전달하는 클래스, 사용자 유무를 확인하고, 없을 경우 예외발생, 있을 경우 UserDetails를 반환
@Slf4j
@Component
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

		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String pwd = passwordEncoder.encode(dept.getDName());

		UserDetails userDetails = new CustomUserDetails(String.valueOf(dept.getDeptNo()), pwd,
				roleMap.get(dept.getDeptNo()), dept.getLoc());

		log.debug(userDetails.toString());

		return null;
	}

}
