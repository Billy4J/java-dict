package struct.adaptPattern;

public class Mp4player implements AdvancedPlayer {
    @Override
    public void playVlc(String name) {

    }

    @Override
    public void playMp4(String name) {
        System.out.println("paly mp4 file: " + name);
    }
}
