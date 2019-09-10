package wade.wei.combination;

public class Client {
    public static void main(String[] args) {
        Folder d = new Folder("D盘");
        Folder music = new Folder("music");
        Folder video = new Folder("video");
        File aa = new File("aa.mp3");
        File bb = new File("bb.mp3");
        File cc = new File("aa.mp4");
        File ee = new File("bb.mp4");

        music.add(aa);
        music.add(bb);
        video.add(cc);
        video.add(ee);

        d.add(music);
        d.add(video);

        d.ls();

    }
}
