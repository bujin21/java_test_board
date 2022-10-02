package com.jbj.exam.board;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

	    System.out.println("== �Խ��� v 0.1 ==");
	    System.out.println("== ���α׷� ���� ==");
	    
	    int articleLastId = 0;
	    
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
	            
	            int id = articleLastId + 1;
	            articleLastId++;
	            
	            Article article = new Article(id, title, body);
	            
	            System.out.println("������ ���ù� ��ü : " + article);
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

class Article{
	int id;
	String title;
	String body;
	
	public Article(int id, String title, String body) {
		this.id = id;
        this.title = title;
        this.body = body;
	}

	@Override
	  public String toString() {
	    return String.format("{id : %d, title : \"%s\", body : \"%s\"}", id, title, body);
	  }
}