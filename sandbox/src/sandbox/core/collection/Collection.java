package sandbox.core.collection;

public interface Collection<Type>{
	public Type at(int index) throws IndexOutOfBoundsException;
	public Type first();
	public Type last();
	public int length();
	public void reset();
	public boolean hasNext();
	public Type next() throws IndexOutOfBoundsException;

}
