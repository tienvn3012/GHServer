package vn.com.nct.base;

public interface PasswordCryptService {
	public String encryptPassword(String password);
	public boolean checkPassword(String input_password, String encrypt_password);
	public boolean checkMd5Password(String password);
}
