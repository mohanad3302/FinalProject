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
	
	public static group searchForGroup (String groupName ,ArrayList<group> groups ){
		
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
   public static  user searchForUser (String userName , ArrayList<user> users ){
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
		   if (count == users.size()) {
			   x = null ;
		   }
	   }
	   return x ;
   }
   public static page searchForPage (String pageName , ArrayList<page> pages ){
	   page x = null ;
	   for (int i = 0 ; i < pages.size() ;i++ ) {
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
	public static void serializeUser(ArrayList<user> o ){
		try{
			FileOutputStream file = new FileOutputStream("G:\\finalproject\\users\\user.dat");
			ObjectOutputStream usersFile = new ObjectOutputStream(file);
			usersFile.writeObject(o);
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
	public  static void serializePage(ArrayList<page> o){
		try{
			FileOutputStream file = new FileOutputStream("G:\\finalproject\\pages\\page.dat");
			ObjectOutputStream pageFile  = new ObjectOutputStream(file);
			pageFile.writeObject(o);
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
	public  static void serializeGroup(ArrayList<group> o){
		try {
			FileOutputStream file = new FileOutputStream("G:\\finalproject\\groups\\group.dat");
			ObjectOutputStream groupFile = new ObjectOutputStream(file);
			groupFile.writeObject(o);
			groupFile.close();
			file.close();
		} catch (IOException x) {
			x.printStackTrace();
			System.out.println("file not found .");
		}
	}
	public static void deserlizeUser(ArrayList<user> users){
		try{
            FileInputStream File = new FileInputStream("G:\\finalproject\\users\\user.dat");
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
	public static ArrayList<page> deserlizePage(ArrayList<page> pages){
		try{
            FileInputStream File = new FileInputStream("G:\\finalproject\\pages\\page.dat");
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
		return pages ;
    }
	public static void deserlizeGroup(ArrayList<group> groups){
        
		try{
			
            FileInputStream File = new FileInputStream("G:\\finalproject\\Groups\\group.dat");
            ObjectInputStream group = new ObjectInputStream(File);
            groups =(ArrayList<group>) group.readObject();
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
	public static void NullPointer (Object  o){
		try{
			if ( o == null ){
				NullPointer(o);
			}
		}
		catch(NullPointerException e ){
			System.out.println("");
		}

	}
	
}


