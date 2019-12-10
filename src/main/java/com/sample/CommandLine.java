package com.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandLine {

	public static void main(String...arg) throws IOException
	{
		Runtime rt = Runtime.getRuntime();
		Process proc = rt.exec("/usr/local/bin/idevice_id -l");
		BufferedReader br = new BufferedReader(new InputStreamReader(proc.getInputStream()));
		String udid = br.readLine();
		System.out.println(udid);
	}
	
/*	public static void main(String...arg)
	{
		ProcessBuilder processBuilder = new ProcessBuilder();
		processBuilder.command("bash","-c","idevicepair pair");

		try {
			Process process = processBuilder.start();

			StringBuilder output = new StringBuilder();

			BufferedReader reader = new BufferedReader(
					new InputStreamReader(process.getInputStream()));

			String line;
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}
			System.out.println(output);
			int exitVal = process.waitFor();
			if (exitVal == 0) {
				System.out.println("Success!");
				System.out.println(output);
				System.exit(0);
			} else {
				System.out.println("abnormal");
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}*/
}
