public class FlourPacker {

    public static boolean canPack(int bigCount, int smallCount, int goal) {

        if (bigCount < 0 || smallCount < 0 || goal < 0) {
            return false;
        }

        int totalWeight = (bigCount * 5) + smallCount;

        if  (totalWeight == goal) {
            return true;
        }
        else if (totalWeight > goal) {

            if ((totalWeight - goal) >= 5) {
                bigCount -= (totalWeight - goal) / 5;
            }

            totalWeight = (bigCount * 5) + smallCount;

            if (totalWeight > goal) {
                smallCount -= (totalWeight - goal);
            }

            totalWeight = (bigCount * 5) + smallCount;

            if (totalWeight == goal && smallCount >= 0 && bigCount >= 0) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }
}
