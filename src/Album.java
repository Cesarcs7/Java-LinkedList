import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String artist;
    private String name;
    private ArrayList<Song> listOfSongs;

    public Album(String artist, String name) {
        this.artist = artist;
        this.name = name;
        this.listOfSongs = new ArrayList<Song>();
    }

    public boolean addSong(String title, Double duration) {
        if(findSong(title) == null){
            this.listOfSongs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    private Song findSong(String title) {
        for (Song song : this.listOfSongs) {
            if(song.getTitle().equals(title)){
                return song;
            }
        }
        return null;
    }

    public boolean addToPlaylist(int trackNumber, LinkedList<Song> playList) {
        int index = trackNumber -1;
        if((index >=0) && (index <= this.listOfSongs.size())){
            playList.add(this.listOfSongs.get(index));
            return true;
        }
        System.out.printf("This album does not have a track "+ trackNumber);
        return false;
    }

    public boolean addToPlaylist(String title, LinkedList<Song> playList) {
       Song checkedSong = findSong(title);
        if (checkedSong != null){
            playList.add(checkedSong);
        }
        System.out.printf("The song "+ checkedSong + "is not in this album");
        return false;
    }
}
