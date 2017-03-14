

/**
 *
 * 
 */
public class main{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SingleLinkedList<Object> SLL = new SingleLinkedList<Object>();
        for (int i = 0; i < 100; i++) {
            SLL.addLast(i);
        }
        System.out.println("100 Intagers Added. \nDeleted Strings are :\n"+SLL.deletedToString());
        for (int i = 0; i < 50; i++) {
            SLL.removeFirst();
        }
        System.out.println("50 Integers Cleaned. \nDeleted Strings are :\n"+SLL.deletedToString());
        for (int i = 0; i < 100; i++) {
            SLL.addLast(i);
        }
        System.out.println("100 Integers added. \nDeleted Strings are :\n"+SLL.deletedToString());
    }
    
}
