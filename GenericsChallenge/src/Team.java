public abstract class Team implements Comparable<Team> {

    private String name;
    private int matchesPlayed = 0;
    private int wins = 0, losses = 0, draws = 0;
    private int points = 0;

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public void playMatch(Team awayTeam, int homeScore, int awayScore) {

        if (homeScore > awayScore) {
            this.wins++;
            this.points += 3;
        }
        else if (homeScore == awayScore) {
            this.draws++;
            this.points++;
        }
        else {
            this.losses++;
        }
        matchesPlayed++;

        if (awayTeam != null) {
            awayTeam.playMatch(null, awayScore, homeScore);
        }
    }

    @Override
    public String toString() {
        return this.name + "\t |  " + matchesPlayed + " \t|   " + wins + "\t|   " + draws + "\t|   " + losses + "\t| " + points + " pts |";
    }
}
