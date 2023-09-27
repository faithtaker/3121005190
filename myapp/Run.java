package myapp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static javafx.application.Platform.exit;

public class Run {

	public static void main(String[] args) throws IOException  {
		Scanner scan=new Scanner(System.in);
		String command=null;
		Create create=new Create();
		Checkanswer checkanswer=new Checkanswer();
		String nr="^\\-n\\s+\\d+\\s+\\-r\\s+\\d+$||^\\-r\\s+\\d+\\s+\\-n\\s+\\d+$";
		String ea="^\\-e\\s+\\S+\\s+\\-a\\s+\\S+$";
		int n = 0;
		int r = 0;
		String exercisesfile=null;
		String answersfile=null;
		System.out.println("Сѧ����������Ŀ���ɳ���");
		System.out.println("-r ��Ŀ����ֵ���ò�����������Ϊ1��������Ȼ����");
		System.out.println("-n ��Ŀ��ֵ���ò�����������Ϊ1��������Ȼ����");
		System.out.println("-e ��Ҫ���ĵĴ𰸵��ļ�·��");
		System.out.println("-a ��ȷ�𰸵��ļ�·��"); 
		System.out.println("�밴������ĸ�ʽ��������");
		System.out.println("����-n 10 -r 10 �� -r 10 -n 10 (-r��-n������Ҫһ��ʹ��)"); 
		System.out.println("����-e D:\\\\myanswer.txt -a D:\\\\Answers.txt (-e��-a������Ҫһ��ʹ��)");
		while(scan.hasNextLine()) {
			if (scan.hasNextLine()) {
		        command = scan.nextLine();}    		   
		
		//��������Ƿ���ȷ
		Pattern pa = Pattern.compile(nr);
        Matcher ma = pa.matcher(command);
        Pattern p = Pattern.compile(ea);
        Matcher m = p.matcher(command);
        if(!(ma.matches()||m.matches())) {
        	System.out.println("�����ʽ��������������");
        	continue;
        }
        //��������зָ�
		String[] c=command.split("\\s+");
		if(c[0].equals("-n")&&c[2].equals("-r")) {
			n=Integer.parseInt(c[1]);
			r=Integer.parseInt(c[3]);
			create.cr(n,r);
			System.out.println("��ϰ��ĿExercises.txt�ʹ��ļ�Answers.txt�����ɣ������ڱ�����ĵ�ǰĿ¼��");
		}
		else if(c[0].equals("-r")&&c[2].equals("-n")){
			r=Integer.parseInt(c[1]);
			n=Integer.parseInt(c[3]);
			create.cr(n,r);
			System.out.println("��ϰ��ĿExercises.txt�ʹ��ļ�Answers.txt�����ɣ������ڱ�����ĵ�ǰĿ¼��");
		}
	    if(c[0].equals("-e")&&c[2].equals("-a")) {
			exercisesfile=c[1];
			answersfile=c[3];
			try {
			checkanswer.check(exercisesfile,answersfile);}
			catch(FileNotFoundException e) {
				System.out.println("�Ҳ���ָ���ļ�,������������ȷ���ļ�·��");
				continue;
			}
			System.out.println("�����ļ�Grade.txt�����ɣ������ڱ�����ĵ�ǰĿ¼��");
		}
		//����
		n=0;
		r=0;
		}	
		
	}
}
