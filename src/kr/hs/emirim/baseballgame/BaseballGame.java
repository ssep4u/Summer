package kr.hs.emirim.baseballgame;

import java.util.Random;
import java.util.Scanner;

public class BaseballGame {
	static int length = 3;

	public static void main(String[] args) {
		String computer = "";
		String user = "";

		// 랜덤수 3자리 : 컴퓨터
		computer = randomNumber();

		// 반복(정답 맞출때까지)
		while (true) {
			// 사용자 입력 : 사용자
			user = inputNumber();
			// 스트라이크, 볼 확인
			// 확인 결과 출력
			if (isEnd(user, computer)) {
				System.out.println("정답입니다.");
				break;
			}

		}
	}

	private static boolean isEnd(String user, String computer) {
		// strike 판정
		// 반복(0~length전)
		// 각자리 문자 뽑아서 비교하고 같으면, strike++
		int strike = 0;
		int ball = 0;
		for (int i = 0; i < length; i++) {
			if (user.charAt(i) == computer.charAt(i)) {
				strike++;
			}
		}
		// ball 판정
		// 반복(0~length 전)
		// computer와 검색하고 있으면, ball++
		for(int i=0;i<length;i++) {
			for(int j=0;j<length;j++) {
				if(user.charAt(i)==computer.charAt(j) && i!=j) {
					ball++;
				}
			}
		}

		// strike, ball 출력하자
		// (strike == length) return true
		System.out.println(strike+"스트라이크"+ball+"볼");
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
		// System.out.println("정답입니다.");
		// return true;
		//
		// }
		// else
		// System.out.println(strike+"스트라이크"+ball+"볼");

		return false;
	}

	private static String randomNumber() {
		// 반복(문자열 길이가 == length)
		// 랜덤숫자(1~9)
		// 뽑힌숫자를 문자열에서 검색하고 있으면, 다시 랜덤숫자로 반복
		// 없으면, 문자열에 추가
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
		System.out.println("세가지 숫자를 입력하세요");
		return scan.nextLine();
	}

}




