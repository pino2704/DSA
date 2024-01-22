public class Rating {
    private int userID;
    private int movieID;
    private int movieRating;
    private long timestamp;

    public Rating(int userID, int movieID, int movieRating, long timestamp) {
        this.userID = userID;
        this.movieID = movieID;
        this.movieRating = movieRating;
        this.timestamp = timestamp;
    }

    public int getUserID() {
        return userID;
    }
    public int getMovieID() {
        return movieID;
    }
    public int getMovieRating() {
        return movieRating;
    }
    public long getTimestamp() {
        return timestamp;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }
    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }
    public void setMovieRating(int movieRating) {
        this.movieRating = movieRating;
    }
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Rating[" + userID + ", " + movieID + ", " + movieRating + ", " + timestamp + "]";
    }
}
