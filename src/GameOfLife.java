public class GameOfLife {
	public static void main(String[] args) throws InterruptedException {
		Generation curr = null;
		int generations, rows, cols, time;
		int[][] glider = { {0,0,0,0,0},
				   {0,0,1,0,0},
				   {1,0,1,0,0},
				   {0,1,1,0,0},
				   {0,0,0,0,0} };
		curr = new Generation(glider);
		generations = 8;
		time = 1000;
		try { 
			generations = Integer.parseInt(args[2]);
			rows = Integer.parseInt(args[0]);
			cols = Integer.parseInt(args[1]);
			curr = new Generation(rows, cols);
			Generation.setLive(args[3].charAt(0));
			Generation.setDead(args[4].charAt(0));
			time = Integer.parseInt(args[5]);
		} catch (Exception e) {
			
		}	
		for (int i = 0; i < generations; i++) {
			System.out.println(curr);
			curr = curr.next();
			Thread.sleep(time);
		}
	}
}
