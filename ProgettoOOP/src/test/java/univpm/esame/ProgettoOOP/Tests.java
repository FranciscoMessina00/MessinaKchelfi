package univpm.esame.ProgettoOOP;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.boot.test.context.SpringBootTest;

import univpm.esame.ProgettoOOP.exception.TypeNotRecognisedException;
import univpm.esame.ProgettoOOP.filter.*;
import univpm.esame.ProgettoOOP.model.*;
/**
 * The class tests if the most important methods work
 * @author Francisco Messina
 * @author Amine Kchelfi
 */
@SpringBootTest
class Tests {
	/* Si può fare un test sul corretto funzionamento dei filtri, del model,
	 * searchByExtension se parte l'eccezione TypeNotRecognised
	 */
	Timestamp date=new Timestamp(0);
	private File file1;
	private File file2;
	private ArrayList<AbstractObject> list;
	private FilterSize filterSize;
	private FilterDate filterDate;
	/**
	 * Set up
	 */
	@SuppressWarnings("static-access")
	@BeforeEach
	void setUp() {
		list=new ArrayList<AbstractObject>();
		file1=new File("File1","pdf",1000L,"/cartella/File1","123asdf", false,"321fdsa", date.valueOf("2021-12-12 00:00:01"));
		list.add(file1);
		file2=new File("File2","txt",3000L,"/cartella/File2","456ghjk", false,"654kjhg", date.valueOf("2021-12-14 00:00:01"));
		list.add(file2);
		filterSize=new FilterSize(2000L,"greater");
		filterDate=new FilterDate(date.valueOf("2021-12-13 00:00:01"),"lower");
	}
	/**
	 * Tear down
	 */
	@AfterEach
	void tearDown() {}
	/**
	 * Tests if the class File builds correctly the name+extension
	 */
	@Test
	void testFullName() {
		assertEquals(file1.fullName(),"File1.pdf");
		assertEquals(file2.fullName(),"File2.txt");
	}
	/**
	 * Tests if the filterSize works
	 * @throws TypeNotRecognisedException If the type isn't either File or Folder
	 */
	@Test
	void testFilterSize() throws TypeNotRecognisedException {
		assertEquals(filterSize.doFilter(list).get(0),file2);
	}
	/**
	 * Tests if the filterDate works
	 * @throws TypeNotRecognisedException If the type isn't either File or Folder
	 */
	@Test
	void testFilterDate() throws TypeNotRecognisedException {
		assertEquals(filterDate.doFilter(list).get(0),file1);
	}
}
