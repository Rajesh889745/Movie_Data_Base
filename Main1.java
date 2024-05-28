import java.util.ArrayList;
import java.util.Scanner;

class Movie {
    private String title;
    private String director;
    private int year;

    public Movie(String title, String director, int year) {
        this.title = title;
        this.director = director;
        this.year = year;
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public int getYear() {
        return year;
    }
}

class MovieDatabase {
    private ArrayList<Movie> movies;

    public MovieDatabase() {
        movies = new ArrayList<>();
    }

    public void addMovie(String title, String director, int year) {
        Movie movie = new Movie(title, director, year);
        movies.add(movie);
    }

    public void searchByTitle(String title) {
        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Title: " + movie.getTitle());
                System.out.println("Director: " + movie.getDirector());
                System.out.println("Year: " + movie.getYear());
                return;
            }
        }
        System.out.println("Movie not found.");
    }

    public void displayAllMovies() {
        for (Movie movie : movies) {
            System.out.println("Title: " + movie.getTitle());
            System.out.println("Director: " + movie.getDirector());
            System.out.println("Year: " + movie.getYear());
            System.out.println();
        }
    }
}

public class Main1 {
    public static void main(String[] args) {
        MovieDatabase database = new MovieDatabase();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("1. Add Movie");
            System.out.println("2. Search Movie by Title");
            System.out.println("3. Display All Movies");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter movie title: ");
                    String title = scanner.next();
                    System.out.print("Enter director: ");
                    String director = scanner.next();
                    System.out.print("Enter year: ");
                    int year = scanner.nextInt();
                    database.addMovie(title, director, year);
                    break;
                case 2:
                    System.out.print("Enter movie title to search: ");
                    String searchTitle = scanner.next();
                    database.searchByTitle(searchTitle);
                    break;
                case 3:
                    database.displayAllMovies();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }
}