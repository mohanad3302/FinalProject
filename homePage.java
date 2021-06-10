
public class homePage {
	public homePage() {
		
	}
	public void printHomePage(user o) {
		
		for (int i= 0; i < o.getFriends().size(); i++ ) {
			
			user user = o.getFriends().get(i);
		     
			for(int y = 0 ; y < user.getUserPosts().size(); y++) {
		    	 
		    	 post post = user.getUserPosts().get(y);
		    	 
		    	 for ( int x = 0 ; x < user.getPrivacyList().size() ; x++) {
		    	
		    		 if ( o.equals(user.getPrivacyList().get(x))) {
		    			 System.out.println(user.getName() + " : ");
		    			 post.printPost(o);
		    		 }
		    	 }
		     }
		}
		
		for (int i2 = 0; i2 < o.getUserGroups().size(); i2++ ) {
			
			group group = o.getUserGroups().get(i2);
		    
			for(int y = 0 ; y < group.getGroupPosts().size(); y++) {
		    	post post = group.getGroupPosts().get(y) ;
		    	System.out.println(post.getCreator().getName() + " from " + group.getGroupName() + " : ");
		    	 post.printPost(o);
		     }
		}
		
		
		for (int i3 = 0; i3 < o.getUserPages().size(); i3++ ) {
			
			page page = o.getUserPages().get(i3);
		    
			for(int y = 0 ; y < page.getPagePosts().size(); y++) {
		    	 post post = page.getPagePosts().get(y);
		    	 System.out.println(post.getCreator().getName() + " from " + page.getPageName() + " : ");
		    	 post.printPost(o);
		     }
		}
	}
}
