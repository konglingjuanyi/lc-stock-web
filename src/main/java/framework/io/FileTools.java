package framework.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileTools {

	public void del(File file) throws IOException, NullPointerException,
			Exception {
		if (file == null)
			throw new NullPointerException("File is null");
		if (file.isFile() && file.exists())
			file.delete();
	}

	public void del(String fileUri) throws IOException, NullPointerException,
			Exception {
		File file = new File(fileUri);
		this.del(file);
	}

	public void cut(String filePath, String newFilePath) throws IOException,
			NullPointerException, Exception {
		this.copy(filePath, newFilePath);
		this.del(filePath);
	}

	public void copy(String filePath, String newFilePath) throws IOException,
			NullPointerException, Exception {
		File file = new File(filePath);
		this.createFile(file, newFilePath);
	}

	public void createFile(File file, String fileUri) throws IOException,
			NullPointerException, Exception {
		if (file == null)
			throw new NullPointerException("File is null");

		int last = fileUri.lastIndexOf("\\");
		String savePath = fileUri.substring(0, last);

		// System.out.println(savePath);

		File dir = new File(savePath);
		if (!dir.exists()) {
			dir.mkdirs();
		}

		FileInputStream inStream = new FileInputStream(file);
		FileOutputStream outStream = new FileOutputStream(new File(fileUri));
		BufferedInputStream bis = new BufferedInputStream(inStream);
		BufferedOutputStream bos = new BufferedOutputStream(outStream);
		try {

			byte[] buffer = new byte[1024];
			int len = -1;
			while ((len = bis.read(buffer)) != -1) {
				bos.write(buffer, 0, len);
			}

		} catch (IOException ioe) {
			throw ioe;
		} catch (NullPointerException ne) {
			throw ne;
		} catch (Exception e) {
			throw e;
		} finally {
			bos.close();
			bis.close();
			this.close(inStream, outStream);
		}
	}

	public void createFile(File file, String fileName, String savePath)
			throws IOException, NullPointerException, Exception {
		String fileuri = savePath + "\\" + fileName;
		this.createFile(file, fileuri);
	}

	private void close(FileInputStream fis, FileOutputStream fos) {
		if (fis != null) {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if (fos != null) {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		try {
//			FileTools t = new FileTools();
//			t.cut("H:\\uploadDemo\\abc.pdf", "H:\\uploadDemo\\test\\abc.pdf");
//			System.out.println("ok");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

}

