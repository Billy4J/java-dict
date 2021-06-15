package struct.adaptPattern;

public class VlcPlayer implements AdvancedPlayer {
    @Override
    public void playVlc(String name) {
        System.out.println("play vlc file: " + name);
    }

    @Override
    public void playMp4(String name) {

    }
}
