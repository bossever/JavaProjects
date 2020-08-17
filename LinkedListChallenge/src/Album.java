import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Album {

    private String albumName;
    private int songNameCount = 0;
    private LinkedList<Song> songList = new LinkedList<Song>();
    private Scanner scanner = new Scanner(System.in);

    public Album(String albumName, int songCount) {
        this.albumName = albumName;
        songGenerator(songCount);
    }

    public Song returnSong(int songIndex) {
        if (songIndex <= songList.size()) {
            return songList.get(songIndex);
        }
        else {
            System.out.println("Invalid number entered");
            return null;
        }
    }

    public void showSongs() {
        Iterator<Song> songIterator = songList.iterator();          //must be initialized inside the method to avoid ConcurrentModificationException

        while(songIterator.hasNext()) {
            Song song = songIterator.next();
            System.out.println("    " + " - " + song.getTitle() + " " + (song.getDurationInSeconds()/60) + ":" + (song.getDurationInSeconds()%60));
        }
        System.out.println();
    }

    public void addSongToAlbum() {
        System.out.print("Enter the title of the song : ");
        String songTitle = scanner.nextLine();
        System.out.print("Enter the duration of the song in seconds : ");
        int songDuration = scanner.nextInt();
        scanner.nextLine();
        songList.add(new Song(songTitle, songDuration));
        System.out.println("Song " + songTitle + " successfully added to the album " + this.albumName + ".");
    }

    public void songGenerator(int songCount) {
        //generates songs and adds them to songList
        int songNameCountConstant = songNameCount;

        for (; songNameCount < songCount + songNameCountConstant; songNameCount++) {
            String songTitle = this.albumName + "_song" + (songNameCount+1);
            int songDuration = (int) (Math.random() * 200);
            Song song = new Song(songTitle, songDuration);
            songList.add(song);
        }
        System.out.println(songCount + " songs added to the album " + this.albumName + ".");
    }

    public String getAlbumName() {
        return albumName;
    }
}
