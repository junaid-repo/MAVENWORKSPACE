package recordTab;

//</PACKAGE-NAME>

//<IMPORT-BLOCK>
import java.io.*;
import java.lang.*;
import java.lang.reflect.*;
import java.util.*;
//</IMPORT-BLOCK>

//</CLASS-DEFINATION>
public class TRECORDTAB extends IIMSListBase implements Serializable
{
/**
*
*/
public TRECORDTAB()
{
  //do nothing
}//TRECORDTAB

/**
*
* @param objIp
*/
public TRECORDTAB(Object objIp)
{
  this.extend(1);
  if (objIp != null) super.set(1, (String)objIp);
}//TRECORDTAB

/**
*
* @param intIndex
* @param lngValue
*/
public void set(int intIndex, long lngValue)
{
  this.set((long)intIndex, OracleFunc.to_char(lngValue));
}//set

/**
*
* @param lngIndex
* @param lngValue
*/
public void set(long lngIndex, long lngValue)
{
  this.set(lngIndex, OracleFunc.to_char(lngValue));
}//set

/**
*
* @param intIndex
* @param dblValue
*/
public void set(int intIndex, double dblValue)
{
  this.set((long)intIndex, OracleFunc.to_char(dblValue));
}//set

/**
*
* @param lngIndex
* @param dblValue
*/
public void set(long lngIndex, double dblValue)
{
  this.set(lngIndex, OracleFunc.to_char(dblValue));
}//set

//get methods start*******************************************************
/**
*
* @param lngIndex
* @return
* @throws  IndexOutOfBoundsException
*/
public String getVal(long lngIndex) throws IndexOutOfBoundsException
{
  if (!verifyIndexWithinBoundary(lngIndex)) throw new IndexOutOfBoundsException("Index is out of range.");
  return (String)super.get((int)--lngIndex);
}//get

/**
*
* @param intIndex
* @return
* @throws  IndexOutOfBoundsException
*/
public String getVal(int intIndex) throws IndexOutOfBoundsException
{
  return this.getVal((long)intIndex);
}//get

}//TRECORDTAB
//</CLASS-DEFINATION>