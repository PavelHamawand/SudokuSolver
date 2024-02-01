package textproc;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

public class BookReaderController {
	
    public BookReaderController(GeneralWordCounter counter) {
        SwingUtilities.invokeLater(() -> createWindow(counter, "BookReader", 1000, 500));
    }

	private void createWindow(GeneralWordCounter counter, String title,  int width, int height) {
         JFrame frame = new JFrame(title);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         Container pane = frame.getContentPane();
         SortedListModel<Map.Entry<String, Integer>> model = new SortedListModel<>(counter.getWordList());
         JList<Map.Entry<String, Integer>> listView = new JList<>(model);
         listView.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
         
         JScrollPane scrollPane = new JScrollPane(listView);
         scrollPane.setPreferredSize(new Dimension(500,400));

         pane.add(scrollPane, BorderLayout.CENTER);
         
      
         frame.pack();
         frame.setVisible(true);
         
         JPanel panel = new JPanel();
         JTextField field = new JTextField(10);
         JButton alph = new JButton("Alphabetic");
         JButton freq = new JButton("Frequency");
         JButton search = new JButton("Search");
         frame.getRootPane().setDefaultButton(search);
         
         panel.add(alph);
         panel.add(freq);
         panel.add(search);
         panel.add(field);

         pane.add(panel, BorderLayout.SOUTH);
         
         alph.addActionListener(event -> model.sort(Map.Entry.comparingByKey()));
         freq.addActionListener(event -> model.sort((e1, e2) -> e2.getValue() - e1.getValue()));
         search.addActionListener(event -> {
             boolean exists = false;
             String searchText = field.getText().toLowerCase().trim();
             for (int i = 0; i<model.getSize();i++) {
                 if (model.getElementAt(i).getKey().equals(searchText)) {
                     listView.ensureIndexIsVisible(i);
                     listView.setSelectedIndex(i);
                     exists = true;
                     break;
                 }
             }
             if(!exists) JOptionPane.showMessageDialog(null, field.getText() + " finns ej i listan.");
         });
     }
}

