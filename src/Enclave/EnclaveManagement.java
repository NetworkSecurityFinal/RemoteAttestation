package enclave;

/*
 * This class is a wrapper for the enclave, to make the calls easier for the client
 */
public class EnclaveManagement {

	private Enclave enclave;

	public EnclaveManagement() {
		enclave = new Enclave("testfile.txt", -1);
	}

	public Enclave getEnclave() {
		return enclave;
	}

	/*
	 * A function that reads the sealed data from a file named "SealedSecret.bin"
	 * 
	 * @param - output: if the file exists, the size of the file is compared with
	 * the SealedDataSize; if it matches, the secret is read as blocks and returns
	 * true otherwise returns false
	 */
	public boolean ReadFromFile() {
		return false;
	}

	/*
	 * A function that writes the sealed data to a file for later use
	 * 
	 * @param - output: sealedData byte array is written to a file named
	 * "SealedSecret.bin"
	 */
	public void WriteToFile() {

	}

	/*
	 * A wrapper function to encyrpt and decrypt the provided data buffer depending
	 * on the validity of the secret at that point of time
	 * 
	 * @param - input : data buffer, buf of string type
	 * 
	 * @param - output : returns true if there exists a valid secret and attestation
	 * is not necessary if there is no valid secret available, does the remote
	 * attestation process; and then if the secret is valid, returns true else
	 * returns false
	 */
	public boolean EncryptDecrypt(String buffer) {
		return false;
	}

	/*
	 * An API that deletes the sealed secret file
	 */
	void RemoveFile() {
	}

	/*
	 * An API that destroys the enclave if the enclave_id is 0. It is a better
	 * practice to destroy an enclave when not in use
	 */
	void DestroyEnclave() {
	}

	/*
	 * An API that creates an enclave If the enclave_id is not 0, it means an
	 * enclave already exists and so the API does nothing, just returns; otherwise
	 * checks the device status using sgx_device_status. If sgx is enabled, creates
	 * the enclave using sgx_create_enclave() API.
	 * 
	 */
	void CreateEnclave() {
	}

	/*
	 * An API that encrypts and decrypts the given data buffer
	 * 
	 * @param -input: buffer of string type. This buffer will be encrypted with the
	 * secret key and decrypted using the secret key by this API output: Prints the
	 * decrypted message to the buffer and returns the status as SUCCESS if the
	 * encryption and decryption operations go well if not the function aborts with
	 * the related error message
	 */
	String EncryptAndDecryptEnclaveCalls(String buffer) {
		return "";
	}

	// A wrapper function that destroys and creates enclave
	void DestroyAndCreateEnclave() {
	}
}
