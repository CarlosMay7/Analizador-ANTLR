import java.util.*;
public class AritSemantic {
    Stack<String> pila;
    boolean flag_error;
    float resultado;

    public AritSemantic(){
        this.pila = new Stack<String>();
        this.flag_error = false;
    }    

    public void analyzer(String entrada){
        entrada = cleaner(entrada);
        fillStack(entrada);
        result();
        if (this.flag_error){
            System.out.println("Error en la sentencia ingresada. Semánticamente incorrecta");
        }else{
            System.out.println(this.resultado);
        }
        

    }

    public String cleaner (String entrada){
        entrada = entrada.replace("(","");
        entrada = entrada.replace(")","");
        return entrada;
    }

    public void fillStack(String entrada){
        String[] texto = entrada.split(" ");
        for (String s : texto) {
           this.pila.push(s);
        }
    }

    public void result(){
        float operacion = 0;
        float temp1 = 0;
        float temp2 = 0;
        int index_operador = 1;

        int tamaño_pila = this.pila.size();
        System.out.println(this.pila);

        while (index_operador < tamaño_pila){
            if (index_operador % 2 != 0){
                temp1 = Float.valueOf(this.pila.peek());
                this.pila.pop();
                temp2 = Float.valueOf(this.pila.peek());
                this.pila.pop();
            }else{
                String operador = this.pila.peek();
                if (operador.equals("+")){
                    operacion = temp1 + temp2;
                }else{
                    if (operador.equals("-")){
                        operacion = temp2 - temp1;
                    }else{
                        if (operador.equals("*")){
                            operacion = temp1 * temp2;
                        }else{
                            if (operador.equals("/")){
                                if (temp1 != 0){
                                    operacion = temp2 / temp1;
                                }else{
                                    operacion = 0;
                                    this.flag_error = true;
                                }
                            }else{
                                if (operador.equals("^")){
                                    operacion = 1;
                                    for(int i = 0; i < temp1; i++){
                                        operacion = operacion * temp2;
                                    }

                                }
                            }
                        }
                    }
                }
                this.resultado = operacion;
                this.pila.pop();
                this.pila.push(String.valueOf(operacion));

            }
            index_operador += 1;
            System.out.println(this.pila);
        }
    }
    
}
