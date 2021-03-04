import java.util.Scanner;
import java.util.ArrayList;

public class Books {
	
	private String title;
	private String author;
	private double starRating;
	private String genre;
	private String review;
	
	public Books(String title, String author, double starRating, String genre, String review) {
		this.title = title;
		this.author = author;
		this.starRating = starRating;
		this.genre = genre;
		this.review = review;
	}
	public Books (String t, String a, double sR) {
		title = t;
		author = a;
		starRating = sR;
	}
	public void setTitle(String t) {
		title = t;
	}
	
	public void setAuthor(String a) {
		author = a;
	}
	
	public void setRating(double sR) {
		starRating = sR;
	}
	
	public void setGenre(String g) {
		genre = g;
	}

	public void setReview(String r) {
		review = r;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public double getRating() {
		return starRating;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public String getReview() {
		return review;
	}

	
	public static String readingChallenge(int numOfBooksRead, int goalNum) {
		int booksLeft = goalNum - numOfBooksRead;
		
		if (booksLeft < 0) {
			return "You have surpassed your reading goal by " + Math.abs(booksLeft) + " books. Congratulations!";
		}
		else if (booksLeft == 0) {
			return "You have reached your reading goal of " + goalNum + " books. Congratulations!";
		}			
		
		return "You have not reached your goal. You need to read " + booksLeft + " more books to reach your goal. Good luck!";
	}
	
	public static String booksRead() {
		boolean addBook = true;
		ArrayList<Books> arr = new ArrayList<Books>();

		while (addBook == true) {
			Scanner keyboard = new Scanner(System.in);
			System.out.print("\nPlease enter the name of the book: ");
			String name = keyboard.nextLine();
			
			Scanner keyboard2 = new Scanner(System.in);
			System.out.print("Please enter the name of the author: ");
			String author = keyboard2.nextLine();

			
			Scanner keyboard3 = new Scanner(System.in);
			System.out.print("Please enter your rating as a number between 0 and 5: ");
			double rating = keyboard3.nextDouble();
			
			Books book = new Books(name, author, rating);
					
			arr.add(book);
			
			Scanner keyboard4 = new Scanner(System.in);
			System.out.print("\nWould you like to enter another book? Please type 'Yes' or 'No': ");
			String yOn = keyboard4.nextLine().toLowerCase();
			
			if(yOn.equals("yes")) {
				addBook = true;
			}
			else {
				addBook = false;
			}
		}
		
		double avgRating = 0.0;
		
		for(Books b: arr) {
			avgRating += b.getRating();
		}
		
		avgRating = avgRating/arr.size();
		
		int avgRatingInt = (int)avgRating;
				
		return "\nYou have read " + arr.size() + " book(s) with an average rating of " + avgRatingInt + ".";
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to your new book library. You can enter the books you have read below.");
		System.out.println(booksRead());
		
		Scanner keyboard5 = new Scanner(System.in);
		System.out.print("\n---\nYou can also see where you are with your reading goal.\n\nEnter the number of books you have read, followed by a space, and then the number of books you want to read (ex. '56 100'): ");
		int numOfBooks = keyboard5.nextInt();
		int goalBooks = keyboard5.nextInt();
		keyboard5.close();
		
		System.out.println(readingChallenge(numOfBooks, goalBooks));
	}

}
