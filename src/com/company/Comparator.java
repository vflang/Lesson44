package com.company;

/**
 * Created by Veronica Lang on 2/20/2018.
 */
public interface Comparator{
    int compare(Object firstObject, Object secondObject);
    //Returns a neg number if firstObject<secondObject;
    //Returns a pos number if firstObject>secondObject;
    //Returns 0 if firstObject = secondObject.
}
