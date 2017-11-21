package insurance.ic.model;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class BaseModel implements Serializable{

	private String uuid;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
}
