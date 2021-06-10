import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner; 

public class group extends user {
	
	private String Groupname ;
	private Date date ;
	private ArrayList<user> members = new ArrayList<>();
	private ArrayList<String> description = new ArrayList<>() ;
	private ArrayList<post> posts = new ArrayList<>();
	private user admin ;
	Scanner input = new Scanner(System.in);
	
public group () {
		
	}
	public group(String groupname, Date date,user admin ) {
		this.Groupname = groupname;
		this.admin = admin;
		this.date = date;
	}
	
	public ArrayList<user> getMembers() {
		return members;
	}
	public void setMembers(user o) {
		this.members.add(o);
	}
	public ArrayList<post> getGroupPosts() {
		return posts;
	}
	public void setGroupPosts(post o) {
		this.posts.add(o);
	}
	public user getAdmin() {
		return admin;
	}
	public void setAdmins(user admin) {
		this.admin = admin ;
	}
	public String getGroupName() {
		return Groupname;
	}
	public void setGroupname(String groupname) {
		Groupname = groupname;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	} 
	public ArrayList<String> getDescription() {
		return description;
	}
	public void setDescription() {
		while (true) {
			String s1 = input.next();
			
			if (s1.equals("end")) {
				break;
			}
			description.add(s1);
		}
	}
	public void printDescription() {
		System.out.println("description : ");
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
	public void invite (String userName) {
		
	}
}