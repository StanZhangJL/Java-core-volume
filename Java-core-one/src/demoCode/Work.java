package demoCode;

public class Work {
    public void doWork(Callback callback){
        System.out.println("Starting async work...==================" + Thread.currentThread().getName());
        //模拟执行一些任务
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Doing some work in a separate thread...==============" + Thread.currentThread().getName());
                // 模拟执行一些任务
                try {
                    Thread.sleep(20000);  // 模拟耗时任务
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //当任务完成时进行调用 回调函数
                //理解：函数回调是指方法中代码逻辑执行完成一下任务后，才会再回来继续调用一个方法一般是异步的
                callback.onComplete("Work complete 回调函数"+Thread.currentThread().getName());
                System.out.println("Work========" + Thread.currentThread().getName());
            }
        }).start();
    }

    public static void main(String[] args) {
        System.out.println("Main================== "+Thread.currentThread().getName());
        Work work = new Work();
        work.doWork(msg -> System.out.println("Callback received: " + msg));

        System.out.println("Main thread is free to do other things...========"+Thread.currentThread().getName());

    }
}
