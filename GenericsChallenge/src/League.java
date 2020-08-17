import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Team> {

    private String name;
    private ArrayList<T> teamList = new ArrayList<T>();

    public League(String name) {
        this.name = name;
    }

    public void printTable() {
        Collections.sort(teamList);
        System.out.println(name + " standings : \n");
        System.out.println("Team Name \t\t\t |  MP\t|   W \t|   D \t|   L \t| Points |");
        int num = 1;

        for (T team : teamList) {
            System.out.print(" " + num + ". ");
            System.out.println(team);
            num++;
        }
    }

    public void setTeamList(ArrayList teamList) {
        this.teamList.addAll(teamList);
    }

    public void fixtures() {

        for (T homeTeam : teamList) {

            for (T awayTeam : teamList) {

                if (homeTeam != awayTeam) {
                    playMatch(homeTeam, awayTeam);
                }
            }
        }
    }

    public void playMatch(T homeTeam, T awayTeam) {
        int homeScore = (int) (Math.random() * 10);
        int awayScore = (int) (Math.random() * 10);

        homeTeam.playMatch(awayTeam, homeScore, awayScore);
    }
}
