package struct.adaptPattern;

public class MediaAdapter implements MediaPlayer {
    AdvancedPlayer advancedPlayer;

    public MediaAdapter(String type) {
        if (type.equals("vlc")) {
            advancedPlayer = new VlcPlayer();
        } else if (type.equals("mp4")) {
            advancedPlayer = new Mp4player();
        }
    }

    @Override
    public void play(String type, String name) {
        if (type.equals("vlc")) {
            advancedPlayer.playVlc(name);
        } else if (type.equals("mp4")) {
            advancedPlayer.playMp4(name);
        }
    }
}
