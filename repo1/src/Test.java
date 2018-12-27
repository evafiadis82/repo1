import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] emails = new String[3];

		emails[0] = "test.email+alex@leetcode.com";
		emails[1] = "test.e.mail+bob.cathy@leetcode.com";
		emails[2] = "testemail+david@lee.tcode.com";

		numUniqueEmails(emails);

	}

	public static int numUniqueEmails(String[] emails) {

		HashMap<String, Integer> hmap = new HashMap<String, Integer>();

		for (int i = 0; i < emails.length; i++) {
			//System.out.println("\nEmail: " + emails[i]);
			String localname;
			String domain;

			String[] emailsplit = new String[2];
			emailsplit = emails[i].split("@");

			localname = emailsplit[0];
			domain = emailsplit[1];

			localname = localname.substring(0, localname.indexOf("+"));
			localname = localname.replace(".", "");

			emails[i] = localname + domain;

			//System.out.println("Localname: " + localname + " Domain: " + domain);

			if (hmap.containsKey(emails[i])) {
				int existingValue = hmap.get(emails[i]);
				hmap.put(emails[i], ++existingValue);
			} else
				hmap.put(emails[i], 1);

		}
		return hmap.size();

	}

}
