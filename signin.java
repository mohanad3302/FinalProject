import java.util.* ;
public class signin {
	public signin() {
		
	}
	system system = new system();
	private ArrayList<user> users = system.getUsers() ;
	
	public user siginIn() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("userName : ");
		String name = input.next();
		System.out.println("password : ");
		String password = input.next();
		user user = new user();
		for ( int i = 0 ; i < users.size(); i ++) {
			user = users.get(i);
			if (user.getName().equals(name) && user.getPassword().equals(password)){
				return user ;
			}
			else if(user.getName().equals(name) && !(user.getPassword().equals(password))){
				System.out.println("the password you have entered is wrong .");
			}
			else {
				System.out.println("user not found .");
			}
		}
		return user ;
	}
}
