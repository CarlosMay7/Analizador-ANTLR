import java.util.Arrays;
import java.util.Scanner;

import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Inicio {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Evaluacion resultado = new Evaluacion();
        Vista vista = new Vista();

        System.out.println("Enter your prefix sentence");

        String sentencia = scanner.nextLine();

        sentencia+= "\r\n";

        CharStream input = CharStreams.fromString(sentencia);
        AritLexer lexer=new AritLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        AritParser parser = new AritParser(tokens);
        ParseTree tree = parser.prog();

        if( parser.getFlag()==false){
            resultado.analyzer(sentencia);
        }

        TreeViewer viewer = new TreeViewer(Arrays.asList(parser.getRuleNames()),tree);

        vista.mostrar(viewer);
        scanner.close();

    }


}
