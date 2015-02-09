package hashmap;

import java.util.Arrays;

public class Hashmap<K,V> {
	private int DEFAULT_CAPACITY = 16;
	private int size;
	@SuppressWarnings("unchecked")
	private MyEntry<K, V>[] values = new MyEntry[DEFAULT_CAPACITY];
	
	public V get(K key)
	{
		for(int i = 0;i<size; i++)
		{
			if(values[i].getKey() == key)
				return values[i].getValue();
		}
		return null;
	}
	
	public void put(K key, V value)
	{
		boolean insert = false;
		for(int i=0; i<size; i++)
		{
			if(values[i].getKey() == key)
			{
				values[i].setValue(value);
				insert = true;
			}
		}
		if(!insert)
		{
			MyEntry<K, V> val = new MyEntry<K,V>(key,value);
			ensureCap();
			values[size++] = val;
		}
	}
	
	private void ensureCap()
	{
		if(size == values.length)
		{
			int newSize = values.length * 2;
			values = Arrays.copyOf(values, newSize);
		}
	}
	
}
