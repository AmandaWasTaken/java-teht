import java.util.*;


class ReservationSystem extends Thread {

	private int customer_id;
	private int thread_id;
	private int n_tickets;
	private final static int MIN_TICKETS =   1;
	private final static int MAX_TICKETS =  10;
	private static int seats_left 		 = 200; 

	public ReservationSystem(int customer_id, int thread_id, int n_tickets){
		this.customer_id = customer_id;
		this.thread_id = thread_id;
		this.n_tickets = n_tickets;
	}

	public static int get_seats_left() { return seats_left; }

	public static synchronized boolean reserve_ticket(int customer_id, int n_tickets){

		if(seats_left == 0) return false;

		if(n_tickets < MIN_TICKETS){
			throw new IllegalArgumentException("Cannot reserve less than " +
					MIN_TICKETS + " tickets!");
		}

		if(n_tickets > MAX_TICKETS){
			throw new IllegalArgumentException("Cannot reserve more than " + 
					MAX_TICKETS + " tickets!");
		}

		// output formatointi ei ole täydellinen mutta en jaksa säätää printf kanssa
		// tämän enempää :D
		if(seats_left - n_tickets < 0){
			System.out.printf("Customer %-2d couldn't reserve %-2d ticket(s) ",
					customer_id, n_tickets);
			System.out.printf("(Tickets left: %d)%n", get_seats_left());
			return false;
		} else {
			seats_left -= n_tickets;
			System.out.printf("Customer %-2d reserved %d ticket(s) ", 
					customer_id, n_tickets);
			System.out.printf("(Tickets left: %3d)%n", get_seats_left());

			return true;
		}

	}

	@Override
	public void run(){
		// System.out.printf("Thread %d started%n", thread_id);
		reserve_ticket(customer_id, n_tickets);
	}
}

class Main {

	public static void main (String[] args) {
		
		Random rand = new Random();
		int customer_id = 0;
		int thread_id   = 0;

		List<ReservationSystem> threads = new ArrayList<>();

		while(ReservationSystem.get_seats_left() > 0){

			int cid = ++customer_id;
			int tid = ++thread_id;
			int n_tickets   = rand.nextInt(10) + 1;
			ReservationSystem r = new ReservationSystem(cid, tid, n_tickets);
			threads.add(r);
			r.start();	

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		for(ReservationSystem t : threads){
			try { t.join(); }
			catch (InterruptedException e) { e.printStackTrace(); }
		}

		try {
			assert(ReservationSystem.get_seats_left() == 0);
			System.out.println("Sold out!");
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}
	}
}
