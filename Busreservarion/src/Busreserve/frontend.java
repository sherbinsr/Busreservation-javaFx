package Busreserve;
import java.sql.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;



public class frontend extends busDetails implements ActionListener{

	
	
	JFrame frame = new JFrame("RESOSBUS");
	JFrame frame1 = new JFrame("RESOBUS");
	
	JDateChooser jd = new JDateChooser();
	JTextField inputbox1 = new JTextField();
	JTextField inputbox2 = new JTextField();
	JTextField inputbox3 = new JTextField();
	JTextField inputbox4 = new JTextField();
	JTextField inputbox5 = new JTextField();
	JTextField inputbox6= new JTextField();
	JTextField inputbox7= new JTextField();
	JTextField inputbox8= new JTextField();
	JTextField inputbox9= new JTextField();
	JRadioButton upi = new JRadioButton("UPI");
	JRadioButton debit = new JRadioButton("Debit Card");
	JRadioButton credit = new JRadioButton("Credit Card");
	ButtonGroup group = new ButtonGroup();
	
	JLabel message = new JLabel();
	JLabel output = new JLabel();
	JLabel cost= new JLabel();
	JLabel busnum= new JLabel();
	JLabel busdetails= new JLabel();
	JLabel bug= new JLabel();
	JLabel nobus= new JLabel();
	String [] gender  = {"Select","Male","Female","others"};
	
	 String age[]= {"select","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15",
			 "16","17","18","19","20","21","22","23","24","25","26","27","28","29","30",
			 "31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47",
			 "48","49","50","51","52","53","54","55","56","57","58","59","60","61","62","63","64","65","66",
			 "67","68","69","70","71","72","73","74","75","76","77","78","79","80"};
	
	JComboBox combobox = new JComboBox(gender);
	JComboBox agebox = new JComboBox(age);
	
	JButton search = new JButton("Look for buses");
	JButton booking = new JButton("BOOK NOW");
	JButton makepay= new JButton("Make Payment");
	
     ImageIcon img  = new ImageIcon("busreserve.jpg");
     ImageIcon img2  = new ImageIcon("ic.png");
     ImageIcon img3 = new ImageIcon("busreserve2.jpg");

	JLabel departure= new JLabel("DEPARTURE");
	JLabel arrival= new JLabel("ARRIVAL");
	JLabel date= new JLabel("DATE");
	JLabel depart= new JLabel("DEPARTURE");
	JLabel arriv= new JLabel("ARRIVAL");
	JLabel name= new JLabel("NAME");
	
	JLabel pay= new JLabel("PAYMENTS");
	JLabel Gender= new JLabel("GENDER");
	JLabel numr= new JLabel("MOBILE NO");
	JLabel cvv= new JLabel("CVV PIN");
	JLabel dat= new JLabel(" JOURNEY DATE");
	JLabel ages= new JLabel("AGE");
	
	JLabel background= new JLabel("",img,JLabel.CENTER);
	JLabel backicon= new JLabel("",img2,JLabel.CENTER);
	JLabel background2= new JLabel("",img3,JLabel.CENTER);
	JLabel  copyright= new JLabel("SHERBIN@2022");
	JLabel empty= new JLabel("");

