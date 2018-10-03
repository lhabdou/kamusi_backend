/**
 * 
 */
package com.lh.kamusi.rest.firebase;

import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Component;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

/**
 * @author asoilihi
 *
 */
@Component
public class FirebaseVerification {

	public String getUserIdFromIdToken(String idToken) throws FirebaseAuthException {
		String userId = null;
		try {
			userId = FirebaseAuth.getInstance().verifyIdTokenAsync(idToken).get().getUid();
		} catch ( InterruptedException | ExecutionException e) {
			
			throw new FirebaseAuthException("403", "User Not Authenticated");
		}
		return userId;
	}

}
