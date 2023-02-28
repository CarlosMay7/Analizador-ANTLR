import java.util.*;
public class Evaluacion {
    Stack<String> stack;
    boolean flag_semantic;
    float result;

    public Evaluacion(){
        this.stack = new Stack<String>();
        this.flag_semantic = false;
    }    

    public void analyzer(String input){
        input = cleaner(input);
        fillStack(input);
        calculator();
        if (this.flag_semantic){
            System.out.println("Error in the statement entered. Semantically incorrect");
        }else{
            
            System.out.println(String.format("The result of the sentence is: %.2f",this.result ));
            
        }
        

    }

    public String cleaner (String input){
        if (input.contains("(") || input.contains(")")){
            input = input.replace("(","");
            input = input.replace(")","");
        }
        return input;
    }

    public void fillStack(String input){
        String[] texto = input.split(" ");
        for (String s : texto) {
           this.stack.push(s);
        }
    }

    public void calculator(){
        float operation = 0;
        float temp1 = 0;
        float temp2 = 0;
        int index_operator = 1;

        int tamaño_stack = this.stack.size();

        while (index_operator < tamaño_stack){
            if (index_operator % 2 != 0){
                temp1 = Float.valueOf(this.stack.peek());
                this.stack.pop();
                temp2 = Float.valueOf(this.stack.peek());
                this.stack.pop();
            }else{
                String operator = this.stack.peek();
                if (operator.equals("+")){
                    operation = temp1 + temp2;
                }else{
                    if (operator.equals("-")){
                        operation = temp2 - temp1;
                    }else{
                        if (operator.equals("*")){
                            operation = temp1 * temp2;
                        }else{
                            if (operator.equals("/")){
                                if (temp1 != 0){
                                    operation = temp2 / temp1;
                                }else{
                                    operation = 0;
                                    this.flag_semantic = true;
                                }
                            }else{
                                if (operator.equals("^")){
                                    operation = 1;
                                    for(int i = 0; i < temp1; i++){
                                        operation = operation * temp2;
                                    }

                                }
                            }
                        }
                    }
                }
                this.result = operation;
                this.stack.pop();
                this.stack.push(String.valueOf(operation));

            }
            index_operator += 1;
        }
    }
    
}