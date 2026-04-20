import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    // Valid test object
    Login user = new Login("ab_cd", "Password1!", "+27831234567", "Nyiko", "Nomvela");

    // Username Tests
    @Test
    public void testValidUsername() {
        assertTrue(user.checkUsername());
    }

    @Test
    public void testInvalidUsername() {
        Login invalidUser = new Login("abcd", "Password1!", "+27831234567", "Test", "User");
        assertFalse(invalidUser.checkUsername());
    }

    // Password Tests
    @Test
    public void testValidPassword() {
        assertTrue(user.checkPasswordComplexity());
    }

    @Test
    public void testInvalidPassword() {
        Login invalidUser = new Login("ab_cd", "pass", "+27831234567", "Test", "User");
        assertFalse(invalidUser.checkPasswordComplexity());
    }

    // Phone Number Tests
    @Test
    public void testValidPhoneNumber() {
        assertTrue(user.checkCellPhoneNumber());
    }

    @Test
    public void testInvalidPhoneNumber() {
        Login invalidUser = new Login("ab_cd", "Password1!", "0831234567", "Test", "User");
        assertFalse(invalidUser.checkCellPhoneNumber());
    }

    // Login Tests
    @Test
    public void testLoginSuccess() {
        assertTrue(user.loginUser("ab_cd", "Password1!"));
    }

    @Test
    public void testLoginFailure() {
        assertFalse(user.loginUser("wrongUser", "wrongPass"));
    }

    // Output Message Test
    @Test
    public void testLoginMessage() {
        String message = user.returnLoginStatus(true);
        assertEquals("Welcome Nyiko, Nomvela it is nice to see you again.", message);
    }
}