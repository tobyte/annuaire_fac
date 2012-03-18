/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package validation;

import java.io.IOException;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import org.apache.ws.security.WSPasswordCallback;

/**
 *
 * @author 10702274
 */
public class PWCallbackHandler implements CallbackHandler {
  @Override
  public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
     WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];
     pc.setIdentifier("remi");
     pc.setPassword("mdp");
  }
}

