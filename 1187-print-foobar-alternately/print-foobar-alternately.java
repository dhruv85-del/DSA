class FooBar {
    private int n;
    private boolean flag=true;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	 synchronized (this){
                if(!flag){
                    wait();
                }
        	  printFoo.run();
              flag=false;
              notify();
             }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
            // printBar.run() outputs "bar". Do not change or remove this line.
            synchronized(this){
                if(flag){
                    wait();
                }
        	  printBar.run();
              flag=true;
              notify();

            }
        }
    }
}