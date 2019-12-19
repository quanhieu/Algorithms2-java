package gcs16216;

import java.util.Scanner;

public class MainString {

	public static void main(String[] args) {
		int select;
		do {
			System.out.println("\n=========String demo Words Without Using Function java=========");
			System.out.println("1. Concatenation");
			System.out.println("2. Find characters");
			System.out.println("3. Length");
			System.out.println("4. Lowercase");
			System.out.println("5. subString"); // He[llo w]orld ->[i, 5]->từ vị trì thứ i lấy 5 kí tự -> xuat [llo w]
			System.out.println("6. Trim");
			System.out.println("================================");
			System.out.println("7. Radix sort");
			System.out.println("0. Exit");
			System.out.println("Enter your selection");
			System.out.println("================================");
			Scanner sc = new Scanner(System.in);
			select = Integer.parseInt(sc.nextLine());

			switch (select) {
			case 1:
				char[] s1, s2;
				System.out.println("Enter string 1: ");
				s1 = readLine();
				System.out.println("Enter string 2: ");
				s2 = readLine();

				char[] s = concat(s1, s2);
				writeLine(s);
				break;
			case 2:
				findChar();
				break;
			case 3:
				System.out.println("Enter the string: ");
				String str = sc.nextLine();
				size(str);

			case 4:
				System.out.println("Enter the string: ");
				String a = sc.nextLine();
				low(a);
				break;
			case 5:
				System.out.println("Enter the string: ");
				String chuoi = sc.nextLine();
				System.out.println("Enter trim from: ");
				int low = sc.nextInt();
				System.out.println("Enter trim to: ");
				int high = sc.nextInt();
				substr(chuoi, low, high);
				break;
			case 6:
				System.out.println("Enter the string: ");
				String stry = sc.nextLine();

				tri1(stry);
				break;
			case 7:
				String[] n = { "158", "124", "238", "707", "608", "250", "888" };
				LSDSort(n, 3);

				System.out.println("");
				System.out.println("");
				System.out.println("The final result are: ");

				for (String result : n)
					System.out.print(result + "    ");
				System.out.println("");

			default:
				System.out.println();
				break;
			}
		} while (select != 0);

	}

	private static void LSDSort(String[] n, int W) {
		int R = 256;
		int N = n.length;

		for (int d = W - 1; d >= 0; d--) {
			int[] count = new int[R + 1];
			for (int i = 0; i < N; i++) {
				count[n[i].charAt(d) + 1]++;
			}
			for (int r = 0; r < R; r++) {
				count[r + 1] += count[r];
			}
			String aux[] = new String[N];
			for (int i = 0; i < N; i++) {
				aux[count[n[i].charAt(d)]] = n[i];
				count[n[i].charAt(d)]++;
			}
			System.arraycopy(aux, 0, n, 0, N);
			System.out.println("The results of the " + d + " posistion of the number: ");
			System.out.println("");

			for (String nu : n)
				System.out.print(nu + "    ");
			System.out.println();
			System.out.println("");
		}
	}

	private static char[] readLine() {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();

		char[] ret = new char[s.length()];
		for (int i = 0; i < s.length(); i++)
			ret[i] = s.charAt(i);

		return ret;
	}

	private static char[] concat(char[] s1, char[] s2) {
		char[] s = new char[s1.length + s1.length];
		int l = 0;

		for (int i = 0; i < s1.length; i++)
			s[i] = s1[i];

		for (int i = 0; i < s2.length; i++)
			s[i + s1.length] = s2[i];

		return s;
	}

	private static void writeLine(char[] s) {
		for (int i = 0; i < s.length; i++)
			System.out.print(s[i]);
		System.out.println();
	}

	private static void findChar() {
		Scanner sc = new Scanner(System.in);

		int frequency = 0;

		System.out.println("Enter any sentence: ");
		String str = sc.nextLine();

		System.out.println("Enter key to search: ");
		char ch = sc.nextLine().charAt(0);

		for (int i = 0; i < str.length(); i++) {
			// equal
			if (ch == str.charAt(i)) {
				++frequency;
				System.out.println("Found Index: " + i);
				break;
			}
		}

		System.out.println("Frequency of " + ch + " = " + frequency);

	}

	private static char[] substring(char[] s, int index, int len) {
		if (index + len > s.length)
			return null;
		char[] sub = new char[len];
		for (int i = index; i < index + len; i++)
			sub[i] = s[i = index];
		return sub;
	}

	private static int size(String str) {
		str = str + '\0';

		int count = 0;
		for (int i = 0; str.charAt(i) != '\0'; i++) {
			count++;
		}
		System.out.println("\n The length =" + count);
		return count;
	}

	private static void low(String a) {
		for (int i = 0; i < a.length(); i++) {
			char aChar = a.charAt(i);
			if (65 <= aChar && aChar <= 90) {
				aChar = (char) ((aChar + 32));
			}
			System.out.print(aChar);
		}

	}

	// https://www.geeksforgeeks.org/print-substring-of-a-given-string-without-using-any-string-function-and-loop-in-c/
	private static void substr(String chuoi, int low, int high) {
		if (low <= high) {
			for (int i = 0; i < chuoi.length(); i++) {
				if (i >= low && i <= high)
					System.out.print(chuoi.charAt(i));
			}
		}
	}

	private static void tri1(String stry) {
		char[] ch = stry.toCharArray();
		int pos = 0;
		int spaceCounter = 0;

		for (int i = 0; i < ch.length; i++) {
			if (ch[i] != ' ') {
				spaceCounter = i;
				break;
			}
		}
		for (int i = ch.length - 1; i >= 0; i--) {
			if (ch[i] != ' ') {
				pos = i;
				break;
			}
		}

		String str = new String(ch);
		if (spaceCounter <= pos) {
			for (int a = 0; a < str.length(); a++) {
				if (a >= spaceCounter && a <= pos)
					System.out.print(str.charAt(a));
			}
		}
	}

}
