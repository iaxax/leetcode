// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    
    private Iterator<Integer> itr;
    
    private boolean invokePeek;
    
    private Integer peekNum;

	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.itr = iterator;
        this.invokePeek = false;
        peekNum = null;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if (!invokePeek) {
            peekNum = itr.next();
            invokePeek = true;
        }
        return peekNum;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        if (invokePeek) {
            invokePeek = false;
            return peekNum;
        }
	    return itr.next();
	}

	@Override
	public boolean hasNext() {
	    return invokePeek || itr.hasNext();
	}
}
