package concurrency;

import net.mindview.util.Generator;

import java.util.List;
import java.util.concurrent.*;

/**
 * Created by pfjia on 2017/4/23 0023.
 */
class ExchangerProduce<T> implements Runnable {
    private Generator<T> generator;
    private Exchanger<List<T>> exchanger;
    private List<T> holder;
    public ExchangerProduce(Exchanger<List<T>> exchg,Generator<T>gen,List<T> holder){
        exchanger=exchg;
        generator=gen;
        this.holder=holder;
    }

    @Override
    public void run() {
        try{
            while(!Thread.interrupted()){
                for(int i=0;i<ExchangerDemo.size;i++){
                    holder.add(generator.next());
                }
                holder=exchanger.exchange(holder);
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ExchangerConsumer<T> implements Runnable{
    private Exchanger<List<T>> exchanger;
    private List<T> holder;

    @Override
    public void run() {

    }
}

public class ExchangerDemo {
    static int size=10;
    static int delay=5;

}
