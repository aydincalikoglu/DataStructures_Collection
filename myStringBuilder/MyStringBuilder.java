
/**
 * MyStringBuilder Class
 * Holds all types and convert them ToString
 */
public class MyStringBuilder{
    /**
     * Single Linked List
     */
    private SingleLinkedList<Object> SLL = new SingleLinkedList<Object>();
    /**
     * Appends all type into Single Linked List
     * @param data
     * @return 
     */
    public boolean appendAnything(Object data)
    {
        SLL.addLast(data);
        return true;
    }
	/**
     * appendAnything Method Appends all type into Single Linked List
     * @param data
     * @return 
     */
	public boolean appendAnything(String data)
    {
        SLL.addLast(data);
        return true;
    }
    /**
     * appendAnything Method Appends all type into Single Linked List
     * @param data
     * @return 
     */
    public boolean appendAnything(double data)
    {
        SLL.addLast(data);
        return true;
    }
    /**
     * appendAnything Method Appends all type into Single Linked List
     * @param data
     * @return 
     */
    public boolean appendAnything(char data)
    {
        SLL.addLast(data);
        return true;
    }
    /**
     * appendAnything Method Appends all type into Single Linked List
     * @param data
     * @return 
     */
    public boolean appendAnything(float data)
    {
        SLL.addLast(data);
        return true;
    }
    /**
     * appendAnything Method Appends all type into Single Linked List
     * @param data
     * @return 
     */
    public boolean appendAnything(long data)
    {
        SLL.addLast(data);
        return true;
    }
    /**
     * toString Method for indexes and get method
     * @return 
     */
    public String toString1()
    {
        String builder="";
        for (int i = 0; i < SLL.size()-1; i++) {
                if(i!=0)
                    builder+=("\n");
                builder+=SLL.get(i).toString();
        }
        return builder;
    }
    /**
     * toString Method for iterator
     * @return 
     */
    public String toString2()
    {
        String builder="";
        Iterator<Object> itr = SLL;
        while(itr.hasNext()) {
            builder+=itr.next().toString();
            builder+=("\n");
        }
        return builder;
    }
    /**
     * toString method of the linked list
     * @return 
     */
    @Override
    public String toString()
    {
        return SLL.toString();
    }
}
