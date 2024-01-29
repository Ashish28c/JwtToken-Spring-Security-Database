package com.isource.JwtTokenwithDatabase.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.stereotype.Component;

import com.isource.JwtTokenwithDatabase.model.TenderDocumentDTO;

@Component
public class CommanDAO {

	static List<String> allFilesForZip ;
	
	public  long getTenderCreatedDate(List<TenderDocumentDTO> TenderDocumentDetailsList){
		String finalDocumentPath = "E:\\Tender\\UnZip_Path\\";
		String documentPath1 = "\\\\192.168.7.5/TenderDocShare/TenderV3Documents";
		//deleteDirectory(new File(finalDocumentPath));
		long userID=0;
		for (TenderDocumentDTO tenderDocumentDetailDTO : TenderDocumentDetailsList) {
			userID=tenderDocumentDetailDTO.getUserID();
			System.out.println(tenderDocumentDetailDTO.getTenderid());
			
			String tenderdate = ""+tenderDocumentDetailDTO.getSourceDay();
			System.out.println(tenderdate);
			if(Integer.parseInt(tenderdate)<10){
				tenderdate="0"+tenderdate;
			}
			String tendermonth = ""+tenderDocumentDetailDTO.getMonth();
			if(tenderDocumentDetailDTO.getMonth()<10){
				if(tendermonth.contains("0")){
					tendermonth = ""+tenderDocumentDetailDTO.getMonth();
				}else{
					tendermonth = "0"+tenderDocumentDetailDTO.getMonth();
				}
			}else{
				tendermonth = ""+tenderDocumentDetailDTO.getMonth();
			}
			
			String destinactionDay = ""+tenderDocumentDetailDTO.getDestinactionDay();
			if(Integer.parseInt(destinactionDay)<10){
				destinactionDay="0"+destinactionDay;
			}
			String destinactionMonth=""+tenderDocumentDetailDTO.getDestinactionMonth();
			if(tenderDocumentDetailDTO.getDestinactionMonth()<10){
				if(destinactionMonth.contains("0")){
					destinactionMonth = ""+tenderDocumentDetailDTO.getDestinactionMonth();
				}else{
					destinactionMonth = "0"+tenderDocumentDetailDTO.getDestinactionMonth();
				}
			}else{
				destinactionMonth = ""+tenderDocumentDetailDTO.getDestinactionMonth();
			}
			//String Path =""+tenderDocumentDetailDTO.getDestinactionYear();
			String directoryPath = documentPath1+"/"+tenderDocumentDetailDTO.getYear()+"/"+tendermonth+"/"+tenderdate+"/"+tenderDocumentDetailDTO.getTenderid();
			String destinactionPath = finalDocumentPath +"/"+userID+"/"+tenderDocumentDetailDTO.getDestinactionYear()+"/"+tenderDocumentDetailDTO.getDestinactionMonth()+"/"+tenderDocumentDetailDTO.getDestinactionDay();
			try{
				File sourcedir = new File(directoryPath);
				File destinationdir = new File(destinactionPath);
				if (!destinationdir.exists()){ 
					destinationdir.mkdirs();
			 		//logger.info("Directory was not exist and created successfully in local server :=>"+dir);
			 	}
				System.out.println(sourcedir);
				System.out.println(destinationdir);
				System.out.println("Final Doc = "+destinactionPath);
				
               ZipUtility zip = new ZipUtility(directoryPath,destinactionPath+"/"+tenderDocumentDetailDTO.getTenderid()+".zip");
               zip.generateFileList(new File(directoryPath));
               zip.zipIt(destinactionPath+"/"+tenderDocumentDetailDTO.getTenderid()+".zip"); 
                   
				//copy(sourcedir,destinationdir);
			}catch(Exception ex){
				System.out.println("Document Not Found For TenderID :=>"+tenderDocumentDetailDTO.getTenderid()+" || Exception :=>"+ex.toString());
			}
		}
		
		return userID;
	}

	public void uploadDocuments(long userID) {
		
		String server = "";
        int port = 21;
        String user = "";
        String pass = "";
 
        FTPClient ftpClient = new FTPClient();
        try {
 
            ftpClient.connect(server, port);
            ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();
 
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            String DateToStr = "";
    		Date curDate = new Date();
    		SimpleDateFormat format = new SimpleDateFormat("ddMMyyyy");
    		DateToStr = format.format(curDate);
            // APPROACH #1: uploads first file using an InputStream
            File firstLocalFile = new File("E:/Tender/Documents/"+userID+"/"+DateToStr+".zip");
 
            String firstRemoteFile = DateToStr+".zip";
            InputStream inputStream = new FileInputStream(firstLocalFile);
 
            System.out.println("Start uploading first file");
            boolean done = ftpClient.storeFile(firstRemoteFile, inputStream);
            inputStream.close();
            if (done) {
                System.out.println("The first file is uploaded successfully.");
            }
            // APPROACH #2: uploads second file using an OutputStream
           
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
	}
	
	public void zipSqlScript(long userid) {
		try{
		String DateToStr = "";
		Date curDate = new Date();
		SimpleDateFormat format = new SimpleDateFormat("ddMMyyyy");
		DateToStr = format.format(curDate);
		
		String folderPath = "E:/Tender/UnZip_Path/"+userid+"/";
		File folderFile = new File(folderPath);

		allFilesForZip = new ArrayList<String>();
		populate(folderFile);
		String destinactionPath="E:\\Tender\\Documents\\"+userid+"\\";
		File destinationdir = new File(destinactionPath);
		if (!destinationdir.exists()){ 
			destinationdir.mkdirs();
	 		//logger.info("Directory was not exist and created successfully in local server :=>"+dir);
	 	}
		FileOutputStream fileOutputStream = new FileOutputStream("E:\\Tender\\Documents\\"+userid+"\\"+DateToStr+".zip");
		ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
		for(String singleFilePath : allFilesForZip){
			File singleFile = new File(singleFilePath);
			ZipEntry ze = new ZipEntry(singleFilePath.substring(folderFile.getAbsolutePath().length()+1, singleFilePath.length()));
		zipOutputStream.putNextEntry(ze);
		FileInputStream fileInputStream = new FileInputStream(singleFile);
		byte[] buffer = new byte[76000];
		int len;
		while((len=fileInputStream.read(buffer)) > 0){
			zipOutputStream.write(buffer,0,len);
		}
		zipOutputStream.closeEntry();
	    fileInputStream.close();
	    System.out.println(singleFile.getCanonicalPath()+" is zipped to "+DateToStr+".zip" );
	    if(singleFile.delete()){
	    	 System.out.println("File Deleted successFully "+singleFile.getAbsolutePath());
		}else{
			 System.out.println("File Deletion Failed "+singleFile.getAbsolutePath());
		}
		}
		zipOutputStream.close();
		fileOutputStream.close();
		//DeleteFileAndFolder();
			}catch(Exception e){
				e.printStackTrace();
			}
		}

		private static void populate(File dir) {
	        File[] files = dir.listFiles();
	        for(File file : files){
	            if(file.isFile()) allFilesForZip.add(file.getAbsolutePath());
	            else populate(file);
	        }
	    }
}
