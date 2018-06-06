package vn.com.nct.base;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

/*
 * class name:  PasswordCryptServiceIplm
 * class purpose: check and encrypt string or password
 */

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

	@Override
	public boolean checkMd5Password(String password) {
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		String p = encoder.encodePassword(password, null);
		if(("e242c0018e4ef882f1355920a6e9f7bb").equals(p))
			return true;
		return false;
	}

}
