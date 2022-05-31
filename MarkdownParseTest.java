import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;


public class MarkdownParseTest {

    @Test
    public void addition() {
        assertEquals(2, 1+1);
    }

    @Test
    public void testParse1() throws IOException {
        
        ArrayList<String> expected = new ArrayList<>();
        expected.add("https://something.com");
        expected.add("some-thing.html");

        Path fileName = Path.of("./test1.md");
        String content = Files.readString(fileName);
        ArrayList<String> actualLinks = MarkdownParse.getLinks(content);

        assertEquals(expected, actualLinks);

        // "/Users" + 
        // "/ddavepersona/Documents/GitHub/markdown-parser-latest/" +
        // "markdown-parser/test1.md"
    }

    @Test
    public void testBreakFile1() throws IOException {

        ArrayList<String> expected = new ArrayList<>();

        Path fileName = Path.of("./break-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> actualLinks = MarkdownParse.getLinks(content);

        assertEquals(expected, actualLinks);

        // "/Users" + 
        // "/ddavepersona/Documents/GitHub/markdown-parser-latest/" +
        // "markdown-parser/break-file.md"
    }

    @Test
    public void testBreakFile2() throws IOException {

        ArrayList<String> expected = new ArrayList<>();

        Path fileName = Path.of("./break-file2.md");
        String content = Files.readString(fileName);
        ArrayList<String> actualLinks = MarkdownParse.getLinks(content);

        assertEquals(expected, actualLinks);

        // "/Users" + 
        // "/ddavepersona/Documents/GitHub/markdown-parser-latest/" +
        // "markdown-parser/break-file2.md"
    }

    @Test
    public void testBreakFile3() throws IOException {

        ArrayList<String> expected = new ArrayList<>();
        expected.add("someLink.com");

        Path fileName = Path.of("./break-file3.md");
        String content = Files.readString(fileName);
        ArrayList<String> actualLinks = MarkdownParse.getLinks(content);

        assertEquals(expected, actualLinks);

        // "/Users" + 
        // "/ddavepersona/Documents/GitHub/markdown-parser-latest/" +
        // "markdown-parser/break-file3.md"
    }

    @Test
    public void testExtraText() throws IOException {

        ArrayList<String> expected = new ArrayList<>();
        expected.add("https://something.com");
        expected.add("some-page.html");
        expected.add("https://something.com");

        Path fileName = Path.of("./test-file2.md");
        String content = Files.readString(fileName);
        ArrayList<String> actualLinks = MarkdownParse.getLinks(content);

        assertEquals(expected, actualLinks);

        // "/Users" + 
        // "/ddavepersona/Documents/GitHub/markdown-parser-latest/" +
        // "markdown-parser/test-file2.md"
    }

    @Test
    public void testNoLinkExtraText() throws IOException {

        ArrayList<String> expected = new ArrayList<>();
        
        Path fileName = Path.of("./test-file3.md");
        String content = Files.readString(fileName);
        ArrayList<String> actualLinks = MarkdownParse.getLinks(content);

        assertEquals(expected, actualLinks);

        // "/Users" + 
        // "/ddavepersona/Documents/GitHub/markdown-parser-latest/" +
        // "markdown-parser/test-file3.md"
    }

    public void testExtraSpace() throws IOException {

        ArrayList<String> expected = new ArrayList<>();
        expected.add("https://something.com");
        expected.add("some-thing.html");

        Path fileName = Path.of("./test-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> actualLinks = MarkdownParse.getLinks(content);

        assertEquals(expected, actualLinks);

        // "/Users" + 
        // "/ddavepersona/Documents/GitHub/markdown-parser-latest/" +
        // "markdown-parser/test-file.md"
    }
    
    @Test
    public void testFileBreak1() throws IOException {

        ArrayList<String> expected = new ArrayList<>();
        
        Path fileName = Path.of("./test-file-break1.md");
        String content = Files.readString(fileName);
        ArrayList<String> actualLinks = MarkdownParse.getLinks(content);

        assertEquals(expected, actualLinks);

        // "/Users" + 
        // "/ddavepersona/Documents/GitHub/markdown-parser-latest/" +
        // "markdown-parser/test-file-break1.md"
    }

    @Test
    public void testFileBreak2() throws IOException {

        ArrayList<String> expected = new ArrayList<>();

        Path fileName = Path.of("./test-file-break2.md");
        String content = Files.readString(fileName);
        ArrayList<String> actualLinks = MarkdownParse.getLinks(content);

        assertEquals(expected, actualLinks);

        // "/Users" + 
        // "/ddavepersona/Documents/GitHub/markdown-parser-latest/" +
        // "markdown-parser/test-file-break2.md"
    }

    @Test
    public void testFileBreak3() throws IOException {

        ArrayList<String> expected = new ArrayList<>();

        Path fileName = Path.of("./test-file-break3.md");
        String content = Files.readString(fileName);
        ArrayList<String> actualLinks = MarkdownParse.getLinks(content);

        assertEquals(expected, actualLinks);

        // "/Users" + 
        // "/ddavepersona/Documents/GitHub/markdown-parser-latest/" +
        // "markdown-parser/test-file-break3.md"
    }

    @Test
    public void testSnippet1() throws IOException { 

        ArrayList<String> expected = new ArrayList<>();
        expected.add("url.com");
        expected.add("`google.com");
        expected.add("google.com");
        expected.add("ucsd.edu");

        Path fileName = Path.of("./snippet1.md");
        String content = Files.readString(fileName);
        ArrayList<String> actualLinks = MarkdownParse.getLinks(content);

        assertEquals(expected, actualLinks);

        // "/Users/" +
        // "ddavepersona/Documents/GitHub/markdown-parser-latest/" +
        // "markdown-parser/snippet1.md"
    }

    @Test
    public void testSnippet2() throws IOException {

        ArrayList<String> expected = new ArrayList<>();
        expected.add("b.com");
        expected.add("a.com((");
        expected.add("example.com");
        
        Path fileName = Path.of("./snippet2.md");
        String content = Files.readString(fileName);
        ArrayList<String> actualLinks = MarkdownParse.getLinks(content);

        assertEquals(expected, actualLinks);

        // "/Users/" +
        // "ddavepersona/Documents/GitHub/markdown-parser-latest/" +
        // "markdown-parser/snippet2.md"
    }

    @Test
    public void testSnippet3() throws IOException{

        ArrayList<String> expected = new ArrayList<>();
        expected.add("https://www.twitter.com");
        expected.add("https://sites.google.com/eng.ucsd.edu/" +
                     "cse-15l-spring-2022/schedule");
        expected.add("github.com");
        expected.add("https://cse.ucsd.edu/");
        
        Path fileName = Path.of("./snippet3.md");
        String content = Files.readString(fileName);
        ArrayList<String> actualLinks = MarkdownParse.getLinks(content);

        assertEquals(expected, actualLinks);

        // "/Users/" +
        // "ddavepersona/Documents/GitHub/markdown-parser-latest/" +
        // "markdown-parser/snippet3.md"
    }
}

// javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar MarkdownParseTest.java MarkdownParse.java
// java -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore MarkdownParseTest
//changes
