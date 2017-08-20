/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
/**
 *
 * @author pavikumbhar
 */


public class QuickPasswordEncodingGenerator {
  
    /**
     * @param args
     */
    public static void main(String[] args) {
            String password = "pravin";
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(11);
            System.out.println(passwordEncoder.encode(password));
    }
  
}