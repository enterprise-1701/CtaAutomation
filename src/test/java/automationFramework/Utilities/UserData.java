package automationFramework.Utilities;

	public class UserData {
		
		private static String userName;
		private static String password;
		private static String userEmail;
		private static String groupUserName;
		
		public static String getUserName(){
			return userName;
		}
		
		public static String getPassword(){
			return password;
		}
		
		public static String getEmail(){
			return userEmail;
		}
		
		public static String getGroupUserName(){
			return groupUserName;
		}
		
		
		public static void setName(String user){
			userName = user;
		}
		
		public static void setPassword(String passwd){
			password = passwd;
		}
		
		public static void setEmail(String email){
			userEmail = email;
		}
		
		public static void setGroupUserName(String gUser){
			groupUserName = gUser;
		}
			
	}


