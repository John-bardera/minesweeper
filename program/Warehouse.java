import java.lang.Math;

public class Warehouse{
	public MineTable getTable(int num){
		MineTable[][] table = new MineTable[4][];
		int random;

		table[0] = new MineTable[2];
		table[0][0] =	new MineTable(2, 2, new int[][] {{1 , 2}, {10, 0}, {2, 3}, {1, 1}});
		table[0][1] = new MineTable(2, 2, new int[][] {{1, 1}, {3, 2}, {3, 2}, {10, 0}});
		table[1] = new MineTable[2];
		table[1][0] = new MineTable(3, 3, new int[][] {{2 , 3}, {10, 0}, {3 , 2}, {10, 0}, {1 , 1}, {10, 0}, {10, 0}, {4 , 3}, {10, 0}});
		table[1][1] = new MineTable(3, 3, new int[][] {{3 , 2}, {10, 0}, {3 , 2}, {10, 0}, {1 , 1}, {10, 0}, {3 , 2}, {10, 0}, {3 , 2}});
		table[2] = new MineTable[3];
		table[2][0] = new MineTable(4, 4, new int[][] {{10, 0}, {5 , 1}, {2 , 2}, {10, 0}, {2, 3}, {10, 0}, {10, 0}, {10, 0}, {10, 0}, {6, 1}, {10, 0}, {4 , 3}, {10, 0}, {10, 0}, {10, 0}, {10, 0}});
		table[2][1] = new MineTable(4, 4, new int[][] {{3 , 1}, {10, 0}, {2 , 2}, {1 , 1}, {10, 0}, {4 , 3}, {4 , 3}, {2 , 2}, {2 , 2}, {4 , 3}, {5 , 3}, {10, 0}, {10, 0}, {10, 0}, {3 , 1}, {2 , 4}});
		table[2][2] = new MineTable(4, 4, new int[][] {{10, 0}, {10, 0}, {10, 0}, {10, 0}, {10, 0}, {9 , 2}, {10, 0}, {3 , 3}, {10, 0}, {10, 0}, {10, 0}, {10, 0}, {2 , 1}, {10, 0}, {3 , 2}, {1 , 1}});
		table[3] = new MineTable[2];
		table[3][0] = new MineTable(5, 5, new int[][] {{1 , 3}, {10, 0}, {1 , 3}, {10, 0}, {2 , 2}, {10, 0}, {3 , 2}, {10, 0}, {4 , 1}, {10, 0}, {2 , 1}, {4 , 3}, {10, 0}, {10, 0}, {3 , 3}, {3 , 1}, {10, 0}, {10, 0}, {10, 0}, {10, 0}, {1 , 2}, {10, 0}, {10, 0}, {3 , 2}, {1 , 1}}); 
		table[3][1] = new MineTable(5, 5, new int[][] {{1 , 2}, {10, 0}, {1 , 1}, {10, 0}, {2 , 1}, {4 , 3}, {10, 0}, {3 , 2}, {10, 0}, {10, 0}, {1 , 1}, {10, 0}, {4 , 3}, {1 , 1}, {1 , 3}, {4 , 3}, {10, 0}, {3 , 3}, {10, 0}, {10, 0}, {1 , 3}, {3 , 3}, {1 , 1}, {10, 0}, {1 , 3}});
		
		random = (int)(Math.random()*table[num].length);
		return table[num][random];
	}
}
