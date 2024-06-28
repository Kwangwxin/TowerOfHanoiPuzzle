public class Pole
{
  private Disk[] disks;
  private int numberOfDisks;
  private int maxNumberOfDisks;
  private int maxDiskSize;

  public Pole(int aMaxNumberOfDisk, int aMaxDiskSize, char aPoleChar)
  {
    maxNumberOfDisks = aMaxNumberOfDisk;
    maxDiskSize = aMaxDiskSize;
    disks = new Disk[maxNumberOfDisks + 2];
    for(int i = 0; i < maxNumberOfDisks + 1; i++){
      disks[i] = new Disk(maxDiskSize,' ', aPoleChar);
    }
    disks[maxNumberOfDisks + 1] = new Disk(maxDiskSize, '=', '=');
  }

  public Pole(int aMaxNumberOfDisk, int aMaxDiskSize)
  {
    maxNumberOfDisks = aMaxNumberOfDisk;
    maxDiskSize = aMaxDiskSize;
    disks = new Disk[maxNumberOfDisks + 2];
    for(int i = 0; i < maxNumberOfDisks + 1; i++){
      disks[i] = new Disk(maxDiskSize,' ', '|');
    }
    disks[maxNumberOfDisks + 1] = new Disk(maxDiskSize, '=', '=');
  }

  public Pole(int aMaxNumberOfDisk)
  {
    maxNumberOfDisks = aMaxNumberOfDisk;
    maxDiskSize = aMaxNumberOfDisk;
    disks = new Disk[maxNumberOfDisks + 2];
    for(int i = 0; i < maxNumberOfDisks + 1; i++){
      disks[i] = new Disk(maxNumberOfDisks,' ', '|');
    }
    disks[maxNumberOfDisks + 1] = new Disk(maxNumberOfDisks, '=', '=');
  }

  public int getMaxNumberOfDisks()
  {
    return maxNumberOfDisks;
  }
  public int getMaxDiskSize()
  {
    return maxDiskSize;
  }
  public int getNumberOfDisks()
  {
    return numberOfDisks;
  }

  public Disk peekTopDisk()
  {
    if(numberOfDisks != 0)
    return disks[maxNumberOfDisks - numberOfDisks + 1];
    else
    return null;
  }
  public String toString()
  {
    StringBuilder S = new StringBuilder();
    for(int i = 0; i < maxNumberOfDisks + 1; i++){
      S.append(disks[i].toString() + "\n");
    }
    S.append(disks[maxNumberOfDisks + 1].toString());
    return S.toString();
  }

  public boolean addDisk(Disk aDisk)
  {
    if(numberOfDisks == maxNumberOfDisks)
    return false;
    else if(aDisk.getSize() > maxDiskSize)
    return false;
    else{
      disks[maxNumberOfDisks - numberOfDisks] = aDisk;
      numberOfDisks++;
      return true;
    }
  }

  public Disk removeDisk()
  {
    if(numberOfDisks != 0){
      Disk aDisk = disks[maxNumberOfDisks - numberOfDisks + 1];
      disks[maxNumberOfDisks - numberOfDisks + 1] = new Disk(maxDiskSize,' ', '|');
      numberOfDisks--;
      return aDisk;
    }
    else
    return null;
  }

}
