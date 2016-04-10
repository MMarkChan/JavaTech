package thread.cooperation;
/**
* Java线程：并发协作-生产者消费者模型
* 
* 错误代码示例
*/
public class ProducerConsumerWrongExample {
	public static void main(String[] args) {
        Godown3 godown = new Godown3(30);
        Consumer3 c1 = new Consumer3(50, godown);
        Consumer3 c2 = new Consumer3(20, godown);
        Consumer3 c3 = new Consumer3(30, godown);
        Producer3 p1 = new Producer3(10, godown);
        Producer3 p2 = new Producer3(10, godown);
        Producer3 p3 = new Producer3(10, godown);
        Producer3 p4 = new Producer3(10, godown);
        Producer3 p5 = new Producer3(10, godown);
        Producer3 p6 = new Producer3(10, godown);
        Producer3 p7 = new Producer3(80, godown);

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
class Godown3 {
    public static final int max_size = 100; //最大库存量
    public volatile int curnum;     //当前库存量
    Godown3() {}
    Godown3(int curnum) {
        this.curnum = curnum;
    }

    /**
     * 生产指定数量的产品
     *
     * @param neednum
     */
    public synchronized void produce(int neednum) {
    	// 意图不断循环生产
    	while(true){
    		if (neednum + curnum > max_size) {
    			/**
    			 * 由于使用了if语句，当当前线程状态从阻塞状态恢复时，
    			 * 它不会再检查库存的状态是否满足条件，
    			 * 而是执行if语句块后面的代码，这明显是不对的,会导致库存状态混乱
    			 */
                System.out.println("要生产的产品数量" + neednum + "超过剩余库存量" + (max_size-curnum) + "，暂时不能执行生产任务!");
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            curnum += neednum;
            System.out.println("已经生产了" + neednum + "个产品，现仓储量为" + curnum);
            notifyAll();
            /**
             * 此代码产生的结果错误的原因在于在同步代码里面使用了死循环，当代码执行到notifyAll()时，虽然它是通知了等待当前
             * 对象锁的线程，但是它随后并没有结束退出此同步方法，而是重新执行while循环体内的代码，因此当前对象的锁并没有被释放，
             * 其它线程没有机会获得锁。
             */
    	}
            
    }

    /**
     * 消费指定数量的产品
     *
     * @param neednum
     */
    public synchronized void consume(int neednum) {
    	 // 意图不断循环消费
    	while(true){
    		if (curnum < neednum) {
    			/**
    			 * 由于使用了if语句，当当前线程状态从阻塞状态恢复时，
    			 * 它不会再检查库存的状态是否满足条件，
    			 * 而是执行if语句块后面的代码，这明显是不对的,会导致库存状态混乱
    			 */
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            curnum -= neednum;
            System.out.println("已经消费了" + neednum + "个产品，现仓储量为" + curnum);
            notifyAll();
            
            /**
             * 此代码产生的结果错误的原因在于在同步代码里面使用了死循环，当代码执行到notifyAll()时，虽然它是通知了等待当前
             * 对象锁的线程，但是它随后并没有结束退出此同步方法，而是重新执行while循环体内的代码，因此当前对象的锁并没有被释放，
             * 其它线程没有机会获得锁。
             */
    	}
	}
        
}

/**
* 生产者
*/
class Producer3 extends Thread {
        private int neednum;                //生产产品的数量
        private Godown3 godown;            //仓库

        Producer3(int neednum, Godown3 godown) {
            this.neednum = neednum;
            this.godown = godown;
        }

        public void run() {
            //生产指定数量的产品
            godown.produce(neednum);
        }
}

/**
* 消费者
*/
class Consumer3 extends Thread {
        private int neednum;                //生产产品的数量
        private Godown3 godown;            //仓库

        Consumer3(int neednum, Godown3 godown) {
            this.neednum = neednum;
            this.godown = godown;
        }

        public void run() {
            //消费指定数量的产品
            godown.consume(neednum);
        }
}

/**
 * 正确的做法是确保一个线程进入的方法在适当的时候退出，以便让出所持有的锁，给其它线程执行的机会
 * 如果要反复执行，则可以在同步方法外多次调用同步方法。
 * */
