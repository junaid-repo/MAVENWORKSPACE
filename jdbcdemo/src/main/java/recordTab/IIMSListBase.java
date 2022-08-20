package recordTab;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public abstract class IIMSListBase extends ArrayList
{
 //set methods start*******************************************************
 //set methods with 3 parameters start.
 protected Set deletedSet = new HashSet();

/**
 *
 * @param lngIndex
 * @param strKey
 * @param objValue
 * @param newMapBase
 * @throws  Exception
 */
 public void set(long lngIndex, String strKey, Object objValue, IIMSMapBase newMapBase) throws Exception
 {
  //validations.
  if (strKey == null || strKey.equals("")) throw new Exception("Invalid argument.");
  if (!this.verifyIndex(lngIndex)) return;

  lngIndex--;
  int intCurrentSize = this.size();
  if (lngIndex < intCurrentSize)
  {
   ((IIMSMapBase)this.get((int)lngIndex)).set(strKey, objValue);
   deletedSet.remove(new Long(lngIndex));
   return;
  }//if
  else
  {
   if (lngIndex > intCurrentSize)
   {
    for (long lngLooper = intCurrentSize; lngLooper < lngIndex; lngLooper++)
    {
     deletedSet.add(new Long(lngLooper));
     this.add(null);
    }//for
   }//if
   newMapBase.set(strKey, objValue);
   this.add(newMapBase);
   return;
  }//else
 }//set



/**
 *
 * @param lngIndex
 * @param strKey
 * @param strValue
 * @param newMapBase
 * @throws  Exception
 */
 public void set(long lngIndex, String strKey, String strValue, IIMSMapBase newMapBase) throws Exception
 {
  this.set(lngIndex, strKey, (Object)strValue, newMapBase);
 }//set

/**
 *
 * @param intIndex
 * @param strKey
 * @param strValue
 * @param newMapBase
 * @throws  Exception
 */
 public void set(int intIndex, String strKey, String strValue, IIMSMapBase newMapBase) throws Exception
 {
  this.set((long)intIndex, strKey, (Object)strValue, newMapBase);
 }//set



/**
 *
 * @param lngIndex
 * @param strKey
 * @param lngValue
 * @param newMapBase
 * @throws  Exception
 */
 public void set(long lngIndex, String strKey, long lngValue, IIMSMapBase newMapBase) throws Exception
 {
  this.set(lngIndex, strKey, new Long(lngValue), newMapBase);
 }//set

/**
 *
 * @param intIndex
 * @param strKey
 * @param lngValue
 * @param newMapBase
 * @throws  Exception
 */
 public void set(int intIndex, String strKey, long lngValue, IIMSMapBase newMapBase) throws Exception
 {
  this.set((long)intIndex, strKey, new Long(lngValue), newMapBase);
 }//set



/**
 *
 * @param lngIndex
 * @param strKey
 * @param dblValue
 * @param newMapBase
 * @throws  Exception
 */
 public void set(long lngIndex, String strKey, double dblValue, IIMSMapBase newMapBase) throws Exception
 {
  this.set(lngIndex, strKey, new Double(dblValue), newMapBase);
 }//set

/**
 *
 * @param intIndex
 * @param strKey
 * @param dblValue
 * @param newMapBase
 * @throws  Exception
 */
 public void set(int intIndex, String strKey, double dblValue, IIMSMapBase newMapBase) throws Exception
 {
  this.set((long)intIndex, strKey, new Double(dblValue), newMapBase);
 }//set
 //set methods with 3 parameters end.



 //set methods with 2 parameters start.
/**
 *
 * @param lngIndex
 * @param objValue
 */
 private void setPrivate(long lngIndex, Object objValue)
 {
  //validations.
  if (!this.verifyIndex(lngIndex)) return;

  lngIndex--;
  int intCurrentSize = this.size();
  if (lngIndex < intCurrentSize)
  {
   super.set((int)lngIndex, objValue);
   deletedSet.remove(new Long(lngIndex));
  }//if
  else
  {
   if (lngIndex > intCurrentSize)
   {
    for (long lngLooper = intCurrentSize; lngLooper < lngIndex; lngLooper++)
    {
     deletedSet.add(new Long(lngLooper));
     this.add(null);
    }//for
   }//if
   this.add(objValue);
   return;
  }//else
 }//set



/**
 *
 * @param intIndex
 * @param strValue
 */
 public void set(int intIndex, String strValue)
 {
  this.set((long)intIndex, strValue);
 }//set

/**
 *
 * @param lngIndex
 * @param strValue
 */
 public void set(long lngIndex, String strValue)
 {
  if ( strValue == null || strValue.equals("null") )
  {
   strValue = "";
  }
  this.setPrivate(lngIndex, strValue);
 }//set



/**
 *
 * @param intIndex
 * @param lngValue
 */
 public void set(int intIndex, long lngValue)
 {
  this.setPrivate((long)intIndex, new Long(lngValue));
 }//set

/**
 *
 * @param lngIndex
 * @param lngValue
 */
 public void set(long lngIndex, long lngValue)
 {
  this.setPrivate(lngIndex, new Long(lngValue));
 }//set



/**
 *
 * @param intIndex
 * @param dblValue
 */
 public void set(int intIndex, double dblValue)
 {
  this.setPrivate((long)intIndex, new Double(dblValue));
 }//set

/**
 *
 * @param lngIndex
 * @param dblValue
 */
 public void set(long lngIndex, double dblValue)
 {
  this.setPrivate(lngIndex, new Double(dblValue));
 }//set
 //set methods with 2 parameters end.
 //set methods end*******************************************************



 //get methods start*******************************************************
/* public Object get(long lngIndex) throws IndexOutOfBoundsException
 {
  if (!verifyIndexWithinBoundary(lngIndex)) throw new IndexOutOfBoundsException("Index is out of range.");
  return super.get((int)--lngIndex);
 }//get

 public Object get(int intIndex)
 {
  return this.get((long)intIndex);
 }//get
*/ //get methods end*******************************************************



 //getCount methods start*******************************************************
 public long getCount()
    {
        if(this != null)
         return this.size() - this.deletedSet.size();
        else
         return 0;
    }//getCount
 //getCount methods end*******************************************************



 //extend methods start*******************************************************
 public void extend()
 {
  this.extend(1L, 0L, false);
 }//extend

 public void extend (long lngNoOfCopies)
 {
  this.extend(lngNoOfCopies, 0L, false);
 }//extend

 public void extend (int intNoOfCopies)
 {
  this.extend((int)intNoOfCopies, 0L, false);
 }//extend

 public void extend (long lngNoOfCopies, long lngIndexElement)
 {
  this.extend(lngNoOfCopies, lngIndexElement, true);
 }//extend

 public void extend (int intNoOfCopies, long lngIndexElement)
 {
  this.extend(intNoOfCopies, lngIndexElement, true);
 }//extend

 public void extend (long lngNoOfCopies, int intIndexElement)
 {
  this.extend(lngNoOfCopies, intIndexElement, true);
 }//extend

 public void extend (int intNoOfCopies, int intIndexElement)
 {
  this.extend(intNoOfCopies, intIndexElement, true);
 }//extend

 protected void extend (long lngNoOfCopies, long lngIndexElement, boolean isCopyData)
 {
  if (!this.verifyIndex(lngNoOfCopies) || !this.verifyIndex(this.getCount() + lngNoOfCopies)) return;
  if (isCopyData == true )
  {
   if (!this.verifyIndexWithinBoundary(lngIndexElement)) return;
  }//if
        Object RefCodeForCopying = null;
        lngIndexElement--;
  if ( isCopyData == true ) RefCodeForCopying = this.get((int)lngIndexElement);
        long lngActualSize = this.getActualCount();
  for (long lngIndex = lngActualSize; lngIndex < lngActualSize + lngNoOfCopies; lngIndex++ )
  {
   this.add(RefCodeForCopying);
  }//for
 }//extend
 //extend methods end*******************************************************



 //delete methods start*******************************************************
 public void delete (long lngStartIndex, long lngEndIndex)
 {
  for ( long lngIndex = lngStartIndex; lngIndex <= lngEndIndex; lngIndex++)
  {
   delete(lngIndex);
  }//for
 }//delete

 public void delete (long lngIndex) throws IndexOutOfBoundsException
 {
  if (!verifyIndexWithinBoundary(lngIndex)) return;
  this.deletedSet.add(new Long(--lngIndex));
 }//delete

 public void delete ()
 {
  this.clear();
  this.deletedSet.clear();
 }//delete
 //delete methods end*******************************************************



 //exists methods start*******************************************************
 public boolean exists(long lngIndex)
 {
  if (!verifyIndexWithinBoundary(lngIndex)) return false;
  if ( this.deletedSet.contains(new Long(--lngIndex) )) return false;
  return true;
 }//exists
 //exists methods end*******************************************************

 //protected methods start*******************************************************
 protected boolean verifyIndex(long lngIndex)
 {
  if ( lngIndex <= 0 || lngIndex > (long)Integer.MAX_VALUE ) return false;
  else return true;
 }//verifyIndex

 protected boolean verifyIndexWithinBoundary(long lngIndex)
 {
  if (!verifyIndex(lngIndex) || lngIndex > this.size()) return false;
  return true;
 }//verifyIndexWithinBoundary
 //protected methods end*******************************************************

    protected long getActualCount()
    {
        return this.size();
    }//getCount

 public long first() throws IndexOutOfBoundsException
 {
  for ( int intArrIndex = 0; intArrIndex < this.size(); intArrIndex++)
  {
   if ( !deletedSet.contains(new Long(intArrIndex) ) )
   {
    return (long)(intArrIndex + 1) ;
   }
  }
  return Long.MIN_VALUE;
 }//first

 public long last() throws IndexOutOfBoundsException
 {
  for ( int intArrIndex = this.size()-1; intArrIndex >= 0; intArrIndex--)
  {
   if ( !deletedSet.contains(new Long(intArrIndex) ) )
   {
    return (long)(intArrIndex + 1);
   }
  }
  return Long.MIN_VALUE;
 }//last

 public long next(long lngIndex) throws IndexOutOfBoundsException
 {
  if (!verifyIndexWithinBoundary(lngIndex)) return Long.MIN_VALUE;

  for ( long intArrIndex = lngIndex ; intArrIndex < (long)this.size(); intArrIndex++)
  {
   if ( !deletedSet.contains(new Long(intArrIndex) ) )
   {
    return (long)(intArrIndex + 1);
   }
  }
  return Long.MIN_VALUE;
 }//first

 public Object[] toArray()
 {
  Object[] objArr = super.toArray();
  if (objArr == null) return new Object[0];
  Object[] objArrOut = new Object[(int)this.getCount()];
  int intIndexOut = 0;

  for (int intIndex = 0; intIndex < objArr.length; intIndex++)
  {
   if (!deletedSet.contains(new Long(intIndex)))
   {
    objArrOut[intIndexOut] = objArr[intIndex];
    intIndexOut++;
   }//if
  }//for

  return objArrOut;
 }//toArray

}//IIMSListBase"
