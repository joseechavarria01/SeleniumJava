/**
 * @author Jose Francisco Echavarria
 */
package utils;


import utils.logger.LogController;

public class RunUtil {
    private static RunUtil instance = new RunUtil();
    private static LogController logger = new LogController(RunUtil.class);
    public String runId = "UNDEFINED";
 
    public static RunUtil getInstance() {
       return instance;
    }
 
    public String getRunId() {
       if (this.runId.equals("UNDEFINED")) {
          this.setRunId();
       }

       return this.runId;
    }
 
    public void setRunId() {
       if (System.getProperty("runId") != null) {
          this.runId = System.getProperty("runId");
       } else {
          this.runId = " ^-^ ";
       }

       logger.info("Run Id is set to - " + this.runId);
    }

    public void setRunId(String value) {

         this.runId = value;
   }
   
 }
 