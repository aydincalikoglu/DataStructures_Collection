/**
 *
 * @author AYDIN ÇALIKOĞLU
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
         * Test Of ReverseToString Method
         */
        SingleLinkedList<String> LinkList = new SingleLinkedList<String>();
        LinkList.addLast("Deneme");
        LinkList.addLast("TersCevir");
        LinkList.addLast("TURK");
        
        String reverse=LinkList.reverseToString();
        System.out.println(reverse);
        
        
        
    }
    
}
