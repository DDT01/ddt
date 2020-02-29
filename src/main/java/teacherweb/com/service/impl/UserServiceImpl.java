package teacherweb.com.service.impl;

import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import teacherweb.com.dto.UserDTO;
import teacherweb.com.dto.UserLoginDTO;
import teacherweb.com.entity.Users;
import teacherweb.com.repository.RoleRepository;
import teacherweb.com.repository.UserRepository;
import teacherweb.com.service.JwtService;
import teacherweb.com.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private DozerBeanMapper dozerBeanMapper;

	@Autowired
	private JwtService jwtService;

	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;

	@Override
	public Users findUserByUserName(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public List<Users> getListUsers() {
		return userRepository.findAll();
	}

	@Override
	public boolean register(UserDTO user) {
		if (userRepository.findByUsername(user.getUsername()) != null) {
			return false;
		} else {
			Users entityUser = dozerBeanMapper.map(user, Users.class);
			entityUser.setId(0);
			entityUser.setPassword(bcryptPasswordEncoder.encode(user.getPassword()));
			entityUser.setRole(roleRepository.findById(user.getRoleDTO().getId()));
			userRepository.save(entityUser);
			return true;
		}
	}

	@Override
	public String login(UserLoginDTO user) {
		Users users = userRepository.findByUsername(user.getUserName());
		if (ObjectUtils.isEmpty(users))
			return "";
		if (bcryptPasswordEncoder.matches(user.getPassword(), users.getPassword()))
			return jwtService.generateTokenLogin(users.getUsername());
		return "";
	}

	@Override
	public boolean updateUser(UserDTO user) {
		Users userEntity = userRepository.findByIdAndUsername(user.getId(), user.getUsername());
		String userName = userEntity.getUsername();
		String password = userEntity.getPassword();
		if (ObjectUtils.isNotEmpty(userEntity)) {
			userEntity = dozerBeanMapper.map(user, Users.class);
			userEntity.setUsername(userName);
			userEntity.setPassword(password);
			if (ObjectUtils.isNotEmpty(userRepository.save(userEntity)))
				return true;
		}
		return false;
	}

	@Override
	public boolean deleteUser(UserDTO user) {
		if (ObjectUtils.isEmpty(userRepository.findById(user.getId())))
			return false;
		Users userEntity = dozerBeanMapper.map(user, Users.class);
		userRepository.delete(userEntity);
		return true;
	}

}
