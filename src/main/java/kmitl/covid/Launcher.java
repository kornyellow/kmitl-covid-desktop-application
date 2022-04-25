package kmitl.covid;

import kmitl.covid.launcher.Application;
import kmitl.covid.lib.korn.kornutil.KornFix;
import kmitl.covid.lib.korn.kornutil.KornResource;

public class Launcher {
	public static void main(String[] args) {
		KornFix.fixAll();
		KornResource.loadResource();
		Application.main(args);
	}
}