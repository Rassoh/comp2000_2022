import java.awt.image.BufferedImage;
import java.util.Optional;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Color;

public class Cell extends Rectangle {
  public static int size = 32;
  int col;
  int row;
  String desc;
  BufferedImage img;
  Color color;
  Boolean showItems = true;
  Boolean showActors = true;
  Boolean showCell = true;

  public Cell(int c, int r, BufferedImage i) {
    super(c * size, r * size, size, size);
    col = c;
    row = r;
    img = i;
  }

  public void paint(Graphics g, Stage stage, Cell c) {
    if(!showCell)
    return;
    g.drawImage(img, x, y, size, size, null);
    if (showItems) {
      Optional<Item> item = stage.itemAtCell(this);
      if (item.isPresent()) {
        item.get().paint(g);
      }
    }

    if (showActors) {
      Optional<Actor> actor = stage.actorAtCell(this);
      if (actor.isPresent()) {
        actor.get().paint(g);
      }
    }
  }


  @Override
  public boolean contains(Point p) {
    if (p != null) {
      return super.contains(p);
    } else {
      return false;
    }
  }

  public int leftOfComparison(Cell c) {
    return Integer.compare(col, c.col);
  }

  public int aboveComparison(Cell c) {
    return Integer.compare(row, c.row);
  }
}
