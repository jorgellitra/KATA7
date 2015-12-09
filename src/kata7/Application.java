package kata7;

import kata7.control.CalculateCommand;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import kata7.control.Command;
import kata7.view.AttributeDialog;
import kata7.view.HistogramDisplay;
import kata7.view.PopulationDialog;

public class Application extends JFrame{

    
    private HashMap<String,Command> commands = new HashMap<>();
    private PopulationDialog populationDialog;
    private AttributeDialog attributeDialog;
    private HistogramDisplay histogramDisplay;
        
    public static void main(String[] args) {
        new Application().setVisible(true);
    }
    
    public Application(){
        this.deployUI();
        this.createCommands();
    }
    
    private void deployUI(){
        this.setTitle("Histogram viewer");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(500, 500));
        this.setLocationRelativeTo(null);
        this.getContentPane().add(HistogramaPanel());
        this.getContentPane().add(toolbar(commands), BorderLayout.NORTH);
    }

    private void createCommands() {
        commands.put("calculate", new CalculateCommand(attributeDialog, populationDialog, histogramDisplay));
    }

    private HistogramPanel HistogramaPanel() {
        HistogramaPanel panel = new HistogramaPanel();
        this.histogramDisplay = panel;
        return panel;
    }

    private JPanel toolbar(HashMap<String, Command> commands) {
        Toolbar panel = new Toolbar(commands);
        this.attributeDialog = panel;
        this.populationDialog = panel;
        return panel;
    }
}
