public class SerieATeam extends Team {

    public SerieATeam(String name) {
        super(name);
    }

    @Override
    public int compareTo(Team team) {

        if (this.getPoints() > team.getPoints()) {
            return -1;
        }
        else if (this.getPoints() == team.getPoints()) {
            return 0;
        }
        else {
            return 1;
        }
    }
}
