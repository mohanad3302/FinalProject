import java.util.Date ;
public class notifications extends user {
	private String text;
	private Date date;
	private user sender ; 
	public notifications() {
		
	}
	public user getSender() {
		return sender;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void messageNotification(String notification , Date date) {
		text = notification ;
		this.date = date ;
	} 
	
	public void commentNotification(String comment , Date date) {
		text = comment ;
		this.date = date ;
	} 
	public void likeNotification(String notification , Date date) {
		text = notification ;
		this.date =date ;
	} 
	public void inviteNotification(String notification , Date date  ) {
		text = notification ;
		this.date = date ;
	} 
	public void requestNotification( String notification , Date date , user sender) {
			text = notification;
			this.date = date ;
			this.sender = sender ;
	}	
	public void followNotification(String notification , Date date ) {
		text = notification ;
		this.date = date ;
	}
}
