package enclave;


public class ClientApp {

 /**
  * This is the client application Jen and Kenzie, your code will go here
  * 
  * To create an enclave, we made the EnclaveManagement class to simplify the
  * process of creation It has a get enclave method, and you can use that to grab
  * any info you need
  * Remote Attestation will be commented out to remove server functionality while you implement the attack
  */
  public static void main(String[] args) {
    EnclaveManagement em = new EnclaveManagement();
    //try{
      //RemoteAttestation ra = new RemoteAttestation(em);
    //}catch(IllegalStateException e){
      //System.out.println("Enclave failed attestation, now exiting.");
      //System.exit(1);
    //}
  }
  
  
}