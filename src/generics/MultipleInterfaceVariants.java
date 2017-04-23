package generics;

interface Payable<T> {

}

class Employee2 implements Payable<Employee2> {

}

// 若两个类继承的接口中移除泛型参数则可以编译

// The interface Payable cannot be implemented more than once with different
// arguments: Payable<Employee2> and Payable<Hourly>
// class Hourly extends Employee2 implements Payable<Hourly> {
//
// }

public class MultipleInterfaceVariants {

}