	PreparedStatement pat;
	
	
	List<String>li = new ArrayList<String>();
	frontend(List<String>zi){
		
	    inputbox1.setBounds(125, 100, 200, 25);
	    inputbox1.setVisible(true);
	    
	    inputbox2.setBounds(125, 150, 200, 25);
	    inputbox2.setVisible(true);
		
	    inputbox3.setBounds(125, 200, 200, 25);
	    inputbox3.setVisible(true);
		
	    inputbox4.setBounds(150, 150, 200, 25);
	    inputbox4.setVisible(true);
	 
	    inputbox5.setBounds(150, 200, 200, 25);
	    inputbox5.setVisible(true);
		
	    inputbox6.setBounds(150, 475, 200, 25);
	    inputbox6.setVisible(true);
	    
	    inputbox7.setBounds(150, 510, 45, 30);
	    inputbox7.setVisible(true);
	    
	    inputbox8.setBounds(150, 300, 200, 25);
	    inputbox8.setVisible(true);
	
	    inputbox9.setBounds(150, 100, 200, 25);
	    inputbox9.setVisible(true);
	
	    combobox.setBounds(150, 250, 200, 25);
	    combobox.setVisible(true);
	    
	    jd.setBounds(150, 350, 200, 25);
	    jd.setVisible(true);
	    
	    agebox.setBounds(400, 250, 80, 25);
	    agebox.setVisible(true);
	    
	    upi.setBounds(125, 400, 200, 25);
	    upi.setVisible(true);
	
	   credit.setBounds(125, 425, 200, 25);
	   credit.setVisible(true);
	
	   debit.setBounds(125, 450, 200, 25);
	   debit.setVisible(true);
	   
	   group.add(upi);
	   group.add(credit);
	   group.add(debit);
	   
	   upi.addActionListener(this);
	   credit.addActionListener(this);
	   debit.addActionListener(this);
	  
		nobus.setBounds(125, 280, 200, 100);
		output.setBounds(125, 280, 200, 100);
		cost.setBounds(125, 320, 200, 100);
		busnum.setBounds(125, 360, 200, 100);
		busdetails.setBounds(125, 400, 200, 100);
		bug.setBounds(200, 340, 440, 100);
		
        search.setBounds(150,250, 150, 25);
		search.addActionListener(this);
		search.setFocusable(true);
		search.setBackground(Color.GRAY);
	   
		booking.setBounds(150,485, 150, 25);
		booking.addActionListener(this);
		booking.setFocusable(false);
		booking.setBackground(Color.GRAY);
		
		makepay.setBounds(150,600, 150, 25);
		makepay.addActionListener(this);
		makepay.setFocusable(false);
		makepay.setBackground(Color.GRAY);
       
		departure.setBounds(50, 100, 75, 25);
		arrival.setBounds(54, 150, 75, 25);
		date.setBounds(56, 200, 75, 25);
		empty.setBounds(58, 200, 75, 25);
		depart.setBounds(50, 100, 75, 25);
		arriv.setBounds(54, 150, 75, 25);
		name.setBounds(50, 200, 75, 25);
		
	    Gender.setBounds(50, 250, 75, 25);
	    ages.setBounds(360, 250, 75, 25);
	    numr.setBounds(50,  300, 75, 25);
	    pay.setBounds(50, 400, 75, 25);
		dat.setBounds(50, 350, 150, 25);
		cvv.setBounds(50, 410, 75, 25);
		cvv.setVisible(true);
		copyright.setBounds(350, 500, 75, 25);
		
		frame.add(search);
		
		frame.add(inputbox1);
		frame.add(inputbox2);
		frame.add(inputbox3);
		frame.add(message);
		frame.add(departure);
		frame.add(arrival);
		frame.add(date);
		frame.add(empty);
		frame.add(output);
		frame.add(nobus);
		frame.add(cost);
		frame.add(busnum);
		frame.add(busdetails);
		frame.add(bug);
		frame.add(background);
		
		frame.add(backicon);
		frame.add(copyright);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,600);
		frame.setVisible(true);
        frame.setLayout(null);
        
        background.setBounds(0, 0, 500,600);
       
        backicon.setBounds(400, 500, 60,70);
        
	
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
	
		
		
		 
		String start =inputbox9.getText();
		 String end =inputbox4.getText();
			String   Customername = inputbox5.getText(); 
			String id = inputbox6.getText();
			String   num = inputbox8.getText(); 
			
			String jds = ((JTextField)jd.getDateEditor().getUiComponent()).getText();
			String   gen = combobox.getSelectedItem().toString();
			String age = agebox.getSelectedItem().toString();
		if (e.getSource()==makepay) {

			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/businfo","root","s3112004@");
				pat =con.prepareStatement("insert into bus(Startpoint,Endpoint,Name,Mobilenum ,Gender,Age,Transaction,JourneyDate)values(?,?,?,?,?,?,?,?) ");
				pat.setString(1, start);
				pat.setString(2, end);
				pat.setString(3, Customername);
				pat.setString(4, num );
				pat.setString(5, gen);
				pat.setString(6, age);
				pat.setString(7, id);
				pat.setString(8, jds);
				int w =pat.executeUpdate();
				  
				if(w==1) {
					
					System.out.println("insertin records");
					inputbox4.setText("");
					inputbox5.setText("");
					inputbox9.setText("");
					inputbox8.setText("");
				
				}
				
				
			
			} catch (Exception k) {
				
				System.out.println(k);
				
				
			}
			
