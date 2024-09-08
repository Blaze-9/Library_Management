import java.util.*;
class Books{
    protected int id,cost,status;
    protected String title,author;
    public Books(int id,String title,String author,int cost,int status){
        this.id=id;
        this.title=title;
        this.author=author;
        this.cost=cost;
        this.status=status;

    }
    public void setId(int id){
        this.id=id;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public void setAuthor(String author){
        this.author=author;
    }
    public void setCost(int cost){
        this.cost=cost;
    }
    public void setStatus(int status){
        this.status=status;
    }
    public int getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;

    }
    public int getCost(){
        return cost;
    }
    public int getStatus(){
        return status;
    }
}
class Student{
    protected int rollno,booklim;
    protected String name;
    public Student(int rollno,String name,int booklim){
        this.rollno=rollno;
        this.name=name;
        this.booklim=booklim;
    }
    public void setRollno(int rollno){
        this.rollno=rollno;
    }
    public void setName(String name){
        this.name=name;

    }
    public void setBooklim(int booklim){

        this.booklim=booklim;
    }
    public int getRollno(){
        return rollno;
    }
    public String getName(){
        return name;
    }
    public int getBooklim(){
        return booklim;
    }
}
class libraryNew{
    public static void main(String args[]){
        Books b[]={new Books(1,"Through My Lens ","Suzie",3000,0),
                new Books(2,"Wit and Wisdom","William",2000,0),
                new Books(3,"Nightmares are Scary","Rico",1000,0),
                new Books(4,"Be a Man","Alex",900,0)};
        Student s[]={new Student(21,"Krishna",3),    
                    new Student(12, "Bharath", 3),
                    new Student(34, "Shreyas", 3),
                    new Student(40, "Samai", 3)
    
    };
    Scanner sc=new Scanner(System.in);

    while(true){
        System.out.println("LIBRARY MENU");
        System.out.println("---------------------------------------------------------");
        System.out.println("press 1- ISSUE THE BOOK");
        System.out.println("press 2-  RETURN THE BOOK");
        System.out.println("press 3- ENQUIRY OF THE BOOK");
        System.out.println("press-4-LIST OF BOOKS YOU TOOk ");
        System.out.println("press 5-EXIT");
        System.out.println("-------------------------------------------------");
        int ch;
        System.out.println("Enter choice");
        ch=sc.nextInt();
        if(ch==1){
            System.out.println("Could you please enter your rollno");
            int rollno=sc.nextInt();
            for (Student x : s)
            {
              if(x.getRollno()==rollno){
                if(x.getBooklim()>0){
                    System.out.println("Could you please enter the details of book");
                    System.out.println("Book id:");
                    int id=sc.nextInt();
                   // System.out.println("Enter the book title");
                    //String title=sc.nextLine();
                    //sc.nextLine();
                    for (Books y : b) {
                        if(y.getId()==id  && y.getStatus()==0){
                            System.out.println("Book is present");
                            y.status=x.rollno;
                            x.booklim=x.booklim-1;
                            System.out.println(x.name +" Your current booklimit is: "+x.booklim);
                            break;
                        }      
                        else{
                            System.out.println("Book under circulation");
                        }  
                             
                    } 
                }
                else{
                    System.out.println("Book limit doesnt support");
                }
                
              }  
             
              
            }
        }
        if(ch==2){
            System.out.println("Enter the book id you want to return");
            int id=sc.nextInt();
            System.out.println("Enter your roll no:");
            int rollno=sc.nextInt();
            for (Books x  : b) {
                for (Student y : s) {
                    if(x.getStatus()==y.getRollno()){
                        if(x.id==id){
                            x.setStatus(0);
                            y.booklim=y.booklim+1;
                            System.out.println(y.getName()+" Your current book limit is "+y.getBooklim());
                            break;

                        }
                       
                    }
                    
                    
                    
                }
               
            }
           
        }


        
            if(ch==3){
                System.out.println("Enter details of book");
                System.out.println("Enter the book id: ");
                int id=sc.nextInt();
               // System.out.println("Enter the book Title: ");
                //String title=sc.nextLine();
               // sc.nextLine(); 
                boolean bookFound = false;

                 for (Books x : b) {
                  for (Student y : s) {
                 if (x.getStatus() == y.getRollno() && x.getId() == id) {
                System.out.println("Book is with: " + y.getName() + " " + "rollno: " + y.getRollno());
                bookFound = true;
                break;
            }
        }
    }

                 if (!bookFound) {
                  System.out.println("Book is Available");
                 } 
                 else {
                 System.out.println("Book is under circulation");
        }
    }
                if(ch==4){
                    System.out.println("enter your rollno");
                    int rollno=sc.nextInt();
                    for (Books a :b) {
                        if(a.status==rollno){
                            System.out.println("Book id: "+a.id+" Title : "+a.title);
                        }
                        
                    }
                }
                if(ch==5){
                    System.exit(1);;
                }
        }
        

        



}
      
}
