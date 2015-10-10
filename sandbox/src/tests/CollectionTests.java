package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import sandbox.core.collection.Collection;
import sandbox.core.Core;

public class CollectionTests {
	
	public static Integer[] array = new Integer[]{1,2,3,4,5,6,7,8,9,10};
	public static Collection<Integer> sut = Core.Factory.Collection(array);
	public static Collection<Integer> sut2 = Core.Factory.Collection(new Integer[100]);
	public static Collection<Integer> sut3 = Core.Factory.Collection(new Integer[0]);
	@Test public void testConstructor(){  
		assertNotNull(sut); 
		assertNotNull(sut2);
		assertNotNull(sut3);
	}
        	
		@Test public void testAt_OK(){
			assertEquals(Integer.valueOf(1), sut.at(0));
			assertEquals(Integer.valueOf(2), sut.at(1));
			assertEquals(Integer.valueOf(3), sut.at(2));
			assertEquals(Integer.valueOf(4), sut.at(3));
			assertEquals(Integer.valueOf(5), sut.at(4));
			assertEquals(Integer.valueOf(6), sut.at(5));
			assertEquals(Integer.valueOf(7), sut.at(6));
			assertEquals(Integer.valueOf(8), sut.at(7));
			assertEquals(Integer.valueOf(9), sut.at(8));
			assertEquals(Integer.valueOf(10), sut.at(9));
		}
		
		@Test (expected = IndexOutOfBoundsException.class)  public void testAt_OK2(){
			assertNull(sut2.at(0));
			assertNull(sut3.at(0));
		}
				
		@Test public void testFirst(){
			assertNotNull(sut.first());
			assertEquals(Integer.valueOf(1), sut.first());
		}
		
		@Test (expected = IndexOutOfBoundsException.class)
		public void testAt_Exception(){
			sut.at(-1);
		}
		
		@Test (expected = IndexOutOfBoundsException.class)
			public void testAt_Exception2(){	
			sut.at(10);
			
		}
		
		@Test public void testHasNext(){
			assertNotNull(sut.at(0));
			assertNotNull(sut.at(1));
			assertNotNull(sut.at(2));
			assertNotNull(sut.at(3));
			assertNotNull(sut.at(4));
			assertNotNull(sut.at(5));
			assertNotNull(sut.at(6));
			assertNotNull(sut.at(7));
			assertNotNull(sut.at(8));
			assertNotNull(sut.at(9));
		}
		
		@Test (expected = Exception.class)
		public void testHasNext2(){
			assertNotNull(sut2.at(0));
		}
		
		@Test (expected = Exception.class)
		public void testHasNext3(){
			assertNotNull(sut3.at(0));
		}

		@Test (expected = Exception.class)
		public void testNext(){
			assertNull(sut.at(10));

		}
		
}
