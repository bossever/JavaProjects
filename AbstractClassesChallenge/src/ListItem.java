public abstract class ListItem {

    private String value;
    protected ListItem next, previous;

    public ListItem getNext() {
        return next;
    }

    public ListItem getPrevious() {
        return previous;
    }

    public static int compareTo(ListItem currentValue, ListItem passedValue) {
        return currentValue.getValue().compareToIgnoreCase(passedValue.getValue());
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}