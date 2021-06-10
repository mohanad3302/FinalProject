import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.* ;

public abstract class system extends main implements Serializable {
	
	
	public system() {
		
	}
	
	public  ArrayList<user> getUsers() {
		return users;
	}

	public  void setUsers(user o) {
		users.add(o);
	}
	public void setUsers(ArrayList<user> o){
		for ( int i = 0  ; i < o.size() ; i ++ ){
			users.add(o.get(i));
		}
	}

	public  ArrayList<post> getPosts() {
		return posts;
	}

	public void setPosts(post o) {
		posts.add(o);
	}

	public  ArrayList<group> getGroups() {
		return groups;
	}

	public  void setGroups(group o ) {
		groups.add(o) ;
	}
	public  void setGroups(ArrayList<group> o ) {
		groups = o ;
	}

	public  ArrayList<messages> getMessage() {
		return message;
	}

	public  void setMessage(messages o) {
		message.add(o);
	}

	public  ArrayList<page> getPages() {
		return pages;
	}

	public  void setPages(page o) {
		pages.add(o);
	}
	public  void setPages(ArrayList<page> o) {
		pages = o ;
	}

	public  group searchForGroup (String groupName){
		group x = null ;
		for (int i = 0 ; i < groups.size() ;i++ ) {
			int count = 0 ;
			if (groupName.equals(groups.get(i).getGroupName())) {
				x = groups.get(i);
				break ;
			}
			else {
				count ++;
			}
			if (count == groups.size()) {
				x = null ;
			}
		}
		return x ;
	}
	public   user searchForUser (String userName){
		user x= null ;
		for (int i = 0 ; i < users.size() ;i++ ) {
			int count = 0 ;
			if (userName.equals(users.get(i).getName())) {
				x= users.get(i);
				break ;
			}
			else {
				count ++;
			}
			if (count == groups.size()) {
				x = null ;
			}
		}
		return x ;
	}
	public  page searchForPage (String pageName){
		page x = null ;
		for (int i = 0 ; i < groups.size() ;i++ ) {
			int count = 0 ;
			if (pageName.equals(pages.get(i).getPageName())) {
				x = pages.get(i);
				break ;
			}
			else {
				count ++;
			}
			if (count == pages.size()) {
				x = null ;
			}
		}
		return x ;
	}
	public  void searchForWord(String word , user o){
		for (int i = 0; i < o.getFriends().size(); i++ ) {
			user user = o.getFriends().get(i);
			for(int x = 0 ; x < user.getUserPosts().size(); x++){
				post post = user.getUserPosts().get(x);
				for (int y =0 ; y <post.getText().size() ; y++) {
					if (word.equals(post.getText().get(y))) {
						System.out.println(user.getName() + " : ");
						post.printPost(o);
					}
					else {
						break;
					}
				}
			 }
		}
		for (int i2 = 0; i2 < o.getUserGroups().size(); i2++ ) {
			group group = o.getUserGroups().get(i2);
			 for(int x = 0 ; x <  group.getGroupPosts().size(); x++) {
				 post post = group.getGroupPosts().get(x);
				 for (int y = 0 ; y < post.getText().size() ; y++ ) {
					 if(word.equals(post.getText().get(y))) {
						 System.out.println(post.getCreator().getName() + " from " + group.getGroupName() + " : ");
						 post.printPost(o);
					 }
				 }
			 }
		}
		for ( int i3 = 0 ; i3 < o.getUserPages().size() ; i3 ++ ) {
			page page  = o.getUserPages().get(i3);
			for ( int t = 0 ; t < page.getPagePosts().size() ; t++) {
				post post = page.getPagePosts().get(t);
				for (int p = 0 ; p < post.getText().size(); p ++) {
					if ( word.equals(post.getText().get(p))) {
						System.out.println(post.getCreator().getName() + " from " + page.getPageName() + " : ");
						post.printPost(o);
					}
				}
			}
		}
	}
	public void serializeUser(){
		try{
			FileOutputStream file = new FileOutputStream("G:\\finalproject\\users\\user.ser");
			ObjectOutputStream usersFile = new ObjectOutputStream(file);
			usersFile.writeObject(users);
			usersFile.close();
			file.close();
		}
		catch(FileNotFoundException x){
			System.out.println("file not found");
		}
		catch(IOException x){
			x.printStackTrace();
		}
	}
	public  void serializePage(){
		try{
			FileOutputStream file = new FileOutputStream("G:\\finalproject\\pages\\page.ser");
			ObjectOutputStream pageFile  = new ObjectOutputStream(file);
			pageFile.writeObject(pages);
			pageFile.close();
			file.close();
		}
		catch(FileNotFoundException x){
			System.out.println("file not found");
		}
		catch(IOException x){
			x.printStackTrace();
			
		}
	}
	public  void serializeGroup(){
		try {
			FileOutputStream file = new FileOutputStream("G:\\finalproject\\groups\\group.ser");
			ObjectOutputStream groupFile = new ObjectOutputStream(file);
			groupFile.writeObject(groups);
			groupFile.close();
			file.close();
		} catch (IOException x) {
			x.printStackTrace();
			System.out.println("file not found .");
		}
	}
	public void deserlizeUser(){
        try{
            FileInputStream File = new FileInputStream("G:\\finalproject\\users\\user.ser");
            ObjectInputStream user = new ObjectInputStream(File);
            
            users = (ArrayList) user.readObject();
            user.close();
            File.close();

        }
        catch(IOException x){
            x.printStackTrace();
        }
        catch (ClassNotFoundException x) 
        {
            System.out.println("Class not found");
            x.printStackTrace();
        }
    }
	public void deserlizePage(){
        try{
            FileInputStream File = new FileInputStream("G:\\finalproject\\pages\\page.ser");
            ObjectInputStream page = new ObjectInputStream(File);
            
            pages = (ArrayList<page>) page.readObject();
            page.close();
            File.close();

        }
        catch(IOException x){
            x.printStackTrace();
        }
        catch (ClassNotFoundException x) 
        {
            System.out.println("Class not found");
            x.printStackTrace();
        }
    }
	public void deserlizeGroup(){
        try{
            FileInputStream File = new FileInputStream("G:\\finalproject\\Groups\\group.ser");
            ObjectInputStream group = new ObjectInputStream(File);
            
            groups = (ArrayList<group>)group.readObject();
            group.close();
            File.close();

        }
        catch(IOException x){
            x.printStackTrace();
        }
        catch (ClassNotFoundException x) 
        {
            System.out.println("Class not found");
            x.printStackTrace();
        }
    }
	
}


