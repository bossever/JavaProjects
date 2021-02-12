class Foo {
    int val;

    public Foo(int val) {
        this(val, 0);  //this MUST be here to refer to another constructor
    }

    public Foo(int val, int another) {
        this.val = val;  //both are the same, but this is more useful.
//        method();        //in a Foo instance, it will refer to this.method()
        this.method();   //but in a Foo2 instance, you must use this to do the same
    }

    public void method() {
        System.out.println("Parent");
    }
}
