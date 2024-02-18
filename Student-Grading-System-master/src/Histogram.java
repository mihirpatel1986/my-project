import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class Histogram {

    private static JFrame frame;

    public static void display(List<Student> studentList) {

        frame = new JFrame();
        frame.setBounds(100, 100, 450, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel hPanel = new JPanel();
        hPanel.setBounds(0, 0, 450, 150);
        frame.getContentPane().add(hPanel);
        hPanel.setLayout(null);

        // The labels show the number limits
        JLabel label1 = new JLabel("0-29");
        label1.setBounds(10, 0, 60, 30);
        hPanel.add(label1);

        JLabel label2 = new JLabel("30-39");
        label2.setBounds(10, 30, 60, 30);
        hPanel.add(label2);

        JLabel label3 = new JLabel("40-69");
        label3.setBounds(10, 60, 60, 30);
        hPanel.add(label3);

        JLabel label4 = new JLabel("70-100");
        label4.setBounds(10, 90, 60, 30);
        hPanel.add(label4);

        JLabel lblStudentNum = new JLabel(studentList.size() + " Students in total");
        lblStudentNum.setBounds(10, 120, 450, 30);
        hPanel.add(lblStudentNum);

        // The labels are printed the stars in the histogram
        JLabel starLabel1 = new JLabel("");
        starLabel1.setBounds(70, 0, 250, 30);
        hPanel.add(starLabel1);

        JLabel starLabel2 = new JLabel("");
        starLabel2.setBounds(70, 30, 250, 30);
        hPanel.add(starLabel2);

        JLabel starLabel3 = new JLabel("");
        starLabel3.setBounds(70, 60, 250, 30);
        hPanel.add(starLabel3);

        JLabel starLabel4 = new JLabel("");
        starLabel4.setBounds(70, 90, 250, 30);
        hPanel.add(starLabel4);

        // Test overall marks of each Student and show text in star labels
        for (Student obj : studentList) {
            if (obj.getOverallMarks() < 30) {
                starLabel1.setText(starLabel1.getText() + "*");

            } else if (obj.getOverallMarks() < 40) {
                starLabel2.setText(starLabel2.getText() + "*");

            } else if (obj.getOverallMarks() < 70) {
                starLabel3.setText(starLabel3.getText() + "*");

            } else {
                starLabel4.setText(starLabel4.getText() + "*");
            }
        }
        frame.setVisible(true);

    }

}
