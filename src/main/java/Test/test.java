package Test;

import org.mindrot.jbcrypt.BCrypt;

import org.mindrot.jbcrypt.BCrypt;

public class test {
    public static void main(String[] args) {
        String password = "adminADMIN1/";
        String providedHash = "$2y$13$PH/uDFQUdtChdejhGF988.hLtTgKBysff6VaCuC9SJn93AhebL01W";

        if (providedHash.startsWith("$2y$")) {
            // Use provided salt version
            if (BCrypt.checkpw(password, providedHash)) {
                System.out.println("Password matches");
            } else {
                System.out.println("Password does not match");
            }
        } else {
            System.out.println("Invalid salt version");
        }
    }
}

