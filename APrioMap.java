
public class APrioMap implements PrioMap{
	PrioQueue<Pair<K,V>> heapRep= new BinHeap(/*TODO ADD COMPARATOR*/);
		
	public APrioMap(){
		
	}
	
	public void put(K k, V v){
		
	}
	
	public V get(K k){
		
	}
	
	public Pair<K, V> peek(){
		return heapRep.peek();
	}
	
	public Pair<K, V> poll(){
		return heapRep.poll();
	}
	
}
