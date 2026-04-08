import java.util.ArrayList;

class Shape {

	public double calculate_area() { return 0.0f; }

} 

class Circle extends Shape {

	private double radius;
	private String color;

	public Circle(double radius, String color){
		this.radius = radius;
		this.color = color;
	}

	public double get_radius() { return radius; }
	public String get_color() { return color; }

	public double calculate_area(){
		return Math.PI * radius * radius;
	}

	@Override
	public String toString(){
		return this.color + " Circle with radius " + this.radius;
	}
}

class Rectangle extends Shape {
	
	private double width;
	private double height;
	private String color;

	public Rectangle(double width, double height, String color){
		this.width = width;
		this.height = height;
		this.color = color;
	}
	
	public double get_width()  { return width ; }
	public double get_height() { return height; }
	public String get_color()  { return color ; }

	public double calculate_area(){
		return width * height;
	}

	@Override
	public String toString(){
		return this.color + " Rectangle with width " + this.width + " and height " + this.height;
	}
}

class Triangle extends Shape {

	private double base;
	private double height;
	private String color;

	public Triangle(double base, double height, String color){
		this.base = base;
		this.height = height;
		this.color = color;
	}

	public double get_base() { return base; }
	public double get_height() { return height; }
	public String get_color() { return color; }

	public double calculate_area(){
		return 0.5 * (base * height);
	}

	@Override
	public String toString(){
		return this.color +  " Triangle with base " + this.base + 
			   " and height " + this.height;
	}
}

class ShapeCalculator {

	public static void main (String[] args) {
		
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		shapes.add(new Circle(5.0, "Red"));
		shapes.add(new Rectangle(4.0, 6.0, "Green"));
		shapes.add(new Triangle(3.0, 8.0, "Blue"));
		shapes.add(new Circle(8.2, "Yellow"));
		shapes.add(new Rectangle(5.1, 11.15, "Purple"));
		shapes.add(new Triangle(7.27, 8.49, "Black"));


		for(Shape s : shapes){
			System.out.printf("%s: %f%n", s, s.calculate_area());
		}
	}
}




