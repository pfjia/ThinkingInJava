package concurrency;

import java.io.IOException;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by pfjia on 2017/4/24 0024.
 */

class Customer {
    private final int serviceTime;

    public Customer(int serviceTime) {
        this.serviceTime = serviceTime;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    @Override
    public String toString() {
        return "Customer{" + serviceTime +
            '}';
    }
}

class CustomerLine extends ArrayBlockingQueue<Customer> {
    public CustomerLine(int capacity) {
        super(capacity);
    }

    @Override
    public String toString() {
        if (this.size() == 0) {
            return "[Empty]";
        }
        StringBuilder sb = new StringBuilder();
        for (Customer c : this) {
            sb.append(c);
        }
        return sb.toString();
    }
}

// 相当于CustomerManager，控制顾客的人数
class CustomerGenerator implements Runnable {
    private CustomerLine customers;

    private static Random rand = new Random(47);

    public CustomerGenerator(CustomerLine customers) {
        this.customers = customers;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(rand.nextInt(300));
                customers.put(new Customer(rand.nextInt(1000)));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 出纳员
 */
class Teller implements Runnable, Comparable<Teller> {
    private static int counter = 0;
    //出纳员id
    private final int id = counter++;


    //已经服务过的顾客数，以此作为优先级队列的排序方式（服务顾客数少的出纳员优先级较高）
    private int customersServed = 0;

    //顾客队列（FIFO）
    private CustomerLine customers;

    //判断出纳员是服务顾客，还是做其他事
    private boolean servingCoustomerLine = true;

    public Teller(CustomerLine customers) {
        this.customers = customers;
    }

    //Used by priority queue:
    @Override
    public synchronized int compareTo(Teller o) {
        return customersServed < o.customersServed ? -1 : (customersServed == o.customersServed ? 0 : 1);
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Customer customer = customers.take();
                TimeUnit.MILLISECONDS.sleep(customer.getServiceTime());
                synchronized (this) {
                    customersServed++;
                    while (!servingCoustomerLine) {
                        wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this + " interrupted()");
    }

    //让出纳员去做其他事，同时将他服务过的顾客人数清0
    public synchronized void doSomethingElse() {
        customersServed = 0;
        servingCoustomerLine = false;
    }

    public synchronized void serveCustomerLine() {
        assert !servingCoustomerLine : "already serving: " + this;
        servingCoustomerLine = true;
        notifyAll();
    }

    @Override
    public String toString() {
        return "Teller{" +
            "id=" + id +
            '}';
    }

    public String shortString() {
        return "T" + id;
    }
}

class TellerManager implements Runnable {
    private ExecutorService exec;
    //顾客队列
    private CustomerLine customers;

    //服务顾客的出纳员队列
    private PriorityQueue<Teller> workingTellers = new PriorityQueue<>();

    //用于调整服务顾客的出纳员数量，当出纳员数量较多时，调整至这个队列
    private Queue<Teller> tellersDoingOtherThings = new LinkedList<>();


    private int adjustmentPeriod;

    private static Random rand = new Random(47);

    public TellerManager(ExecutorService exec, CustomerLine customers, int adjustmentPeriod) {
        this.exec = exec;
        this.customers = customers;
        this.adjustmentPeriod = adjustmentPeriod;

        Teller teller = new Teller(customers);
        exec.execute(teller);
        workingTellers.add(teller);
    }

    public void adjustTellNumber() {
        // This is actually a control system,By adjusting the numbers,you can reveal stability issues in the control mechanism
        if (customers.size() / workingTellers.size() > 2) {
            // If tellers are on break or doing another job,bring one back
            if (tellersDoingOtherThings.size() > 0) {
                Teller teller = tellersDoingOtherThings.remove();
                teller.serveCustomerLine();
                workingTellers.offer(teller);
                return;
            }

            // Else create (hire) a new teller
            Teller teller = new Teller(customers);
            exec.execute(teller);
            workingTellers.add(teller);
            return;
        }

        // If line is short enough,remove a teller
        if (workingTellers.size() > 1 && customers.size() / workingTellers.size() < 2) {
            reassignOneTeller();
        }

        // If there is no line ,we only need one teller
        if (customers.size() == 0) {
            while (workingTellers.size() > 1) {
                reassignOneTeller();
            }
        }
    }

    private void reassignOneTeller() {
        Teller teller = workingTellers.poll();
        teller.doSomethingElse();
        tellersDoingOtherThings.offer(teller);
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(adjustmentPeriod);
                adjustTellNumber();
                System.out.print(customers + " { ");
                for (Teller teller : workingTellers) {
                    System.out.print(teller.shortString() + " ");
                }
                System.out.println("}");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this + "terminating");
    }
}

public class BankTellerSimulation {
    static final int MAX_LINE_SIZE = 50;
    static final int ADJUSTMENT_PERIOD = 1000;

    public static void main(String[] args) throws InterruptedException, IOException {
        ExecutorService exec = Executors.newCachedThreadPool();

        CustomerLine customers = new CustomerLine(MAX_LINE_SIZE);
        exec.execute(new CustomerGenerator(customers));
        exec.execute(new TellerManager(exec, customers, ADJUSTMENT_PERIOD));
        if (args.length > 0) {
            TimeUnit.SECONDS.sleep(new Integer(args[0]));
        } else {
            System.out.println("Press 'Enter' to quit");
            System.in.read();
        }
        exec.shutdownNow();
    }
}
