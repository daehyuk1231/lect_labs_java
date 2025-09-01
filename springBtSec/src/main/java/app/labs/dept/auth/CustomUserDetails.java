package app.labs.dept.auth;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


// 1. username, userpassword, role에 관련된 사용자정보를 스프링 시큐리티에 적합하게 변환하는 클래스
public class CustomUserDetails implements UserDetails {
	
	private static final long serialVersionUID = 1L;

	private String userName;
	private String password;
	private String authority;

	private String userEmail;

	public CustomUserDetails(String userName, String password, String authority, String userEmail) {
		this.userName = userName;
		this.password = password;
		this.authority = authority;
		this.userEmail = userEmail;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> auths = new ArrayList<>();
		
		String[] authorities = this.authority.split(",");
		
		for (String role: authorities) {
			auths.add(new SimpleGrantedAuthority(role));
		}
		
		return auths;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public String getEmail() {
		return this.userEmail;
	}

	@Override
	public String toString() {
		return "CustomUserDetails [userName=" + userName + ", password=" + password + ", authority=" + authority
				+ ", userEmail=" + userEmail + "]";
	}

}
