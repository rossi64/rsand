package sandbox.core;
import sandbox.core.collection.Collection;
import sandbox.core.collection.implementations.RCollection;

public class Core{
	public static _Factory Factory = (new Core()).new _Factory();
	
	public class _Factory{
		public <Type> Collection<Type> Collection(Type[] array){
			return new RCollection<>(array);
		}
	}
}
