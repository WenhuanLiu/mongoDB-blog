package com.chuwa.mongoDBblog.exception;

import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.chuwa.mongoDBblog.exception.ResourceNotFoundException;
/**
 * @ClassName ResourceNotFoundException
 * @Description TODO
 * @Author wenhu
 * @Date 6/24/2022 4:46 PM
 * @Version 1.0
 **/
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    private String resourceName;
    private String fieldName;
    private ObjectId fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName, ObjectId fieldValue) {
        //post not found with id: "1"
        super(String.format("% not  found with %s : '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public ObjectId getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(ObjectId fieldValue) {
        this.fieldValue = fieldValue;
    }
}
