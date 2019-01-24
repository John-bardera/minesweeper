public class Warehouse{
	public MineTable getTable(int num){
		MineTable[] table = new MineTable[8];
		table[0] = new MineTable(3, 3, new int[][] {{1, 1}, {10, 0}, {5, 3}, {10, 0}, {3, 2}, {10, 0}, {2, 2}, {10, 0}, {9, 1}});
		return table[num];
	}
}
