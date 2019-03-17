package com.mhfs.javabean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class File {
	private int id;
	private String uName;
	private String name;
	private String content;
	private int pri;
}
