package kmitl.covid.lib.korn.kornutil;

import java.util.Base64;

public class KornEncryption {
	public static String getUsername() {
		if (KornEncryption.username != null)
			return KornEncryption.username;

		String username = "Vm0wd2QyUXlWa2hWV0doVVYwZG9jRlZ0TVZOWFJsbDNXa2M1VjJKSGVEQmFSV2hyVm14S2MyTkVRbFZXYlUweFZqQmFTMlJIVmtsaVJtaG9UV3N3ZUZadGNFZFpWMUpJVm10V1VtSlZXbGhXYWtaTFUxWmtWMXBFVWxSTmF6RTBWMnRvVjJGR1NuUlZiRkpoVmpOU1IxcFZXbXRXTVhCRlZXeFNUbUY2UlRCV01uUnZWakpHUjFOdVVsWmlSa3BvVm1wT1UxSXhjRlpYYlVacVlrZDBObGxWV2xOVWJGcFZWbXhzVjFaNlFYaFZla3BIWXpGT2RWVnRhRk5pV0doWVZrWldZVmxXVWtkVmJsSnNVakJhY1ZSV1pGTk5SbFowWlVkMFZXSkdjREZWVjNodlZqRktjMk5HYUZkaGEzQklWVEJhWVdSV1NuTlRiR1JUVFRBd01RPT0";
		for (int i = 0; i < 5; i++)
			KornEncryption.timeUsername = new String(Base64.getDecoder().decode(KornEncryption.timeUsername));
		for (int i = 0; i < Integer.parseInt(KornEncryption.timeUsername); i++)
			username = new String(Base64.getDecoder().decode(username));
		KornEncryption.username = username;
		return KornEncryption.username;
	}
	public static String getPassword() {
		if (KornEncryption.password != null)
			return KornEncryption.password;

		String password = "Vm0wd2QyUXlVWGxWV0d4V1YwZDRWMVl3WkRSWFJteFZVbTVrVlUxV2NIcFhhMXBQWVd4S2MxZHFRbFZXYkhCUVZqQmFZV015U2tWVWJHaG9UV3N3ZUZacVFtRlRNazE1VTJ0V1ZXSkhhRzlVVjNOM1pVWmtWMVp0UmxSTmF6RTBWakkxUjFaWFNraFZia0pYWVRGd2FGcFdXbUZrUjFaSFYyMTRVMkpIZHpGV2EyUXdZekpHYzFOdVVsWmhlbXhoVm1wT2IyRkdjRmRYYlVaclVqRmFTRll5TVRSVk1rcElaSHBHVjJFeVVYZFpla3BIVmpGT2RWVnNXbWhsYlhob1ZtMXdUMkl5UmtkalJtUllZbFZhY2xWcVFURlNNV1J5VjI1a1YwMUVSa1pWYkZKSFZqSkZlVlZZWkZwbGEzQklWbXBHVDJSV1ZuTlhiV2hzWWxob2IxWXhaRFJpTWtsNFZXdGthVk5GV2xSWmJGWmhZMVpTVjFkdVpFNVNiRm93V2xWa01GWlhTa2RqUkVaV1ZqTm9kbFpxUmt0ak1rNUhZVVprYUdFelFrbFdWRUpoV1ZkU1YxTnVUbFJpUjFKVVZGUkJkMDFSUFQwPQ";
		for (int i = 0; i < 10; i++)
			KornEncryption.timePassword = new String(Base64.getDecoder().decode(KornEncryption.timePassword));
		for (int i = 0; i < Integer.parseInt(KornEncryption.timePassword); i++)
			password = new String(Base64.getDecoder().decode(password));
		KornEncryption.password = password;
		return KornEncryption.password;
	}

	private static String timeUsername = "VmtaYVUxTnNRbEpRVkRBOQ==";
	private static String username;
	private static String timePassword = "Vm0wd2QyVkZNVWRpUm1ScFVtMVNXRll3Wkc5WFZteDBZM3BHVmsxWGVIbFdiVFZyVm0xS1IyTkliRmRXTTFKTVZsVmFWMVpWTVVWaGVqQTk";
	private static String password;
}
