import java.util.*;
public class profile {
	
	Scanner input = new Scanner (System.in);
	
	public profile () {
		
	}
	
	public void printProfile(user o) {
	
		System.out.println("name : " + o.getName());
		System.out.println();
		System.out.println("phone nember : "+o.getPhoneNumber());
		System.out.println();
		System.out.println("age  : " +o.getAge() );
		System.out.println();
		System.out.println("addres  : " +o.getAddress() );
		System.out.println();
		System.out.println("work : " +o.getWork() );
		System.out.println();
		System.out.println("education : " +o.getEducation() );
		
		System.out.println("enter 1 to see your posts .");
		System.out.println("enter 2 to see your groups .");
		System.out.println("enter 3 to see your pages .");
		System.out.println("enter 4 to see your friends .");
		System.out.println("enter 5 to exit .");
		
		signup signup = new signup();
		int n = signup.numberValidation();
		
		if ( n == 1) {
			if ( o.getUserPosts().size() == 0 ) {
				System.out.println("there are no posts created .");
			}
			else if (o.getUserPosts().size() > 0) {
				for ( int v = 0 ; v < o.getUserPosts().size(); v++) {
				o.getUserPosts().get(v).printPost(o);
				}	
			}
		}
		else if ( n == 2) {
			groupView groupView = new groupView();
			group group = groupView.viewGroups(o);
			groupView.printGroup(o, group);
		}
		else if(n == 3) {
			pageView pageView = new pageView();
			page page = pageView.viewPages(o);
			pageView.printPage(o, page);
		}
		else if (n == 4 ) {
			for ( int i = 0 ; i < o.getFriends().size() ; i ++) {
				user friend = o.getFriends().get(i);
				System.out.println((i+1) + " - " + friend.getName());
				System.out.println("enter number of friend to see his profile or enter 0 to exit .");
				if ( n > 0 ) {
					friend = o.getFriends().get(n-1);
					friendProfile(friend);
				}
			}
		}
	}
	public void friendProfile(user o) {

		System.out.println("name : " + o.getName());
		System.out.println();
		System.out.println("phone nember : "+o.getPhoneNumber());
		System.out.println();
		System.out.println("age  : " +o.getAge() );
		System.out.println();
		System.out.println("addres  : " +o.getAddress() );
		System.out.println();
		System.out.println("work : " +o.getWork() );
		System.out.println();
		System.out.println("education : " +o.getEducation() );
		System.out.println();
		
		if (o.getUserPosts().size() == 0 ) {
			System.out.println("there are no posts created .");
		}
		else if (o.getUserPosts().size() > 0) {
			if ( o.getUserPosts().size() == 0 ) {
				System.out.println("there are no posts created .");
			}
			else if (o.getUserPosts().size() > 0) {
				for ( int v = 0 ; v < o.getUserPosts().size(); v++) {
				o.getUserPosts().get(v).printPost(o);
				}	
			}
		}
	}
}
