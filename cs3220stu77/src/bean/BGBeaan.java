 package bean;

public class BGBeaan {

	int red, green,blue;

	
	public BGBeaan()
	{
		this.red=255;
		this.green=0;
		this.blue=0;
	}
	public BGBeaan(int red, int green, int blue) {
		super();
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	public int getR() {
		return red;
	}
	public void setR(int red) {
		this.red = red;
	}
	public int getG() {
		return green;
	}
	public void setG(int green) {
		this.green = green;
	}
	public int getB() {
		return blue;
	}
	public void setB(int blue) {
		this.blue = blue;
	}
	
	
}
