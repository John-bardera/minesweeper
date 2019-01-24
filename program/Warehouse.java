public class Warehouse{
	public MineTable getTable(int num){
		MineTable[] table = new MineTable[8];
		table[0] = new MineTable(3, 3, new int[][] {{1, 1}, {10, 0}, {10, 0}, {10, 0}, {10, 0}, {10, 0}, {10, 0}, {10, 0}, {10, 0}});
		return table[num];
	}
}
