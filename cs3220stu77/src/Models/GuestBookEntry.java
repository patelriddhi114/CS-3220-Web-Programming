package Models;

import java.util.Date;

public class GuestBookEntry {

	static int count=0;
	
	
	int id;
	String name;
	String message;
	String address;
	Date created;
	
	public GuestBookEntry()
	{
		created = new Date();
	}
	public GuestBookEntry(int id,String name,String message)
	{
		this.id = id;
		this.name=name;
		this.message=message;
		this.created=new Date();
	}
	public GuestBookEntry(String name,String message)
	{
		super();
		this.name=name;
		this.message=message;
		this.created = new Date();
		this.id = count++;
	}
	
	public int getId()
	{
		return id;
	}
	public Date getCreated()
	{
		return created;
		
	}
	public void setCreated(Date created)
	{
		this.created=created;
	}
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name=name;
		
	}
	public String getMessage()
	{
		return message;
	}
	public void setMessage(String message)
	{
		this.message=message;
		
	}
}
