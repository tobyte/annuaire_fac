package validation;



import org.apache.ws.security.WSSecurityException;
import org.apache.ws.security.handler.RequestData;
import org.apache.ws.security.message.token.UsernameToken;
import org.apache.ws.security.validate.UsernameTokenValidator;


public class UTValidator extends UsernameTokenValidator {

    @Override
    protected void verifyPlaintextPassword(UsernameToken usernameToken,
            RequestData data) throws WSSecurityException {
        System.out.println("nom=" + usernameToken.getName());
        if (!usernameToken.getName().equalsIgnoreCase("remi") ||
                !usernameToken.getPassword().equalsIgnoreCase("mdp")) {
            throw new WSSecurityException(WSSecurityException.FAILED_AUTHENTICATION);
        }
    }
}
