package Enclave;

import java.security.*;
import javax.crypto.spec.*;

public class Enclave {

	private int eid;
	private String FileName;
	private PublicKey spPublicKey;
	private DHParameterSpec kpg;

	static byte[] sealing_key = new byte[16];
	static byte[] provisioning_key = new byte[16];

	static {
		SecureRandom sr = new SecureRandom();
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
	public Enclave(String enclaveFileName, int enclaveID) {
		// Make the choice to not load enclave file
		// Don't use a creation token

		eid = enclaveID;
	}
	
	/*
	 * Kenzie, Jen, these functions are for initializing PSE
	 * This should include TPM work
	 * These need to be called before and after sgx_ra_init
	 */
	public void sgx_create_pse_session() {}
	public void sgx_close_pse_session() {}
	
	/*
	 * Accepts public key from Service Provider
	 * Create a context for DHKE, returns the DH public key
	 */
	public byte[] sgx_ra_init(PublicKey spPubKey)
	{
		spPublicKey = spPubKey;
		//takes public key from SP
		//Creates context for DHKE
		return new byte[16];
	}
	
	/*
	 * retrieves the extended group ID, 
	 * an anonymous signature scheme used for identification
	 */
	public byte[] sgx_get_extended_epid_group_id()
	{
		return new byte[16];
	}
	
	/*
	 * Should return a msg1 object
	 * Just contains an object containing the public DH key
	 */
	public void sgx_ra_get_msg1()
	{
		
	}
	
	/*
	 * sgx_ra_proc_msg
	 */
	public void sgx_ra_proc_msg2()
	{
		//verify the service provider signature
		//Check the SigRl
		//generate msg 3
		//msg 3 contains quote to attest enclave
	}
	
	//some code goes in here to get the quote for the enclave
	private void GetQuote()
	{
		
	}
}
