import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.antlr.v4.gui.TreeViewer;

public class Vista {
    public void mostrar(TreeViewer viewer){
        JFrame frame = new JFrame("Antlr AST");
        JPanel panel = new JPanel();
        panel.add(viewer);
        frame.add(panel);
        viewer.setScale(2);
        JScrollPane myJScrollPane = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        frame.add(myJScrollPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
