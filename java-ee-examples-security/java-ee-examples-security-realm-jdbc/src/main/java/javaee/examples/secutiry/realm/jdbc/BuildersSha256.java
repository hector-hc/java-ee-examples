
/**
 * @Class BuildersSha256
 * @author Hector
 * @Created on Jun 22, 2019, 9:45:35 PM
 */

package javaee.examples.secutiry.realm.jdbc;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class BuildersSha256 {
    
    public static void main(String[] args) throws NoSuchAlgorithmException {
        BuildersSha256 builder = new BuildersSha256();
        String p = builder.generateSha256("customer01");
        System.out.println("" + p);
    }
    
    private String generateSha256(String text) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(text.getBytes(StandardCharsets.UTF_8));
        String encoded = Base64.getEncoder().encodeToString(hash); // Java 8 feature
        
        return encoded;
    }
}
