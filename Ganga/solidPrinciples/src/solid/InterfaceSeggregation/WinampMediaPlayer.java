package solid.InterfaceSeggregation;

public class WinampMediaPlayer implements MediaPlayer {

    @Override
    public void playVideo() {
    	 System.out.println("Playing video ..............");
    } 
    

    @Override
    public void playAudio() {
        System.out.println("Playing audio ..............");
}
}