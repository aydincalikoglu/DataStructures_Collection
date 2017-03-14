
/**
 * SingleLinkedList
 * @author Aydın Çalıkoğlu
 * @param <E> 
 */
public class SingleLinkedList<E> implements Iterator<E>{
    private Node<E> head=null;
    private int size=0;
    /**
     * Iteration Node
     */
    private Node<E> iteratorNode=null;
    /**
     * Garbage Node Head
     */
    private Node<E> garbageHead=null;
    private int garbageSize=0;
    /**
     * add a Garbage Node
     * Take removed node and add it garbageLinkedList
     * @param aNode 
     */
    public void addGarbageFirst(Node<E> aNode) {
        aNode.next=garbageHead;
        garbageHead=aNode;
        garbageSize++;
    }
    /**
     * give an empty Node
     * @return an empty node from garbageLinkedList
     */
    public Node<E> removeGarbageFirst() {
        Node<E> temp=garbageHead;
        if(garbageSize>1)
        {
            garbageHead=garbageHead.next;
            garbageSize--;
        }
        else
        {
            garbageHead=null;
            garbageSize=0;
        }
        return temp;
    }
    
    public String deletedToString()
    {
        String toString="";
        if (garbageHead!=null) {
            toString+=garbageHead.toString()+"\n";
            Node<E> curr=garbageHead;
            while (curr.getNext() != null) 
            {
                curr = curr.getNext();
                toString+=curr.toString()+"\n";
            }
        }
        return toString;
    }
    
    /**
     * add new item begining of linkedList
     * @param data 
     */
    public void addFirst(E data) {
        Node<E> temp=removeGarbageFirst();
        if (temp!=null) {
            temp.next=head;
            temp.data=data;
            head=temp;
        }
        else
            head=new Node<E>(data,head);
        ++size;
    }
    /**
     * remove item begining of linkedList
     * @return 
     */
    public E removeFirst() {
        Node<E> temp=head;
        if (head!=null) {
            head=head.next;
        }
        if(temp!=null)
        {
            addGarbageFirst(temp);
            --size;
            return temp.data;
        }
        else return null;
    }
    /**
     * add new node after given node
     * @param node
     * @param data 
     */
    public void addAfter(Node<E> node,E   data) {
        Node<E> temp=removeGarbageFirst();
        if (temp!=null) {
            temp.next=node.next;
            temp.data=data;
            node.next=temp;
        }
        else
            node.next=new Node<E>(data,node.next);
        ++size;
    }
    /**
     * remove node after given node
     * @param node
     * @return 
     */
    public E removeAfter(Node<E> node) {
        if(node.next!=null)
        {
            Node<E> temp=node.next;
            node.next = temp.next;
            --size;
            addGarbageFirst(temp);
            return temp.data;
        }
        else
            return null;
    }
    
    
    
    /**
     * Constructor of SingleLinkedList Class
     */
    public SingleLinkedList() {
        head = null;
        size = 0;
    }
    /**
     * iteration next
     * @return data 
     */
    @Override
    public E next() {
        if (hasNext()) 
        {
                iteratorNode=iteratorNode.next;
                return iteratorNode.data;            
        }
        return null;
    }
    /**
     * control of next node
     * @return boolean
     */
    @Override
    public boolean hasNext() {
        if(head!=null)
        {
            if(iteratorNode==null)
                iteratorNode=head;
            if(iteratorNode.next!=null)
            {
                return true;
            }
            iteratorNode=head;
        }
        return false;
    }
    /**
     * Size of linkedList
     * @return size
     */
    public int size() {
        return size;
    }
    /**
     * LinkedList toString Method
     * @return 
     */
    @Override
    public String toString() {
        Node<E> nodeRef = head;
        StringBuilder result = new StringBuilder();
        
        while (nodeRef != null){
            result.append(nodeRef.getData());
            if(nodeRef.next!=null)
                result.append("\n");
            
            nodeRef = nodeRef.getNext();
        }
        return result.toString();
    }
    
    /**
     * add new item end of linkedList
     * @param data 
     */
    public void addLast(E data) {
        Node<E> temp=removeGarbageFirst();
        if (temp!=null) {
            temp.data=data;
            temp.next=null;
        }
        else
        {
            temp = new Node<E>(data);
        }
        Node<E> curr = head;

        if (head == null) 
        {
            head = temp;
        } 
        else 
        {
            while (curr.getNext() != null) 
            {
                curr = curr.getNext();
            }
            curr.setNext(temp);
        }
        ++size;
    }
    
    /**
     * remove Last Data
     */
    public void removeLast() {
        Node<E> curr = head;
        if (head != null) 
        {
            if(size>2)
            {
                while (curr.getNext().getNext() != null) 
                {
                    curr = curr.getNext();
                }
                addGarbageFirst(curr.next);
                curr.next=null;
            }
            else
            {
                if (head.getNext()==null)
                {
                    addGarbageFirst(head);
                    head=null;
                }
                else 
                {
                    addGarbageFirst(head.next);
                    head.next=null;
                }  
            }
            --size;
        }
    }
    /**
     * get item of given index
     * @param index
     * @return 
     */
    public E get(int index) {
        Node<E> temp = head;
        for (int i = 0; i < index && i<size; i++){
            temp = temp.getNext();
        }
        return temp.getData();
    }


    
    
    /**
     * Inner Class Node
     * @param <E> 
     */
    public class Node<E>{

        private E data=null;
        private Node<E> next=null;
        /**
         * Controctor of Node with param data
         * @param data 
         */
        private Node(E data) {
            this(data, null);
        }
        /**
         * Controctor of Node with param data after itself 
         * @param data
         * @param next 
         */
        private Node(E data, Node<E> next) {
            this.next = next;
            this.data = data;
        }
        /**
         * get data of node
         * @return 
         */
        private E getData() {
            return this.data;
        }
        /**
         * set data the node
         * @param data 
         */
        private void setData(E data) {
            this.data = data;
        }
        /**
         * get next node method
         * @return 
         */
        private Node<E> getNext() {
            return this.next;
        }
        /**
         * set next node method
         * @param nextNode 
         */
        private void setNext(Node<E> nextNode) {
            this.next = nextNode;
        }

    }
}


