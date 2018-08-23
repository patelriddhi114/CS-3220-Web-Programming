package Final;

import java.util.ArrayList;

public class CourseEntry {

	
	int cid;
	int aid;
	String cnumber;
	String cname;
	ArrayList<assignment> assiDescri;
	
	public CourseEntry()
	{
		
	}
	public CourseEntry(int cid, String cnumber, String cname) {
		super();
		this.cid = cid;
		this.cnumber = cnumber;
		this.cname = cname;
	}

	public CourseEntry(String cnumber, String cname) {
		super();
		this.cnumber = cnumber;
		this.cname = cname;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getCnumber() {
		return cnumber;
	}

	public void setCnumber(String cnumber) {
		this.cnumber = cnumber;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public ArrayList<assignment> getAssiDescri() {
		return assiDescri;
	}

	public void setAssiDescri(ArrayList<assignment> assiDescri) {
		this.assiDescri = assiDescri;
	}
	
	
}
