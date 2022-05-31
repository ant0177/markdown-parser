import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MarkdownParseTest {

    @Test
    public void testFile1() throws IOException {
        String contents= Files.readString(Path.of("./test-file.md"));
        List<String> expect = List.of("https://something.com", "some-thing.html");
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testFile2() throws IOException {
        String contents= Files.readString(Path.of("./test-file2.md"));
        List<String> expect = List.of("https://something.com", "some-page.html");
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testLinkAtBeginning() {
        String contents= "[link title](a.com)";
        List<String> expect = List.of("a.com");
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testSpaceInURL() {
        String contents = "[title](space in-url.com)";
        List<String> expect = List.of();
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testSpaceAfterParen() {
        String contents = "[title]( space-in-url.com)";
        List<String> expect = List.of("space-in-url.com");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }

    @Test
    public void testSpaceBeforeParen() {
        String contents = "[title]   (should-not-count.com)";
        List<String> expect = List.of();
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testNestedParens() throws IOException {
        String contents = Files.readString(Path.of("test-parens-inside-link.md"));
        List<String> expect = List.of("something.com()", "something.com((()))", "something.com", "boring.com");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }

    @Test
    public void testMissingCloseParen() throws IOException {
        String contents = Files.readString(Path.of("test-missing-paren-plus-test-file2.md"));
        List<String> expect = List.of("https://something.com", "some-page.html");
        assertEquals(MarkdownParse.getLinks(contents), expect);
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
