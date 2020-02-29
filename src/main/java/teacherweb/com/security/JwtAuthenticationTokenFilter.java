
package teacherweb.com.security;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import teacherweb.com.dto.UserLoginDTO;
import teacherweb.com.entity.Users;
import teacherweb.com.repository.UserRepository;
import teacherweb.com.service.JwtService;

public class JwtAuthenticationTokenFilter extends UsernamePasswordAuthenticationFilter {

	private final static String TOKEN_HEADER = "authorization";

	@Autowired
	private JwtService jwtService;

	@Autowired
	private UserRepository userRepository;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String authToken = httpRequest.getHeader(TOKEN_HEADER);
		try {
			if (Boolean.TRUE.equals(jwtService.validateTokenLogin(authToken))) {

				String username = jwtService.getUsernameFromToken(authToken);
				Users userEntity = userRepository.findByUsername(username);
				UserLoginDTO user = new UserLoginDTO(userEntity.getUsername(), userEntity.getPassword());
				user.setRoles(Arrays.asList(userEntity.getRole().getName()));

				if (user != null) {
					boolean enabled = true;
					boolean accountNonExpired = true;
					boolean credentialsNonExpired = true;
					boolean accountNonLocked = true;
					UserDetails userDetail = new User(username, user.getPassword(), enabled, accountNonExpired,
							credentialsNonExpired, accountNonLocked, user.getAuthorities());

					UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
							userDetail, null, userDetail.getAuthorities());
					authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpRequest));
					SecurityContextHolder.getContext().setAuthentication(authentication);
				}
			}
		} catch (Exception e) {
			System.out.println("Invalid format token!");
		}
		chain.doFilter(request, response);
	}
}