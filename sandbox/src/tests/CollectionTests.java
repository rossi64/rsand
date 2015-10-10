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
		
		@Test public void testHasNext1(){
			assertTrue(sut.hasNext());
			sut.next();
			
			assertTrue(sut.hasNext());
			sut.next();
			
			assertTrue(sut.hasNext());
			sut.next();
			
			assertTrue(sut.hasNext());
			sut.next();
			
			assertTrue(sut.hasNext());
			sut.next();
			
			assertTrue(sut.hasNext());
			sut.next();
			
			assertTrue(sut.hasNext());
			sut.next();
			
			assertTrue(sut.hasNext());
			sut.next();
			
			assertTrue(sut.hasNext());
			sut.next();
			
			assertTrue(sut.hasNext());
			sut.next();
			
			assertFalse(sut.hasNext());
		}
		
		@Test public void testNext1(){
			assertTrue(sut.hasNext());
			assertEquals(Integer.valueOf(1), sut.next());
			
			assertTrue(sut.hasNext());
			assertEquals(Integer.valueOf(2), sut.next());
			
			assertTrue(sut.hasNext());
			assertEquals(Integer.valueOf(3), sut.next());
			
			assertTrue(sut.hasNext());
			assertEquals(Integer.valueOf(4), sut.next());
			
			assertTrue(sut.hasNext());
			assertEquals(Integer.valueOf(5), sut.next());
			
			assertTrue(sut.hasNext());
			assertEquals(Integer.valueOf(6), sut.next());
			
			assertTrue(sut.hasNext());
			assertEquals(Integer.valueOf(7), sut.next());
			
			assertTrue(sut.hasNext());
			assertEquals(Integer.valueOf(8), sut.next());
			
			assertTrue(sut.hasNext());
			assertEquals(Integer.valueOf(9), sut.next());
			
			assertTrue(sut.hasNext());
			assertEquals(Integer.valueOf(10), sut.next());
			
			assertFalse(sut.hasNext());
		}
		
		@Test public void testSumCollection(){
			int expectedSum = 55;
			
			//This is one way to sum the collection
			//But it requires that you first get the length then create a for loop to loop over all the enteries
			//This is longer and you could possibly introduce errors in your loop logic
			int len = sut.length();
			int sum1 = 0;
			
			for(int i=0; i<len; i++){
				sum1 = sum1 + sut.at(i);
			}
			
			//The hasNext() and next() functions make it a little neater
			int sum2 = 0;
			
			while(sut.hasNext()){
				sum2 = sum2 + sut.next();
			}
			
			//Remember while(sut.hasNext()){} is shorthand for while(sut.hasNext() == true){}
			//You don't have to keep track of any looping variables, you write that logic in one place,
			//And let the collection manage that itself
			
			//Now, both ways should give us 55
			assertEquals(expectedSum, 	sum1);
			assertEquals(expectedSum, 	sum2);
			assertEquals(sum1, 			sum2); //If you get to this line then it will obviously be true.
		}
		
		/*
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
		*/
}
