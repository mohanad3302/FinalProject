import java.util.*;
public class post extends user{
	private Date date;
	private ArrayList<String> text = new ArrayList<>();
	private user creator ;
	private ArrayList<String> comment = new ArrayList<>();
	private ArrayList<ArrayList<String>> allComments = new ArrayList<>();
	private ArrayList<user> commentCreator = new ArrayList<>();
	private int like = 0  ;
	Scanner input = new Scanner(System.in);
	
	public post() {
	
	}
	public post(Date date, user creator) {
		this.date=date ;
		this.creator = creator ;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public ArrayList<String> getText() {
		return text;
	}
	public void setText() {
		System.out.println("enter text of post : (enter end when you finish )");
		
		while (true) {
			String s1 = input.next();
			
			if (s1.equals("end")) {
				break;
			}
			text.add(s1);
		}
	}
	public user getCreator() {
		return creator;
	}
	public void setCreator(user creator) {
		this.creator = creator;
	}
	public int GetLike() {
		return like ;
	}
	public ArrayList<ArrayList<String>> getAllComment () {
		return allComments ;
	}
	public post share(post o, Date date) {
		
	return o;
	}
	public void like() {
		this.like += 1 ;
	}
	public void comment( user o) {
		
		while (true) {
			String s1 = input.next();
			
			if (s1.equals("end")) {
				break;
			}
			comment.add(s1);
		}
		allComments.add(comment);
		this.commentCreator.add(o);
	}
	public void printComment(ArrayList<String> comment) {
		for (int i = 0 ; i < comment.size() ; i++) {
			System.out.print(comment.get(i)+" ");
			int x = 15 ;
			if(i == x ) {
				System.out.println();
				x += 15 ;
			}
		}
		System.out.println();
	}
	public void printPost( user o) {
		
		System.out.println(date);
		for (int i = 0 ; i < text.size() ; i++) {		
			System.out.print(text.get(i)+" ");
			int x = 15 ;
			if(i == x ) {
				System.out.println();
				x += 15 ;
			}
		}
		System.out.println("likes :" + like);
		System.out.println();
		System.out.println("comments : " );
		System.out.println();
		
		for ( int x = 0 ; x < allComments.size() ; x++) {
			System.out.print(commentCreator.get(x).getName() + " : ");
			printComment(allComments.get(x));
			System.out.println("----------------------------------------------------------");
		}
		while(true) {
			System.out.println("to like press 1 .");
			System.out.println("to comment press 2 .");
			System.out.println("to continue seeing posts press 3 .");
			signup signup = new signup();
			int d = signup.numberValidation();
			
			if(d == 1) {
				like += 1 ;
				Date likeDate = new Date();
				String notification = o.getName() + "like your post ." ;
				notifications x = new notifications();
				x.likeNotification(notification , likeDate);
				creator.setNotifications(x);
			}
			
			else if(d == 2) {
				Date commentDate = new Date();
				System.out.println("enter comment : ");
				comment(o);
				String notification = o.getName() + "commented on your post .";
				notifications x = new notifications() ;
				x.commentNotification(notification , commentDate);
				creator.setNotifications(x);
			}
			
			else if(d == 3) {
				break ;
			}
		}
		
	}
	public void createPost(user o) {
		System.out.println("enter 1 to make your post private .");
		System.out.println("enter 2 to make your post public .");
		signup signup = new signup();
		int n = signup.numberValidation();
		
		if (n == 2) {
			Date postDate = new Date() ;
			post post = new post(postDate , o);
			post.setText();
			o.setUserPosts(post);
		}
		else if ( n == 1) {
			Date postDate = new Date() ;
			post post = new post(postDate , o);
			post.setText();
			o.setPrivatePosts(post);
		}
	}
}
