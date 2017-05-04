package tech.saltyegg.leetcode.jdk;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.mindrot.jbcrypt.BCrypt;

/**
 * Created by hzhou on 2015/6/18. Email: i@hzhou.me
 */
public class StringTest {

	private static final Logger log = Logger.getLogger(StringTest.class);

	@Test
	public void splitTest() {
		String[] result = ".453".split("\\.");
		int i = Integer.valueOf(result[0]);
	}

	@Test
	public void bcrypt() {
		String password = "123456";
		String candidate = password;
		// Hash a password for the first time
		String hashed = BCrypt.hashpw(password, BCrypt.gensalt());

		// gensalt's log_rounds parameter determines the complexity
		// the work factor is 2**log_rounds, and the default is 10
		//String hashed = BCrypt.hashpw(password, BCrypt.gensalt(12));

		// Check that an unencrypted password matches one that has
		// previously been hashed
		System.out.println(hashed);
		if (BCrypt.checkpw(candidate, hashed)) {
			System.out.println("It matches");
		} else {
			System.out.println("It does not match");
		}
	}
}
