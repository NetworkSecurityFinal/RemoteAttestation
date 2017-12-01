package Enclave;

import java.security.SecureRandom;

public class Enclave {

	private int eid;
	private String FileName;

	static SecureRandom sr = new SecureRandom();
	static byte[] sealing_key = new byte[16];
	static byte[] provisioning_key = new byte[16];

	static {
		sr.nextBytes(provisioning_key);
		sr.nextBytes(sealing_key);
	}
	// This creates our enclave
	// needs a launch token, enclave file, eid, u
	// enclave file name is the file name to the enclave image
	// launch token is data used for launching
	// updated is if the launch token got updates

	/**
	 * Creates a new enclave
	 * 
	 * @param enclaveFileName
	 *            the signed enclave file, with the enclave image
	 * @param enclaveID
	 *            used as a handle for the enclave by other functions
	 * @param t
	 *            token with startup details for the enclave
	 * 
	 */
	public Enclave(String enclaveFileName, int enclaveID, CreationToken t) {
		// We need to verify the enclave file signature here
		// How do keys work? Do we create a new private enclave key here, or do accept
		// one

		eid = enclaveID;
	}
}
