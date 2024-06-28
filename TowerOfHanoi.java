public class TowerOfHanoi
{
  private Pole[] poles;
  private Disk[] disks;
  private int numberOfDisks;

  public TowerOfHanoi()
  {
    TowerOfHanoi hanoi = new TowerOfHanoi(7);
    numberOfDisks = 7;
    poles = new Pole[3];
    disks = new Disk[7];
    poles[0] = new Pole(7);
    for(int a = 0; a < 7; a++){
      disks[a] = new Disk(7 - a);
      poles[0].addDisk(disks[a]);
    }
    for(int i = 1; i < 3; i++){
      poles[i] = new Pole(7);
    }
  }
  public TowerOfHanoi(int aNumberOfDisks)
  {
    numberOfDisks = aNumberOfDisks;
    poles = new Pole[3];
    if(numberOfDisks >= 1){
      disks = new Disk[numberOfDisks];
      poles[0] = new Pole(numberOfDisks);
      for(int a = 0; a < numberOfDisks; a++){
        disks[a] = new Disk(numberOfDisks - a);
        poles[0].addDisk(disks[a]);
      }
      for(int i = 1; i < 3; i++){
        poles[i] = new Pole(numberOfDisks);
      }
    }
    else{
      disks = new Disk[1];
      poles[0] = new Pole(1);
        disks[0] = new Disk(1);
        poles[0].addDisk(disks[0]);
    }
  }

  public Disk peekTopDisk(int aPoleNumber)
  {
    if(aPoleNumber > 0 && aPoleNumber < 4)
      return poles[aPoleNumber - 1].peekTopDisk();
    else
      return null;
  }

  public int getNumberOfDisks(int aPoleNumber)
  {
    if(aPoleNumber > 0 && aPoleNumber < 4)
    return poles[aPoleNumber - 1].getNumberOfDisks();
    else
    return -1;
  }

  public String toString()
  {
    StringBuilder s = new StringBuilder();
    String[] bar = new String[numberOfDisks * 6 + 5];
      for(int a = 0; a < bar.length; a++){
        if(a == numberOfDisks)
        bar[a] = new String("1");
        else if(a == numberOfDisks * 3 + 2)
        bar[a] = new String("2");
        else if(a == numberOfDisks * 5 + 4)
        bar[a] = new String("3");
        else
        bar[a] = new String(" ");
        s.append(bar[a].toString());
      }
      s.append("\n");
      String[][] array = new String[numberOfDisks + 2][5];
      for(int i = 0; i < array.length; i++){
        for(int m = 0; m < 5; m++){
          if(m == 0 || m == 2 || m == 4){
            for(int p = 0; p < 3; p++){
              String str = poles[p].toString();
              String[] a = str.split("\n");
              array[i][p * 2] = a[i];
              int len = (array[i][p * 2].length() - 1)/2;
              if(len < numberOfDisks){
                array[i][p * 2] = "";
                for(int index = len; index < numberOfDisks; index++)
                  array[i][p * 2] += " ";
              array[i][p * 2] += a[i];
              for(int index = len; index < numberOfDisks; index++)
                array[i][p * 2] += " ";
            }
            else
              array[i][p * 2] = a[i];
            }
          }
          else{
            if(i == array.length - 1)
            array[i][m] = "=";
            else
            array[i][m] = " ";
          }
        }
      }
     for(int r = 0; r < array.length; r++){
        for(int cl = 0; cl < array[r].length; cl++){
            s.append(array[r][cl].toString());
        }
        s.append("\n");
      }
    return s.toString();
  }

  public boolean move(int fromPole, int toPole)
  {
    if(fromPole > 0 && fromPole < 4 && toPole > 0 && toPole < 4){
      if(getNumberOfDisks(fromPole) == 0)
      return false;
      else if(getNumberOfDisks(toPole) == numberOfDisks)
      return false;
      else{
        poles[toPole - 1].addDisk(peekTopDisk(fromPole));
        poles[fromPole - 1].removeDisk();
        return true;
      }
    }
    else
    return false;
  }

  public void reset()
  {
    disks = new Disk[numberOfDisks];
    poles[0] = new Pole(numberOfDisks);
    for(int a = 0; a < numberOfDisks; a++){
      disks[a] = new Disk(numberOfDisks - a);
      poles[0].addDisk(disks[a]);
    }
    for(int i = 1; i < 3; i++){
      poles[i] = new Pole(numberOfDisks);
    }
  }
}
