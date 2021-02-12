class Foo2 extends Foo {

    public Foo2(int val) {
        this(val, 0);       //this will refer to the other Foo2 constructor
    }
    public Foo2(int val, int another) {
        super(val, another);
//        super.method();             //this will refer to Foo.method1()
    }

    @Override
    public void method() {
        System.out.println("Child");
    }        //overridden method
}