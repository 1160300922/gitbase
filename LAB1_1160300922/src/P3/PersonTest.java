package P3;
import static org.junit.Assert.*;

import org.junit.Test;

import P3.Person;
import P3.FriendshipGragh;
public class PersonTest {
    /**
     * Tests that assertions are enabled.
     */
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false;
    }

    /**
     * Tests calculateRegularPolygonAngle.
     */
    @Test
    public void getDistanceTest() {
    	FriendshipGragh graph = new FriendshipGragh();
		Person rachel = new Person("Rachel"); 
		Person ross = new Person("Ross"); 
		Person ben = new Person("Ben"); 
		Person kramer = new Person("Kramer");
		graph.addVertex(rachel); 
		graph.addVertex(ross); 
		graph.addVertex(ben); 
		graph.addVertex(kramer); 
		graph.addEdge(rachel, ross); 
		graph.addEdge(ross, rachel); 
		graph.addEdge(ross, ben); 
		graph.addEdge(ben, ross); 
        assertEquals(1, graph.getDistance(rachel, ross));
        assertEquals(2, graph.getDistance(rachel, ben));
        assertEquals(0, graph.getDistance(rachel, rachel));
        assertEquals(-1, graph.getDistance(rachel, kramer));
    }
}
