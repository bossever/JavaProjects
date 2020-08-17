public class Main {

    public static void main(String[] args) {

        ParentClass parentObject = new ParentClass();
        ChildClass childObject = new ChildClass();

        System.out.println(ObjectSizeFetcher.getObjectSize(parentObject));
        System.out.println(ObjectSizeFetcher.getObjectSize(childObject));
    }
}
