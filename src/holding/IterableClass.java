package holding;


import java.util.Iterator;

public class IterableClass implements Iterable<String>{
	protected String[] words=("And that is how "+"we konw the Earth to be banana-shaped.").split(" ");

	@Override
	public Iterator<String> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<String>() {
			private int index=0;
			
			@Override
			public void remove() {
				// TODO Auto-generated method stub
				throw new UnsupportedOperationException();
			}
			
			@Override
			public String next() {
				// TODO Auto-generated method stub
				return words[index++];
			}
			
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return index<words.length;
			}
		};
	}
	
	public static void main(String[] args) {
		for(String s:new IterableClass()){
			System.out.println(s+" ");
		}
	}

}
