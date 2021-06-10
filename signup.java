import java.util.*;
public class signup extends system{

	
	Scanner input = new Scanner (System.in);
	
	public signup() {
		
	}
	public void signUp(ArrayList<user> users) {
		
		System.out.print("userName : ");
		String name = nameValidation(users);
		
		System.out.print("age : ");
		int age = numberValidation();
		
		System.out.print("email : ");
		String email = input.next();
		
		System.out.print("phone number : ");
		int phoneNumber = numberValidation();
		
		System.out.print("password : ");
		String password = input.next();
		
		System.out.print("education : ");
		String education = input.next();
		
		System.out.print("work : ");
		String work = input.next();
		
		System.out.print("address : " );
		String address = input.next();
		
		user user = new user(name , email , phoneNumber , address , age , education , work ,password );
		users.add(user);
		
	}
	public String nameValidation(ArrayList<user> users) {
		
		String m = null ;
		boolean n = true ;
		
		while ( true ) {
			n = false ;
			m = input.next();
			for ( int i = 0 ; i < users.size() ; i++ ) {
				if (m.equals(users.get(i).getName())) {
					System.out.println(m + " is already used .");
					System.out.println("please enter name again .");
					n = true ;
				}
			}
			if (n) {
				continue ;
			}
			break ;
		}
		return m ;
		
	}
	
	public void emailValidation(ArrayList<user> users) {
		
		boolean n = true ;
		String email = input.next();
		
		for (int i = 0 ; i < users.size(); i ++) {
			user user = users.get(i);
			if(email.equals(user.getEmail())) {
				System.out.println("this email is already used .");
				System.out.println("please enter email again ");
				email = input.next();
			}
		}
	}
	
	public int numberValidation() {
		
		boolean n = true ;
		int number = 0 ;
	
		while (n == true) {
		
			try {
				number = input.nextInt();
				n = false ;
			}
			catch( InputMismatchException ex) {
				System.out.println("please enter a valid number :");
				input.nextLine() ;
			}
		}
		return number ;
	}
}
