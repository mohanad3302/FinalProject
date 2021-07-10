import java.util.*;
public class pageView {
	
	Scanner input = new Scanner( System.in);
	
	public pageView() {
		
	}
	
	
	public page viewPages(user o) {
		page page = null ;
		if ( o.getUserPages().size() != 0 ){
			for (int i = 0 ; i < o.getUserPages().size() ; i ++ ) {
				page = o.getUserPages().get(i);
				System.out.println((i + 1) +" - " + page.getPageName());
			}
			
			System.out.println("please enter number of page you want to enter .");
			signup signup = new signup();
			int n = signup.numberValidation();
			page = o.getUserPages().get(n-1);
		}
		return page ;
	}
	
	
	public void printPage( user o ,page page ) {
		if ( page != null ){
			System.out.println("enter 1 to creat a post inside of page .");
			System.out.println("enter 2 to see page .");
			System.out.println("enter 3 to close page .");
			
			boolean x = true ;
			
			while(x == true ) {
				
				signup signup = new signup() ;
				int n = signup.numberValidation();
				
				if (n == 1) {
					if (o == page.getAdmin()) {
					Date PagePostDate = new Date() ;
					post PagePost = new post( PagePostDate , o);
					PagePost.setText();
					page.setPagePosts(PagePost);
					}
					else {
						System.out.println("only admins can create posts on page .");
					}
				}
				
				else if ( n == 2 ){
					System.out.println("name :" + page.getPageName());
					System.out.println("admin : " +page.getAdmin().getName());
					System.out.println("description : ");
					
					page.printDescription();
					
					if ( page.getPagePosts().size() == 0) {
						System.out.println("there are no post created .");
					}
					else if (page.getPagePosts().size() > 0) {
						for (int i = 0 ; i < page.getPagePosts().size() ; i++) {
							post post = page.getPagePosts().get(i);
							System.out.println("creted by : " + post.getCreator().getName());
							System.out.println("date : " + post.getDate());
							post.printPost(o);
							System.out.println("--------------------------------------------------------------------");
						}
					}
				}
				
				else if ( n == 3) {
					x = false ;
				}
			}
		}
	}
}
