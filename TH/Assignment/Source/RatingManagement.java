import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RatingManagement {
    private ArrayList<Rating> ratings;
    private ArrayList<Movie> movies;
    private ArrayList<User> users;

    // @Requirement 1
    public RatingManagement(String moviePath, String ratingPath, String userPath) {
        this.movies = loadMovies(moviePath);
        this.users = loadUsers(userPath);
        this.ratings = loadEdgeList(ratingPath);
    }

    private ArrayList<Rating> loadEdgeList(String ratingPath) {
        ArrayList<Rating> listRatings = new ArrayList<>();
        try {
            Scanner reader = new Scanner(new File(ratingPath));
            reader.nextLine();
            while(reader.hasNextLine()) {
                String[] rating = reader.nextLine().split(",");
                listRatings.add(new Rating(Integer.parseInt(rating[0]), Integer.parseInt(rating[1]), Integer.parseInt(rating[2]), Long.parseLong(rating[3])));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listRatings; 
    }

    private ArrayList<Movie> loadMovies(String moviePath) {
        ArrayList<Movie> listMovies = new ArrayList<>();
        try {
            Scanner reader = new Scanner(new File(moviePath));
            reader.nextLine();
            while(reader.hasNextLine()) {
                ArrayList<String> listGenres = new ArrayList<>();
                String[] movie = reader.nextLine().split(",");
                String[] moiveGenres = movie[2].split("-");
                for(String genre : moiveGenres) {
                    listGenres.add(genre);
                }
                listMovies.add(new Movie(Integer.parseInt(movie[0]), movie[1], listGenres));
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listMovies;
    }

    private ArrayList<User> loadUsers(String userPath) {
        ArrayList<User> listUsers = new ArrayList<>();
        try {
            Scanner reader = new Scanner(new File(userPath));
            reader.nextLine();
            while(reader.hasNextLine()) {
                String[] user = reader.nextLine().split(",");
                listUsers.add(new User(Integer.parseInt(user[0]), user[1], Integer.parseInt(user[2]), user[3], user[4]));
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listUsers; 
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<Rating> getRating() {
        return ratings;
    }

    // @Requirement 2
    public ArrayList<Movie> findMoviesByNameAndMatchRating(int userId, int rating) {
        ArrayList<Movie> listMovies = new ArrayList<>();
        for(Rating r : ratings) {
            if(r.getUserID() == userId && r.getMovieRating() >= rating) {
                for(Movie m : movies) {
                    if(r.getMovieID() == m.getId()) {
                        listMovies.add(m);
                        break;
                    }
                }
            }
        }
        listMovies.sort(new Comparator<Movie>() {
            @Override
            public int compare(Movie m1, Movie m2) {
                return m1.getName().compareTo(m2.getName());
            }
        });     
        return listMovies; 
    }

    // Requirement 3
    public ArrayList<User> findUsersHavingSameRatingWithUser(int userId, int movieId) {
        int userRate = 0;
        for(Rating r : ratings) {
            if(r.getUserID() == userId && r.getMovieID() == movieId) {
                userRate = r.getMovieRating();
                break;
            }
        }

        ArrayList<Integer> listIdUsers = new ArrayList<>();
        for(Rating r : ratings) {
            if(r.getUserID() != userId && r.getMovieID() == movieId && r.getMovieRating() == userRate) {
                listIdUsers.add(r.getUserID());
            }
        }

        ArrayList<User> listUsers = new ArrayList<>();
        for(User u : users) {
            if(listIdUsers.contains(u.getId())) {
                listUsers.add(u);
            }
        }
        return listUsers; 
    }

    // Requirement 4
    public ArrayList<String> findMoviesNameHavingSameReputation() {
        ArrayList<Integer> listMoviesID = new ArrayList<>();
        ArrayList<Integer> listRatings = new ArrayList<>();
        for(Rating r : ratings) {
            if(r.getMovieRating() > 3) {
                if(!listMoviesID.contains(r.getMovieID())) {
                    listMoviesID.add(r.getMovieID());
                    listRatings.add(1);
                } else {
                    listRatings.set(listMoviesID.indexOf(r.getMovieID()), listRatings.get(listMoviesID.indexOf(r.getMovieID())) + 1);
                }
            }
        }

        ArrayList<String> listMoviesName = new ArrayList<>();
        for(Movie m : movies) {
            if(listMoviesID.contains(m.getId()) && listRatings.get(listMoviesID.indexOf(m.getId())) > 1) {
                listMoviesName.add(m.getName());
            }
        }

        listMoviesName.sort(new Comparator<String>() {
            @Override
            public int compare(String m1, String m2) {
                return m1.compareTo(m2);
            }
        }); 

        return listMoviesName; 
    }

    // @Requirement 5
    public ArrayList<String> findMoviesMatchOccupationAndGender(String occupation, String gender, int k,
            int rating) {
        ArrayList<Integer> listUsersID = new ArrayList<>();
        for(User u : users) {
            if(u.getGender().equals(gender) && u.getOccupation().equals(occupation)) {
                listUsersID.add(u.getId());
            }
        }

        Set<Integer> setMovieID = new HashSet<>();
        for(Rating r : ratings) {
            if(r.getMovieRating() == rating && listUsersID.contains(r.getUserID())) {
                setMovieID.add(r.getMovieID());
            }
        }

        ArrayList<Integer> listMovieID = new ArrayList<>(setMovieID);
        ArrayList<String> listMoviesName = new ArrayList<>();
        
        for(Movie m : movies) {
            if(listMovieID.contains(m.getId())) {
                listMoviesName.add(m.getName());
            }
        }

        listMoviesName.sort(new Comparator<String>() {
            @Override
            public int compare(String m1, String m2) {
                return m1.compareTo(m2);
            }
        }); 

        ArrayList<String> kMovies = new ArrayList<>();
        int i = 0;
        for(String movie : listMoviesName) {
            if(i == k)  break;
            kMovies.add(movie);
            i++;
        }

        return kMovies; 
    }

    // @Requirement 6
    public ArrayList<String> findMoviesByOccupationAndLessThanRating(String occupation, int k, int rating) {
        ArrayList<Integer> listUsersID = new ArrayList<>();
        for(User u : users) {
            if(u.getOccupation().equals(occupation)) {
                listUsersID.add(u.getId());
            }
        }

        Set<Integer> setMovieID = new HashSet<>();
        for(Rating r : ratings) {
            if(r.getMovieRating() < rating && listUsersID.contains(r.getUserID())) {
                setMovieID.add(r.getMovieID());
            }
        }

        ArrayList<Integer> listMovieID = new ArrayList<>(setMovieID);
        ArrayList<String> listMoviesName = new ArrayList<>();
        
        for(Movie m : movies) {
            if(listMovieID.contains(m.getId())) {
                listMoviesName.add(m.getName());
            }
        }

        listMoviesName.sort(new Comparator<String>() {
            @Override
            public int compare(String m1, String m2) {
                return m1.compareTo(m2);
            }
        }); 

        ArrayList<String> kMovies = new ArrayList<>();
        int i = 0;
        for(String movie : listMoviesName) {
            if(i == k)  break;
            kMovies.add(movie);
            i++;
        }

        return kMovies; 
    }

    private User findUser(int userId) {
        User user = null;
        for(User u : users) {
            if(u.getId() == userId) {
                user = u;
                break;
            }
        }
        return user;
    }

    private Rating findLatestUserIdRating(int userId) {
        Rating UserIdRate = null;
        long timestamp = 0;
        
        for(Rating r : ratings) {
            if(r.getUserID() == userId && timestamp <=  r.getTimestamp()) {
                UserIdRate = r;
                timestamp = r.getTimestamp();
            }
        }

        return UserIdRate;
    }

    private ArrayList<String> findGenres(int movieId) {
        ArrayList<String> genres = new ArrayList<>();
        
        for(Movie m : movies) {
            if(m.getId() == movieId) {
                genres = m.getGenres();
                break;
            }
        }

        return genres;
    }

    private boolean isSameGender(ArrayList<String> genres1, ArrayList<String> genres2) {
        for(String g : genres1) {
            if(genres2.contains(g)) return true;
        }
        return false;
    }

    // @Requirement 7
    public ArrayList<String> findMoviesMatchLatestMovieOf(int userId, int rating, int k) {
        Rating UserIdRate = findLatestUserIdRating(userId);
        User user = findUser(userId);
        ArrayList<String> genres = findGenres(UserIdRate.getMovieID());

        ArrayList<Rating> listRatingsTmp = new ArrayList<>();
        ArrayList<Integer> listUsersID = new ArrayList<>();
        for(Rating r : ratings) {
            if(r.getMovieRating() >= UserIdRate.getMovieRating()) {
                listRatingsTmp.add(r);
                listUsersID.add(r.getUserID());
            }
        }

        ArrayList<Integer> listUsers = new ArrayList<>();
        for(User u : users) {
            if(u.getGender() == user.getGender() && listUsersID.contains(u.getId())) {
                listUsers.add(u.getId());
            }
        }

        ArrayList<Integer> listMoviesID = new ArrayList<>();
        for(Rating r : listRatingsTmp) {
            if(listUsers.contains(r.getUserID())) {
                listMoviesID.add(r.getMovieID());
            }
        }

        ArrayList<String> listMoviesName = new ArrayList<>();
        for(Movie m : movies) {
            if(isSameGender(genres, m.getGenres())) {
                listMoviesName.add(m.getName());
            }
        }

        listMoviesName.sort(new Comparator<String>() {
            @Override
            public int compare(String m1, String m2) {
                return m1.compareTo(m2);
            }
        }); 
        
        ArrayList<String> kMovies = new ArrayList<>();
        int i = 0;
        for(String movie : listMoviesName) {
            if(i == k)  break;
            kMovies.add(movie);
            i++;
        }

        return kMovies; 
    }
}