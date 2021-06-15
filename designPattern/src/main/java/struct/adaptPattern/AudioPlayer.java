package struct.adaptPattern;

public class AudioPlayer implements MediaPlayer {
    private MediaAdapter mediaAdapter;

    @Override
    public void play(String type, String name) {
        if (type.equals("mp3")) {
            System.out.println("play Mp3");
        } else if (type.equals("vlc") || type.equals("mp4")) {
            mediaAdapter = new MediaAdapter(type);
            mediaAdapter.play(type, name);
        } else {
            System.out.println("Invalid media. " +
                    type + " format not supported");
        }
    }
}
