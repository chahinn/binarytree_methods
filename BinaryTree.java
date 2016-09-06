import java.util.*;
import java.util.Queue;

public class BinaryTree<E> {

  protected E data;
  protected BinaryTree<E> left,right;

  BinaryTree(){
    data = null;
    left = right = null;
  }

  BinaryTree(E item){
    data = item;
    left = new BinaryTree<E>();
    right = new BinaryTree<E>();
  }

  BinaryTree(E item, BinaryTree<E> left, BinaryTree<E> right)
  {
    data = item;
    this.left = left;
    this.right = right;
  }

  public E getData(){
    return data;
  }

  public BinaryTree<E> getLeft(){
    return left;
  }

  public BinaryTree<E> getRight(){
    return right;
  }

  public void setData(E obj){
    data=obj;
  }

  public void setLeft(BinaryTree<E> tree){
      left = tree;
  }

  public void setRight(BinaryTree<E> tree){
      right = tree;
  }

  public boolean isEmpty(){
    return left == null;
  }

  public boolean isLeaf(){
    return !isEmpty() && left.isEmpty() && right.isEmpty();
  }

  public int nodeCount(){
      if(isEmpty())
   return 0;
      else
   return 1 + left.nodeCount()+right.nodeCount();
  }

  public int leafCount(){
     
    if(data == null){
      return 0;
    }
     if (isLeaf()){ 
       return 1;
     }
  return left.leafCount() + right.leafCount();
  
  }

  public BinaryTree<E> mirrorImage(){
     
    BinaryTree<E> left = null, right = null;
        if (this.left != null) {
            left = this.left.mirrorImage();
        }
        if (this.right != null) {
            right = this.right.mirrorImage();
        }
        return new BinaryTree<E>(this.data, right, left);
  }

  public int height(){
    
    
    if (isLeaf()) 
   return 0;
    if (isEmpty())
      return -1;
  else {
   int p = 0;
   if (left != null) 
    p = Math.max(p, left.height());
   if (right != null) 
    p = Math.max(p, right.height());
   return p+1;      // inner: one higher than highest child
  }
     //return 0;
     
  }

  public int levelCount(int level){
     if (data == null || level < 0) {
    return 0;
  }
  if (level == 0) {
    return 1;
  }
  else {
    return this.getRight().levelCount(level-1) + this.getLeft().levelCount(level-1);
  } 
  }

  public int weightBalanceFactor(){
    if(data == null){
      return 0;
    }
    int tWeight = Math.abs(left.nodeCount() - right.nodeCount());
    return tWeight;
  }



  public int nodeSum(){
    
     
    if (data == null){
      return 0;
    }
    else{
    int tInt = Integer.parseInt(getData().toString());
    return tInt + left.nodeSum() + right.nodeSum(); 
    }
  }

  public void doubles(){
    
  if (data== null){
    data = data;
  }
  else{
   int tInt = Integer.parseInt(getData().toString());
   tInt *= 2;
   this.data = (E) Integer.toString(tInt);
   left.doubles();
   right.doubles();
  }
  }

  public int maxPathSum(){
     
    if (data == null){
      return 0;
    }
    else{
     int tInt = Integer.parseInt(getData().toString());
  return Math.max(tInt + left.maxPathSum(), tInt + right.maxPathSum());
    }
  }

  public String preOrder(){
     
   String returnValue = "";
    if (data == null){
      return "";
    }
    returnValue += ""+this.getData();
    if (this.getLeft() != null){
    returnValue += " "+this.getLeft().preOrder();
    }
    if (this.getRight() != null){
    returnValue += ""+this.getRight().preOrder();
    }
    return returnValue;
  }

  public String inOrder(){
     
    String returnValue = "";
    if (data == null){
      return "";
    }
    if (this.getLeft() != null){
    returnValue += ""+this.getLeft().inOrder();
    }
    returnValue += ""+this.getData();
    if (this.getRight() != null){
    returnValue += " "+this.getRight().inOrder();
    }
    return returnValue;
  }

  public String postOrder(){
     
    String returnValue = "";
    if (data == null){
      return "";
    }
    if (this.getLeft() != null){
    returnValue += ""+this.getLeft().postOrder();
    }
    if (this.getRight() != null){
    returnValue += ""+this.getRight().postOrder();
    }
    returnValue += " "+this.getData();
    return returnValue;
  }
  
  
  
  
  
  
  
  
  
  

  public String levelOrder(){
     
    if(isEmpty()) 
      return null;
    Queue<BinaryTree> q= new LinkedList<BinaryTree>();
    q.add(this);
    String output="";
    while(!q.isEmpty()){
      BinaryTree p= q.remove();
      output+=p.data.toString()+" ";
      System.out.println(p.data.toString());
      if(!p.left.isEmpty()) q.add(p.left);
      if(!p.right.isEmpty()) q.add(p.right);
    }
 
    return output;
    
    
    }
    

     
     
    

  public String toString( String indent ) {
    if(isEmpty())
      return "";
    else
      return right.toString( indent + "   " ) + "\n" +
       indent + "/\n" +
       indent + data + "\n" +
       indent + "\\" +
       left.toString( indent + "   ");
  }

  public String toString() {
      return toString("");
  }
}
