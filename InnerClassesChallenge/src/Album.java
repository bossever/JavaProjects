import java.util.*;

public class Album {

    private String albumName;
    private SongList songList;
    private int songNameCount = 0;

    public Album(String albumName, int songCount) {
        this.albumName = albumName;
        songList = new SongList();
        this.songList.songGenerator(songCount);
    }

    public String getAlbumName() {
        return albumName;
    }

    public void showSongs() {
        songList.showSongs();
    }

    public Song returnSong(int index) {
        return songList.returnSong(index);
    }

    private class SongList {

        private List<Song> songArrayList = new ArrayList<Song>();
        private Scanner scanner = new Scanner(System.in);

        public void addSongToAlbum() {
            System.out.print("Enter the title of the song : ");
            String songTitle = scanner.nextLine();
            System.out.print("Enter the duration of the song in seconds : ");
            int songDuration = scanner.nextInt();
            scanner.nextLine();
            songArrayList.add(new Song(songTitle, songDuration));
            System.out.println("Song " + songTitle + " successfully added to the album " + albumName + ".");
        }

        public void songGenerator(int songCount) {
            //generates songs and adds them to songArrayList
            int songNameCountConstant = songNameCount;

            for (; songNameCount < songCount + songNameCountConstant; songNameCount++) {
                String songTitle = albumName + "_song" + (songNameCount+1);
                int songDuration = (int) (Math.random() * 200);
                Song song = new Song(songTitle, songDuration);
                songArrayList.add(song);
            }
            System.out.println(songCount + " songs added to the album " + albumName + ".");
        }

        public Song returnSong(int songIndex) {
            if (songIndex <= songArrayList.size()) {
                return songArrayList.get(songIndex);
            }
            else {
                System.out.println("Invalid number entered");
                return null;
            }
        }

        public void showSongs() {
            Iterator<Song> songIterator = songArrayList.iterator();          //must be initialized inside the method to avoid ConcurrentModificationException

            while(songIterator.hasNext()) {
                Song song = songIterator.next();
                System.out.println("    " + " - " + song.getTitle() + " " + (song.getDurationInSeconds()/60) + ":" + (song.getDurationInSeconds()%60));
            }
            System.out.println();
        }
    }
}
