package org.sharfulumair.pages;

import org.sharfulumair.base.BasePage;

public class NewCarsPage  extends BasePage{

	

	public void gotoHonda() {

		click("honda_XPATH");
	}

	public void gotoToyota() {

		click("toyota_XPATH");
	}

	public void gotoKia() {

		click("kia_XPATH");
	}

	public void gotoBMW() {

		click("bmw_XPATH");
	}
}
