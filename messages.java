import java.util.* ;

public class messages extends user{
	private Date date;
	private ArrayList<String> message  = new ArrayList<>();
	private user name1;
	private user name2;
	
	
	public user getName1() {
		return name1;
	}
	public void setName1(user name1) {
		this.name1 = name1;
	}
	public user getName2() {
		return name2;
	}
	public void setName2(user name2) {
		this.name2 = name2;
	}
	public messages() {
		
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public ArrayList<String> getMassage() {
		return message;
	}
	public void setMassage(String message) {
		this.message.add(message);
	}
	public messages(Date date , String message) {
		
	}
	
	public void sendMessage(user x, user o)	{
		if (x == null ) {
			System.out.println("couldn't find user you are searching for ");		
		}
		else {
			date = new Date();
			System.out.println("enter message : (enter end to finish )");
			Scanner input = new Scanner(System.in);
			while (true) {
				String s1 = input.next();
				
				if (s1.equals("end")) {
					break;
				}
				message.add(s1);
			}
		}
		notifications y = new notifications() ;
		String notification = o.getName() + "sent you a message ." ;
		Date messageDate = new Date() ;
		y.messageNotification(notification , messageDate);
	}
	public void reciveMessage(user sender ,user reciver , messages o) {
		sender.setMessages(o);
		reciver.setMessages(o);
	}
	public void printMessage() {
		for (int i = 0 ; i < message.size() ; i++) {
			System.out.println(message.get(i)+" ");
			int x = 15 ;
			if(i == x ) {
				System.out.println();
				x += 15 ;
			}
		}
	}
}