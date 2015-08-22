import java.io.*;
 import java.util.zip.*;
 public class Zip
 {
 public static void main(String a[])
  {
  try
 {
  File inFolder=new File(System.getProperty("user.dir")+"\\XSLT_Reports\\output");
  File outFolder=new File("Reports.zip");
  ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(outFolder)));
  BufferedInputStream in = null;
  byte[] data  = new byte[1000];
  String files[] = inFolder.list();
 for (int i=0; i<files.length; i++)
  {
  in = new BufferedInputStream(new FileInputStream
(inFolder.getPath() + "/" + files[i]), 1000);  
out.putNextEntry(new ZipEntry(files[i])); 
  int count;
  while((count = in.read(data,0,1000)) != -1)
  {
 out.write(data, 0, count);
  }
  out.closeEntry();
  }
  out.flush();
  out.close();
  }
  catch(Exception e)
 {
  e.printStackTrace();
  } 
 }
  } 