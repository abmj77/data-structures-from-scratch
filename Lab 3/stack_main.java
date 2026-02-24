
package lab4;

public class stack_main {

    
    public static boolean checkBalance(String expr){
         boolean test = true;
        
         Stack stack = new Stack();
         for (int i = 0; i < expr.length(); i++) {
            char character = expr.charAt(i);
            E x=new E(character);
            if (x.getValue() == '(' || x.getValue() == '[' || x.getValue() == '{') {
                stack.push(x);
                continue;
            }
              char check;
             
            switch (x.getValue()) {
            case ')':
                check = stack.pop().getValue();
             
                if (check == '{' || check == '['){
                    test = false;
            
                }
                break;
 
            case '}':
                check = stack.pop().getValue();
            
                if (check == '(' || check == '['){
                   test = false;
                
                }
                break;
 
            case ']':
                check = stack.pop().getValue();
             
                if (check == '(' || check == '{'){
                    test = false;
                  
                }
                break;
            }
        }
       return test;
   
    }
    
    public static void main(String[] args) {
          String brackets  ="{([])}";
         if(checkBalance(brackets )){
            System.out.println(brackets  + " is balance");
        }else{
            System.out.println(brackets  + " is not balance");
        }
     
    }
    
}
