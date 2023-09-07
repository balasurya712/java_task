package day_4;

class Err extends Error{
Err(String msg){
    super(msg);
    System.out.println("Custome Exception");
}
}
class StackOver {  
     void check(int i)  
    {  
        if (i == 0)  
            return;  
        else {  
            check(i++);  
        }  
    }  
}  

public class Erro {

    public static void main(String[] args) {
        StackOver so=new StackOver();
        try{
            so.check(2);
            
        }catch(StackOverflowError a){
            try{
            throw new Error("Your Recursion condition never fails");
            }
            catch(Err e){
                System.out.println(e);
            }
        }
    }
    
}
