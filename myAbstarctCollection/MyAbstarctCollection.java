import java.util.Iterator;
import java.util.AbstractCollection;

/**
 * MyAbstarctCollection class can hold all types also appends all other abstractCollection hierarchy 
 * @param <E>
 */
public abstract class MyAbstarctCollection<E> extends AbstractCollection<Object> {
    /**
     * Append all incoming items of AbstractCollection with iterators
     * @param AbsCollection
     * @return boolean if it appended item or not
     */
    public boolean appendAnything(AbstractCollection<Object> AbsCollection) {
        boolean degisim = false;
        Iterator itr = AbsCollection.iterator();
        while (itr.hasNext()) 
        {
            boolean durum=add(itr.next());
            if (durum) {
                degisim=true;
            }
        }
        return degisim;
    }

}
