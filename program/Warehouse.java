public class Warehouse{
	public MineTable getTable(int num){
		MineTable[] table = new MineTable[8];
		MineTable table[0] = new MineTable(3, 3, new int[][] {{1, 0, 0}, {10, 0, 0}, {5, 0, 0}, {10, 0, 0}, {3, 0, 0}, {10, 0, 0}, {2, 0, 0}, {10, 0, 0}, {9, 0, 0}});
		return table[num];
	}
}
