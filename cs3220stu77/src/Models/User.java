package Models;

public class User {
	
	private static int count = 0;
	
	int id;
	String first, last;
	
	public User(String first, String last) {
		this.id = count++;
		this.first = first;
		this.last = last;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public int getId() {
		return id;
	}
	
	
	
	
}
