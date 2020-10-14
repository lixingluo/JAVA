# Java Multithread 
## Thread Main Features
1. Set Priority
   - Thread.MAX_PRIORITY
   - Thread.NORM_PRIORITY
   - Thread.MIN_PRIORITY
2. Sleep 
   - 线程的睡眠，不释放锁
3. Wait 
   - 线程的等待，释放锁，本质是Object.wait()，call了Object.wait()之后，持有本Object的线程会进入'等待队列(等待池)'，需要Object.notify()/notifyAll()来唤醒，重新获得对象锁
4. Yield
   - 线程的让步，顾名思义，遇到yield会暂停目前执行的线程，把CPU资源让给更高优先级的线程或者跟已暂停线程优先级相同的线程
5. Join
   - 线程的加入，主线程里调用join会等子线程完成返回后，主线程才继续运行
6. Notify
   - 线程的唤醒，本质是Object.notify()。
   - Object类中的notify()方法，唤醒在此对象监视器上等待的单个线程。如果所有线程都在此对象上等待，则会选择唤醒其中一个线程。选择是任意性的，并在对实现做出决定时发生。
   - 线程通过调用其中一个 wait 方法，在对象的监视器上等待。 直到当前的线程放弃此对象上的锁定，才能继续执行被唤醒的线程。被唤醒的线程将以常规方式与在该对象上主动同步的其他所有线程进行竞争

## Important Explanation
- Obj.wait()，与Obj.notify()必须要与synchronized(Obj)一起使用，也就是wait,与notify是针对已经获取了Obj锁进行操作
- 从语法角度来说就是Obj.wait(),Obj.notify必须在synchronized(Obj){...}语句块内
- 从功能上来说wait就是说线程在获取对象锁后，主动释放对象锁，同时本线程休眠。直到有其它线程调用对象的notify()，从而唤醒该线程，才能继续获取对象锁，并继续执行
- 相应的notify()就是对对象锁的唤醒操作
- 但有一点需要注意的是notify()调用后，并不是马上就释放对象锁的，而是在相应的synchronized(){}语句块执行结束，自动释放锁后，JVM会在wait()对象锁的线程中随机选取一线程，赋予其对象锁，唤醒线程，继续执行
- 这样就提供了在线程间同步、唤醒的操作。Thread.sleep()与Object.wait()二者都可以暂停当前线程，释放CPU控制权，主要的区别在于Object.wait()在释放CPU同时，释放了对象锁的控制

## wait() vs sleep()
- sleep()睡眠时，保持对象锁，仍然占有该锁
- 而wait()睡眠时，释放对象锁，使得其他线程可以使用同步控制块或者方法
- wait，notify和notifyAll只能在同步控制方法或者同步控制块里面使用，而sleep可以在任何地方使用
- wait()和sleep()都可以通过interrupt()方法打断线程的暂停状态，从而使线程立刻抛出InterruptedException（但不建议使用该方法）
- 在sleep()休眠时间期满后，该线程不一定会立即执行，这是因为其它线程可能正在运行而且没有被调度为放弃执行，除非此线程具有更高的优先级

## 专有名词解释
- 主线程：JVM调用程序main()所产生的线程。
- 当前线程：这个是容易混淆的概念。一般指通过Thread.currentThread()来获取的进程。
- 后台线程：又称守护线程，指为其他线程提供服务的线程。JVM的垃圾回收线程就是一个后台线程。用户线程和守护线程的区别在于，是否等待主线程依赖于主线程结束而结束
- 前台线程：是指接受后台线程服务的线程，其实前台后台线程是联系在一起，就像傀儡和幕后操纵者一样的关系。傀儡是前台线程、幕后操纵者是后台线程。由前台线程创建的线程默认也是前台线程。可以通过isDaemon()和setDaemon()方法来判断和设置一个线程是否为后台线程。

## 常用方法
- sleep(): 强迫一个线程睡眠Ｎ毫秒。 
- isAlive(): 判断一个线程是否存活。 
- join(): 等待线程终止。 
- activeCount(): 程序中活跃的线程数。 
- enumerate(): 枚举程序中的线程。 
- currentThread(): 得到当前线程。 
- isDaemon(): 一个线程是否为守护线程。 
- setDaemon(): 设置一个线程为守护线程。(用户线程和守护线程的区别在于，是否等待主线程依赖于主线程结束而结束) 
- setName(): 为线程设置一个名称。 
- wait(): 强迫一个线程等待。 
- notify(): 通知一个线程继续运行。 
- setPriority(): 设置一个线程的优先级。

## synchronized 关键字作用域
1. 针对对象，即某个类实例化后的对象(object)，作用于单一object。synchronized aMethod()，只要有一个线程访问了其中的一个aMethod()，其他线程不能同时访问这个object内任何一个synchronized方法。但是同一个类实例化后的不同对象不受这个影响，也就是说其他线程还可以访问相同类的其他对象实例中的synchronized方法
2. 针对类本身，即某个类class本身，作用于该类下所有的object。synchronized static aStaticMethod()防止多个线程同时访问这个类中的synchronized static方法
3. 针对方法中的某个区块，即synchronized(this){/*区块*/}，表示这个区块的资源互斥(实行互斥访问，即不能多个线程同时访问)。作用域是当前对象，这点同1，1也是当前对象
4. synchronized关键字是不能被继承的，也就是说，基类的方法synchronized f()在继承中并不自动是synchronized f()，而是变成了f()。继承类需要显示指定它的某个方法为synchronized方法

## synchronized source code
```
public synchronized void methodAAA()
{
  //...
}
```
等价于
```
public void methodAAA()
{
  synchronized(this)
  {
    //...
  }
}
```
等价于
```
private Object c;
public void methodAAA()
{
  synchronized(c) {
    //...
  }
}
```
1. synchronized当函数修饰符，锁同步方法的对象，线程调用同一对象时互斥
2. synchronized作用于object reference
3. synchronized锁的是c这个对象，谁拿到这个锁谁就可以运行它所控制的那段代码，实际锁的还是object c和methodAAA()所处的对象

## 总结
1. (_首先要知道存在的目的是什么_)线程同步的目的是为了保护多个线程访问一个资源，资源不受到破坏
2. (_知道了目的就要搞懂怎么实现_)线程同步是通过锁来实现，每个对象都有切仅有一个锁，类本身有一把大锁，这把大锁可以锁所有这个类实例化的对象。线程一旦获取了对象锁，其他访问该对象的线程就无法再访问该对象的其他同步方法，可以访问非同步方法。对于静态同步方法，锁是针对这个类的，锁对象是该类的Class对象。静态和非静态方法的锁互不干预。一个线程获得锁，当在一个同步方法中访问另外对象上的同步方法时，会获取这两个对象锁
3. (_知道了怎么实现就要注意编写代码时的逻辑_)编写线程安全的类，需要时刻注意对多个线程竞争访问资源的逻辑和安全做出正确的判断，保证原子操作期间别的线程无法访问竞争资源。
4. (_知道了编写逻辑就要懂得分析运行起来会发生什么_)当多个线程等待一个对象锁时，没有获取到锁的线程将发生阻塞