package task1;

public class Ex8Lucky {
    static int x = 0;
    static int count = 0;

    static class LuckyThread extends Thread {
        @Override
        public void run() {

            while (true)
            {
                int temp;

                synchronized (Ex8Lucky.class) {
                    if (x < 999999) {
                        x++;
                        temp = x;
                    } else
                        break;
                }

                if ((temp % 10) + (temp / 10) % 10 + (temp / 100) % 10 == (temp / 1000) % 10 + (temp / 10000) % 10 + (temp / 100000) % 10) {

                    /*//имитируем долгие вычисления
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {

                    }*/

                    System.out.println(temp);

                    synchronized (Ex8Lucky.class)
                    {
                        count++;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //long start = System.currentTimeMillis();

        Thread t1 = new LuckyThread();
        Thread t2 = new LuckyThread();
        Thread t3 = new LuckyThread();
        /*Thread t4 = new LuckyThread();
        Thread t5 = new LuckyThread();
        Thread t6 = new LuckyThread();
        Thread t7 = new LuckyThread();
        Thread t8 = new LuckyThread();
        Thread t9 = new LuckyThread();
        Thread t10 = new LuckyThread();
        Thread t11 = new LuckyThread();
        Thread t12 = new LuckyThread();*/

        t1.start();
        t2.start();
        t3.start();
        /*t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();
        t11.start();
        t12.start();*/

        t1.join();
        t2.join();
        t3.join();
        /*t4.join();
        t5.join();
        t6.join();
        t7.join();
        t8.join();
        t9.join();
        t10.join();
        t11.join();
        t12.join();*/

        System.out.println("Total: " + count);

        //Измерыем примерное время выполнения
        //System.out.println(System.currentTimeMillis() - start);

        /*ИТОГО:
        * при работе в 1 поток:   84495
        * при работе в 6 потоков: 12983
        * при работе в 12 потоков: 6046*/
    }
}
