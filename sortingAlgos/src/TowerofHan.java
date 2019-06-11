
public class TowerofHan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		reTower(5,"A","B","C");

	}
	static int count =0;
	public static void reTower(int diskNum, String fromRod, String toRod, String otherRod) {
		if(diskNum ==1) {
			System.out.println((++count) + "Move disk 1 from "+ fromRod+ "to " + toRod);
		}
		reTower(diskNum -1, fromRod, otherRod, toRod);
		System.out.println((++count) + "Move disk" + diskNum + "from rod" + fromRod + "toRod" +toRod);
		reTower(diskNum-1, otherRod, toRod, fromRod);
	}
	

}
