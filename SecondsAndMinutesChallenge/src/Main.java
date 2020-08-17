public class Main {

    public static void main(String[] args) {

        System.out.println(getDurationString(60));
        System.out.println(getDurationString(67, 45));
        System.out.println(getDurationString(-1));
    }

    public static String getDurationString(int minutes, int seconds) {

        if (minutes < 0 || seconds < 0 || seconds > 59) {
            return "Invalid Value";
        }

        int hours = minutes / 60;
        minutes = minutes % 60;
        String duration = hours + "h " + minutes + "m " + seconds + "s";
        return duration;
    }

    public static String getDurationString(int seconds) {

        if (seconds < 0) {
            return "Invalid Value";
        }

        int minutes = seconds / 60;
        seconds = seconds % 60;
        return getDurationString(minutes, seconds);
    }
}

