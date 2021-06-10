import java.util.*;

public class page extends user {
	private String pageName ;
	private Date date ;
	private ArrayList<user> memmbers = new ArrayList<>();
	private user Admin ;
	private ArrayList<post> pagePosts = new ArrayList<>();
	private ArrayList<String> description = new ArrayList<>();
	
	public page () {
		
	}
	public page(String pageName, Date date, user admin) {
		this.pageName = pageName;
		this.date = date;
		this.Admin = admin;
	}
	public String getPageName() {
		return pageName;
	}
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public ArrayList<user> getMemmbers() {
		return memmbers;
	}
	public void setMemmbers(user o) {
		memmbers.add(o);
	}
	public user getAdmin() {
		return Admin;
	}
	public void setAdmin(user admin) {
		Admin = admin;
	}
	public void setPagePosts(post o) {
		pagePosts.add(o);
	}
	public ArrayList<post> getPagePosts() {
		return pagePosts ;
	}
	public void setDescription() {
		Scanner input = new Scanner(System.in);
		while (true) {
			String s1 = input.next();
			
			if (s1.equals("end")) {
				break;
			}
			description.add(s1);
		}
	}
	public void printDescription() {
		
		for (int i = 0 ; i < description.size() ; i++) {
			System.out.print(description.get(i)+" ");
			int x = 15 ;
			if(i == x ) {
				System.out.println();
				x += 15 ;
			}
		}
		System.out.println();
	}
}
