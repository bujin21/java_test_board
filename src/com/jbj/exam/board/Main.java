package com.jbj.exam.board;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

	    System.out.println("== �Խ��� v 0.1 ==");
	    System.out.println("== ���α׷� ���� ==");
	    
	    while (true) {
	        System.out.printf("���) ");
	        String cmd = sc.nextLine();

	        if ( cmd.equals("exit")) {
	          break;
	        }

	        else if( cmd.equals("/usr/article/write")) {
	            System.out.println("- �Խù� ��� -");
	            System.out.printf("���� : ");
	            String title = sc.nextLine();
	            System.out.printf("���� : ");
	            String body = sc.nextLine();
	            int id = 1;
	            System.out.printf("%d�� �Խù��� �ԷµǾ����ϴ�.\n", id);
	          }
	          else {
	            System.out.printf("�Է� �� ��ɾ� : %s\n", cmd);
	          }
	      }

	      System.out.println("== ���α׷� �� ==");

	      sc.close();
	}
}