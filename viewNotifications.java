import java.util.*;
public class viewNotifications extends notifications{
	Scanner input = new Scanner(System.in);
	public viewNotifications() {
		
	}
	public void printNotification(user o) {
		System.out.println("enter 1 to see your requests .");
		System.out.println("enter 2 to see your invites .");
		System.out.println("enter 3 to see notifications .");
		signup signup = new signup();
		int n = signup.numberValidation();
		
		if ( n == 1) {
			for (int i = 0 ; i < o.getRequestNotification().size() ; i++) {
				notifications request = o.getRequestNotification().get(i);
				System.out.println(request.getText());
				System.out.println("enter 1 to accept request .");
				System.out.println("enter 2 to see next request .");
				System.out.println("enter 3 to finish");
				int answer = input.nextInt();
				if ( answer == 1 ) {
					o.setFriends(request.getSender());
					request.getSender().setFriends(o);
					o.getRequestNotification().remove(request);
				}
				else if (answer == 2) {
					continue ;
				}
				else if (answer == 3) {
					break;
				}
			}
		}
		else if ( n == 2 ) {
			for (int i = 0 ; i < o.getInviteNotifications().size() ; i++) {
				notifications request = o.getInviteNotifications().get(i);
				System.out.println(request.getText());
				System.out.println("enter 1 to accept request .");
				System.out.println("enter 2 to see next request .");
				System.out.println("enter 3 to finish");
				int answer = input.nextInt();
				if ( answer == 1 ) {
					o.setFriends(request.getSender());
					request.getSender().setFriends(o);
					o.getInviteNotifications().remove(request);
				}
				else if (answer == 2) {
					continue ;
				}
				else if (answer == 3) {
					break;
				}
			}
		}
		
		else if ( n == 3 ) {
			for (int i = 0 ; i < o.getNotifications().size() ; i ++ ) {
				System.out.println(o.getNotifications().get(i));
			}
		}
	}
}
