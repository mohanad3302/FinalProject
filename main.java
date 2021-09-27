import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.io.Serializable;


public class main implements Serializable {


	public static void main(String[] args) {

		
		ArrayList<user> users = new ArrayList<>();
		ArrayList<group> groups = new ArrayList<>() ;
		ArrayList<messages> messages = new ArrayList<>();
		ArrayList<page> pages = new ArrayList<>() ;
		
		user user1 = new user("mohanad", "a", 12, "alexandria", 18, "aiu", "student", "Mohanad");
		users.add(user1);
		user user2 = new user("mohamed", "a", 12, "alexandria", 18, "aiu", "student", "Mohamed");
		users.add(user2);

		Scanner input = new Scanner(System.in) ;
		int y = 0; 
	


		while (y != -1) {
			System.out.println("enter 1 to signup") ;
			System.out.println("enter 2 to signin");
			System.out.println("enter -1 to close program");
			signup signup = new signup();
			y = signup.numberValidation() ;
			if (y == 1) { 
				signup.signUp(users);
				

			}
			else if (y == 2) {
				signin signin = new signin();
				user o = signin.siginIn(users);
					if(o != null){
						int x= 0 ;
						while(x != 15) {
							System.out.println("enter 1 to see Home Page  .");
							System.out.println("enter 2 to Addfriend .");
							System.out.println("enter 3 to join group .");
							System.out.println("enter 4 to join page .");
							System.out.println("enter 5 to create post .");
							System.out.println("enter 6 to see profile .");
							System.out.println("enter 7 to see notifications.");
							System.out.println("enter 8 to creat a page .");
							System.out.println("enter 9 to create a group .");
							System.out.println("enter 10 to see your Groups .");
							System.out.println("enter 11 to see your pages .");
							System.out.println("enter 12 to see a search word in posts .");
							System.out.println("enter 13 to follow a user .");
							System.out.println("enter 14 to see your chat .");
							System.out.println("enter 15 to logout .");
							x = signup.numberValidation();
							
							switch (x) {
							
							// print home page 
								case 1 :
									homePage homePage = new homePage();
									homePage.printHomePage(o);
									break;
							
									// to add friends
									
								case 2:
									System.out.print("enter name of user you want to search for : ");
									String UserName = input.next();
									o.AddFriends(UserName , o , users);
									break;
									
									// to join groups
									
								case 3 :
									System.out.print("enter name of group you want to join : ");
									String GroupName = input.next();
									o.joinGroup(GroupName , groups);
									break;
									
									// to join pages
									
								case 4 :
									System.out.print("enter name of page you want to join : " ) ;
									String pageName = input.next();
									o.joinPage(pageName , pages);
									break;
									
									// to create post
									
								case 5 : 
									post post = new post();
									post.createPost(o);
									break;
									
									// to see your profile
									
								case 6 :
									profile profile = new profile();
									profile.printProfile(o);
									
									break;
									
									// to see notifications
									
								case 7 :
									viewNotifications notifications = new viewNotifications();
									notifications.printNotification(o);
									break;
									
									// to create a page
									
								case 8 : 
									Date pageDate = new Date();
									System.out.print("page name : ");
									String PageName = input.next();
									page page = new page(PageName , pageDate , o ) ;
									System.out.println("description : (enter end to finish)");
									page.setDescription();
									pages.add(page);
									o.SetUserPages(page);
									break;
									
									// to create a group 
									
								case 9 :
									Date GroupDate = new Date();
									System.out.print("GroupName : ");
									String groupName = input.next();
									group group = new group(groupName , GroupDate , o);
									System.out.println("description : (enter end to finish)");
									group.setDescription();
									o.setUserGroups(group);
									o.setUserGroups(group);
									groups.add(group);
									break;
									
									// to see all of your groups and enter one of them
								
								case 10 :
										groupView groupView = new groupView();
										group Group =groupView.viewGroups(o);
										groupView.printGroup(o, Group);
										break;
										
										// to see all of your pages and enter one of them
										
								case 11 : 
										pageView pageView = new pageView();
										page = pageView.viewPages(o);
										pageView.printPage(o , page );
										break;
										
										// to search for a word through posts
										
								case 12 :
									System.out.println("enter word you want to search for : ");
									String word = input.next();
									
									break;

									// to follow a user 
									
								case 13 : 
									System.out.print("enter name of user you want to follow : ");
									UserName = input.next();
									o.followUser(UserName , users);
									break;
									
									// to send messages to a user 
									
								case 14 :
									System.out.print("enter name of user you want to see your chat with : ");
									String Name = input.next();
									user reciver = system.searchForUser( Name , users);
									if(reciver==null) {
										System.out.println("cant found ");
									}else {
										messages m=new messages();
										System.out.println("enter text >");
										m.sendMessage(reciver, o);
										
										m.setName1(o);
										m.setName2(reciver);
										o.setMessages(m);
										reciver.setMessages(m);
										
									
									}
									break;
									
								case 17:
									System.out.print("enter name user you see chat : ");
									String Name1 = input.next();
									user reciver1 = system.searchForUser(Name1 , users);
									if(reciver1==null) {
										System.out.println("cant found ");
									}
									else {
										
										ArrayList<messages>  k=o.getMessages();
										messages p=null; 
										for(int i8=0 ; i8<k.size() ; i8++) {
											
											if(k.get(i8).getName1().equals(o) && k.get(i8).getName2().equals(reciver1) || k.get(i8).getName1().equals(reciver1) && k.get(i8).getName2().equals(o) ){
												p= k.get(i8);
												break;
											}
											
										 }
										 
										 if(p==null) {
										      System.out.println("no chat ");
											 
											 
										 }else {
											 p.printMessage();

										 }									
									}	
							}	
						}
						
					}
				}
			}
		}
		

	

}
