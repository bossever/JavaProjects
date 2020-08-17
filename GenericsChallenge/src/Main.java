/*      // Create a generic class to implement a league table for a sport.
        // The class should allow teams to be added to the list, and store
        // a list of teams that belong to the league.
        //
        // Your class should have a method to print out the teams in order,
        // with the team at the top of the league printed first.
        //
        // Only teams of the same type should be added to any particular
        // instance of the league class - the program should fail to compile
        // if an attempt is made to add an incompatible team.
 */

import java.util.ArrayList;

public class Main {

    public static League<LaLigaTeam> laLiga = new League<>("LaLiga");
    public static League<EPLTeam> epl = new League<>("English Premier League");
    public static League<SerieATeam> serieA = new League<>("Serie A");

    public static void main(String[] args) {

        laLiga.setTeamList(LaLigaTeamGenerator(12));
        epl.setTeamList(EPLTeamGenerator(12));
        serieA.setTeamList(SerieATeamGenerator(12));

        System.out.println("\n");

        laLiga.fixtures();
        laLiga.printTable();
        System.out.println("\n");

        epl.fixtures();
        epl.printTable();
        System.out.println("\n");

        serieA.fixtures();
        serieA.printTable();
        System.out.println("\n");


    }

    public static ArrayList<LaLigaTeam> LaLigaTeamGenerator(int numberOfTeams) {
        String name;
        ArrayList<LaLigaTeam> teamList = new ArrayList<>();

        for (int i = 0; i < numberOfTeams; i++) {
            name = "LaLiga" + "_team" + (i+1);
            teamList.add(new LaLigaTeam(name));
        }
        return teamList;
    }

    public static ArrayList<EPLTeam> EPLTeamGenerator(int numberOfTeams) {
        String name;
        ArrayList<EPLTeam> teamList = new ArrayList<>();

        for (int i = 0; i < numberOfTeams; i++) {
            name = "LaLiga" + "_team" + (i+1);
            teamList.add(new EPLTeam(name));
        }
        return teamList;
    }

    public static ArrayList<SerieATeam> SerieATeamGenerator(int numberOfTeams) {
        String name;
        ArrayList<SerieATeam> teamList = new ArrayList<>();

        for (int i = 0; i < numberOfTeams; i++) {
            name = "LaLiga" + "_team" + (i+1);
            teamList.add(new SerieATeam(name));
        }
        return teamList;
    }
}
