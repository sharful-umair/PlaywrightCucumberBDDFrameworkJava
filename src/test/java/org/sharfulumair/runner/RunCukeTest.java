package org.sharfulumair.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.sharfulumair.utils.MonitoringMail;
import org.sharfulumair.utils.TestConfig;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@CucumberOptions(
        features= {"src/test/resources/features"},
        glue= {"org.sharfulumair.steps"},
        //tags="@carprices",
        plugin= {"html:target/cucumber-reports/cucumber-html-report.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class RunCukeTest extends AbstractTestNGCucumberTests {

    @AfterSuite
    public void sendReportEmail() {
        try {
            MonitoringMail mail = new MonitoringMail();

            String reportPath = System.getProperty("user.dir") + "/reports/extent-report.html";

            // Dynamic Jenkins URL (assumes Jenkins is running on port 8080)
            String messageBody;
            try {
                messageBody = "Hi Team,<br><br>"
                        + "Please find the automation execution report at the below link:<br><br>"
                        + "<a href='http://" + java.net.InetAddress.getLocalHost().getHostAddress()
                        + ":8080/job/PlaywrightProject/Extent_20Report/'>Click to view Extent Report</a><br><br>"
                        + "Regards,<br>Automation Team";
            } catch (java.net.UnknownHostException e) {
                e.printStackTrace();
                messageBody = "Hi Team,<br><br>Please find the attached automation report.<br><br>Regards,<br>Automation Team";
            }

            // Set values for email config
            TestConfig.subject = "Automation Report - " +
                    java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

            TestConfig.messageBody = messageBody;
            TestConfig.attachmentPath = reportPath;
            TestConfig.attachmentName = "extent-report.html";

            // Send email
            mail.sendMail(
                    TestConfig.server,
                    TestConfig.from,
                    TestConfig.to,
                    TestConfig.subject,
                    TestConfig.messageBody
            );

            System.out.println("✅ Report email with Jenkins link sent successfully.");

        } catch (Exception e) {
            System.err.println("❌ Failed to send report email: " + e.getMessage());
        }
    }
}