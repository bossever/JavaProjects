/*  //We'll be using the source code from the LinkedList challenge
    // Modify the playlist challenge so that the Album class uses an inner class.
    // Instead of using an ArrayList to hold its tracks, it will use an inner class called SongList
    // The inner SongList class will use an ArrayList and will provide a method to add a song.
    // It will also provide findSong() methods which will be used by the containing Album class
    // to add songs to the playlist.
    // Neither the Song class or the Main class should be changed.
 */


import java.util.*;

public class Main {

    private static ArrayList<Album> albumArrayList = new ArrayList<Album>();
    private static LinkedList<Song> playlist = new LinkedList<Song>();
    private static int albumNameCount = 0;

    public static void main(String[] args) {
        albumGenerator(5, 10);
        addSongsToPlaylist();
        playlistMenu();
    }

    public static void playlistMenu() {
        boolean quit = false;
        ListIterator<Song> playlistIterator = playlist.listIterator();
        Song currentSong = playlistIterator.next();
        Scanner scanner = new Scanner(System.in);
        boolean goingForward = true;
        while (!quit) {
            System.out.println("Current track : " + currentSong.getTitle());
            printPlaylistMenu();
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    if (!goingForward) {
                        playlistIterator.next();
                    }
                    if (playlistIterator.hasNext()) {
                        currentSong = playlistIterator.next();
                    } else {
                        System.out.println("End of playlist!");
                    }
                    goingForward = true;
                    break;
                case 2:
                    if (goingForward) {
                        playlistIterator.previous();
                    }
                    if (playlistIterator.hasPrevious()) {
                        currentSong = playlistIterator.previous();
                    } else {
                        System.out.println("Start of playlist!");
                    }
                    goingForward = false;
                    break;
                case 3:
                    playlistIterator.previous();
                    goingForward = false;
                    break;
                case 4:
                    showPlaylist();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public static void printPlaylistMenu() {
        System.out.println("\nChoose an option : \n0 - quit \n1 - Skip to next track \n2 - Skip to previous track \n3 - Replay current song \n4 - Show playlist");
    }

    public static void showAlbums() {
        for (int i = 0; i < albumArrayList.size(); i++) {
            System.out.println("--> " + albumArrayList.get(i).getAlbumName() + " : ");
            albumArrayList.get(i).showSongs();
        }
    }

    public static void albumGenerator(int albumCount, int songCount) {
        //generates albums and adds them to albumArrayList
        int albumNameCountConstant = albumNameCount;

        for (; albumNameCount < albumCount - albumNameCountConstant; albumNameCount++) {
            String albumName = "album" + (albumNameCount + 1);
            albumArrayList.add(new Album(albumName, songCount));
        }
    }

    public static void showPlaylist() {
        System.out.println("\nPlaylist : ");
        Iterator<Song> playlistIterator = playlist.iterator();

        while (playlistIterator.hasNext()) {
            Song song = playlistIterator.next();
            System.out.println("    " + "--> " + song.getTitle() + " " + (song.getDurationInSeconds() / 60) + ":" + (song.getDurationInSeconds() % 60));
        }
        System.out.println();
    }

    public static void addSongsToPlaylist() {
        showAlbums();
        boolean addMoreSongs = true;
        Scanner scanner = new Scanner(System.in);

        while (addMoreSongs) {
            System.out.print("Enter the album number : ");
            int albumNo = scanner.nextInt();

            if (albumNo <= albumArrayList.size()) {
                System.out.print("Enter the song number : ");
                int songNo = scanner.nextInt();
                scanner.nextLine();

                if (albumArrayList.get(albumNo - 1).returnSong(songNo - 1) != null) {
                    Song song = albumArrayList.get(albumNo - 1).returnSong(songNo - 1);
                    playlist.add(song);
                    System.out.print("Do you want to add more songs? (y/n) : ");
                    if (scanner.nextLine().trim().equals("y")) {
                        System.out.println();
                    } else {
                        addMoreSongs = false;
                    }
                }
            } else {
                System.out.println("Invalid number entered.");
            }
        }
    }
}

