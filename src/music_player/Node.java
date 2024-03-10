package music_player;

public class Node {
	Song data;
	Node prev;
	Node next;
	Node(Song data)
	{
		this.data=data;
		this.prev=null;
		this.next=null;
	}
	

}
