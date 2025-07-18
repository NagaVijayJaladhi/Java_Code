package com.jaladhi.cms.exception;

import lombok.Data;
import java.util.Date;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {

	private Date timeStamp;
	private String message;
	private String errorDesc;
	
}
