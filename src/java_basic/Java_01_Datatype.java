package java_basic;

public class Java_01_Datatype {

	public static void main(String[] args) {
		String start = "Automation Testing Tutorials Online 123456";
		int i;
		int count = 0;
		int count1 = 0;
		char kyTu = 'a';
		String str1 = "Testing";
		String str2 = "Automation";
		String str3 = "Online";
		String str4 = "Tutorials";
		String str5 = "Online";

		for (i = 0; i < start.length(); i++) {
			if (start.charAt(i) == kyTu) {
				count++;
			}
			if (Character.isDigit(start.charAt(i))) {
				count1++;
			}
		}
		System.out.println("Result count 'a' : " + (count + 1));
		System.out.println("Result count 'int' : " + (count1));

		boolean compare = start.equals(str1);
		compare = str1.equals(str1);
		System.out.println("Result equal: " + compare);

		boolean startAt = start.startsWith(str2);
		System.out.println("Result start with: " + startAt);

		boolean endAt = start.endsWith(str3);
		System.out.println("Result end with: " + endAt);

		int index = start.indexOf(str4);
		System.out.println("Result index: " + index);

		start = start.replace(str5, "Offline");
		System.out.println("New string:" + start);
	}
}
