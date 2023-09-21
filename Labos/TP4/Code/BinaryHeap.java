import java.util.*; 


public class BinaryHeap<AnyType extends Comparable<? super AnyType>> extends AbstractQueue<AnyType>
{
    private static final int DEFAULT_CAPACITY = 100;
    private int currentSize;      // Nombre d'elements
    private AnyType [ ] array;    // Tableau contenant les donnees (premier element a l'indice 1)
    private boolean min;
    private int modifications;    // Nombre de modifications apportees a ce monceau
    
    @SuppressWarnings("unchecked")
    public BinaryHeap( boolean min ){
	    this.min = min;
	    currentSize = 0;
	    array = (AnyType[]) new Comparable[ DEFAULT_CAPACITY + 1];
    }
    
    @SuppressWarnings("unchecked")
    public BinaryHeap( AnyType[] items, boolean min ){
	    this.min = min;
		// COMPLETEZ
        currentSize = 0;
        array = (AnyType[]) new Comparable[items.length + 1];
        for (AnyType currentItem : items) {
            array[++currentSize] = currentItem;
        }
        // invoquez buildMinHeap() ou buildMaxHeap() en fonction du parametre min;
        if (min)
            buildMinHeap();
        else
            buildMaxHeap();
    }

    public boolean offer(AnyType x) {

        if (x == null) {
            throw new NullPointerException("Cannot insert null in a BinaryHeap");
        }

        if (currentSize + 1 == array.length) {
            doubleArray();
        }

        // COMPLETEZ

        if (array[1] == null) {
            array[1] = x;

        } else {
            int currentPos = currentSize + 1;
            array[currentSize + 1] = x;
            int compareResult = array[currentPos].compareTo(array[(int) ((currentPos) / 2)]);
            while (((min && compareResult < 0) || (!min && compareResult > 0))) {
                swapReferences(currentPos, (int) ((currentPos) / 2));

                if (currentPos / 2 != 1) {

                    currentPos = currentPos / 2;
                    compareResult = array[currentPos].compareTo(array[(int) ((currentPos) / 2)]);

                } else {
                    break;
                }
            }
        }
        currentSize++;
        modifications++;
        return true;
    }
    
    public AnyType peek(){
	    if(!isEmpty())
	    return array[1];
	
	    return null;
    }
    
    public AnyType poll(){
	    //COMPLETEZ
        if (!isEmpty()) {
            AnyType top = array[1];
            array[1] = array[currentSize--];
            if (min)
                percolateDownMinHeap(1, currentSize);
            else
                percolateDownMaxHeap(1, currentSize);
            modifications++;
            return top;
        }
    	return null;
    }
    
    public Iterator<AnyType> iterator(){
	    return new HeapIterator();
    }
    
    private void buildMinHeap(){
	   //COMPLETEZ
        for( int i = currentSize / 2; i > 0; i-- )
            percolateDownMinHeap( i, currentSize );
    }
    
    private void buildMaxHeap(){
	    //COMPLETEZ
        for( int i = currentSize / 2; i > 0; i-- )
            percolateDownMaxHeap( i, currentSize );
    }
    
    public boolean isEmpty(){
	    return currentSize == 0;
    }
    
    public int size(){
	    return currentSize;
    }
    
    public void clear(){
	    currentSize = 0;
	    modifications = 0;
	    array = (AnyType[]) new Comparable[ DEFAULT_CAPACITY + 1];
    }
    
    private static int leftChild( int i, boolean heapIndexing ){
	            return ( heapIndexing ? 2*i : 2*i+1 );
    }
    
    private void swapReferences( int index1, int index2 ){
	    swapReferences(array, index1, index2);
    }
    
    private static <AnyType extends Comparable<? super AnyType>>
				    void swapReferences( AnyType[] array, int index1, int index2 ){
	
    	AnyType tmp = array[ index1 ];
	    array[ index1 ] = array[ index2 ];
	    array[ index2 ] = tmp;
    }
    
    @SuppressWarnings("unchecked")
	private void doubleArray(){
	    AnyType [ ] newArray;
	
	    newArray = (AnyType []) new Comparable[ array.length * 2 ];
	for( int i = 0; i < array.length; i++ )
	    newArray[ i ] = array[ i ];
	    array = newArray;
    }
    
    
    /**
     * @param hole    Position a percoler
     * @param size    Indice max du tableau
     */
    private void percolateDownMinHeap( int hole, int size ){
	     percolateDownMinHeap(array, hole, size, true);
    }
    
    /**
     * @param array   Tableau d'element
     * @param hole    Position a percoler
     * @param size    Indice max du tableau
     * @param heapIndexing  True si les elements commencent a l'index 1, false sinon
     */
    private static <AnyType extends Comparable<? super AnyType>>
				    void percolateDownMinHeap( AnyType[] array, int hole, int size, boolean heapIndexing )
    {
	//COMPLETEZ
        int child;
        AnyType temp = array[hole];

        while (leftChild(hole, heapIndexing) <= size) {
            child = leftChild(hole, heapIndexing);
            if (child != size &&
                    array[child + 1].compareTo(array[child]) < 0)
                child++;
            if (array[child].compareTo(temp) < 0)
                array[hole] = array[child];
            else
                break;
            hole = child;
        }
        array[hole] = temp;
    }
    
