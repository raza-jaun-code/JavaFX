import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class UserController {
	private ArrayList<User> users;
	private File file;
	
	public UserController(){
		users= new ArrayList<>();
		file= new File("users.bin");
		if(file.exists()){
			readUsers();
		}
	}

	@SuppressWarnings("unchecked")
	private void readUsers() {
		try{
			FileInputStream fis= new FileInputStream(file);
			ObjectInputStream ois= new ObjectInputStream(fis);
			users=(ArrayList<User>)ois.readObject();
			fis.close();
			ois.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	
	private void writeUsers(){
		try{
			FileOutputStream fos= new FileOutputStream(file);
			ObjectOutputStream oos= new ObjectOutputStream(fos);
			oos.writeObject(users);
			oos.close();
			fos.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	public void addUser(User u){
		this.users.add(u);
		writeUsers();
	}
	
	public void delete(User u) {
		this.users.remove(positionOfUser(u));
		writeUsers();
	}
	
	public boolean signUp(String firstName, String lastName, String username, String password,String verifyPassword,
			String phone, String profession, String salary){
		if(password.equals(verifyPassword)){
			User u = new User(firstName, lastName, username, password, phone,profession ,salary);
			this.addUser(u);
			writeUsers();
			return true;
		}
		return false;
	}
		
	public ArrayList<User> getUsers(){
		return this.users;
	}
	
	public void editUser(User updatedUser, int index){
		this.users.set(index, updatedUser);
		writeUsers();
	}
	
	public int positionOfUser(User currentUser) {
		for(int i=0 ; i<this.users.size(); i++) {
			if(currentUser.getUsername().equals(this.users.get(i).getUsername())){
				return i;
			}
		}
		return -1;
	}

}
	
	
	
	
	
