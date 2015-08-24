package framework.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


import org.apache.commons.codec.binary.Base64;

public class Encrypt {

	private final static String[] strDigits = { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	private final static String KEY_MAC = "HmacMD5";

	private static String byteToArrayString(byte bByte) {
		int iRet = bByte;
		// System.out.println("iRet="+iRet);
		if (iRet < 0) {
			iRet += 256;
		}
		int iD1 = iRet / 16;
		int iD2 = iRet % 16;
		return strDigits[iD1] + strDigits[iD2];
	}

	@SuppressWarnings("unused")
	private static String byteToNum(byte bByte) {
		int iRet = bByte;
		System.out.println("iRet1=" + iRet);
		if (iRet < 0) {
			iRet += 256;
		}
		return String.valueOf(iRet);
	}

	private static String byteToString(byte[] bByte) {
		StringBuffer sBuffer = new StringBuffer();
		for (int i = 0; i < bByte.length; i++) {
			sBuffer.append(byteToArrayString(bByte[i]));
		}
		return sBuffer.toString();
	}

	public static String GetMD5Code(String strObj)
			throws NoSuchAlgorithmException, Exception {
		String resultString = null;
		resultString = new String(strObj);
		MessageDigest md = MessageDigest.getInstance("MD5");
		resultString = byteToString(md.digest(strObj.getBytes()));

		return resultString;
	}

	public static String GetSHACode(String strObj) throws Exception {
		String resultString = null;
		resultString = new String(strObj);
		MessageDigest sha = MessageDigest.getInstance("SHA1");
		resultString = byteToString(sha.digest(strObj.getBytes()));

		return resultString;
	}

	/**
	 * BASE64
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	public static byte[] decryptBASE64(String key) throws Exception {
		return new Base64().decodeBase64(key);
	}

	/**
	 * BASE64
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String encryptBASE64(byte[] key) throws Exception {
		return new Base64().encodeToString(key);
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String initMacKey() throws Exception {
		KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_MAC);

		SecretKey secretKey = keyGenerator.generateKey();
		return encryptBASE64(secretKey.getEncoded());
	}

	/**
	 * 
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptHMAC(byte[] data, String key) throws Exception {

		SecretKey secretKey = new SecretKeySpec(decryptBASE64(key), KEY_MAC);
		Mac mac = Mac.getInstance(secretKey.getAlgorithm());
		mac.init(secretKey);

		return mac.doFinal(data);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		try {
//			String a = Encrypt.encryptBASE64("http://www.163.com?a=123"
//					.getBytes());
//			System.out.println(a);
//
//			byte[] b = Encrypt.decryptBASE64(a);
//			System.out.println(new String(b));
//
//			String admin = Encrypt.GetSHACode("admin");
//			System.out.println(admin);
//
//			String key = Encrypt.initMacKey();
//			byte[] c = Encrypt.encryptHMAC("1234567890abcdefg".getBytes(), key);
//			BigInteger bin = new BigInteger(c);
//			System.out.println(bin.toString(16));
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

}

