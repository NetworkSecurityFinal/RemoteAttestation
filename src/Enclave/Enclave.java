package enclave;

import java.math.BigInteger;
import java.security.*;

import javax.crypto.KeyAgreement;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.*;

/**
 * Software simulation of an SGX enclave
 * that exposes a subset of the SGX instruction set used for remote attestation
 * @author Madeline MacDonald
 * @since 12/1/17
 * @version beta 1.0
 */
public class Enclave {
	
	//Hold the p and g values for the DHKE
	private static DHParameterSpec paramSpec;
	//These are hardware keys
	//in a real enclave these would have been generated when the enclave was created
	//These are kept hidden from the manufacturer (Intel) and used to generate other provisioning keys
	static byte[] sealing_key = new byte[16];
	static byte[] provisioning_key = new byte[16];
	
	private int eid;
	private String FileName;
	private PublicKey spPublicKey;	
	private KeyPair dhKeyPair;
	private KeyAgreement dhKeyAgree;

	static {
		
		//generate keys in a static block 
		//to simulate their creation when the hardware was made
		SecureRandom sr = new SecureRandom();
		sr.nextBytes(provisioning_key);
		sr.nextBytes(sealing_key);
		
		//Init P and G for Diffie Hellman
		paramSpec = new DHParameterSpec(new BigInteger("47"), new BigInteger("71"));
	}

	/**
	 * Creates a new instance of an enclave simulator 
	 * that exposes a subset of the SGX instruction set used for remote attestation.
	 * This is equivalent to sgx_create_enclave()
	 * @param enclaveFileName
	 * @param enclaveID
	 */
	public Enclave(String enclaveFileName, int enclaveID) {
		// Make the choice to not load enclave file
		// Don't use a creation token

		eid = enclaveID;
	}
	
	/*
	 * These functions are for initializing PSE, which is where TPM logic would be called
	 * These need to be called before and after sgx_ra_init()
	 */
	public void sgx_create_pse_session() {}
	public void sgx_close_pse_session() {}
	
	/**
	 * Initializes the enclave for remote attestation.
	 * Stores the service provider's public key, and initializes a Diffie Hellman key exchange
	 * @param spPubKey The service provider's public key
	 * @return the public Diffie Hellman key
	 */
	public DHPublicKey sgx_ra_init(PublicKey spPubKey)
	{	
		try {
			spPublicKey = spPubKey;
			KeyPairGenerator kpg = KeyPairGenerator.getInstance("DiffieHellman");
			kpg.initialize(paramSpec);
			dhKeyPair = kpg.generateKeyPair();
			dhKeyAgree = KeyAgreement.getInstance("DiffieHellman");
			dhKeyAgree.init(dhKeyPair.getPrivate());
			
			return (DHPublicKey) dhKeyPair.getPublic();
		} catch (NoSuchAlgorithmException e) {
			System.out.println(e.getMessage());
		} catch (InvalidAlgorithmParameterException e) {
			System.out.println(e.getMessage());
		} catch (InvalidKeyException e) {
			System.out.println(e.getMessage());
		}
		
		return (DHPublicKey)dhKeyPair.getPublic();
	}
	
	/**
	 * retrieves the extended group ID, which indicates the attestation service provider
	 * 0 indicates Intel's attestation service, != 0 indicates a third party attestation service
	 * 
	 * This simulated enclave follows Intel's attestation protocol
	 * @return extended group id
	 */
	public int sgx_get_extended_epid_group_id()
	{
		return 0;
	}
	
	/**
	 * 
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
