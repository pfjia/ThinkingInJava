package containers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.WeakHashMap;


/**
 * Demonstrates performance differences in Maps
 * {Args: 100 5000) Small to keep build testing short
 * @author Administrator
 *
 */
public class MapPerformance {
	static List<Test<Map<Integer,Integer>>> tests=new ArrayList<Test<Map<Integer,Integer>>>();
	
	static{
		tests.add(new Test<Map<Integer,Integer>>("put") {
			
			@Override
			int test(Map<Integer, Integer> container, TestParam tp) {
				// TODO Auto-generated method stub
				int loops=tp.loops;
				int size=tp.size;
				for(int i=0;i<loops;i++){
					container.clear();
					for(int j=0;j<size;j++){
						container.put(j, j);
					}
				}
				return loops*size;
			}
		});
		
		tests.add(new Test<Map<Integer,Integer>>("get") {
			
			@Override
			int test(Map<Integer, Integer> container, TestParam tp) {
				// TODO Auto-generated method stub
				int loops=tp.loops;
				int span=tp.size*2;
				for(int i=0;i<loops;i++){
					for(int j=0;j<span;j++){
						container.get(j);
					}
				}
				return loops*span;
			}
		});
		
		tests.add(new Test<Map<Integer,Integer>>("iterate") {
			
			@Override
			int test(Map<Integer, Integer> container, TestParam tp) {
				// TODO Auto-generated method stub
				int loops=tp.loops*10;
				for(int i=0;i<loops;i++){
					Iterator it=container.entrySet().iterator();
					while(it.hasNext()){
						it.next();
					}
				}
				return loops*container.size();
			}
		});
	}
	
	public static void main(String[] args) {
		if(args.length>0){
			Tester.defaultParams=TestParam.array(args);
		}else{
			Tester.run(new TreeMap<Integer,Integer>(), tests);
			Tester.run(new HashMap<Integer,Integer>(), tests);
			Tester.run(new LinkedHashMap<Integer,Integer>(), tests);
			Tester.run(new IdentityHashMap<Integer, Integer>(), tests);
			Tester.run(new WeakHashMap<Integer, Integer>(), tests);
			Tester.run(new Hashtable<Integer, Integer>(), tests);
		}
	}

}
