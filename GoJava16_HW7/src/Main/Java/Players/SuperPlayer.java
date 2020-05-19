package Main.Java.Players;

public abstract class SuperPlayer {
    String song;
    String[] playlist;

    public String getSong() {
        return song;
    }

    public String[] getPlaylist() {
        return playlist;
    }

    public void playSong(String songName) {
        System.out.println("Playing: " + songName);
    }

    public void playAllSongs(String[] playlist) {
        for (String song : playlist) {
            System.out.println("Playing: " + song);
        }
    }
}
