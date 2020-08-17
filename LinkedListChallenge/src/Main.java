/*  	// Create a program that implements a playlist for songs
        // Create a Song class having Title and Duration for a song.
        // The program will have an Album class containing a list of songs.
        // The albums will be stored in an ArrayList
        // Songs from different albums can be added to the playlist and will appear in the list in the order
        // they are added.
        // Once the songs have been added to the playlist, create a menu of options to:-
        // Quit,Skip forward to the next song, skip backwards to a previous song. Replay the current song.
        // List the songs in the playlist
        // A song must exist in an album before it can be added to the playlist (so you can only play songs that
        // you own).
        // Hint: To replay a song, consider what happened when we went back and forth from a city before we
        // started tracking the direction we were going.
        // As an optional extra, provide an option to remove the current song from the playlist
        // (hint: listIterator.remove()
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
                    }
                    else {
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
                    }
                    else {
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
            String albumName = "album" + (albumNameCount+1);
            albumArrayList.add(new Album(albumName, songCount));
        }
    }

    public static void showPlaylist() {
        System.out.println("\nPlaylist : ");
        Iterator<Song> playlistIterator = playlist.iterator();

        while (playlistIterator.hasNext()) {
            Song song = playlistIterator.next();
            System.out.println("    " + "--> " + song.getTitle() + " " + (song.getDurationInSeconds()/60) + ":" + (song.getDurationInSeconds()%60));
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
            }
            else {
                System.out.println("Invalid number entered.");
            }
        }
    }
}