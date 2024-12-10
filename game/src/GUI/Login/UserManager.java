package GUI.Login;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;


public class UserManager {
    private static final String USERS_FILE = "resources/users/users.txt";
    private static final int SALT_LENGTH = 16; // Length of the salt in bytes
    public boolean checkUserNameExists(String userName) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(USERS_FILE));
        for (String line : lines) {
            String storedUserName = line.split(":")[0];
            if (storedUserName.equalsIgnoreCase(userName)) {
                return true; // Username exists (case-insensitive)
            }
        }
        return false; // Username does not exist
    }

    public boolean validateCredentials(String userName, String password) throws IOException, NoSuchAlgorithmException {
        List<String> lines = Files.readAllLines(Paths.get(USERS_FILE));
        for (String line : lines) {
            String[] parts = line.split(":");
            if (parts[0].equalsIgnoreCase(userName)) {
                String storedHash = parts[1];
                String storedSalt = parts[2];
                String enteredHash = hashPassword(password, storedSalt);
                if (storedHash.equals(enteredHash)) {
                    return true; // Correct credentials
                }
            }
        }
        return false; // Incorrect credentials
    }

    public void createNewAccount(String userName, String password, String email) throws IOException, NoSuchAlgorithmException {
        if (!checkUserNameExists(userName)) {
            String salt = generateSalt();
            String hashedPassword = hashPassword(password, salt);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(USERS_FILE, true))) {
                writer.write(userName + ":" + hashedPassword + ":" + salt + ":" + email + "\n");
            }
        } else {
            throw new IllegalArgumentException("Username already exists.");
        }
    }

    private String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[SALT_LENGTH];
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    private String hashPassword(String password, String salt) throws NoSuchAlgorithmException {
        String saltedPassword = salt + password;
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = digest.digest(saltedPassword.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(hashBytes);
    }

}
