	import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

import javax.tools.Tool;
	public class MysqlConnector1 {
	public static void main(String[] args) throws SQLException, ParseException {
		System.out.println("MySQL Connect Example");
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "e19155_e19098";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root"; 
		String password = "";

		try{
			Class.forName(driver).getDeclaredConstructor().newInstance();
			conn = DriverManager.getConnection(url+dbName,userName,password);
			System.out.println("Connected to database");
		}catch(Exception e) {
			e.printStackTrace();
		} 
		
		int NEXT = -1;
		while (NEXT!=0) {
		System.out.println("\n\n\n------------------------MENU--------------------------");
		System.out.println("If you want to insert data press:  1");
		System.out.println("If you want to show subjects press:  2");
		System.out.println("If you want to show professors press:  3");
		System.out.println("If you want to show supervisor and professors press:  4");
		System.out.println("If you want to show optional subjects with no signed students press:  5");
		System.out.println("If you want to upgrade succeed grade press:  6");
		System.out.println("If you want to show and delete old students press:  7");
		System.out.println("If you want to exit press:  0");
		System.out.println("-------------------------------------------------------");
		Scanner myObj = new Scanner(System.in);
		NEXT = myObj.nextInt();
		
		switch(NEXT)
		{	
		case 1: 
		
			System.out.println("\n\n\n--------------------INSERT MENU-----------------------------");
			System.out.println("If you want to insert campus_club values press: a");
			System.out.println("If you want to insert sxolh press: b");
			System.out.println("If you want to insert tmima press:  c");
			System.out.println("If you want to insert programma spoudwn press: d");
			System.out.println("If you want to insert epopti press:  e");
			System.out.println("If you want to insert didaskon press: f");
			System.out.println("If you want to insert student press:  g");
			System.out.println("If you want to insert subject press:  h");
			System.out.println("If you want to insert epitropi press:  i");
			System.out.println("If you want to exit press:  z");
			System.out.println("-------------------------------------------------------");
			 
			String in="";
			Scanner myObj9 = new Scanner(System.in);
			in = myObj9.nextLine();
			
			switch(in) {	
		
		
		case "a":
		try{
			
			Scanner myObj13 = new Scanner(System.in);
			System.out.println("\nINSERT CAMPUS NAME:" );
			String onoma_campus= myObj13.nextLine();
		
			 Scanner myObj12= new Scanner(System.in);
			System.out.println("\nINSERT ADDRESS OF CAMPUS:" );
			String address_campus = myObj12.nextLine();
				
				
			Scanner myObj11 = new Scanner(System.in);
			System.out.println("\nINSERT DISTANCE OF CAMPUS:");
		    int  distance= myObj11.nextInt();
		    
		    Scanner myObj4 = new Scanner(System.in);
			System.out.println("\nINSERT CAMPUS BUS:");
			int bus = myObj4.nextInt();
			
			Scanner myObj15 = new Scanner(System.in);
			System.out.println("\nINSERT CLUB NAME:");
			String name_club = myObj15.nextLine();
			
			Scanner myObj6= new Scanner(System.in);
			System.out.println("\nINSERT CLUB BUILDING:");
		    String building = myObj6.nextLine();
		    
		    Scanner myObj7 = new Scanner(System.in);
			System.out.println("\nINSERT PHONE OF CLUB:");
			int phone = myObj7.nextInt();
			
			Scanner myObj8 = new Scanner(System.in);
			System.out.println("\nINSERT CLUB'S AMOUNT OF SPORTS:");
			int sports = myObj8.nextInt();
			
			
			Statement st = conn.createStatement();
			int val = st.executeUpdate("INSERT INTO campus_club VALUES('"+onoma_campus+"','"+address_campus+"',"+distance+","+bus+",'"+name_club+"','"+building+"',"+phone+","+sports+")");
			
			}catch(SQLException s){
			System.out.println("");
		} 
	  		
	    try{
	    	
			Statement st = conn.createStatement();
			
			ResultSet res = st.executeQuery("SELECT * FROM campus_club");
			System.out.println("\n\nCAMPUS NAME: " + "\t" + "ADDRESS OF CAMPUS: "+ "\t" + "DISTANCE OF CAMPUS: " + "\t" + " CAMPUS BUS: " + "\t" + "NAME OF CLUB: " + "\t" + "BUILDING OF CLUB: " + "\t" + "PHONE CLUB:  "+ "\t" + "AMOUNT OF SPORTS: " + "\t");
			while (res.next()) {
				String a = res.getString("name_campus");
				String s = res.getString("address_campus");
				String b = res.getString("distance_campus");
				String c = res.getString("bus_number");
				String d = res.getString("onoma_club");
				String e = res.getString("ktirio_club");
				String f = res.getString("phone_club");
				String h = res.getString("plithos_sport");
				
				System.out.println(a + "\t\t" + s+ "\t\t" + b+ "\t\t" + c+ "\t\t" + d+ "\t\t" + e+ "\t\t" + f+ "\t\t" + h+ "\t\t" );
			}
			}catch(SQLException s){
				System.out.println("");
			} 
	    
	    System.out.println("\n\n INSERT DATA IN SPORTS TABLE: ");
	    try{
			
			Statement st = conn.createStatement();
			
			Scanner myObj74= new Scanner(System.in);
			System.out.println("\nINSERT SPORT NAME:" );
			String sport_name = myObj74.nextLine();
			
			Scanner myObj75= new Scanner(System.in);
			System.out.println("\nINSERT CAMPUS NAME:" );
			String campus_name = myObj75.nextLine();
			
		   
		     int val = st.executeUpdate("INSERT INTO sports VALUES('"+sport_name+"','"+campus_name+"')");	
			}catch(SQLException s){
			System.out.println("");
		}

	    try{		
	    	Statement st = conn.createStatement();	
	    	ResultSet res = st.executeQuery("SELECT * FROM sports");
	    	System.out.println("ONOMA ATHLIMATOS: " +"\t" + "ONOMA CAMPUS: " );
	    	while (res.next()) {
	    		String l = res.getString("name_sport");
	    		String m = res.getString("campus_club_name_campus");
	    		
	    		
		
	    		System.out.println(l + "\t\t\t" +  m+ "\t\t" );
	    	}
	    	}catch(SQLException s){
	    		System.out.println(" ");
	    	} 
	    break;

			
		
		case "b":
			try {
			
				Scanner myObj17 = new Scanner(System.in);
				System.out.println("\nINSERT SXOLH NAME:" );
				String name_sxolhs= myObj17.nextLine();
			
				 Scanner myObj18= new Scanner(System.in);
				System.out.println("\nINSERT NAME OF KOSMHTORA:" );
				String kosmhtoras = myObj18.nextLine();
					
					
				Scanner myObj19 = new Scanner(System.in);
				System.out.println("\nINSERT BUILDING OF SXOLH:");
			    String  building_sxolh= myObj19.nextLine();
			    
			    Scanner myObj20 = new Scanner(System.in);
				System.out.println("\nINSERT CAMPUS NAME:");
			    String  onoma_campus= myObj20.nextLine();
			   
			    Statement st = conn.createStatement();
				
			  // ResultSet res = st.executeQuery("SELECT * FROM campus_club");
			  // String v = res.getString("name_campus");
			    

				int val = st.executeUpdate("INSERT INTO sxolh VALUES('"+name_sxolhs+"','"+kosmhtoras+"','"+building_sxolh+"','"+onoma_campus+"')");
				
						
				}catch(SQLException s){
				System.out.println("");
			}
    
	        try{		
	        	Statement st = conn.createStatement();	
	        	ResultSet res = st.executeQuery("SELECT * FROM sxolh");
	        	System.out.println("\nSXOLH NAME: " + "\t" + "KOSMHTORAS: "+ "\t" + "KTIRIO SXOLHS: " + "\t" + " CAMPUS NAME : " + "\t" );
	        	while (res.next()) {
	        		String l = res.getString("name_sxolhs");
	        		String s = res.getString("kosmhtoras");
	        		String b = res.getString("ktirio_sxolhs");
	        		String a = res.getString("campus_club_name_campus");
			
	        		System.out.println(l + "\t\t" + s+ "\t\t" + b+ "\t\t" + a+ "\t\t" );
	        	}
	        	}catch(SQLException s){
	        		System.out.println("");
	        	} 
		
	        break;
	        
		case "e":
	        try{
	        	
	        	Statement st = conn.createStatement();
	        	Scanner myObj21 = new Scanner(System.in);
				System.out.println("\nINSERT EPOPTHS NAME:" );
				String name_epopti= myObj21.nextLine();
			

			  // ResultSet res = st.executeQuery("SELECT * FROM campus_club");
			  // String v = res.getString("name_campus");
			    

				int val = st.executeUpdate("INSERT INTO epoptis VALUES('"+name_epopti+"')");
	        	
	
	        }catch(SQLException s){
	        	System.out.println("");
	        } 
	
	        try{
	        	Statement st = conn.createStatement();	
	        	ResultSet res = st.executeQuery("SELECT * FROM epoptis");
	        	System.out.println("\n\nEPOPTIS NAME: " + "\t" );
	        	while (res.next()) {
	        		String f = res.getString("name_epoptis");
			
			
	        		System.out.println(f + "\t\t" );
	        	}
	        }catch(SQLException s){
	        	System.out.println("");
	        } 
	       break;
	
	      
		
		case "c":
	        try{
		
	        	Statement st = conn.createStatement();
	        	Scanner myObj23 = new Scanner(System.in);
				System.out.println("\nINSERT TMHMA NAME:" );
				String onoma_tmima= myObj23.nextLine();
			
				 Scanner myObj24= new Scanner(System.in);
				System.out.println("\nINSERT BUILDING OF TMHMA:" );
				String building_tmima = myObj24.nextLine();
					
					
				Scanner myObj25 = new Scanner(System.in);
				System.out.println("\nINSERT SXOLHS NAME:");
			    String  onoma_sxolh = myObj25.nextLine();
			    
			 
				int val = st.executeUpdate("INSERT INTO tmima VALUES('"+onoma_tmima+"','"+building_tmima+"','"+onoma_sxolh+"')");
				
		
			
	
	        }catch(SQLException s){
	        	System.out.println("");
	        }

	        try{		
	        	Statement st = conn.createStatement();	
	        	ResultSet res = st.executeQuery("SELECT * FROM tmima");
	        	System.out.println("\n\nTMHMA NAME: " + "\t" + "KTIRIO TMHMATOS: "+ "\t" + "ONOMA SXOLHS: " + "\t"  );
	        	while (res.next()) {
	        		String l = res.getString("name_tmima");
	        		String s = res.getString("ktirio_tmima");
	        		String b = res.getString("sxolh_name_sxolhs");
    		
	
	        		System.out.println(l + "\t\t" + s+ "\t\t" + b+ "\t\t" );
	        	}
	        }catch(SQLException s){
	        	System.out.println("");
	        } 
	        break;
   

		case "f":

	        try{
		
	        	Statement st = conn.createStatement();
	        	
	        	Scanner myObj26 = new Scanner(System.in);
				System.out.println("\nINSERT CODE DIDASKON:" );
				String didaskon_code= myObj26.nextLine();
			
				 Scanner myObj27= new Scanner(System.in);
				System.out.println("\nINSERT ONOMATEPONYMO DIDASKONTA:" );
				String on_ep_didask = myObj27.nextLine();
					
					
				Scanner myObj28 = new Scanner(System.in);
				System.out.println("\nINSERT TITLOS DIDASKONTA:");
			    String  didask_title = myObj28.nextLine();
			    
			    Scanner myObj29= new Scanner(System.in);
				System.out.println("\nINSERT GRAFEIO DIDASKONTA:" );
				String grafeio = myObj29.nextLine();
					
					
				Scanner myObj30 = new Scanner(System.in);
				System.out.println("\nINSERT ONOMA TMIMATOS:");
			    String  name_tmima = myObj30.nextLine();
			    
			    Scanner myObj31 = new Scanner(System.in);
				System.out.println("\nINSERT ONOMA EPOPTI:");
			    String  name_epopti = myObj31.nextLine();
			 
			    
				int val = st.executeUpdate("INSERT INTO didaskon VALUES('"+didaskon_code+"','"+on_ep_didask+"','"+didask_title+"','"+grafeio+"','"+name_tmima+"','"+name_epopti+"')");
				
		

	        }catch(SQLException s){
	        	System.out.println("");
	        }

	        try{		
	        	Statement st = conn.createStatement();	
	        	ResultSet res = st.executeQuery("SELECT * FROM didaskon");
	        	System.out.println("\n\nCODE DIDASKONTA: " +"\t" + "ONOMATEPONUMO DIDASKONTA:" + "\t" + "TITLOS DIDASKONTA: " + "\t"+"GRAFEIO DIDASKONTA: " + "\t"+"ONOMA TMHMATOS: " + "\t"  +"ONOMA EPOPTH: " + "\t");
	        	while (res.next()) {
	        		String l = res.getString("code_didask");
	        		String s = res.getString("on_epon_didask");
	        		String b = res.getString("title_didask");
	        		String c= res.getString("grafeio_didask");
	        		String f = res.getString("tmima_name_tmima");
	        		String g = res.getString("epoptis_name_epoptis");
    		
	
	        		System.out.println(l + "\t\t\t\t" + s+ "\t\t" + b+ "\t\t" + c+ "\t\t" + f+ "\t\t"  + g+ "\t");
	        	}
	        }catch(SQLException s){
	        	System.out.println("");
	  
	        } 
	        break;
   
		case "i":
	        try{ 
	        	Statement st = conn.createStatement();
	        	
	        	Scanner myObj32 = new Scanner(System.in);
				System.out.println("\nINSERT NAME EPITROPHS:" );
				String name_epopti= myObj32.nextLine();
			
				 Scanner myObj33= new Scanner(System.in);
				System.out.println("\nINSERT SYNXOTHTA SUNEDRIWN:" );
				String syxnothta = myObj33.nextLine();
					
					
				Scanner myObj34 = new Scanner(System.in);
				System.out.println("\nINSERT SXOLH NAME:");
			    String sxolh_name = myObj34.nextLine();
			    
			    
			    int val = st.executeUpdate("INSERT INTO epitropi VALUES('"+name_epopti+"','"+syxnothta+"','"+sxolh_name+"')");
		
	
	        }catch(SQLException s){
	        	System.out.println("");
	        }
	        
		
	        try{		
    	Statement st = conn.createStatement();	
    	ResultSet res = st.executeQuery("SELECT * FROM epitropi");
    	System.out.println("ONOMA EPITROPHS: " +"\t" + "SYXNOTHTA SUNEDRIASEWN:" + "\t" + "ONOMA SXOLHS: " );
    	while (res.next()) {
    		String l = res.getString("name_epitropis");
    		String s = res.getString("syxnothta_synedriwn");
    		String b = res.getString("sxolh_name_sxolhs");
    		
    		
	
    		System.out.println(l + "\t\t\t\t" + s+ "\t\t" + b+ "\t\t" );
    	}
    	}catch(SQLException s){
    		System.out.println("");
    	} 
	        System.out.println("\n\n INSERT DATA IN TABLE EPITROPH-DIDASKON ");
	        try {
	        	
	        Statement st = conn.createStatement();
			
        	Scanner myObj55= new Scanner(System.in);
			System.out.println("\nINSERT NAME EPITROPHS:" );
			String name_epitropi= myObj55.nextLine();
		
			Scanner myObj56= new Scanner(System.in);
			System.out.println("\nINSERT CODE DIDASKONTA:" );
			String code_didask = myObj56.nextLine();
		 
		    
			int val = st.executeUpdate("INSERT INTO epitropi_didaskon VALUES('"+name_epitropi+"','"+code_didask+"')");
			

	       }catch(SQLException s){
	        System.out.println("");
           }



try{		
	Statement st = conn.createStatement();	
	ResultSet res = st.executeQuery("SELECT * FROM epitropi_didaskon");
	System.out.println("ONOMA EPITROPHS: " +"\t" + "CODE DIDASKONTA:" + "\t " );
	while (res.next()) {
		String l = res.getString("epitropi_name_epitropis");
		String s = res.getString("didaskon_code_didask");
		
		
		

		System.out.println(l + "\t\t" + s+ "\t\t" );
	}
	}catch(SQLException s){
		System.out.println("");
	} 
	       break;
	       
	   
	       
		case "d":
	try{	
		
		Statement st = conn.createStatement();

    	Scanner myObj35 = new Scanner(System.in);
		System.out.println("\nINSERT CODE PROGRAMMATOS:" );
		String code_program= myObj35.nextLine();
	
		 Scanner myObj36= new Scanner(System.in);
		System.out.println("\nINSERT TITLO PROGRAMMATOS:" );
		String titlo_program = myObj36.nextLine();
			
		Scanner myObj37 = new Scanner(System.in);
		System.out.println("\nINSERT BATHIMADA PROGRAMMATOS:");
	    String  bath_program = myObj37.nextLine();
	    
	    Scanner myObj38= new Scanner(System.in);
		System.out.println("\nINSERT DIARKEIA PROGRAMMATOS:" );
		String diarkeia_program = myObj38.nextLine();
			
		Scanner myObj39 = new Scanner(System.in);
		System.out.println("\nINSERT NAME TMHMA:");
	    String  name_tmima = myObj39.nextLine();
	     
		int val = st.executeUpdate("INSERT INTO program_tmima VALUES('"+code_program+"','"+titlo_program+"','"+bath_program+"','"+diarkeia_program+"','"+name_tmima+"')");
		
		}catch(SQLException s){
		System.out.println("");
	}
	
	System.out.println("\n\n INSERT DATA IN TABLE PROGRAM_TMIMA ");

    try{		
    	Statement st = conn.createStatement();	
    	ResultSet res = st.executeQuery("SELECT * FROM program_tmima");
    	System.out.println("CODE PROGRAMMATOS: " +"\t" + "TITLOS PROGRAMMATOS:" + "\t" + "BATHMIDA: " + "\t" + "DIARKEIA SPOUDWN: "+"\t" + "ONOMA TMIMATOS: "  );
    	while (res.next()) {
    		String l = res.getString("code_program");
    		String s = res.getString("title_program");
    		String b = res.getString("bathmida_program");
    		String a = res.getString("diarkeia_program");
    		String g = res.getString("tmima_name_tmima");
    		
    		
	
    		System.out.println(l + "\t\t\t" + s+ "\t\t" + b+ "\t\t"+ a+ "\t\t"+ g+ "\t\t" );
    	}
    	}catch(SQLException s){
    		System.out.println("");
    	} 
    break;
    
		case "g":
			
try{ 
		
		Statement st = conn.createStatement();
		
		Scanner myObj40 = new Scanner(System.in);
		System.out.println("\nINSERT ARITHMO MITROOY STUDENT:" );
		String a_m_student= myObj40.nextLine();
	
		 Scanner myObj41= new Scanner(System.in);
		System.out.println("\nINSERT ONOMATEPONYMO STUDENT:" );
		String name_student = myObj41.nextLine();
			
			
		Scanner myObj42 = new Scanner(System.in);
		System.out.println("\nINSERT PATRWNYMO STUDENT:");
	    String  pat_student = myObj42.nextLine();
	    
			
	    System.out.println("INSERT HMEROMHNIA GENNHSHS STUDENT");
	    Scanner scanner = new Scanner(System.in);
	    String date = scanner.nextLine();
	    Date date1=new SimpleDateFormat("yyyy-mm-dd").parse(date);  
	    
		Scanner myObj44 = new Scanner(System.in);
		System.out.println("\nINSERT ETOS EGGRAFHS STUDENT:");
	    int etos_eggrafhs = myObj44.nextInt();
	    
	    Scanner myObj45 = new Scanner(System.in);
		System.out.println("\nINSERT CODE PROGRAMMATOS STUDENT:");
	    String  code_program = myObj45.nextLine();
	    
	    int val = st.executeUpdate("INSERT INTO student VALUES('"+a_m_student+"','"+name_student+"','"+pat_student+"','"+date+"',"+etos_eggrafhs+",'"+code_program+"')");
		
		
		System.out.println("");
	
		}catch(SQLException s){
		System.out.println("");
	}

    try{		
    	Statement st = conn.createStatement();	
    	ResultSet res = st.executeQuery("SELECT * FROM student");
    	System.out.println("ARITHMOS MITROOY : " +"\t" + "ONOMATEPONYMO FOITHTH: " + "\t" + "PATRWNUMO FOITHTH: " + "\t" + "HMEROMHNIA GENNHSHS: "+"\t" + "ETOS EGGRAFHS: "+ "\t" +"CODE PROGRAMMATOS" );
    	while (res.next()) {
    		String l = res.getString("a_m_student");
    		String s = res.getString("on_epon_student");
    		String b = res.getString("patrwnumo_student");
    		String a = res.getString("birth_student");
    		String g = res.getString("etos_eggrafhs");
    		String k = res.getString("program_tmima_code_program");
    		
    		
	
    		System.out.println(l + "\t\t\t" + s+ "\t" + b+ "\t\t"+ a+ "\t\t"+ g+ "\t\t"+ k+ "\t\t" );
    	}
    	}catch(SQLException s){
    		System.out.println("SQL code does not execute.");
    	} break;
    
		case "h":
			
	try{
 
		
		Statement st = conn.createStatement();
		
		Scanner myObj50 = new Scanner(System.in);
		System.out.println("\nINSERT CODE SUBJECT:" );
		String code_sub= myObj50.nextLine();
	
		 Scanner myObj51= new Scanner(System.in);
		System.out.println("\nINSERT NAME SUBJECT:" );
		String name_sub = myObj51.nextLine();
			
			
		Scanner myObj52 = new Scanner(System.in);
		System.out.println("\nINSERT CODE PROGRAMMATOS:");
	    String  code_prog = myObj52.nextLine();
	    
	
	    
	    int val = st.executeUpdate("INSERT INTO subject VALUES('"+code_sub+"','"+name_sub+"','"+code_prog+"')");
		
	
		}catch(SQLException s){
		System.out.println("SQL statement is not executed!");
	}

    try{		
    	Statement st = conn.createStatement();	
    	ResultSet res = st.executeQuery("SELECT * FROM subject");
    	System.out.println("CODE SUBJECT: " +"\t" + "NAME SUBJECT: " + "\t" + "\t" +"CODE PROGRAMMATOS" );
    	while (res.next()) {
    		String l = res.getString("code_subject");
    		String s = res.getString("name_subject");
    		String k = res.getString("program_tmima_code_program");
    		
    		
	
    		System.out.println(l + "\t\t" + s+ "\t\t\t" + k+ "\t\t" );
    	}
    	}catch(SQLException s){
    		System.out.println("");
    	}
    
    System.out.println("\n\n INSERT DATA IN TABLE PROAPAITOYMENOY MATHIMATOS ");
    
    try{
		
		Statement st = conn.createStatement();
		
		Scanner myObj60 = new Scanner(System.in);
		System.out.println("\nINSERT CODE PROAPAITOUMENOU SUBJECT:" );
		String code_proapait= myObj60.nextLine();
	
		 Scanner myObj61= new Scanner(System.in);
		System.out.println("\nINSERT NAME PROAPAITOUMENOU SUBJECT:" );
		String name_proapait = myObj61.nextLine();
			
			
		Scanner myObj62 = new Scanner(System.in);
		System.out.println("\nINSERT CODE SUBJECT:");
	    String  subject_code= myObj62.nextLine();
	    
	
	    
	    int val = st.executeUpdate("INSERT INTO proapait_subject VALUES('"+code_proapait+"','"+name_proapait+"','"+subject_code+"')");
	
		}catch(SQLException s){
		System.out.println("");
	}

    try{		
    	Statement st = conn.createStatement();	
    	ResultSet res = st.executeQuery("SELECT * FROM proapait_subject");
    	System.out.println("CODE PROAPAITOYMENOY SUBJECT: " +"\t" + "NAME PROAPAITOYMENOY SUBJECT: " + "\t" + "\t" +"CODE SUBJECT" );
    	while (res.next()) {
    		String l = res.getString("proapait_code");
    		String s = res.getString("name_proapait");
    		String k = res.getString("subject_code_subject");
    		
    		
	
    		System.out.println(l + "\t\t\t\t" + s+ "\t\t\t\t" + k+ "\t\t" );
    	}
    	}catch(SQLException s){
    		System.out.println("");
    	} 
    System.out.println("\n\n INSERT DATA IN TABLE SUBJECT_STUDENT ");
try{
		
		Statement st = conn.createStatement();
		
		Scanner myObj65 = new Scanner(System.in);
		System.out.println("\nINSERT GRADE:" );
		int grade= myObj65.nextInt();
		
		Scanner myObj66= new Scanner(System.in);
		System.out.println("\nINSERT ETOS DHLWSHS MATHIMATOS:" );
		int year = myObj66.nextInt();
		
	    Scanner myObj68= new Scanner(System.in);
		System.out.println("\nINSERT EIDOS SUBJECT (YPOXREWTIKO/EPILOGHS) :" );
		String kind = myObj68.nextLine();
	    
	    Scanner myObj69 = new Scanner(System.in);
		System.out.println("\nINSERT SUBJECT CODE:");
	    String  code_subject = myObj69.nextLine();
	    
	    Scanner myObj70 = new Scanner(System.in);
		System.out.println("\nINSERT ARITHMO MHTRWOU FOITHTH:");
	    String  am_student = myObj70.nextLine();
	    
	    
	    String apotelesma;
	    if (grade>=5) 
	    	apotelesma = "passed"; 	
	    else
	    	apotelesma="failed";
	    
	    int val = st.executeUpdate("INSERT INTO subject_student VALUES("+grade+","+year+",'"+kind+"','"+code_subject+"','"+am_student+"','"+apotelesma+"')");
		
	
		}catch(SQLException s){
		System.out.println("");
	}

    try{		
    	Statement st = conn.createStatement();	
    	ResultSet res = st.executeQuery("SELECT * FROM subject_student");
    	System.out.println("\nBATHMOLOGIA SUBJECT: " +"\t" +"APOTELESMA: " + "\t" + "ETOS DILOSHS SUBJECT: " + "\t" + "\t" +"EIDOS SUBJECT:" + "\t"+ "CODE SUBJECT: " + "\t" +"ARITHMOS MITROOY STUDENT:" );
    	while (res.next()) {
    		String l = res.getString("bathmologia");
    		String n = res.getString("apotelesma");
    		String s = res.getString("etos_dilosis");
    		String k = res.getString("eidos_subject");
    		String m = res.getString("subject_code_subject");
    		String a = res.getString("student_a_m_student");
    		
    		
	
    		System.out.println(l + "\t\t\t\t" + n + "\t\t\t\t" + s + "\t\t\t" + k+ "\t\t"+ m+ "\t\t"+ a+ "\t\t" );
    	}
    	}catch(SQLException s){
    		System.out.println("");
    	} 
    
    System.out.println("\n\n INSERT DATA IN TABLE DIDASKON_SUBJECT ");
try{
		
		Statement st = conn.createStatement();
	
		
		Scanner myObj71 = new Scanner(System.in);
		System.out.println("\nINSERT DIDASKON CODE:" );
		String didaskon_code= myObj71.nextLine();
		
		Scanner myObj72= new Scanner(System.in);
		System.out.println("\nINSERT SUBJECT CODE:" );
		String subject_code = myObj72.nextLine();
		
	   
	     int val = st.executeUpdate("INSERT INTO didaskon_subject VALUES('"+didaskon_code+"','"+subject_code+"')");
	
		}catch(SQLException s){
		System.out.println("");
	}

    try{		
    	Statement st = conn.createStatement();	
    	ResultSet res = st.executeQuery("SELECT * FROM didaskon_subject");
    	System.out.println("CODE DIDASKONTA: " +"\t" + "CODE SUBJECT: " );
    	while (res.next()) {
    		String l = res.getString("didaskon_code_didask");
    		String m = res.getString("subject_code_subject");
    		
    		
	
    		System.out.println(l + "\t\t\t" +  m+ "\t\t" );
    	}
    	}catch(SQLException s){
    		System.out.println("");
    	} 
    
    	
    break;
    	
		case "z":
			System.out.println("-----------EXITED FROM INSERT MENU--------------" );
			break;
			
		}  	
		
    	break;
    	
		case 2:
			try {
		   
		    Statement st = conn.createStatement();
		    
		    ResultSet rs = st.executeQuery("SELECT name_subject,name_proapait FROM subject,proapait_subject WHERE code_subject=subject_code_subject ORDER BY program_tmima_code_program");
		   
		    System.out.println( "\nNAME SUBJECT: " + "\t\t\t"+ "NAME PROAPAITOYMENOY SUBJECT:" + "\t");
		    while (rs.next()) {
	    		String l = rs.getString("name_subject");
	    		String m = rs.getString("name_proapait");
		
	    		System.out.println(l + "\t\t\t" +  m+ "\t\t" );
	    		 rs.close();
		    }     
	    	}catch(SQLException s){
	    		System.out.println("");
	    	} 
			
		    break;
		    
		case 3:
			try{
				
				Statement stmt = conn.createStatement();
				
				 
			    ResultSet rs = stmt.executeQuery("SELECT DISTINCT on_epon_didask, name_tmima,sxolh_name_sxolhs FROM didaskon, tmima WHERE name_tmima = tmima_name_tmima ORDER BY tmima_name_tmima");
			    
			    System.out.println( "\nNAME DIASKONTA: " + "\t"+ "NAME TMIMATOS:"+ "\t"+ "NAME SXOLHS:");
				while (rs.next()) {
					
					String s = rs.getString("on_epon_didask");
					String b = rs.getString("name_tmima");            
					String p = rs.getString("sxolh_name_sxolhs");  
					

					System.out.println(s + "\t\t" + b + "\t\t" + p + "\t\t"  );
				}
				
				}catch(SQLException s){
					System.out.println("");
				} 

				break;

				
		case 4:
			try{
				
				Statement stmt = conn.createStatement();
				
				System.out.println("\n Sorted by name Didaskonta:");
			    ResultSet rs = stmt.executeQuery("SELECT on_epon_didask, name_epoptis FROM didaskon, epoptis WHERE name_epoptis = epoptis_name_epoptis order by on_epon_didask");
			    
			    System.out.println( "\nNAME DIASKONTA: " + "\t\t" + "NAME EPOPTH:" + "\t\t");
				while (rs.next()) {
					
					String s = rs.getString("on_epon_didask");
					String b = rs.getString("name_epoptis");             
					
					

					System.out.println(s + "\t\t" + b + "\t\t"  );
				}
				
				System.out.println("\n Sorted by name Epopti:");
				ResultSet rst = stmt.executeQuery("SELECT on_epon_didask, name_epoptis FROM didaskon, epoptis WHERE name_epoptis = epoptis_name_epoptis order by name_epoptis");
			   
			    System.out.println( "\n NAME EPOPTH:" + "\t\t" + "NAME DIASKONTA:" + "\t\t");
				while (rst.next()) {
					
					String b = rst.getString("name_epoptis"); 
					String s = rst.getString("on_epon_didask");
					            
					
					

					System.out.println(b + "\t\t" + s + "\t\t"  );
				}
				
				}
			catch(SQLException s){
					System.out.println("");
				}
			
			break;
			
		case 5:
try{
				
				Statement stmt = conn.createStatement();
				
				
				Scanner myObj80 =new Scanner(System.in);
				System.out.println("\nINSERT PROGRAMMA SPOYDWN:" );
				String prog= myObj80.nextLine();
				
				Scanner myObj81= new Scanner(System.in);
				System.out.println("\nINSERT ETOS DHLWSHS:" );
				String et = myObj81.nextLine();
				
				
				System.out.println("\n Mathimata epiloghs apo to programma "+prog+" me kamia eggrafi to etos "+et+" :");
				String eidos= "EPILOGHS";
				
			    ResultSet rs = stmt.executeQuery("SELECT DISTINCT * FROM subject,program_tmima,subject_student WHERE title_program=prog "
			    		+ "and program_tmima_code_program=code_program and etos_dilosis!=et and eidos_subject=eidos and subject_code_subject=code_subject");
			    
			    System.out.println( "\nONOMA MATHIMATOS:" + "\t\t");
				while (rs.next()) {
					
					String s = rs.getString("name_subject");
					            
					// name_subject, title_program, eidos_subject, code_program
			
					System.out.println(s + "\t\t"  );
				}
				
			
				}
			catch(SQLException s){
					System.out.println("");
				}
			
		break;
		
		case 6:
			try{
				
				Statement stmt = conn.createStatement();
				
				
				System.out.println("\n FOITHTES KAI TA MATHIMATA POY PARAKOLOYTHOYN:");
			    ResultSet rs = stmt.executeQuery("SELECT DISTINCT name_subject,on_epon_student,a_m_student,bathmologia,code_subject FROM subject,student,subject_student WHERE code_subject=subject_code_subject and student_a_m_student = a_m_student ");
			    
			    System.out.println( "\nNAME STUDENT: "  + "\t\t"+ "ARITHMOS MHTRWOU:" + "\t\t" + "NAME SUBJECT:" + "\t\t"+ "KWDIKOS SUBJECT:" + "\t\t");
				while (rs.next()) {
					
					String s = rs.getString("on_epon_student");
					String b = rs.getString("name_subject");             
					String v = rs.getString("a_m_student");   
					String t = rs.getString("code_subject"); 
					
					

					System.out.println(s + "\t\t" + v + "\t\t\t\t" + b + "\t\t\t\t" + t + "\t\t" );
				}
				
				    Scanner myObj1 = new Scanner(System.in);
					System.out.println("\nEISAGETE FOITHTH:" );
					String student = myObj1.nextLine();
					
					 Scanner myObj4= new Scanner(System.in);
					System.out.println("\nEISAGETE ARITHMO MHTRWOY FOITHTH:" );
					String am = myObj4.nextLine();
						
						
					Scanner myObj2 = new Scanner(System.in);
					System.out.println("\nEISAGETE MATHIMA:");
				    String subject = myObj2.nextLine();
				    
				    Scanner myObj5 = new Scanner(System.in);
					System.out.println("\nEISAGETE KWDIKO MATHIMATOS:");
					String code = myObj5.nextLine();
					
					Scanner myObj3 = new Scanner(System.in);
					System.out.println("\nEISAGETE NEO VATHMO MEGALYTERO/ISO TOY 5:");
					
					int grade ;
					do{
						grade = myObj3.nextInt();
						if(grade<5) {
						System.out.println("\nEISAGETE NEO VATHMO MEGALYTERO/ISO TOY 5 ! ");
						}
					}while(grade<5);
				   String ap="passed";
				   String f="failed";
				
					Statement st = conn.createStatement();
					
					String query1 = "update subject_student set bathmologia=? where student_a_m_student = ? and subject_code_subject= ?";
				    PreparedStatement preparedst = conn.prepareStatement(query1);
				    
				    preparedst.setInt (1, grade);
				    preparedst.setString (2, am);
				    preparedst.setString (3, code);
				    
				    preparedst.executeUpdate();
				    
				    String query2 = "update subject_student set apotelesma=? where student_a_m_student = ? and subject_code_subject= ? and apotelesma=?";
				    PreparedStatement preparedstm = conn.prepareStatement(query2);
				    
				    preparedstm.setString (1, ap);
				    preparedstm.setString (2, am);
				    preparedstm.setString (3, code);
				    preparedstm.setString (4, f);
				    
			        preparedstm.executeUpdate();
			        
					
			        System.out.println( "\nNAME STUDENT: " +student);
					System.out.println("NAME SUBJECT:" +subject);
					System.out.println("UPDATED GRADE:" +grade);
					System.out.println("UPDATED EXAM'S RESULT:" +ap);
					
				}
				catch(SQLException s){
						System.out.println("");
					}
				
				break;
				
		case 7:
			
			
			System.out.println("\n\n ---------------------------------- CURRENTLY NOT AVAILABLE :( -------------------------");
			
			
			
			
			
			break;
				
				
		case 0:
			System.out.println("---------------EXITED FROM MENU-------------------" );
			break; 
			
		
			
		}
		}
	}
}
	
	
	


		
	
	
	
	
