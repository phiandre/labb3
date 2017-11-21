
import java.util.*;


public class APrioMap<K,V extends Comparable<? super V>> implements PrioMap<K,V>{
	private PrioQueue<Pair<K,V>> heapRep= new BinHeap<Pair<K,V>>(new PairComparator<Pair<K,V>>());
	private HashMap<K,V> map = new HashMap<K,V>(); 	
	
	public APrioMap(){
		
	}
	
	public void put(K k, V v){
		/* CHECK IF KEY ALREADY EXISTS*/
		if(map.containsKey(k))
			map.remove(k);
		
		/* Add the element to both map and heap */
		Pair<K,V> newPair = new Pair<K,V>(k,v);
		heapRep.add(newPair);
		map.put(k,v);
	}
	
	public V get(K k){
		return map.get(k);
	}
	
	public Pair<K, V> peek(){
		return heapRep.peek();
	}
	
	public Pair<K, V> poll(){
		/* Element must be removed from both map and heap */
		Pair<K,V> tmp = heapRep.poll();
		map.remove(tmp.a);
		return tmp;
	}

	
	private class PairComparator<Pair> implements Comparator<Pair<K,V extends Comparable<? super V>>> {
		@Override
		public int compare(Pair<K,V> p1, Pair<K,V> p2){
			return (p1.b).compareTo(p2.b);
		}
	}
}
