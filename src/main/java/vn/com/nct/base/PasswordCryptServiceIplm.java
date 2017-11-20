package vn.com.nct.base;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class PasswordCryptServiceIplm implements PasswordCryptService{

	private static final int lenght = 12;
	
	@Override
	public String encryptPassword(String password) {
		String salt = BCrypt.gensalt(lenght);
		return BCrypt.hashpw(password, salt);
	}

	@Override
	public boolean checkPassword(String input_password, String encrypt_password) {
		boolean check = false;
		
		if(null == encrypt_password || !encrypt_password.startsWith("$2a$"))
			throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");

		check = BCrypt.checkpw(input_password, encrypt_password);
		
		return check;
	}

}
