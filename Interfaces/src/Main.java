public class Main {

    public static void main(String[] args) {
        ITelephone ashusPhone;
        ashusPhone = new DeskPhone(123456);
        ashusPhone.powerOn();
        ashusPhone.callPhone(123456);
        ashusPhone.answer();

        ashusPhone = new MobilePhone(24565);
        ashusPhone.powerOn();
        ashusPhone.callPhone(24565);
        ashusPhone.answer();
    }
}
