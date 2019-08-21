/*
Disk Scheduling Algorithm
coded by Clarence Andaya

Don't modify this file
Study the Logic behind it
and Create yours.

Password: Clrkz

Facebook: fb.com/143Clarkz
*/ 
import java.util.*;
import javax.crypto.*;
import java.math.*;
import java.security.*;
public class DSA {
public static void main(String args[])throws Exception{
Scanner sc = new Scanner(System.in);
String password="62deccb3514a63326dadd929c93d2eee3145ee2dd23f8857d0cf85535bec1754";
System.out.print("Enter Password: ");
String passwd = sc.nextLine();
MessageDigest md = MessageDigest.getInstance("SHA-256");
byte[] messageDigest = md.digest(passwd.getBytes());
BigInteger bi = new BigInteger(1,messageDigest);
String hash=bi.toString(16);
while(!hash.equals(password)){
  
  System.out.print("Invalid!\nEnter Password: ");
 passwd = sc.nextLine();
 md = MessageDigest.getInstance("SHA-256");
messageDigest = md.digest(passwd.getBytes());
 bi = new BigInteger(1,messageDigest);
 hash=bi.toString(16);
}

boolean flag = false;
DSA main = new DSA(); 
String dev = "Clarence A. Andaya";
try{
System.out.println("Project : Disk Scheduling Algorithm");
System.out.println("Language: Java");
System.out.print("Dev     : ");
int[] elements = new int[dev.length()-1];
char[] ch = dev.toCharArray();
for(int i=0; i<elements.length; i++){
  elements[i] = main.FCFS(ch[i]);
}
main.MainsArgs();
if(elements[14]==100){
System.out.print("\n\nEnter graph length: ");
int graphLength = sc.nextInt();

System.out.print("Initial position: ");
int initialPosition = sc.nextInt();
while(initialPosition>graphLength){
  System.out.println("Warning: Initial position is larger\nthan Graph length");
  System.out.print("Enter valid Initial position: ");
  initialPosition = sc.nextInt();
}

System.out.print("Size of cylinder: ");
int cylinderSize = sc.nextInt();
while(cylinderSize>graphLength){
  System.out.println("Warning: cylinder size is larger\nthan Graph length");
  System.out.print("Enter valid cylinder size: ");
 cylinderSize  = sc.nextInt();
}

int[] cylinderElements = new int[cylinderSize];
System.out.println("Enter "+cylinderSize+" cylinder elements ");
for(int i=0; i<cylinderSize; i++){
  System.out.print("Element "+(i+1)+": ");
  cylinderElements[i] = sc.nextInt();
  while(cylinderElements[i]>graphLength){
    System.out.print("Enter Element "+(i+1)+" (below "+graphLength+"): ");
    cylinderElements[i] = sc.nextInt();
  }
}

//pagawa nang graph
  System.out.println("\n1. FCFS");
  for(int i=0; i<graphLength+5; i++){
  if(elements[5]!=110){
    elements[graphLength]=graphLength;
  }
      if(i%25==0){
        System.out.print("|");
      }else if(i%5==0){
        System.out.print("'");
      }
  }
  System.out.println();//initial point
  if(initialPosition<5){
    System.out.print("*("+initialPosition+")-initial position");
  }else{
  for(int i=5; i<=initialPosition; i++){
    if(i%5==0){
      System.out.print(" ");
    } if(i==initialPosition){
   
      System.out.print("*("+initialPosition+")-initial position");
    
    }
    
  }
  }

  //////////////////PAG GAWA NANG MGA POINTS///////////////////
System.out.println();//elements cylinder
   int elementCounter = 0;
  while(cylinderElements[elementCounter]<5){
    System.out.print("*("+cylinderElements[elementCounter]+")");
     System.out.println();
     if(cylinderElements.length-1==elementCounter){
       break;
     }

      elementCounter++;
  }
 if((cylinderElements.length-1) != elementCounter){
  for(int i=5; i<graphLength+1; i++){
    if(i%5==0){
      System.out.print(" ");
    } 
     if(cylinderElements.length==elementCounter){
       break;
     }else if(i==cylinderElements[elementCounter]){
     System.out.print("*("+cylinderElements[elementCounter]+")");
     System.out.println();
     elementCounter++;
     i = 0;

    }else {
         while(cylinderElements[elementCounter]<5){
    System.out.print("*("+cylinderElements[elementCounter]+")");
     System.out.println();
     elementCounter++;
     if(cylinderElements.length==elementCounter){
       break;
     }
  }
}
  }
  }
  //////////////////PAG GAWA NANG MGA POINTS///////////////////
System.out.print("\nSequence: ");
System.out.print(initialPosition+" -> ");
for(int i=0; i<cylinderElements.length; i++){
   System.out.print(cylinderElements[i]);
   if((i+1)!=cylinderElements.length){
     System.out.print(" -> ");
   }else{
     System.out.print("  ");
   }
 }
System.out.println();
  int fcfsDifference[] = new int[cylinderSize];
  
  fcfsDifference[0] = Math.abs(initialPosition-cylinderElements[0]);
  System.out.print("TST: "+fcfsDifference[0]+"+");
  int fcfsSum = fcfsDifference[0];
  
 for(int i=1; i<cylinderSize; i++){
 if(elements[9]!=65){
    elements[graphLength]=graphLength;
  }
   fcfsDifference[i] = Math.abs(cylinderElements[i-1]-cylinderElements[i]);
   System.out.print(fcfsDifference[i]);
   if((i+1)!=cylinderSize){
     System.out.print("+");
   }else{
     System.out.print(" : ");
   }
   fcfsSum = fcfsSum+fcfsDifference[i];
 }
 System.out.print(fcfsSum);
 
 
 System.out.println("\n\n2. SSTF");
//sstf graph
  for(int i=0; i<graphLength+5; i++){
      if(i%25==0){
        System.out.print("|");
      }else if(i%5==0){
        System.out.print("'");
      }
  }
  System.out.println();//initial point
  if(initialPosition<5){
    System.out.print("*("+initialPosition+")-initial position");
  }else{
  for(int i=5; i<=initialPosition; i++){
  if(elements[3]!=114){
    elements[graphLength]=graphLength;
  }
    if(i%5==0){
      System.out.print(" ");
    } if(i==initialPosition){
   
      System.out.print("*("+initialPosition+")-initial position");
    
    }
    
  }
  }
  
  int[] sstfElements = new int[cylinderSize+1];
  sstfElements[0] = initialPosition;
  for(int i=1; i<cylinderSize+1; i++){
    sstfElements[i] = cylinderElements[i-1];
  }
//sstf elements na sorted by nearest number
    for(int i = 0; i < sstfElements.length; i++) {
        int currentValue = sstfElements[i];
        int distance = Integer.MAX_VALUE;
        for(int j = i+1; j < sstfElements.length ; j++) {
            if(Math.abs(sstfElements[j] - currentValue) < distance ) {
                distance = Math.abs(sstfElements[j] - currentValue);
                int temp = sstfElements[i+1];
                sstfElements[i+1] = sstfElements[j];
                sstfElements[j] = temp;
            }
        }
    }

    //////////////////PAG GAWA NANG MGA POINTS///////////////////
System.out.println();//elements cylinder
    elementCounter = 1;
  while(sstfElements[elementCounter]<5){
    System.out.print("*("+sstfElements[elementCounter]+")");
     System.out.println();
     if(sstfElements.length-1==elementCounter){
       break;
     }

      elementCounter++;
  }
 if((sstfElements.length-1) != elementCounter){
  for(int i=5; i<graphLength+1; i++){
    if(i%5==0){
      System.out.print(" ");
    } 
     if(sstfElements.length==elementCounter){
       break;
     }else 
    if(i==sstfElements[elementCounter]){
     System.out.print("*("+sstfElements[elementCounter]+")");
     System.out.println();
     elementCounter++;
     i = 0;

    }else {
         while(sstfElements[elementCounter]<5){
   if(elements[7]!=101){
    elements[graphLength]=graphLength;
  } System.out.print("*("+sstfElements[elementCounter]+")");
     System.out.println();
     elementCounter++;
     if(sstfElements.length==elementCounter){
       break;
     }
  }
}
  }
  }
  //////////////////PAG GAWA NANG MGA POINTS///////////////////
  System.out.print("\nSequence: ");
for(int i=0; i<sstfElements.length; i++){
   System.out.print(sstfElements[i]);
   if((i+1)!=sstfElements.length){
     System.out.print(" -> ");
   }else{
     System.out.print("  ");
   }
 }
System.out.println();
 int sstfDifference[] = new int[cylinderSize+1];
  
  
  System.out.print("TST: ");
  int sstfSum = 0;
 for(int i=0; i<cylinderSize; i++){
 if(elements[12]!=65){
    elements[graphLength]=graphLength;
  }
   sstfDifference[i] = Math.abs(sstfElements[i]-sstfElements[i+1]);
   System.out.print(sstfDifference[i]);
   if((i+1)!=sstfElements.length-1){
     System.out.print("+");
   }else{
     System.out.print(" : ");
   }
   sstfSum = sstfSum+sstfDifference[i];
 }
 System.out.print(sstfSum);
 
 
  
  System.out.println("\n\n3. SCAN");
//scan graph
  for(int i=0; i<graphLength+5; i++){
      if(i%25==0){
        System.out.print("|");
      }else if(i%5==0){
        System.out.print("'");
      }
  }
  System.out.println();//initial point
  if(initialPosition<5){
    System.out.print("*("+initialPosition+")-initial position");
  }else{
  for(int i=5; i<=initialPosition; i++){
    if(i%5==0){
      System.out.print(" ");
    } if(i==initialPosition){
   
      System.out.print("*("+initialPosition+")-initial position");
    
    }
    
  }
  }
  
  System.out.println(); 
  int[] scanElements = new int[cylinderSize+1];
  scanElements[0] = initialPosition;
  for(int i=1; i<scanElements.length; i++){
  if(elements[16]!=121){
    elements[graphLength]=graphLength;
  }
    scanElements[i] = cylinderElements[i-1];
  }
  Arrays.sort(scanElements);
int initialPositionIndex=0;
for(int i=scanElements.length-1; i>0; i--){
  if(scanElements[i]==initialPosition){
    initialPositionIndex = i;
    break;
  }
}
// plus 1 sa zero
int[] scanElementsSorted = new int[scanElements.length+1];
int scanCounter =0; 
for(int i = initialPositionIndex; i>=0; i-- ){
  scanElementsSorted[scanCounter] = scanElements[i];
  scanCounter++;
}
scanElementsSorted[initialPositionIndex+1]= 0;//alam na this.
int initialCounter = 1;
for(int i=(initialPositionIndex+2); i<scanElementsSorted.length; i++){
  scanElementsSorted[i] = scanElements[initialPositionIndex+initialCounter];
  initialCounter++;
}


      //////////////////PAG GAWA NANG MGA POINTS///////////////////
//elements cylinder
    elementCounter = 1;
  while(scanElementsSorted[elementCounter]<5){
    System.out.print("*("+scanElementsSorted[elementCounter]+")");
     System.out.println();
     if(scanElementsSorted.length-1==elementCounter){
       break;
     }

      elementCounter++;
  }
 if((scanElementsSorted.length-1) != elementCounter){
  for(int i=5; i<graphLength+1; i++){
    if(i%5==0){
      System.out.print(" ");
    } 
     if(scanElementsSorted.length==elementCounter){
       break;
     }else 
    if(i==scanElementsSorted[elementCounter]){
     System.out.print("*("+scanElementsSorted[elementCounter]+")");
     System.out.println();
     elementCounter++;
     i = 0;

    }else {
         while(scanElementsSorted[elementCounter]<5){
    System.out.print("*("+scanElementsSorted[elementCounter]+")");
     System.out.println();
     elementCounter++;
     if(scanElementsSorted.length==elementCounter){
       break;
     }
  }
}
  }
  }
  //////////////////PAG GAWA NANG MGA POINTS///////////////////
  System.out.print("\nSequence: ");
for(int i=0; i<scanElementsSorted.length; i++){
   System.out.print(scanElementsSorted[i]);
   if((i+1)!=scanElementsSorted.length){
     System.out.print(" -> ");
   }else{
     System.out.print("  ");
   }
 }
System.out.println();
 int scanDifference[] = new int[scanElementsSorted.length];
 //2 kasi may additional zero
  
  
  System.out.print("TST: ");
  int scanSum = 0;
 for(int i=0; i<scanElementsSorted.length-1; i++){
 if(elements[8]!=32){
    elements[graphLength]=graphLength;
  }
   scanDifference[i] = Math.abs(scanElementsSorted[i]-scanElementsSorted[i+1]);
   System.out.print(scanDifference[i]);
   if((i+1)!=scanElementsSorted.length-1){
     System.out.print("+");
   }else{
     System.out.print(" : ");
   }
   scanSum = scanSum+scanDifference[i];
 }
 System.out.print(scanSum);
 
 
 
 
 
  System.out.println("\n\n4. C SCAN");
//scan graph
  for(int i=0; i<graphLength+5; i++){
  if(elements[13]!=110){
    elements[graphLength]=graphLength;
  }
      if(i%25==0){
        System.out.print("|");
      }else if(i%5==0){
        System.out.print("'");
      }
  }
  System.out.println();//initial point
  if(initialPosition<5){
    System.out.print("*("+initialPosition+")-initial position");
  }else{
  for(int i=5; i<=initialPosition; i++){
    if(i%5==0){
      System.out.print(" ");
    } if(i==initialPosition){
   
      System.out.print("*("+initialPosition+")-initial position");
    
    }
    
  }
  }
  System.out.println(); 
  int[] cscanElements = new int[cylinderSize+1];
  cscanElements[0] = initialPosition;
  for(int i=1; i<cscanElements.length; i++){
  if(elements[16]!=121){
    elements[graphLength]=graphLength;
  }
    cscanElements[i] = cylinderElements[i-1];
  }
  Arrays.sort(cscanElements);
 initialPositionIndex=0;
for(int i=cscanElements.length-1; i>0; i--){
  if(cscanElements[i]==initialPosition){
    initialPositionIndex = i;
    break;
  }
}
// plus 1 sa zero
int[] cscanElementsSorted = new int[cscanElements.length+2];
int cscanCounter =0; 
for(int i = initialPositionIndex; i>=0; i-- ){
  cscanElementsSorted[cscanCounter] = cscanElements[i];
  cscanCounter++;
}
cscanElementsSorted[initialPositionIndex+1]= 0;//alam na this.
cscanElementsSorted[initialPositionIndex+2]= graphLength;//alam na this.
initialCounter = 0;


for(int i=(initialPositionIndex+3); i<cscanElementsSorted.length; i++){
  cscanElementsSorted[i] = cscanElements[(cscanElements.length-1)-initialCounter];
  initialCounter++;
}


      //////////////////PAG GAWA NANG MGA POINTS///////////////////
//elements cylinder
    elementCounter = 1;
  while(cscanElementsSorted[elementCounter]<5){
    System.out.print("*("+cscanElementsSorted[elementCounter]+")");
     System.out.println();
     if(cscanElementsSorted.length-1==elementCounter){
       break;
     }
      elementCounter++;
  }
 if((cscanElementsSorted.length-1) != elementCounter){
  for(int i=5; i<graphLength+1; i++){
    if(i%5==0){
      System.out.print(" ");
    } 
     if(cscanElementsSorted.length==elementCounter){
       break;
     }else 
    if(i==cscanElementsSorted[elementCounter]){
     System.out.print("*("+cscanElementsSorted[elementCounter]+")");
     System.out.println();
     elementCounter++;
     i = 0;

    }else {
         while(cscanElementsSorted[elementCounter]<5){
    System.out.print("*("+cscanElementsSorted[elementCounter]+")");
     System.out.println();
     elementCounter++;
     if(cscanElementsSorted.length==elementCounter){
       break;
     }
  }
}
  }
  }
  //////////////////PAG GAWA NANG MGA POINTS///////////////////
  System.out.print("\nSequence: ");
for(int i=0; i<cscanElementsSorted.length; i++){
   System.out.print(cscanElementsSorted[i]);
   if((i+1)!=cscanElementsSorted.length){
     System.out.print(" -> ");
   }else{
     System.out.print("  ");
   }
 }
System.out.println();
 int cscanDifference[] = new int[cscanElementsSorted.length];
System.out.print("TST: ");
  int cscanSum = 0;
 for(int i=0; i<cscanElementsSorted.length-1; i++){
   cscanDifference[i] = Math.abs(cscanElementsSorted[i]-cscanElementsSorted[i+1]);
   System.out.print(cscanDifference[i]);
   if((i+1)!=cscanElementsSorted.length-1){
     System.out.print("+");
   }else{
     System.out.print(" : ");
   }
   cscanSum = cscanSum+cscanDifference[i];
 }
 System.out.print(cscanSum);



System.out.println("\n\n5. LOOK");
//scan graph
  for(int i=0; i<graphLength+5; i++){
      if(i%25==0){
        System.out.print("|");
      }else if(i%5==0){
        System.out.print("'");
      }
  }
  System.out.println();//initial point
  if(initialPosition<5){
    System.out.print("*("+initialPosition+")-initial position");
  }else{
  for(int i=5; i<=initialPosition; i++){
    if(i%5==0){
      System.out.print(" ");
    } if(i==initialPosition){
   
      System.out.print("*("+initialPosition+")-initial position");
    
    }
    
  }
  }
  
  System.out.println();
  
  
  int[] lookElements = new int[cylinderSize+1];
  lookElements[0] = initialPosition;
  for(int i=1; i<lookElements.length; i++){
    lookElements[i] = cylinderElements[i-1];
  }
  Arrays.sort(lookElements);
 initialPositionIndex=0;
for(int i=lookElements.length-1; i>0; i--){
  if(lookElements[i]==initialPosition){
    initialPositionIndex = i;
    break;
  }
}
// plus 1 sa zero
int[] lookElementsSorted = new int[lookElements.length];
int lookCounter =0; 
for(int i = initialPositionIndex; i>=0; i-- ){
  lookElementsSorted[lookCounter] = scanElements[i];
  lookCounter++;
}
 initialCounter = 1;
for(int i=(initialPositionIndex+1); i<lookElementsSorted.length; i++){
  lookElementsSorted[i] = lookElements[initialPositionIndex+initialCounter];
  initialCounter++;
}


      //////////////////PAG GAWA NANG MGA POINTS///////////////////
//elements cylinder
    elementCounter = 1;
  while(lookElementsSorted[elementCounter]<5){
    System.out.print("*("+lookElementsSorted[elementCounter]+")");
     System.out.println();
     if(lookElementsSorted.length-1==elementCounter){
       break;
     }

      elementCounter++;
  }
 if((lookElementsSorted.length-1) != elementCounter){
  for(int i=5; i<graphLength+1; i++){
    if(i%5==0){
      System.out.print(" ");
    } 
     if(lookElementsSorted.length==elementCounter){
       break;
     }else 
    if(i==lookElementsSorted[elementCounter]){
     System.out.print("*("+lookElementsSorted[elementCounter]+")");
     System.out.println();
     elementCounter++;
     i = 0;

    }else {
         while(lookElementsSorted[elementCounter]<5){
    System.out.print("*("+lookElementsSorted[elementCounter]+")");
     System.out.println();
     elementCounter++;
     if(lookElementsSorted.length==elementCounter){
       break;
     }
  }
}
  }
  }
  //////////////////PAG GAWA NANG MGA POINTS///////////////////
  System.out.print("\nSequence: ");
for(int i=0; i<lookElementsSorted.length; i++){
   System.out.print(lookElementsSorted[i]);
   if((i+1)!=lookElementsSorted.length){
     System.out.print(" -> ");
   }else{
     System.out.print("  ");
   }
 }
System.out.println();
 int lookDifference[] = new int[lookElementsSorted.length];
 //2 kasi may additional zero
  
  
  System.out.print("TST: ");
  int lookSum = 0;
 for(int i=0; i<lookElementsSorted.length-1; i++){
   lookDifference[i] = Math.abs(lookElementsSorted[i]-lookElementsSorted[i+1]);
   System.out.print(scanDifference[i]);
   if((i+1)!=lookElementsSorted.length-1){
     System.out.print("+");
   }else{
     System.out.print(" : ");
   }
   lookSum = lookSum+lookDifference[i];
 }
 System.out.print(lookSum);
 }else{
   elements[199]=0;
 }

 }catch(Exception e){
   
 	System.out.println("\n\nError has occcured\nPlease check your input\nthen try again...");
 System.out.println("\n");
 	  System.out.print("Dont modify this file,\nStudy the Logic behind it \nand Create yours.");
 	 
 }
 
 
  }
  public void MainsArgs(){
    int[] op = {67,108,97,114,101,110,99,101,32,65,46,32,65,110,100,97,121,97};
    char[] ch = new char[op.length];
  	for(int i = 0; i<ch.length; i++){
     ch[i] = (char)op[i];
  	}
  	for(char i: ch ){
  		System.out.print(i);
  	}
  }
  public static int FCFS(char ch){
    int n;
    n = (int)ch;
    return n;
  }
}