    /**
     * @param hole    Position a percoler
     * @param size    Indice max du tableau
     */
    private void percolateDownMaxHeap( int hole, int size ){
	    percolateDownMaxHeap(array, hole, size, true);
    }
    
    /**
     * @param array         Tableau d'element
     * @param hole          Position a percoler
     * @param size          Indice max du tableau
     * @param heapIndexing  True si les elements commencent a l'index 1, false sinon
     */
    private static <AnyType extends Comparable<? super AnyType>> 
				    void percolateDownMaxHeap( AnyType[] array, int hole, int size, boolean heapIndexing )
    {
	//COMPLETEZ
        int child;
        AnyType temp = array[hole];

        while (leftChild(hole, heapIndexing) <= size) {
            child = leftChild(hole, heapIndexing);
            if (child != size &&
                    array[child + 1].compareTo(array[child]) > 0)
                child++;
            if (array[child].compareTo(temp) > 0)
                array[hole] = array[child];
            else
                break;
            hole = child;
        }
        array[hole] = temp;
    }
    
    public static <AnyType extends Comparable<? super AnyType>>
				   void heapSort( AnyType[] a )
    {
	//COMPLETEZ
        for (int i = a.length / 2 ; i >= 0; i--)
            percolateDownMaxHeap(a, i, a.length - 1, false);
        for (int i = a.length - 1; i > 0; i--) {
            swapReferences(a, 0, i);
            percolateDownMaxHeap(a, 0, i- 1, false);
        }
    }
    
    public static <AnyType extends Comparable<? super AnyType>>
				   void heapSortReverse( AnyType[] a )
    {
	//COMPLETEZ
        for (int i = a.length / 2 ; i >= 0; i--)
            percolateDownMinHeap(a, i, a.length - 1, false);
        for (int i = a.length - 1; i > 0; i--) {
            swapReferences(a, 0, i);
            percolateDownMinHeap(a, 0, i- 1, false);
        }
    }
    
    public String nonRecursivePrintFancyTree()
    {
	String outputString = "";

	//COMPLETEZ
        boolean returning = false;
        Stack<String> s = new Stack();
        int index = 1;
        int parent = 1;

        String prefix = "";
        s.push(prefix);
        do {
            if (!returning) {
                outputString += prefix + "|__";
                if (index <= currentSize) {

                    outputString += array[index] + "\n";

                    if (index % 2 == 0)
                        prefix += "|  "; // un | et trois espace
                    else
                        prefix += "   "; // quatre espaces
                    if (index * 2 > currentSize) {
                        if (index + 1 == parent * 2 + 1) {
                            index++;
                            prefix = s.pop();
                        } else {
                            returning = true;
                        }
                    } else {
                        parent = index;
                        index *= 2;
                        s.push(prefix);
                    }
                } else {
                    outputString += "null\n";
                    returning = true;
                }
            } else if (returning) {
                prefix = s.pop();
                index = parent;
                parent = index / 2;
                index++;
                if (index == parent * 2 + 1) {
                    returning = false;
                } else {
                    index = parent * 2;
                    s.push(prefix);
                }
            }
        } while (!(s.isEmpty()));


        return outputString;
    }
    
    public String printFancyTree()
    {
	return printFancyTree(1, "");
    }
    
    private String printFancyTree( int index, String prefix)
    {
	String outputString = "";
	
	outputString = prefix + "|__";
	
	if( index <= currentSize )
	    {
		boolean isLeaf = index > currentSize/2;
		
		outputString += array[ index ] + "\n";
		
		String _prefix = prefix;
		
		if( index%2 == 0 )
		    _prefix += "|  "; // un | et trois espace
		else
		    _prefix += "   " ; // quatre espaces
		
		if( !isLeaf ) {
		    outputString += printFancyTree( 2*index, _prefix);
		    outputString += printFancyTree( 2*index + 1, _prefix);
		}
	    }
	else
	    outputString += "null\n";
	
	return outputString;

    }

















    private class HeapIterator implements Iterator {

        private int position = 1;

        private int nbModification = modifications;

        public boolean hasNext() {
            //COMPLETEZ
            return (position < currentSize);
        }

        public Object next() throws NoSuchElementException,
                ConcurrentModificationException,
                UnsupportedOperationException {
            //COMPLETEZ

            if(modifications != nbModification)
                throw new ConcurrentModificationException();

            if (!hasNext())
                throw new NoSuchElementException();

            return array[position++];

        }
	public void remove() {
	    throw new UnsupportedOperationException();
	}
    }
}