			 JOptionPane.showMessageDialog(null, "REGISTRATION SUCESSEFULL");
             try {
 				Class.forName("com.mysql.jdbc.Driver");
 				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/businfo","root","s3112004@");
 			    Statement stmt = conn.createStatement();
 			    ResultSet rs=stmt.executeQuery("SELECT * FROM businfo.bus");
 				
 			    while (rs.next()) {
 					
 				
 					String name = rs.getString("Name");
 			  System.out.println(name);
 					}
 			
 			} catch (Exception k) {
 				
 				System.out.println(k);
 				
 				
 			}        
		}

		 String dp =inputbox1.getText();
		   String av =inputbox2.getText();
	 
    
	   if(e.getSource()==upi) {
    	   
    	   frame1.add(inputbox6);
       }
	   else if(e.getSource()==credit) {
		   
		   frame1.add(inputbox6);
		   frame1.add(inputbox7);
		   frame1.add(cvv);
		   
		   
	   }
       else if(e.getSource()== debit) {
		   
		   frame1.add(inputbox6);
		  
		   
	   }
    
	   
	   if(dp.equalsIgnoreCase("") || dp.equalsIgnoreCase("")) {
		   
		   JOptionPane.showMessageDialog(null, "! Please Enter Your Destiny");
	   }
	   
	   else if(dp.equalsIgnoreCase("coimbatore") && av.equalsIgnoreCase("nagercoil")) {
		   
		   frame.add(booking);
		   output.setText("Travel hours :9 hrs 49 minutes");
		   cost.setText("Rate:$560");
		   busnum.setText("Bus Number:7HB23");
		   busdetails.setText("TN-SETC-SEMI-SLEEPER");
           bug.setText(null);
           
           if(e.getSource()==booking) {
        	   
        	   
        	  
        	   frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       		   frame1.setSize(520,700);
       		   frame1.setVisible(true);
               frame1.setLayout(null);
               frame1.setBackground(Color.RED);
               frame1.add(background2);
               background2.setBounds(0, 0, 520,700);
               frame1.add(inputbox4);
               frame1.add(inputbox5);
               frame1.add(inputbox9);
               frame1.add(depart);
               frame1.add(arriv);
       	       frame1.add(name);
       	       frame1.add(ages);
       	       frame1.add(combobox);
       	       frame1.add(Gender);
       	       frame1.add(agebox);
       	       frame1.add(pay);
       	       frame1.add(upi);
       	       frame1.add(credit);
       	       frame1.add(debit);
       	       frame1.add(numr);
       	       frame1.add(inputbox8);
       	       frame1.add(makepay);
       	        frame1.add(dat);
    	       frame1.add(jd);
       	       frame1.add(background2);
       	       
       	   
               booking.add(frame1);
               
               
              
           }
           
		   
	   }
    else if(dp.equalsIgnoreCase("nagercoil") && av.equalsIgnoreCase("koyambedu")) {
		   
		   frame.add(booking);
           
		   output.setText("Travel hours :11 hrs 21 minutes");
		   cost.setText("Rate:$700");
		   busnum.setText("Bus Number:7HB23");
		   busdetails.setText("TN-SETC-SEMI-SLEEPER");
           bug.setText(null);
           
           if(e.getSource()==booking) {
        	   
        	   
        	   background2.setBounds(0, 0, 520,700);
        	   frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       		   frame1.setSize(520,700);
       		   frame1.setVisible(true);
               frame1.setLayout(null);
               frame1.setBackground(Color.RED);
               frame1.add(background2);
               
               frame1.add(inputbox4);
               frame1.add(inputbox5);
               frame1.add(inputbox9);
               frame1.add(depart);
               frame1.add(arriv);
       	       frame1.add(name);
       	       frame1.add(ages);
       	       frame1.add(combobox);
       	       frame1.add(Gender);
       	       frame1.add(agebox);
       	       frame1.add(pay);
       	       frame1.add(upi);
       	       frame1.add(credit);
       	       frame1.add(debit);
       	       frame1.add(numr);
       	       frame1.add(inputbox8);
       	       frame1.add(makepay);
       	       frame1.add(dat);
    	       frame1.add(jd);
       	       frame1.add(background2);
       	     
       	   
               booking.add(frame1);
               
               
              
           }
           
		   
	   }
	   else if(dp.equalsIgnoreCase("nagercoil") && av.equalsIgnoreCase("coimbatore")) {
		   
		   frame.add(booking);
		   output.setText("Travel hours :9 hrs 49 minutes");
		   cost.setText("Rate:$560");
		   busnum.setText("Bus Number:7HB23");
		   busdetails.setText("TN-SETC-SEMI-SLEEPER");
           bug.setText(null);
           if(e.getSource()==booking) {
        	   
        	   
        	   background2.setBounds(0, 0, 520,700);
        	   frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       		   frame1.setSize(520,700);
       		   frame1.setVisible(true);
               frame1.setLayout(null);
               frame1.setBackground(Color.RED);
               frame1.add(background2);
               frame1.add(inputbox4);
               frame1.add(inputbox5);
               frame1.add(inputbox9);
               frame1.add(depart);
               frame1.add(arriv);
       	       frame1.add(name);
       	       frame1.add(ages);
       	       frame1.add(combobox);
       	       frame1.add(Gender);
       	       frame1.add(agebox);
       	       frame1.add(pay);
       	       frame1.add(upi);
       	       frame1.add(credit);
       	       frame1.add(debit);
       	       frame1.add(numr);
       	       frame1.add(inputbox8);
       	       frame1.add(makepay);
       	       frame1.add(dat);
       	       frame1.add(jd);
       	   
               booking.add(frame1);
               
               
              
           }
	   }
	   else if (dp.equalsIgnoreCase("cuddalore") && av.equalsIgnoreCase("coimbatore")){
		   frame.add(booking);
		   output.setText("Travel hours :7 hrs 05 minutes");
		   cost.setText("Rate:$420");
		   busnum.setText("Bus Number:3362");
		   busdetails.setText("SETC");
           bug.setText(null);
          
		 
	       if(e.getSource()==booking) {
	    	   frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   		   frame1.setSize(520,700);
	   		   frame1.setVisible(true);
	           frame1.setLayout(null);
	           frame1.setBackground(Color.RED);
	           
	           background2.setBounds(0, 0, 520,700);
	           frame1.add(inputbox4);
	           frame1.add(inputbox5);
	           frame1.add(inputbox9);
	           frame1.add(depart);
	           frame1.add(arriv);
	   	       frame1.add(name);
	   	       frame1.add(ages);
	   	       frame1.add(combobox);
	   	       frame1.add(Gender);
	   	       frame1.add(agebox);
	   	       frame1.add(pay);
	   	       frame1.add(upi);
	   	       frame1.add(credit);
	   	       frame1.add(debit);
	   	       frame1.add(numr);
	   	       frame1.add(inputbox8);
	   	       frame1.add(makepay);
	   	    frame1.add(dat);
	   	       frame1.add(jd);
	   	   
	   	    frame1.add(background2);
	   	      
	           booking.add(frame1);
	           
	           
	       }
	   }
	   else if(dp.equalsIgnoreCase("sivakasi") && av.equalsIgnoreCase("coimbatore")) {
		   frame.add(booking);
		   output.setText("Travel hours :7 hrs 39 minutes");
		   cost.setText("Rate:$650");
		   busnum.setText("Bus Number:TN66AH5592");
		   busdetails.setText("SEMI-SLEEPER");
           bug.setText(null);
          
         if(e.getSource()==booking) {
    	 
    	   frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   		   frame1.setSize(520,700);
   		   frame1.setVisible(true);
           frame1.setLayout(null);
           frame1.setBackground(Color.RED);
           frame1.add(background2);
           background2.setBounds(0, 0, 520,700);
           frame1.add(inputbox4);
           frame1.add(inputbox5);
           frame1.add(inputbox9);
           frame1.add(depart);
           frame1.add(arriv);
   	       frame1.add(name);
   	       frame1.add(ages);
   	       frame1.add(combobox);
   	       frame1.add(Gender);
   	       frame1.add(agebox);
   	       frame1.add(pay);
   	       frame1.add(upi);
   	       frame1.add(credit);
   	       frame1.add(debit);
   	       frame1.add(numr);
   	       frame1.add(inputbox8);
   	       frame1.add(makepay);
   	       frame1.add(dat);
   	       frame1.add(jd);
   	      
           booking.add(frame1);
           
           
          
       }
       else if(dp.equalsIgnoreCase("Madurai") && av.equalsIgnoreCase("chennai")) {
    	   frame.add(booking);
    	   output.setText("Travel hours :9 hrs 30 minutes");
		   cost.setText("Rate:$500");
		   busnum.setText("Bus Number:TN66AH51392");
		   busdetails.setText("SEMI-SLEEPER");
           bug.setText(null);
           
    	   if(e.getSource()==booking) {
    
    	   frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   		   frame1.setSize(520,700);
   		   frame1.setVisible(true);
           frame1.setLayout(null);
           frame1.setBackground(Color.RED);
           frame1.add(background2);
           background2.setBounds(0, 0, 520,700);
           frame1.add(inputbox4);
           frame1.add(inputbox5);
           frame1.add(inputbox9);
           frame1.add(depart);
           frame1.add(arriv);
   	       frame1.add(name);
   	       frame1.add(ages);
   	       frame1.add(combobox);
   	       frame1.add(Gender);
   	       frame1.add(agebox);
   	       frame1.add(pay);
   	       frame1.add(upi);
   	       frame1.add(credit);
   	       frame1.add(debit);
   	       frame1.add(numr);
   	       frame1.add(inputbox8);
   	       frame1.add(makepay);
   	   
   	       frame1.add(dat);
   	       frame1.add(jd);
   	   
           booking.add(frame1);
           
       }
    
       }
	}
   else {
		   
		   nobus.setText("NO BUSSES FOUND");
		   frame.add(backicon);
	   }
	  }
}
