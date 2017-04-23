package typeinfo.pets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public abstract class PetCreator {
	private Random rand = new Random(47);
	public abstract List<Class<? extends Pet>> getTypes();
	
	public Pet randomPet(){
		int n=rand.nextInt(getTypes().size());
		try{
			return getTypes().get(n).newInstance();
		}catch(IllegalAccessException e){ 
			throw new RuntimeException(e);
		}catch (InstantiationException e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 根据size返回对应长度的Pet数组
	 * @param size
	 * @return
	 */
	public Pet[] createArray(int size){
		Pet[] result=new Pet[size];
		for(int i=0;i<size;i++){
			result[i]=randomPet();
		}
		return result;
	}
	/**
	 * 根据size返回对应长度的Pet ArrayList
	 * @param size
	 * @return
	 */
	public ArrayList<Pet> arrayList(int size){
		ArrayList<Pet> result=new ArrayList<Pet>();
		Collections.addAll(result, createArray(size));
		return result;
	}
}
