package Enclave;

public class enclave {
	//enclave ID
	private int eid;
	
	
	//This creates our enclave
	//needs a launch token, enclave file, eid, u
	//enclave file name is the file name to the enclave image
	//launch token is data used for launching
	//updated is if the launch token got updates
	
	/**Creates a new enclave
	 * 	@param enclaveFileName the signed enclave file, with the enclave image
	 * @param enclaveID used as a handle for the enclave by other functions
	 * @param t token with startup details for the enclave
	 * 
	 */
	public enclave(String enclaveFileName, int enclaveID, CreationToken t)
	{
		//		@param Input ENCLAVE_FILE is the signed enclave file, defined above.
		//		@param Input SGX_DEBUG_FLAG is set to 1 if the enclave is to be launched in debug mode else it is set to 0
		//
		//		*/
		//ret = sgx_create_enclave(ENCLAVE_FILE, SGX_DEBUG_FLAG, &token, &updated, &eid, NULL);
		//the launch token has some data used to create the enclave type
		//we can give it a zero, and it will try to update itself
		//
		eid = enclaveID;
	}
}
