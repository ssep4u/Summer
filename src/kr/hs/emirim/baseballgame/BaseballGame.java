package kr.hs.emirim.baseballgame;

import java.util.Random;
import java.util.Scanner;

public class BaseballGame {
	static int length = 3;

	public static void main(String[] args) {
		String computer = "";
		String user = "";

		// ������ 3�ڸ� : ��ǻ��
		computer = randomNumber();

		// �ݺ�(���� ���⶧����)
		while (true) {
			// ����� �Է� : �����
			user = inputNumber();
			// ��Ʈ����ũ, �� Ȯ��
			// Ȯ�� ��� ���
			if (isEnd(user, computer)) {
				System.out.println("�����Դϴ�.");
				break;
			}

		}
	}

	private static boolean isEnd(String user, String computer) {
		// strike ����
		// �ݺ�(0~length��)
		// ���ڸ� ���� �̾Ƽ� ���ϰ� ������, strike++
		int strike = 0;
		int ball = 0;
		for (int i = 0; i < length; i++) {
			if (user.charAt(i) == computer.charAt(i)) {
				strike++;
			}
		}
		// ball ����
		// �ݺ�(0~length ��)
		// computer�� �˻��ϰ� ������, ball++
		for(int i=0;i<length;i++) {
			for(int j=0;j<length;j++) {
				if(user.charAt(i)==computer.charAt(j) && i!=j) {
					ball++;
				}
			}
		}

		// strike, ball �������
		// (strike == length) return true
		System.out.println(strike+"��Ʈ����ũ"+ball+"��");
		if(strike==length) return true;
	

		// int man= Integer.parseInt(user);
		// int comp = Integer.parseInt(computer);
		// int man2[]=new int[3];
		// int comp2[]=new int[3];
		// man2[0]= man/100;
		// man2[1]= man%100/10;
		// man2[2]=man%10;
		//
		// comp2[0]=comp/100;
		// comp2[1]=comp%100/10;
		// comp2[2]=comp%10;
		// for(int i=0;i<3;i++) {
		// if(man2[i]==comp2[i])
		// strike++;
		// for(int j=0;j<3;j++) {
		// if(man2[i]==comp2[j]&&i!=j)
		// ball++;
		//
		//
		// }
		//
		// }
		// if(strike==3) {
		// System.out.println("�����Դϴ�.");
		// return true;
		//
		// }
		// else
		// System.out.println(strike+"��Ʈ����ũ"+ball+"��");

		return false;
	}

	private static String randomNumber() {
		// �ݺ�(���ڿ� ���̰� == length)
		// ��������(1~9)
		// �������ڸ� ���ڿ����� �˻��ϰ� ������, �ٽ� �������ڷ� �ݺ�
		// ������, ���ڿ��� �߰�
		Random random = new Random();
		int r;
		String resultString="";
		for(int i=0;i<length;i++) {
			while(true) {
				r=random.nextInt(9)+1;
				if(!isDuplicate(r,resultString)) {
					resultString+=r;
					break;
				}
			}
		}
		return resultString;
	}

	private static boolean isDuplicate(int r, String resultString) {
		return resultString.contains(r+"");
	}

	private static String inputNumber() {
		Scanner scan = new Scanner(System.in);
		System.out.println("������ ���ڸ� �Է��ϼ���");
		return scan.nextLine();
	}

}




