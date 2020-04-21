 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.UserAccount.UserAccount;

/**
 *
 * @author yash
 */
public class LabTestWorkRequest extends WorkRequest{
    
    private String testResult;
    private UserAccount account;
    
    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    public UserAccount getPatientAccount() {
        return account;
    }

    public void setPatientAccount(UserAccount account) {
        this.account = account;
    }
    
    
    
}
