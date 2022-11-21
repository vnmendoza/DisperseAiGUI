package pkg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.awt.event.ActionEvent;
import javax.swing.Icon;

public class MainFrame extends JFrame {
	File originalPic;
	String picPath = "src/pkg/pics/IMG_5.jpg";
	JPanel panelOGPic;
	JLabel picLabel;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
					frame.setResizable(false); 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		//Global Vars
		//File originalPic = new File(picPath);
		
		setTitle("Disperse.Ai");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1413, 815);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		JFileChooser fc = new JFileChooser();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDisperseAi = new JLabel("Disperse.Ai");
		lblDisperseAi.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblDisperseAi.setBounds(621, 11, 144, 47);
		contentPane.add(lblDisperseAi);
		
		
		panelOGPic = new JPanel();
		//Default Original Picture
		BufferedImage myPicture;
		//String picPath = "src/pkg/pics/IMG_5.jpg";
		//String picPath =  originalPic.
		try {
			myPicture = ImageIO.read(new File(picPath));
			picLabel = new JLabel(new ImageIcon(myPicture));
			panelOGPic.add(picLabel);
			

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		panelOGPic.setBounds(45, 69, 627, 420);
		contentPane.add(panelOGPic);
		//panelOGPic.get
		
		JButton btnUpload = new JButton("Upload JPG");
		String floc = "";
		btnUpload.putClientProperty("fileLocation", floc);
		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int returnVal = fc.showOpenDialog(null);
				if(returnVal == JFileChooser.APPROVE_OPTION)
				{
					originalPic = fc.getSelectedFile();
					System.out.println("File Name: " + originalPic.getName());
		            System.out.println("File Location: " + originalPic.getAbsolutePath());
		            picPath = originalPic.getAbsolutePath();
		            BufferedImage oPic = null;
					try {
						oPic = ImageIO.read(new File(picPath));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
		            picLabel.setIcon(new ImageIcon(oPic));
		            
				}
			}
		});
		btnUpload.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUpload.setBounds(291, 506, 124, 47);
		contentPane.add(btnUpload);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//String[] cmd = {"echo", "hi"};
				//String cmd = "python C:\\Users\\VNMen\\Documents\\SrDesign\\CSRNet-crowd_analysis\\analyze.py C:\\Users\\VNMen\\Documents\\SrDesign\\CSRNet-crowd_analysis\\ckpts\\model.pth.tar C:\\Users\\VNMen\\Documents\\SrDesign\\CSRNet-crowd_analysis\\ckpts\\Shanghai\\part_A_final\\test_data\\images\\IMG_2.jpg; dir";
				String cmd = "python C:\\Users\\VNMen\\Documents\\SrDesign\\CSRNet-crowd_analysis\\helloworld.py";
				try {
					 Process runtime = Runtime.getRuntime().exec(cmd);
				     Show_Output(runtime);
				} catch (IOException e1) {
					//TODO Create more TOdos
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
								
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSubmit.setBounds(989, 506, 124, 47);
		contentPane.add(btnSubmit);
		
		JLabel lblCount = new JLabel("Count:");
		lblCount.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCount.setBounds(621, 500, 55, 53);
		contentPane.add(lblCount);
		
		JLabel lblNumber = new JLabel("number");
		lblNumber.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNumber.setBounds(686, 516, 88, 21);
		lblNumber.setText("100");
		contentPane.add(lblNumber);
		
		
		
		//
		JPanel panelDensityPic = new JPanel();
		panelDensityPic.setBounds(722, 69, 627, 420);
		contentPane.add(panelDensityPic);
		//Default Density Picture
		BufferedImage dPic;
		String dPicPath = "src/pkg/pics/DensityMap_Predicted.png"; 
		try {
			dPic = ImageIO.read(new File(dPicPath));
			Image scaledDpic = dPic.getScaledInstance(panelDensityPic.getWidth(), panelDensityPic.getHeight(), DO_NOTHING_ON_CLOSE);
			JLabel picLabel = new JLabel(new ImageIcon(scaledDpic));
			panelDensityPic.add(picLabel);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//JLabel picLabel = new JLabel((Icon) null);
		//panelDensityPic.add(picLabel);
		contentPane.add(panelDensityPic);
		
	}
	public static void Show_Output(Process process) throws IOException {
        BufferedReader output_reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String output = "";
        while ((output = output_reader.readLine()) != null) {
            System.out.println(output);
        }
    }
}
