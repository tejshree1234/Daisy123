package com.testingshastra.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.testingshastra.keywords.UIkeywords;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class TestListener implements ITestListener {
	private static final Logger LOG = Logger.getLogger(TestListener.class);
	
	@Override
	public void onTestFailure(ITestResult result) {
		
		AShot ashot = new AShot();
		ashot.shootingStrategy(ShootingStrategies.viewportPasting(200));
		Screenshot sc = ashot.takeScreenshot(UIkeywords.getInstance().driver);
		BufferedImage img = sc.getImage();
		String dir = System.getProperty("user.dir");
			
		
		try {
			ImageIO.write(img, "png", new File(dir+"/Screenshots/"+result.getName()+".png"));
			LOG.info("screen shot is saved successfully");
		}catch(IOException e) {
			
			e.printStackTrace();
		}
	
	}

}
