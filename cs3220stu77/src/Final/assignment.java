package Final;

public class assignment {

	int aid;
	int cid;
	String assiDesc;
	int flag = 0;

	public assignment(int aid, int cid, String assiDesc) {
		super();
		this.aid = aid;
		this.cid = cid;
		this.assiDesc = assiDesc;
		//this.flag = flag;
	}

	public assignment(int cid, String assiDesc) {
		super();
		this.cid = cid;
		this.assiDesc = assiDesc;

	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getAssiDesc() {
		return assiDesc;
	}

	public void setAssiDesc(String assiDesc) {
		this.assiDesc = assiDesc;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

}
