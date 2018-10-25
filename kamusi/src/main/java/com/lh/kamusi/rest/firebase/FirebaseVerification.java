/**
 * 
 */
package com.lh.kamusi.rest.firebase;

import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Component;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;

/**
 * @author asoilihi
 *
 */
@Component
public class FirebaseVerification {

	/**
	 * @param idToken
	 * @return
	 * @throws FirebaseAuthException
	 */
	public String getUserIdFromIdToken(String idToken) throws FirebaseAuthException {
		String userId = null;
		try {
			userId = FirebaseAuth.getInstance().verifyIdTokenAsync(idToken).get().getUid();
		} catch ( InterruptedException | ExecutionException e) {
			
			throw new FirebaseAuthException("403", "User Not Authenticated");
		}
		return userId;
	}
	
	/**
	 * @param uid
	 * @return
	 * @throws FirebaseAuthException
	 */
	public UserRecord getUserIdFromUid(String uid) throws FirebaseAuthException {
		UserRecord user = null;
		try {
			user = FirebaseAuth.getInstance().getUser(uid);
		} catch ( FirebaseAuthException e) {
			
			throw new FirebaseAuthException("403", "User Not found");
		}
		return user;
	}

}
