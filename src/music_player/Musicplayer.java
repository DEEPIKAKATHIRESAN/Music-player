package music_player;
import java.util.Scanner;

import java.io.FileWriter;
import java.io.IOException;

public class Musicplayer {
	Node head;
	Node tail;
	Node currentSong;
	
	Musicplayer()
	{
		this.head=null;
		this.tail=null;
		this.currentSong=null;
	}
	public void addSong(String title,String artist)
	{
		Song newSong =new Song(title,artist);
		Node newNode =new Node(newSong);
        addToFile(newSong);
		if(head==null)
		{
			head=newNode;
			tail=newNode;
			currentSong=head;
		}
		else
		{
			tail.next=newNode;
			newNode.prev=tail;
			tail=newNode;
			
		}
			
	}
	public void play()
	{
		if(currentSong!=null)
		{
			System.out.println("Song:"+currentSong.data.title+"    ArtistName:"+currentSong.data.artist);
		}
		
	}
	 public static void addToFile(Song a) {
	        String filePath = System.getProperty("user.home") + "/Documents/playlist.txt";
	        try (FileWriter fw = new FileWriter(filePath, true)) {
	            fw.write("Title: " + a.getTitle() + "  Artist: " + a.getArtist() + "\n");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	public void nextSong()
	{
		if(currentSong!= null && currentSong.next!= null)
		{
			currentSong=currentSong.next;
			play();
		}
		else
		{
			System.out.println("It is the the end of the playlist");
		}
	}
	public void prevSong()

	{
		if( currentSong!= null &&currentSong.prev!=null)
		{
			currentSong=currentSong.prev;
			play();
		}
		else
		{
			System.out.println("This is the first song in the playlist");
		}
	}
	
	 public static void main(String args[]) {
	        Scanner scanner = new Scanner(System.in);
	        Musicplayer player = new Musicplayer();

	        System.out.println("Welcome to My Music Player!");
	        displayMenu();

	        while (true) {
	            System.out.print("Enter your choice: ");
	            int option=scanner.nextInt();

	            switch (option) {
	                case 1:
	                    player.play();
	                    break;
	                case 2:
	                    player.nextSong();
	                    break;
	                case 3:
	                    player.prevSong();
	                    break;
	                case 4:
	                    System.out.println("Enter the song name: ");
	                    String songName = scanner.nextLine();
	                    
	                    System.out.println("Enter the artist name: ");
	                    String artistName = scanner.nextLine();
	                    player.addSong(songName, artistName);
	                    break;
	                case 5:
	                    System.out.println("Thank you for using My Music Player. Goodbye!");
	                    System.exit(0);
	                default:
	                    System.out.println("Invalid option. Please try again.");
	                    break;
	            }
	        }
	    }

	    public static void displayMenu() {
	        System.out.println("Menu:");
	        System.out.println("1. Play");
	        System.out.println("2. Next");
	        System.out.println("3. Previous");
	        System.out.println("4. Add Song");
	        System.out.println("5. Quit");
	        System.out.println();
	    }
	}
	


