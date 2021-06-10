import java.util.*;

public class user extends system {
	
	private String name ;
	private String password ;
	private String email ;
	private int phoneNumber;
	private String address ;
	private int age ;
	private String education ;
	private String work ;
	private ArrayList<user> friends = new ArrayList<>();
	private ArrayList<post> userPosts = new ArrayList<>();
	private ArrayList<post> privatePosts = new ArrayList<>();
	private ArrayList<group> userGroups = new ArrayList<>();
	private ArrayList<page> userPages = new ArrayList<>();
	private ArrayList<notifications> notifications = new ArrayList<>();
	private ArrayList<notifications> requestNotifications = new ArrayList<>();
	private ArrayList<notifications> inviteNotifications = new ArrayList<>();
	private ArrayList<user> privacyList = new ArrayList<>();
	private ArrayList<messages> messages = new ArrayList<>();
	private ArrayList<user> following = new ArrayList<>();
	Scanner input = new Scanner(System.in);
	
	public user () {
		
	}
	
	public user (String name , String email , int phoneNumber , String address , int age , String education , String work , String password){
	
		this.name = name ;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber ;
		this.age = age ;
		this.education = education ;
		this.work = work ;
		this.password = password ;
	
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword (){
		return password ;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
	}
	
	public ArrayList<user> getFriends() {
		return friends;
	}
	public void setFriends (user friend) {
		friends.add(friend);
	}
	
	public void setPrivacyList(user o){
		privacyList.add(o) ;
	}
	public ArrayList<user>  getPrivacyList(){
		return privacyList ;
	}
	
	public ArrayList<post> getUserPosts(){
		return userPosts ;
	}
	public void setUserPosts(post o ) {
		userPosts.add(o) ;
	}
	
	public ArrayList<notifications> getNotifications() {
		return notifications ;
	}
	public void setNotifications(notifications o) {
		notifications.add(o);
	}
	
	public void setRequestNotification(notifications o) {
		requestNotifications.add(o);
	}
	public ArrayList<notifications> getRequestNotification(){
		return requestNotifications ;
	}
	
	public void setInviteNotifications(notifications o){
		inviteNotifications.add(o);
	}
	public ArrayList<notifications> getInviteNotifications(){
		return inviteNotifications;
	}
	
	public ArrayList<group> getUserGroups(){
		return userGroups ;
	}
	public void setUserGroups(group o) {
		userGroups.add(o);
	}
	
	public ArrayList<page> getUserPages(){
		return userPages ;
	}
	public void SetUserPages(page o) {
		userPages.add(o);
	}
	
	public ArrayList<messages> getMessages(){
		return messages ;
	}
	public void setMessages (messages  o) {
		messages.add(o);
	}
	
	public void setPrivatePosts(post o) {
		privatePosts.add(o);
	}
	public ArrayList<post> getPrivatePosts(){
		return privatePosts ;
	}
	
	public void joinGroup (String groupName , ArrayList<group> groups) {

		group x = searchForGroup(groupName , groups );
		
		if(x == null) {
			System.out.println("you are searching for a group that don't exist");
		}
		else {
			System.out.println("do you want to join this group ( " + x.getGroupName() + " )");
			System.out.println("please enter Y to join group or N to cancel");
			char answer = input.next().charAt(0);
			if (answer =='Y' || answer =='y') {
				userGroups.add(x) ;
			}
		}
	}
	public void leaveGroup (String groupName , ArrayList<group> groups ) {
		
		group x = searchForGroup(groupName , groups);
		if (x == null ) {
			System.out.println("you are not a member of this group");
		}
		else {
			System.out.println("Do you want to leave this group ( " +x.getGroupName()+ " )");
			System.out.println("please enter Y to leave group or N to cancel");
			char answer = input.next().charAt(0);
			if (answer == 'y' ||answer == 'Y') {
				userGroups.remove(x);
			}
		}
	}
	public void joinPage (String pageName , ArrayList<page> pages ) {

		page x = searchForPage(pageName , pages );
		if(x == null) {
			System.out.println("you are searching for a page that don't exist");
		}
		else {
			System.out.println("do you want to join this page ( " + x.getPageName() + " )");
			System.out.println("please enter Y to join page or N to cancel");
			char answer = input.next().charAt(0);
			if (answer =='Y' || answer =='y') {
				userPages.add(x) ;
			}
		}
	}
	public void leavePage (String pageName , ArrayList<page> pages ) {

		page x = searchForPage(pageName , pages);
		if (x == null ) {
			System.out.println("you are not a member of this page");
		}
		else {
			System.out.println("Do you want to leave this group ( " +x.getPageName()+ " )");
			System.out.println("please enter Y to leave page or N to cancel");
			char answer = input.next().charAt(0);
			if (answer == 'y' ||answer == 'Y') {
				userPages.remove(x);
			}
		}
	}
	public void privacylist (String userName){
		
		for(int i = 0 ; i < friends.size(); i ++) {
			if (userName.equals(friends.get(i).getName())) {
				System.out.println("do you want to add " + friends.get(i).getName());
				System.out.println("please enter Y to add and N to cancel");
				char answer = input.next().charAt(0);
				if ( answer == 'y' || answer == 'Y') {
					privacyList.add(friends.get(i));
					break;
				}
			}
			else {
				System.out.println("couldent find user in your friends");
			}
		}
	}
	public void AddFriends(String userName  ,user o , ArrayList<user> users ) {

		user x = searchForUser(userName , users ) ;
		if (x == null ) {
			System.out.println("couldn't find user you are searching for ");
		}
		else {
			System.out.println("do you want to send a Request to "+ x.getName());
			System.out.println("please enter Y to send request or N to cancel");
			char answer = input.next().charAt(0);
			if (answer == 'y' || answer == 'Y') {
				String notification = o.getName() + "sent you a friend request .";
				Date requestDate = new Date();
				notifications y = new notifications();
				y.requestNotification(notification , requestDate  , o);
				x.setRequestNotification(y);
			}
		}
	}
	public user searchForFriend(String userName) {
		int count = 0 ;
		user x = null ;
		for(int i = 0; i < friends.size() ; i ++) {
			user friend = friends.get(i);
			if (userName.equals(friend.getName())) {
				x = friend ;
				break ;
			}
			else {
				count ++ ;
			}
			if (count == friends.size()) {
				x = null ;
			}
		}
		return x ;
	}
	public void followUser (String userName , ArrayList<user> users) {

		user x = searchForUser(userName , users);
		if(x == null) {
			System.out.println("couldn't find user you are searching for .");
		}
		else {
			System.out.println("do you want to follow " + x.getName());
			System.out.println("please enter Y to send request or N to cancel");
			char answer = input.next().charAt(0);
			if (answer == 'y' || answer == 'Y') {
				String notification = name + "followed you .";
				notifications y = new notifications();
				Date followDate = new Date();
				y.followNotification(notification , followDate);
				following.add(x);
			}
		}

	}
}

