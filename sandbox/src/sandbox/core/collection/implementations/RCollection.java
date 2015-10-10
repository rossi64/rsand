package sandbox.core.collection.implementations;

import sandbox.core.collection.Collection;
import java.lang.IndexOutOfBoundsException;
public class RCollection<Type> implements Collection<Type>{
	protected Type[] array;
	protected int len;
	
	public RCollection(Type[] _array){
		if(_array == null) throw new NullPointerException();
		this.array = _array;
		this.len = this.array.length;
		
		//TODO You need to keep a variable to keep track of looping over the contents of the collection
		//See test testSumCollection() to see what I mean
	}
	
		               
	@Override public Type at(int index) throws IndexOutOfBoundsException{	
		if(len == 0) throw new IndexOutOfBoundsException("The Collection is empty");	
		if(index<0||index>=len) throw new IndexOutOfBoundsException(
				"Index must be between 0 and " + len + "you supplied " + index);
		return array[index];
	}

	@Override
	public Type first(){
		return this.at(0);
	}

	@Override
	public Type last(){
		return this.at(this.array.length-1);
	}

	@Override
	public int length(){
		return len;
	}

	@Override
	public boolean hasNext() {
		//TODO Look at the test testNext1() to see how this should work
		int j;
		for(j=0; j<len-1; j++)
		if (this.at(j) != null);
		return true;
	}


	@Override
	public Type next() throws IndexOutOfBoundsException {
		//TODO Next is supposed to be an easier way to loop over all the elements of the collection
		//Look at test testSumCollection(), I explain in more detail there
		return this.at(len);
	}


	@Override
	public void reset() {
		// TODO Reset should reset the looping to the beginning
		
	}

}
