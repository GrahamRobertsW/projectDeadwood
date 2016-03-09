import java.awt.*;
import java.util.*;
import javax.swing.*;
public class SwingPlayer{
	public static void main (String args[]){
		JFrame f = new JFrame("does this work");
		f.setSize(200,200);
		f.setLayout(new FlowLayout());
      ImageIcon icon = new ImageIcon("dice1.png");
		JLabel lab = new JLabel(icon, JLabel.CENTER);
		//JButton button = new JButton(icon);
      MouseListener listener = new DragMouseAdapter();
      label.addMouseListener(listener);
		label.setTransferHandler(new TransferHandler("duck"));
