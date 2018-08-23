package Midterm;

public class UserQuotes {

static int count=0;
	
	
	String text,author;
	int id, viewed,liked,disliked;

	public UserQuotes(String text,String author)
	{
		super();
		this.id=count++;
		this.text=text;
		this.author=author;
		viewed = liked = disliked = 0;
	}
	public int getId()
	{
		return id;
	}
	public int getViewed()
	{
		return viewed;
	}
	public void incrementViewed()
	{
		this.viewed++;
	}
	public int getLiked()
	{
		return liked;
	}
	public void incrementLiked()
	{
		this.liked++;
	}
	public int getDisliked()
	{
		return disliked;
	}
	public void incrementDisliked()
	{
		this.disliked++;
	}
	
	public String getText()
	{
		return text;
	}
	
	public String getAuthor()
	{
		return author;
	}
		
}
