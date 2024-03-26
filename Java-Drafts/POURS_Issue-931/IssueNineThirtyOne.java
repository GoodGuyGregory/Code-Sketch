
import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IssueNineThirtyOne {

 public Set<String> listFilesUsingFilesList(String dir) throws IOException {
    try (Stream<Path> stream = Files.list(Paths.get(dir))) {
        return stream
        // filters the directories from displaying
          .filter(file -> !Files.isDirectory(file))
          .map(Path::getFileName)
          .map(Path::toString)
          .collect(Collectors.toSet());
    }
}

    public static void main(String[] args) {
        IssueNineThirtyOne ff = new IssueNineThirtyOne();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the directory where to search ");
        String directory = scan.next();
        try {
            Set<String> foundFiles = ff.listFilesUsingFilesList(directory);
            for (String file: foundFiles) {
                System.out.println(file);
            }
        }
        catch (IOException ex) {
            System.out.println(ex);
            System.out.println("encountered an issue with that provided directory");
        }
    }

}
