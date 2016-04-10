package thread.projava8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLConnection;

public class DownloadFiles extends JPanel {
    private JPanel listPanel;
    private GridBagConstraints constraints;
    public static void main(String[] args) {
        JFrame f = new JFrame("Download Files");
        DownloadFiles df = new DownloadFiles();
        for (int i = 0; i < args.length; i++) {
            df.createDownloader(args[i]);
        }
        f.getContentPane().add(df);
        f.setSize(600, 400);
        f.setVisible(true);
    }
    public DownloadFiles() {
        setLayout(new BorderLayout());
        listPanel = new JPanel();
        listPanel.setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.weightx = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.NORTH;
        JScrollPane jsp = new JScrollPane(listPanel);
        add(jsp, BorderLayout.CENTER);
        add(getAddURLPanel(), BorderLayout.SOUTH);
    }
    private JPanel getAddURLPanel() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("URL:");
        final JTextField textField = new JTextField(20);
        JButton downloadButton = new JButton("Download");
        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (createDownloader(textField.getText())) {
                    textField.setText("");
                    revalidate();
                }
            }
        };
        textField.addActionListener(actionListener);
        downloadButton.addActionListener(actionListener);
        panel.add(label);
        panel.add(textField);
        panel.add(downloadButton);

        JButton clearAll = new JButton("Cancel All");
        clearAll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Downloader4.cancelAllAndWait();
                listPanel.removeAll();
                revalidate();
                repaint();
            }
        });
        panel.add(clearAll);
        return panel;
    }
    private boolean createDownloader(String url) {
        try {
            URL downloadURL = new URL(url);
            URLConnection urlConn = downloadURL.openConnection();
            int length = urlConn.getContentLength();
            if (length < 0) throw new Exception(
                    "Unable to determine content " +
                            "length for '" + url + "'");
            int index = url.lastIndexOf('/');
            FileOutputStream fos = new FileOutputStream(
                    url.substring(index + 1));
            BufferedOutputStream bos =
                    new BufferedOutputStream(fos);
            DownloadManager dm = new DownloadManager(
                    downloadURL, bos);
            listPanel.add(dm, constraints);
            return true;
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),
                    "Unable To Download",
                    JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
}


