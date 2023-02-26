import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Inicio {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Calculadora calculadora = new Calculadora();
        AritSemantic resultado = new AritSemantic();

        System.out.println("Ingrese su sentencia prefija");

        String sentencia = scanner.nextLine();

        sentencia+= "\r\n";

        CharStream input = CharStreams.fromString(sentencia);
        AritLexer lexer=new AritLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        AritParser parser = new AritParser(tokens);
        ParseTree tree = parser.prog(); // parse

        if( parser.getFlag()==true){
            System.out.print("El resultado es: ");
            resultado.analyzer(sentencia);
        }

        JFrame frame = new JFrame("Antlr AST");
        JPanel panel = new JPanel();
        TreeViewer viewer = new TreeViewer(Arrays.asList(parser.getRuleNames()),tree);
        viewer.setScale(3); // Scale a little
        panel.add(viewer);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        scanner.close();

    }


}
