public class Warehouse{
	public MineTable getTable(int num){
		MineTable[] table = new MineTable[8];
		table[0] = new MineTable(3, 3, new int[][] {{1, 1}, {10, 0}, {10, 0}, {10, 0}, {10, 0}, {10, 0}, {10, 0}, {10, 0}, {10, 0}});
		table[1] = new MineTable(4, 4, new int[][] {{10, 0}, {5, 1}, {2, 2}, {10, 0}, {10, 0}, {10, 0}, {10, 0}, {10, 0}, {10, 0}, {10, 0}, {10, 0}, {4, 3}, {10, 0}, {10, 0}, {10, 0}, {10, 0}});
    return table[num];
	}
}
