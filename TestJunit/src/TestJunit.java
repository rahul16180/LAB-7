import org.junit.Test;
import lab7.main;
import static org.junit.Assert.assertEquals;


public class TestJunit {

main t = new main();

@
@SuppressWarnings("static-access")
@Test
public void add() {
	 
	main.add(t.playlist, "country","wales",89);
	String message="Name:abc  Singer:abc  Duration:46\r\n" + 
			"Name:xyz  Singer:rahul  Duration:55\r\n" + 
			"Name:pop  Singer:amit  Duration:141\r\n" + 
			"Name:jazz  Singer:aman  Duration:58\\r\\n" +
			"Name:country  Singer:wales  Duration:89";
	
	assertEquals(message,main.show(t.playlist));
}



@Test
public void delete() {
	 
 main.delete(t.playlist, "pop");
 String message="Name:abc  Singer:abc  Duration:46\r\n" + 
			"Name:xyz  Singer:rahul  Duration:55\r\n" +  
			"Name:jazz  Singer:aman  Duration:58\\r\\n" +
			"Name:country  Singer:wales  Duration:89";
 assertEquals(message,main.show(t.playlist));
		 
		
}

@Test
public void search() {
	 
	
	String message= "Name:jazz  Singer:aman  Duration:58";
	assertEquals(message,main.search(t.playlist, "jazz"));
	
		
}

}