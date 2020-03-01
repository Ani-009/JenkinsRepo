package com.Blazedemo.MavenDemo;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import utils.Constants;

public class BaseClass {

	
	private static ITestContext context;
	public WebDriver driver;
	public Login login;
	public Home home;
	public LandingPage landingPage;
	public ListOfFlights listOfFlights;
	public BlazeDemoPurchase blazeDemoPurchase;
	public BlazedemoConfirmation blazedemoConfirmation;

	public static ITestContext setContext(ITestContext iTestContext, WebDriver driver) {
		iTestContext.setAttribute("driver", driver);
		return iTestContext;
	}

	@BeforeClass()
	public void openBrowser(ITestContext iTestContext) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		driver = new ChromeDriver();
		context = setContext(iTestContext, driver);
		driver.manage().window().maximize();
		driver.get("http://blazedemo.com/login");
		login = new Login(driver);
		home = new Home(driver);
		landingPage = new LandingPage(driver);
		listOfFlights = new ListOfFlights(driver);
		blazeDemoPurchase = new BlazeDemoPurchase(driver);
		blazedemoConfirmation = new BlazedemoConfirmation(driver);
	}

	@AfterClass()
	public void closeBrowser() {
		driver.close();
	}

	@AfterSuite(enabled=true)
	public void tearDown() {
		
		sendReportByGMail("abc@gmail.com", Constants.EMAIL_PASSWORD, "aparanji6@gmail.com", "Test Report", "");
	}

	/**
	 * Send email using java
	 * 
	 * @param from
	 * @param pass
	 * @param to
	 * @param subject
	 * @param body
	 */
	private static void sendReportByGMail(String from, String pass, String to, String subject, String body) {
		Properties props = System.getProperties();
		String host = "smtp.gmail.com";
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", from);
		props.put("mail.smtp.password", pass);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		Session session = Session.getDefaultInstance(props);
		MimeMessage message = new MimeMessage(session);

		try {
			// Set from address
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			// Set subject
			message.setSubject(subject);
			message.setText(body);

			BodyPart objMessageBodyPart = new MimeBodyPart();

			objMessageBodyPart.setText("Please Find The Attached Report File!");

			Multipart multipart = new MimeMultipart();

			multipart.addBodyPart(objMessageBodyPart);

			objMessageBodyPart = new MimeBodyPart();

			// Set path to the pdf report file
			String filename = System.getProperty("user.dir") + "\\TestReport\\Test-Automation-Report.html";
			// Create data source to attach the file in mail
			DataSource source = new FileDataSource(filename);

			objMessageBodyPart.setDataHandler(new DataHandler(source));

			objMessageBodyPart.setFileName(filename);

			multipart.addBodyPart(objMessageBodyPart);

			message.setContent(multipart);
			Transport transport = session.getTransport("smtp");
			transport.connect(host, from, pass);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (AddressException ae) {
			ae.printStackTrace();
		} catch (MessagingException me) {
			me.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
