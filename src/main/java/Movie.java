
public class Movie {
    private final Integer movieWidth = 0;
    private final Integer movieHeight = 0;

    public Integer getMovieWidth() {
        return movieWidth;
    }

    public Integer getMovieHeight() {
        return movieHeight;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMoviePath() {
        return moviePath;
    }

    public void setMoviePath(String moviePath) {
        this.moviePath = moviePath;
    }

    private String title;
    private String moviePath;
}
