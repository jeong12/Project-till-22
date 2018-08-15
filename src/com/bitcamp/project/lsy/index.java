package com.bitcamp.project.lsy;

import java.util.Iterator;
import java.util.List;

public class index {

	calDAO da = new calDAO();
	calDTO dt = new calDTO();
	
	//
	List<calDTO>arr = da.getList();
	Iterator<calDTO> itr = arr.iterator();
	for(int i=0; i<arr.size(); i++) {
		itr.next().acode
	}

}
