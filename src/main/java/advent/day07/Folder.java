package advent.day07;

import static java.lang.Integer.MAX_VALUE;

import java.util.ArrayList;
import java.util.List;

public class Folder {
  private int size;
  private List<Folder> folders = new ArrayList<>();

  public void addFolder(Folder folder) {
    this.folders.add(folder);
  }

  public void addSize(int size) {
    this.size += size;
  }

  public List<Folder> getFolders() {
    return this.folders;
  }

  public int getTotalSize() {
    return folders.stream().map(f -> f.getTotalSize()).reduce((a, b) -> a + b).orElseGet(() -> 0)
        + this.size;
  }

  public int getTotalSmallerThan(int limit) {
    int tot = 0;
    int totalSize = getTotalSize();
    if (totalSize < limit) {
      tot += totalSize;
    }
    for (Folder f : folders) {
      tot += f.getTotalSmallerThan(limit);
    }
    return tot;
  }

  public int findFolderBetween(int min, int max) {
    int totalSizeCurrentBest = getTotalSize();
    if (folders.size() == 0) {
      return totalSizeCurrentBest > min && totalSizeCurrentBest < max
          ? totalSizeCurrentBest
          : MAX_VALUE;
    } else if (totalSizeCurrentBest < min) {
      return MAX_VALUE;
    } else {
      for (Folder f : folders) {
        int size = f.findFolderBetween(min, totalSizeCurrentBest);
        if (size < totalSizeCurrentBest) {
          totalSizeCurrentBest = size;
        }
      }
      return totalSizeCurrentBest;
    }
  }
}
