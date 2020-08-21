import java.util.Scanner;

/*
 * I have done a similar project before on my free time 
 * Named Encryption-Decryption on my github, https://github.com/Swirl86/Encryption-Decryption
 * I used the Shift class methods from that project I had written and modified the methods slightly for this task
 * Encryption algorithm: Caesar
 * "The action of a Caesar cipher is to replace each plaintext letter with a different one a fixed number of places down the alphabet."
 */

public class Cipher {
	
	// final because the alphabet shall not change
	final static String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	   
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);

		String cipherText = "govmywo dy tkfk zbyqbkwwsxq";
		int key = 10; // Took a few tries to find the key by hand :)
		System.out.println("Your Cipher text is: " + cipherText);

		System.out.print("Please enter Cipher key: ");
		try {
			key = Integer.parseInt(input.nextLine()); 
		} catch (Exception e) {
			System.out.println("Faild to enter valid key, default set to 10.");
		}

		String decrypt = shiftText(cipherText, key * -1); 	// Move -key (-10) steps back in the alphabet per char
			String encrypt = shiftText(decrypt, key);	// Move key (10) steps forward in the alphabet per char

		System.out.println("Decrypt: " + decrypt);
		System.out.println("Encrypt: " + encrypt);

		input.close();
	}
	
	public static String shiftText(String text, int key) {
		
		String cipherStr = ""; // Will build the cipher text row on this variable
		
		for (int i = 0; i < text.length(); i++) {
		    if(notLetter(text.charAt(i))) { // Add space, tab or new line if not a letter
			cipherStr += text.charAt(i);
		    } else {
			// Loop through the alphabet and move the correct character on "i" position "key" value steps
			for (int j = 0; j < alphabet.length(); j++) {
				// Traverse the text char by char
			    if(text.charAt(i) == alphabet.charAt(j)) {
				char letter = shiftChar(alphabet.charAt(j), key);
				cipherStr += letter; // add shifted character to the text row
				break;
			    }
			}
		    }
		}

        	return cipherStr; // send back an complete encrypted/decrypted string
    }

	// Get new character by using the letter value from (charAt + steps)
	public static char shiftChar(char charAt, int steps) {
		char letter = (char) (charAt + steps);
		if (letter > 'z') {
		    letter = (char) (letter - 26);
		} else if (letter < 'a') {
		    letter = (char) (letter + 26);
		}
		return letter;
    }

    private static boolean notLetter(char ch) {
        return ((ch == ' ') || (ch =='\n') || (ch == '\t'));
    }
}
