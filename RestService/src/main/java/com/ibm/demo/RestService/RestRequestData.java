package com.ibm.demo.RestService;

public class RestRequestData {
	public String source_dataset;
	public String target_vsam;
	public String start_rows;
	public String row_count;
	
	
	@Override
	public String toString() {
		return "RestRequestData [source_dataset=" + source_dataset + ", target_vsam=" + target_vsam + ", start_rows="
				+ start_rows + ", row_count=" + row_count + "]";
	}	
}
