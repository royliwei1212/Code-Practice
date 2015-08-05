/**
 * Copyright (c) 2015 Ovitas Inc, All rights reserved.
 */
package com.codeashobby.leetcode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.utils.IOUtils;

/**
 * Description:
 *
 * @author hzhou
 */
public class ZipCompress {

	public static void main(String[] args) throws Exception {
		/* Create Output Stream that will have final zip files */
		OutputStream zip_output = new FileOutputStream(new File("zip_output.zip"));
		/* Create Archive Output Stream that attaches File Output Stream / and specifies type of compression */
		ArchiveOutputStream logical_zip = new ArchiveStreamFactory()
				.createArchiveOutputStream(ArchiveStreamFactory.ZIP, zip_output);
		/* Create Archive entry - write header information*/
		logical_zip.putArchiveEntry(new ZipArchiveEntry("pom.xml"));
		/* Copy input file */
		IOUtils.copy(new FileInputStream(new File("pom.xml")), logical_zip);
		/* Close Archive entry, write trailer information */
		logical_zip.closeArchiveEntry();
		/* Repeat steps for file - 2 */
		logical_zip.putArchiveEntry(new ZipArchiveEntry("logger.txt"));
		IOUtils.copy(new FileInputStream(new File("logger.log")), logical_zip);
		logical_zip.closeArchiveEntry();
        /* Finish addition of entries to the file */
		logical_zip.finish();
        /* Close output stream, our files are zipped */
		zip_output.close();
	}
}