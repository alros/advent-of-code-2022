package advent.day07;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Stack;

public class Day07 {

  public int solveStep1(BufferedReader br) throws IOException {
    Folder root = parse(br);
    return root.getTotalSmallerThan(100000);
  }

  public int solveStep2(BufferedReader br) throws IOException {
    Folder root = parse(br);
    int totalSpace = 70000000;
    int spaceNeeded = 30000000 - (totalSpace - root.getTotalSize());
    return root.findFolderBetween(spaceNeeded, totalSpace);
  }

  private Folder parse(BufferedReader br) throws IOException {
    Stack<Folder> currentFolder = new Stack<>();
    br.readLine();
    currentFolder.add(new Folder());

    boolean withinLs = false;
    for (String line = br.readLine(); line != null; line = br.readLine()) {
      if (withinLs) {
        if (line.startsWith("dir")) {
          // nothing
        } else if (line.matches("\\d.*")) {
          currentFolder.peek().addSize(Integer.parseInt(line.split(" ")[0]));
        } else {
          withinLs = false;
        }
      }
      if (withinLs) {
        continue;
      } else if (line.matches("\\$ cd ..")) {
        currentFolder.pop();
      } else if (line.matches("\\$ cd .*")) {
        Folder f = new Folder();
        currentFolder.peek().addFolder(f);
        currentFolder.push(f);
      } else if (line.equals("$ ls")) {
        withinLs = true;
      } else {
        continue;
      }
    }
    return currentFolder.get(0);
  }
}
