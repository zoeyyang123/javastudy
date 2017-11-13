package foundation.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;


@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS,include = JsonTypeInfo.As.PROPERTY,property = "domainName")
public class ModelComponent extends BaseModel {

//    public ModelComponent(){
//        String id = Guid.generateUuid();
//        this.setUuid(id);
//    }
}
