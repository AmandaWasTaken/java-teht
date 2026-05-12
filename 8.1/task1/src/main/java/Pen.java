package Pen;

public class Pen {

	public enum Color {
		RED("red"), GREEN("green"), BLUE("blue");
		private final String color;
		Color(String color) { this.color = color; };
		@Override public String toString() { return color; }
	}	

	private Color color;
	private boolean capped = true;

	public Pen(){ this(Color.RED); }

	public Pen(Color color) { this.color = color; }

	public void capOff() { capped = false; }
	public void capOn() { capped = true; }

	public void changeColor(Color newColor){
		if(capped) this.color = newColor;
	}

	public String draw(){
		if(capped) return "";
		return "Drawing " + color;
	}
}


















