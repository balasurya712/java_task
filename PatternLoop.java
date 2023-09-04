class PatternLoop{

static void printStarPattern(int n){
    for(int ctr=1;ctr<=n;ctr++){
        for(int i=1;i<=ctr;i++){
            System.out.print("*");
        }
        for(int j=0;j<(2*n)-(ctr*2);j++){
             System.out.print(" ");
        }
        for(int i=1;i<=ctr;i++){
            System.out.print("*");
        }
    
    System.out.println("");
    }
}

static void printMinus(int n){
     
       for(int ctr=0;ctr<n;ctr++){
        for(int i=n;i>ctr;i--){
            System.out.print("-");
        }
        for(int j=(2*n);j>(2*n)-(ctr*2);j--){
             System.out.print(" ");
        }
        for(int i=n;i>ctr;i--){
            System.out.print("-");
        }
    
    System.out.println("");
    }
    
}
public static void main(String[] args) {

    printStarPattern(9);
    printMinus(9);

}
}