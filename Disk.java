 public class Disk
 {
   private int diskSize;
   private String diskString;


   public Disk(int aDiskSize, char aDiskChar, char aPoleChar)
   {
     if(aDiskSize > 0)
       diskSize = aDiskSize;
     else
       diskSize = 1;
       diskString = "";
       for(int i = 0; i < diskSize; i++){
         diskString += aDiskChar;
       }
       diskString += aPoleChar;
       for(int i = 0; i < diskSize; i++){
         diskString += aDiskChar;
       }
   }

   public Disk(int aDiskSize)
   {
     if(aDiskSize > 0)
       diskSize = aDiskSize;
     else
       diskSize = 1;
       diskString = "";
     for(int i = 0; i < diskSize; i++){
       diskString += '*';
     }
     diskString += '|';
     for(int i = 0; i < diskSize; i++){
       diskString += '*';
     }
   }

   public int getSize()
   {
     return diskSize;
   }

   public String toString()
   {
     return diskString;
   }

 }
