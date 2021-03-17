package com.adobeclassic.qa.tests;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.cognifide.qa.bb.provider.selenium.webdriver.modifiers.capabilities.CapabilitiesModifier;
import com.google.inject.Inject;
import com.google.inject.name.Named;

public class ChromeOptionsModifier implements CapabilitiesModifier {

	@Inject
	@Named("webdriver.chrome.headless")
	private boolean enabled;

	@Inject
	@Named("webdriver.chrome.headless.disableGpu")
	private boolean disableGpu;

	@Override
	public boolean shouldModify() {
		return enabled;
	}

	@Override
	public Capabilities modify(Capabilities capabilities) {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("headless");
		if (disableGpu) {
			chromeOptions.addArguments("disable-gpu");
		}
		Capabilities chromeCapabilites = DesiredCapabilities.chrome();
		((DesiredCapabilities) capabilities).setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		return chromeCapabilites.merge(capabilities);
	}
}