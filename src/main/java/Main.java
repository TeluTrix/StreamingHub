import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {

        //EmbeddedMediaPlayerComponent component = new EmbeddedMediaPlayerComponent();
        Frame f=new JFrame();//creating instance of JFrame


        //JButton b=new JButton("click");//creating instance of JButton
        //b.setBounds(130,100,100, 40);//x axis, y axis, width, height

        //f.add(b);//adding button in JFrame

        BufferedImage myPicture = ImageIO.read(new File("/Users/lucaalbrecht/Desktop/logo.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        f.add(picLabel);

        for(int i = 0; i < getMovies().size(); i++){
            JButton tempBtn = new JButton(getMovies().get(i).getTitle());
            int tempNr = 200 - (i * 40);
            tempBtn.setBounds(35, tempNr,400, 40);
            f.add(tempBtn);
            tempBtn.addActionListener( new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    EmbeddedMediaPlayerComponent component = new EmbeddedMediaPlayerComponent();
                    Frame f2 = new JFrame();
                    f2.setSize(1000,1000);//400 width and 500 height
                    f2.setLayout(null);//using no layout managers
                    f2.setVisible(true);//making the frame visible

                    /* f2.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosing(WindowEvent e) {
                            component.release();
                            System.exit(0);
                        }
                    }); */
                }
            });
        }

        f.setSize(1000,1000);//400 width and 500 height
        f.setLayout(null);//using no layout managers
        f.setVisible(true);//making the frame visible


    }
    public static ArrayList<Movie> getMovies(){
        File folder = new File("/Users/lucaalbrecht/Desktop/testfolder");
        File[] listOfFiles = folder.listFiles();
        ArrayList<Movie> listOfMovies = new ArrayList<Movie>();

        assert listOfFiles != null;
        for (File file : listOfFiles) {
            if (file.isFile()) {
                System.out.println(file.getAbsolutePath());

                Movie tempMovie = new Movie();

                String filtereName = filterName(file.getName());
                if(!(filtereName.equals("system_file"))){
                    tempMovie.setTitle(filterName(file.getName()));
                    tempMovie.setMoviePath((file.getAbsolutePath()));

                    listOfMovies.add(tempMovie);
                }

            }

        }
        return listOfMovies;
    }
    static String filterName(String name){
        if (!(name.contains("DS_Store"))){
            name = name.split("\\.")[0];
            name = name.replace("_", " ");
            name = name.replace("-", " ");
            name = name.replace("mp4", " ");
            name = name.replace("mkv", " ");
            name = name.replace("720p", " ");
            name = name.replace("720", " ");
            name = name.replace("1080p", " ");
            name = name.replace("1080", " ");
            name = name.replace("480p", " ");
            name = name.replace("480", " ");
            return name;
        }
        return "system_file";
    }
}
