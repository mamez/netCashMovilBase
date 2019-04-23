package com.bbva.pibee.web.dto.response;

import java.io.Serializable;

public class ExportOperationFileResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6065672701358879541L;

	private String FileName;
	private String FileNamePath;
	private Long fileSize;
	
	public String getFileName() {
		return FileName;
	}
	public void setFileName(String fileName) {
		FileName = fileName;
	}
	public String getFileNamePath() {
		return FileNamePath;
	}
	public void setFileNamePath(String fileNamePath) {
		FileNamePath = fileNamePath;
	}
	public Long getFileSize() {
		return fileSize;
	}
	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}
	
	

}
