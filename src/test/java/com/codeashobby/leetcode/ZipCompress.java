/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package com.codeashobby.leetcode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.compress.utils.IOUtils;

/**
 * Description:
 *
 * @author hzhou
 */
public class ZipCompress {

	public static void main(String[] args) throws Exception {
		/* Create Output Stream that will have final zip files */
		//OutputStream zip_output = new FileOutputStream(new File("zip_output.zip"));
		ZipOutputStream zip_output = new ZipOutputStream(new FileOutputStream("zip_output2.zip"));
		/* Create Archive Output Stream that attaches File Output Stream / and specifies type of compression */

		zip_output.putNextEntry(new ZipEntry("pom.xml"));
		FileInputStream in = new FileInputStream(new File("pom.xml"));
		IOUtils.copy(in, zip_output);
		IOUtils.closeQuietly(in);

		zip_output.putNextEntry(new ZipEntry("logger.log"));
		FileInputStream in2 = new FileInputStream("logger.log");
		IOUtils.copy(in2, zip_output);
		IOUtils.closeQuietly(in2);

        /* Close output stream, our files are zipped */
		IOUtils.closeQuietly(zip_output);
	}
}