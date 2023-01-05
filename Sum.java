class Sum extends java.lang.Thread {
    static int N;
    static int P;
    static int sum = 0;
    static Object lck = new Object();

    int low;
    int high;
    int psum;

    Sum(int tid) {
        low = (N / P) * tid;
        high = low + (N / P);
        psum = 0;
    }

    int compute(int i) {
        return i * i;
    }

    public void run() {
        for (int i = low; i < high; i++) {
            psum += compute(i);
        }
        synchronized (lck) {
            System.out.print(
                    "ThreadID: " + Thread.currentThread().getName() + " psum = " + psum + ", and has a range of "
                            + low
                            + " to" + high + ".\n");
            sum += psum;
        }
    }

    public static void main(String[] args) {
        String filePath = args[2];
        N = Integer.parseInt(args[0]);
        P = Integer.parseInt(args[1]);
        System.out.print("filePath = " + filePath + " N =" + N + "and P =" + P + ".\n");
        try {
            Sum[] threads = new Sum[P];
            for (int k = 0; k < P; k++) // create threads
                threads[k] = new Sum(k);
            for (int k = 0; k < P; k++) // start threads
                threads[k].start();
            for (int k = 0; k < P; k++) // join threads
                threads[k].join();
            System.out.println("The sum is " + sum + " (should be 332833500)");
            if (sum != 332833500)
                System.out.println("*** Found an incorrect answer, " + sum + "! ***");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}