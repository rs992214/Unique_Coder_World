import java.util.Scanner;

class Stack{
    private int size=0,top=-1;
    Scanner sc= new Scanner(System.in);
    int [] stack;
    String name;

    Stack(String n){
        System.out.print("Ohk then Enter the size of the stack: ");
        size = sc.nextInt();
        name = n;

        if(size<=0)
            System.out.println("Stack size is not proper...");
        else{    
            stack = new int[size];
            operations();
        }
    }

    void operations(){
        System.out.println("Your stack of size " +stack.length+" and named "+name +" is created and the you have already inserted " +(top+1) + "elements");
        
        do{
            System.out.println("1. push");
            System.out.println("2. pop");
            System.out.println("3. exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            System.out.println("\n");
            
            switch (choice) {
                case 1:
                    push();
                    break;
                case 2:
                    pop();
                    break;
                case 3:
                    return;
                
                default:
                    System.out.println("Enter Right value: ");
                    break;
                }
        }while(true);
    }

    private boolean isEmpty(){
        if(top<0){
            System.out.println("Your stack is empty you can not add ");
            return true;
        }
        return false;
    }

    private boolean isFull(){
        if(top>((stack.length)-2)){
            System.out.println("Stack is full... you can not add more values");
            return true;
        }
        return false;
    }

    private void push(){
        if(isFull())
            return;

        System.out.print("Enter a value to insert: ");
        
        top++;
        stack[top] = sc.nextInt();
        System.out.println("Your value is inserted, total element in a stack is: "+(top+1));
    }
    
    private void pop(){
        if(isEmpty())
            return;
        
        top--;
        System.out.println("Value is removed from the stack, total element in a stack is: " +(top+1));

    }
}

public class Linear{
    
    private Stack manageStack(Stack[] oldArrayStack){

        Scanner sc = new Scanner(System.in);
        //find how many stack are present
        //give user to choose which stack they want to work by listing and choosing that
        //for creating new stack
            

        do{
            System.out.print("Enter your choice for the stack: ");
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter the name of that stack: ");
                    sc.nextLine();
                    Stack s = new Stack(sc.nextLine());
                    break;
                case 2:
                    for (Stack stack : oldArrayStack) {
                        System.out.println(stack.name);
                    }
                
                case 3:
                    // return s;

                default:
                    break;
            }


        }while(true);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Linear l = new Linear();
        Stack[] mainStack = new Stack[1];

        // do {
        //     System.out.println("1. Stack");
        //     System.out.println("2. Exit");
        //     System.out.print("Enter your choice: ");
        //     int choice = sc.nextInt();
        //     System.out.println("\n");
        
        //     switch (choice) {
        //         case 1:   
        //                
        //             l.manageStack(mainStack);

        //             break;

        //         case 2:
        //             return;
            
        //         default:
        //             System.out.println("Enter proper choice: ");
        //             break;
        //     }

            
        // } while (true);



        
        
        
    }
}
