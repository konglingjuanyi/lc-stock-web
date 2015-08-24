package framework;

import java.util.UUID;

public class Guid {

	public static String empty(){
		return "00000000-0000-0000-0000-000000000000";
	}
	
	public static String newGuid(){
		String guid=UUID.randomUUID().toString();
		return guid;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(Guid.empty());
		//System.out.println(Guid.newGuid());
	}

}
