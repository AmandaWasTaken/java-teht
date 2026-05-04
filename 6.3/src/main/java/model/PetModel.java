package model;

public class PetModel {

	private double x;
	private double y;

	private double target_x;
	private double target_y;

	private boolean moving;
	private final float _movement_speed = 0.5f;

	public PetModel() {
		this.x = 50;
		this.y = 50;
		this.moving = false;
	}

	public double  get_x()			{ return x; }
	public void    set_x(double x)  { this.x = x; }

	public double  get_y()			{ return y; }
	public void    set_y(double y)  { this.y = y; }

	public double  get_target_x()   { return this.target_x; }
	public void    set_target_x(double x) { this.target_x = x; }

	public double  get_target_y()   { return this.target_y; }
	public void    set_target_y(double y) { this.target_y = y; }

	public boolean is_moving()      { return moving; }
	public void    set_moving(boolean b) { this.moving = b; }
	
	public void update_position() {
		double dx = target_x - x;
		double dy = target_y - y;

		double dist = Math.sqrt(dx * dx + dy * dy);
		double dir_x = dx/dist;
		double dir_y = dy/dist;
		double speed = Math.min(dist, _movement_speed);
		x += dir_x * speed;
		y += dir_y * speed;
	}

	public boolean has_reached_target() {
		return Math.sqrt((target_x - x) * 2 + (target_y - y) * 2) < 3.0f;
	}
}
