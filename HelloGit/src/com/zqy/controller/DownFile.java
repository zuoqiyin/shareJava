package com.zqy.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DownFile {


	@RequestMapping("/downFile.do")
	public void downFile(HttpServletResponse response) {
		try {
			InputStream is = new FileInputStream("F:\\BaiduYunDownload\\战狼2.mp4");
			response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;filename=" + "战狼2.mp4");
			OutputStream os = response.getOutputStream();
			byte[] buf = new byte[1024*1024*10];
			int len = 0;
			while ( (len=is.read(buf)) !=-1 ) {
				os.write(buf,0,len);
			}
			os.close();
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}
}
