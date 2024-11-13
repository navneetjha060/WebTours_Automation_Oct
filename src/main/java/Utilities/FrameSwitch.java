package Utilities;

import BaseClass.BaseClass;

public class FrameSwitch extends BaseClass {

	public FrameSwitch() {
		super();
	}

	public void switchFrameName(String Fname) {

		driver.switchTo().frame(Fname);

	}

	public void switchParentFrame() {
		driver.switchTo().parentFrame();
	}

}
