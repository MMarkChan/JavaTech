package thread.cooperation;
/**
* Java线程：并发协作-生产者消费者模型
* 
* 实际上，准确说应该是“生产者-消费者-仓储”模型，离开了仓储，生产者消费者模型就显得没有说服力了。
* 对于此模型，应该明确一下几点：
* 
* 1、生产者仅仅在仓储未满时候生产，仓满则停止生产。
* 2、消费者仅仅在仓储有产品时候才能消费，仓空则等待。
* 3、当消费者发现仓储没产品可消费时候会通知生产者生产。
* 4、生产者在生产出可消费产品时候，应该通知等待的消费者去消费。
* 
* 此模型将要结合java.lang.Object的wait与notify、notifyAll方法来实现以上的需求。这是非常重要的。
*
* @author leizhimin 2009-11-4 14:54:36
*/
public class ProducerConsumer {
	public static void main(String[] args) {
        Godown godown = new Godown(30);
        Consumer2 c1 = new Consumer2(50, godown);
        Consumer2 c2 = new Consumer2(20, godown);
        Consumer2 c3 = new Consumer2(30, godown);
        Producer2 p1 = new Producer2(10, godown);
        Producer2 p2 = new Producer2(10, godown);
        Producer2 p3 = new Producer2(10, godown);
        Producer2 p4 = new Producer2(10, godown);
        Producer2 p5 = new Producer2(10, godown);
        Producer2 p6 = new Producer2(10, godown);
        Producer2 p7 = new Producer2(80, godown);

        c1.start();
        c2.start();
        c3.start();
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
        p6.start();
        p7.start();
	}
}

/**
* 仓库
*/
class Godown {
    public static final int max_size = 100; //最大库存量
    public volatile int curnum;     //当前库存量
    Godown() {}
    Godown(int curnum) {
        this.curnum = curnum;
    }

    /**
     * 生产指定数量的产品
     *
     * @param neednum
     */
    public synchronized void produce(int neednum) {
    		//测试是否需要生产
            while (neednum + curnum > max_size) {
                System.out.println("要生产的产品数量" + neednum + "超过剩余库存量" + (max_size-curnum) + "，暂时不能执行生产任务!");
                try {
                    //当前的生产线程等待
                    wait(); // 调用后，当前线程处于阻塞状态，等等notify()或notifyAll()信号的到来再恢复执行后面的代码
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //满足生产条件，则进行生产，这里简单的更改当前库存量
            curnum += neednum;
            System.out.println("已经生产了" + neednum + "个产品，现仓储量为" + curnum);
            //唤醒在此对象监视器上等待的所有线程
            notifyAll();
    }

    /**
     * 消费指定数量的产品
     *
     * @param neednum
     */
    public synchronized void consume(int neednum) {
		//测试是否可消费
        while (curnum < neednum) {
            try {
                //当前的生产线程等待
                wait(); // 调用后，当前线程处于阻塞状态，等等notify()或notifyAll()信号的到来再恢复执行后面的代码
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //满足消费条件，则进行消费，这里简单的更改当前库存量
        curnum -= neednum;
        System.out.println("已经消费了" + neednum + "个产品，现仓储量为" + curnum);
        //唤醒在此对象监视器上等待的所有线程
        notifyAll();
	}
        
}

/**
* 生产者
*/
class Producer2 extends Thread {
        private int neednum;                //生产产品的数量
        private Godown godown;            //仓库

        Producer2(int neednum, Godown godown) {
            this.neednum = neednum;
            this.godown = godown;
        }

        public void run() {
        	while(true){
	            //生产指定数量的产品
	            godown.produce(neednum);
        	}
        }
}

/**
* 消费者
*/
class Consumer2 extends Thread {
        private int neednum;                //生产产品的数量
        private Godown godown;            //仓库

        Consumer2(int neednum, Godown godown) {
            this.neednum = neednum;
            this.godown = godown;
        }

        public void run() {
        	while(true){
	            //消费指定数量的产品
	            godown.consume(neednum);
        	}
        }
}
