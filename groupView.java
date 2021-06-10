import java.util.*;

public class groupView {
	Scanner input = new Scanner(System.in);
	
	public groupView() {
		
	}
	public group viewGroups(user o) {
		
		for (int i = 0 ; i < o.getUserGroups().size() ; i ++ ) {
			group group = o.getUserGroups().get(i);
			System.out.println((i + 1) + " - " + group.getGroupName());
		}
		
		System.out.println("please enter number of group you want to enter .");
		signup signup = new signup();
		int n = signup.numberValidation();
		group group = o.getUserGroups().get(n-1);
		
		return group ;
	}
	public void printGroup(user o , group group) {
		
		System.out.println("press 1 to creat a post inside of group .");
		System.out.println("press 2 to see Group");
		System.out.println("press 3 to invite a friend");
		
		signup signup = new signup();
		int y = signup.numberValidation();
		
		if (y == 1) {
			Date GroupPostDate = new Date() ;
			System.out.print("enter text of post then enter edn to finish : ");
			post groupPost = new post( GroupPostDate , o);
			groupPost.setText();
			group.setGroupPosts(groupPost);
		}
		
		else if ( y == 2 ){
			System.out.println("name : " + group.getGroupName());
			System.out.println();
			System.out.println("admin : " +group.getAdmin().getName());
			System.out.println();
			
			group.printDescription();
			
			if(group.getGroupPosts().size() == 0) {
				System.out.println("there are no posts created .");
			}
			else if (group.getGroupPosts().size() > 0) {
				for (int i = 0 ; i < group.getGroupPosts().size() ; i++) {
					
						post post = group.getGroupPosts().get(i);
						System.out.println("creted by : " + post.getCreator().getName());
						System.out.println();
						System.out.println("date : " + post.getDate());
						System.out.println();
						post.printPost(o);
						System.out.println("--------------------------------------------------------------------");
				}			
			}
		}
		
		else if (y == 3) {
			System.out.print("enter name of friend you want to invite :");
			String Name = input.next();
			user friend = o.searchForFriend(Name);
			if (friend == null ) {
				System.out.println("this user is not in your friends .");
			}
			else {
				Date inviteDate = new Date();
				String notification  = o.getName() + "invited you to this group";
				notifications x1 = new notifications();
				x1.inviteNotification(notification , inviteDate);	
				friend.setInviteNotifications(x1);
			}
		}
		
	}
}
