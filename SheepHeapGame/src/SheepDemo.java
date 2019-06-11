/*
 * Written by Xiaoyi Liu 04/05/2019
 */
public class SheepDemo {

    public static void main(String[] args) {

        SheepHeap heap = new SheepHeap(128);
        
        heap.addSheep(new Sheep("Sheep 1",11.5));
        heap.addSheep(new Sheep("Sheep 2",22));
        heap.addSheep(new Sheep("Sheep 3",33));
        heap.addSheep(new Sheep("Sheep 4",44));
        heap.addSheep(new Sheep("Sheep 5",55));
        heap.addSheep(new Sheep("Sheep 6",66));
        heap.addSheep(new Sheep("Sheep 7",77));
        heap.addSheep(new Sheep("Sheep 8",88));
        heap.addSheep(new Sheep("Sheep 9",99));
        heap.addSheep(new Sheep("Sheep 10",23.6));
        heap.addSheep(new Sheep("Sheep 11",34));
        heap.addSheep(new Sheep("Sheep 12",45));
        heap.addSheep(new Sheep("Sheep 13",67));
        heap.addSheep(new Sheep("Sheep 14",78));
        heap.addSheep(new Sheep("Sheep 15",100));
        System.out.println("\nCheck the reuslt of insertions by printing in breadth order.");
        heap.sheepRollCall();
        
        System.out.println("\nPrinting the min heap in sorted order");
        Sheep[] sortedHeap = heap.sheepHeapSort();
        for(Sheep s : sortedHeap) {
        	System.out.println(s.toString());
        }
        
        System.out.println("\nRemove 5 sheepes");
        System.out.println("Before Removal");
        heap.sheepRollCall();
        for(int i=1; i<=5; i++) {
        	heap.removeSheep();
        }
        System.out.println("After Removal");
        heap.sheepRollCall();

    }
}