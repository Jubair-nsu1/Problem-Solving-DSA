package Solution;

import java.util.*;

/*-------------------------------------------Singly Linked List---------------------------------------------------------*/
class SinglyLinkedList{

    public static class Node{
        int data;
        Node next;
    }
    
    static Node head; // Declare head node globally
    
    /*-------------------------------------Function to insert a Node at the beginning------------------------*/
    public static void insert_front(int new_data) {
        Node new_node = new Node();
        new_node.data = new_data;
        new_node.next = head;
        head = new_node;
    }

    /*-------------------------------------Function to insert a Node at the end------------------------*/
    public static void insert_end(int new_data){
     
        Node new_node = new Node();
        new_node.data = new_data;
        new_node.next = null;

        Node tail=head;

        if(head == null){
            head = new_node;
            tail = new_node;            
        }
        else{
            while(tail.next != null){
                tail = tail.next;
            }
            tail.next= new_node;
            tail = new_node;
        }
    }

    /*-------------------------------------Function to insert a Node at Nth position------------------------*/
    public static void insert(int data, int location){
        Node new_node = new Node();
        new_node.data = data;
        
        if(location == 1){
            new_node.next =null;
            head = new_node;
            return;
        }

        Node temp=head;

        for(int i=1 ;i<location-1;i++ ){
            temp = temp.next;
        }
        new_node.next = temp.next;   // new node in (location) connects with next node(location+1)
        temp.next = new_node;        // previous node (location-1) connects with new node (location)         
    }

    /*-------------------------------------Function to Delete a Node by position------------------------*/
    public static void delete(int location){
        Node temp1= head;

        if(location==1){
            head.next = temp1;
            return;
        }

        for(int i=1; i<location-1;i++){
            temp1= temp1.next;
        }
        
        Node temp2;
        temp2 = temp1.next;  
        temp1.next = temp2.next;    
    }

    /*-------------------------------------Function to Delete a Node by value------------------------*/
    public static void deleteByValue(int data){
        Node temp =head;
        
        if(data == temp.data){
            head = temp.next; 
            return;
        }

        while(temp.next != null){
            Node ptr = temp;
            if(data == temp.data){
                Node temp2= temp.next;
                ptr.next = temp2.next;
            }
        }
    }

    /*-------------------------------------Function to Remove Duplicates------------------------*/
    public static void removeDuplicate(){

        // Hash to store seen values
        HashSet<Integer> set = new HashSet<>();
        Node current = head;
        Node prev = null;

        while(current != null){
            if(set.contains(current.data)){
                prev.next = current.next;
            }
            else{
                set.add(current.data);
                prev = current;
            }
            current=current.next;
        }

    }

    /*-------------------------------------Function to Reverse a Linked List by Iteration------------------------*/
    public static void Reverse_Itr(){    
        Node current, prev,next;
        prev = null;
        current = head;

        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;            
        }
        head =prev;
    }

    /*-------------------------------------Function to Reverse a Linked List by Recursion------------------------*/
    public static void Reverse_Rec(){}

    /*-------------------------------------Function to Print Linked List by Recursion------------------------*/
    public static void Print_Recursive(Node p){
        if(p == null){
            System.out.println("\n");;
            return;
        }
        System.out.println("List is:");
        System.out.println(p.data);
        Print_Recursive(p.next);
    }

    /*-------------------------------------Function to Print Linked List by Recursion------------------------*/
    public static void Print_Reverse(Node p){
        if(p == null){
            System.out.println("\n");;
            return;
        }
        Print_Reverse(p.next);
        System.out.println(p.data);;
    }


    /*------------------------------------- Function to Print Linked List ---------------------------------------*/
    public static void displayList(){
        Node ptr = head;   
     
        while(ptr != null){
            System.out.println("List is: "+ptr.data);
            ptr = ptr.next;
        }
        System.out.println("");
    }

}

/*-------------------------------------------Doubly Linked List---------------------------------------------------------*/
class DoublyLinkedList{

    public static class Node{
        int data;
        Node next;
        Node prev;
    }

    static Node head;

    static Node GetNewNode(int data){
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;
        newNode.prev = null;
        return newNode;
    }

    public static void InsertAtHead(int newdata){
        Node newNode = GetNewNode(newdata);
    
        if(head== null){
            head=newNode;
            return;
        }
        head.prev = newNode;
        newNode.next = head;
        head = newNode;
    }

    public static void InsertAtTail(int newdata){        
        Node temp = head;
        Node newNode = GetNewNode(newdata);

        if(head == null){
            head = newNode;
            return;
        }

        while(temp.next != null){
            temp= temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    public static void Reverse_Itr(){

    }

    public static void Reverse_Rec(){
        
    }

    public static void PrintReverse(){
        
    }

    public static void Print_Recursive(){
        
    }

    public static void Display(){
        Node temp = head;
        while(temp!= null){
            System.out.println(temp.data);    
            temp = temp.next;
        }
        System.out.println("");
    }
}

/*-------------------------------------------Stack Using Array----------------------------------------------------------*/
class Stack_Array{
    static int[] A = new int[20];
    static int top = -1; // Empty Stack

    public static void Push(int x){
        if(top == 20-1){
            System.out.println("Stack is full!\n");
            return;
        }
        top++;
        A[top]=x;
    }

    public static void Pop(){
        if(top==-1){
            System.out.println("Stack is Empty\n");
            return;
        }
        top--;
    }

    public static int Top(){
        return A[top];
    }

    public static void IsEmpty(){
        if(top==-1){
            System.out.println("Stack is Empty! \n");
        }
        else{
        System.out.println("Stack is Not Empty! \n");
        }
    }

    public static void DisplayStack(){
        
        for(int i=0;i<=top;i++){
            System.out.println("Stack: "+A[i]);
        }
        System.out.println("");
    }


}

/*-------------------------------------------Stack Using Linked List----------------------------------------------------*/
class Stack_LinkedList{
    public static class Node{
        int data;
        Node next;
    }
    
    static Node Top=null; // Declare head node globally
    
    public static void Push(int data){
        Node new_node = new Node();
        new_node.data = data;
        new_node.next = Top;
        Top = new_node;
    }

    public static void Pop(){
        Node temp =Top;
        if(Top ==null ){
            System.out.println("Stack is Empty!\n");
            return;
        }
        Top = temp.next;
    }

    public static void Top(){
        if(Top == null ){
            System.out.println("Stack is Empty!\n");
            return;
        }
        else{
            System.out.println("Top: "+Top.data);
        }
    }

    public static void IsEmpty(){
        if(Top == null){
            System.out.println("Stack is Empty!\n");
        }
        else{
            System.out.println("Stack is not Empty!\n");
        }
    }

    public static void DisplayStack(){
        Node temp = Top;
        while(temp!= null){
            System.out.println("Stack is: "+temp.data);
            temp = temp.next;
        }
        System.out.println("");
    }
    
}

/*-------------------------------------------Queue Using Array----(Problem in Enqueue)----------------------------------*/
class Queue_Array{
    
    static int[] A = new int[10];
    static int front =1;
    static int rear =1;
    
    public static void Enqueue(int data){
        if(IsFull()){
            System.out.println("Queue is Full!\n");
            return;
        }
        else if(IsEmpty()){
            front = rear = 0;
       //     A[rear]=data; 
        }
        else{
            rear= (rear+1)%10;            
        }
        A[rear] =data;        
    }

    public static void Dequeue(){
        if(IsEmpty()){
            System.out.println("Queue is Empty!\n");
            return;
        }
        else if(front==rear){
            front = rear = -1;            
        }
        else{
            front = (front+1)%10;
        }
    }

    public static void Front(){
        if(front==-1){
            System.out.println("Queue is Empty, no front!\n");
        }
        else{
            System.out.println("Front: "+A[front]);            
        }        
    }

    public static boolean IsEmpty(){
        if(front==-1 && rear == -1){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean IsFull(){
        if((rear+1)%10 == front){   
            return true;
        }
        else{
            return false;
        }
    }

    public static void PrintQueue(){
        System.out.print("Queue: ");
        for(int i=front;i<=rear;i++){
            System.out.print(A[i]+" ");
        }
        System.out.println("");    
    }
}

/*-------------------------------------------Queue Using Linked List----------------------------------------------------*/
class Queue_LinkedList{
    static class Node{
        int data;
        Node next;
    }

    static class BstNode{
        Node root;
        Node next;
    }

    static Node front=null;
    static Node rear=null;

    public static void Enqueue(int data){
        Node temp = new Node();
        temp.data=data;
        temp.next=null;
        if(front==null && rear==null){
            front=rear=temp;
            return;
        }
        rear.next= temp;
        rear=temp;
    }


    public static void Dequeue(){
        Node temp =front;
        if(front==null && rear==null){
            System.out.println("Queue is Empty!\n");
            return;
        }
        else{
            front = temp.next;
        }        
    }

    public static void Front(){
        if(front==null && rear==null){
            System.out.println("Queue is Empty!\n");
            return;
        }
        else{
            System.out.println("Front: "+front.data);
        }
    }

    public static void IsEmpty(){
        if(front==null && rear==null){
            System.out.println("Queue is Empty!\n");            
        }
        else{
            System.out.println("Queue is not Empty!\n");
        }        
    }

    public static void DisplayQueue(){
        Node temp= front;
        System.out.print("Queue: ");
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

}

/*-------------------------------------------Binary Search Tree(BST)----------------------------------------------------*/
class BST{ 
    static class BstNode{
        int data;
        BstNode left;
        BstNode right;
    }

    public BstNode root=null;;

    //Creating New Node
    static BstNode GetNewNode(int data){
        BstNode newNode = new BstNode();
        newNode.data = data;
        newNode.left = null;
        newNode.right = null;
        return newNode;    
    }

    //Inserting New Node Using Recursion
    public static BstNode Insert(BstNode root, int data){
        if(root==null){
            root = GetNewNode(data);
        }
        else if(data <= root.data){
            root.left = Insert(root.left,data);
        }
        else{
            root.right = Insert(root.right,data);
        }
        return root;
    }

    //Search any node using Recursion
    public static boolean Search(BstNode root, int data){
        if(root == null){
            return false;
        }
        else if(root.data == data){
            return true;
        }
        else if( data <= root.data){
            return Search(root.left, data);
        }
        else{
            return Search(root.right, data);
        }
    }

    public BstNode FindMin(BstNode root){
        BstNode current = root;

        while(current.left != null){
            current = current.left;
        }
        return current;
    }

    //Finding minimum element of BST using Iteration
    public int FindMinItr(BstNode root){
        if(root ==null){
            System.out.println("Empty Tree!");
            return -1;
        }
        BstNode current = root;

        while(current.left != null){
            current = current.left;
        }
        return current.data;
    }

    //Finding minimum element of BST using Recursion
    public int FindMinRec(BstNode root){
        if(root ==null){
            System.out.println("Empty Tree!");
            return -1;
        }
        else if(root.left ==null){
            return root.data;
        }
        else{
            return FindMinRec(root.left);
        }
    }    

    //Finding maximum element of BST using Iteration
    public int FindMax(BstNode root){
        if(root ==null){
            System.out.println("Empty Tree!");
            return -1;
        }

        while(root.right != null){
            root= root.right;
        }
        return root.data;
    }

    //Delete a Node in BST
    public BstNode Delete(BstNode root, int data){
        if(root ==null){
            return root;
        }
        else if(data<root.data){
            root.left = Delete(root.left,data);
        }
        else if(data>root.data){
            root.right = Delete(root.right, data);
        }
        else{
            //case1: If no child 
            if(root.left ==null && root.right==null){
       //       delete root;
                root=null;
                return root;
            }
            //case2: If one child
            else if(root.left ==null){
                BstNode temp = root;
                root = root.right;
      //        delete temp;
                temp =null;
            }
            else if(root.right ==null){
                BstNode temp = root;
                root = root.left;    
      //        delete temp;
                temp =null;
            }
            //case3: Two child
            else{
                BstNode temp = FindMin(root.right);
                root.data = temp.data;
                root.right = Delete(root.right, temp.data);
            }

        }
        return root;
    }   

    //Tree Traversal using Breath-First-Strategy OR Level Order Traversal
    public void BFS(BstNode root){
        if(root == null){
            return;    
        }        
        Queue<BstNode> q = new LinkedList<>();
        q.add(root);
        
        //While there is atleast one discovered node
        while(!q.isEmpty()){ 
            BstNode current = q.peek();
            System.out.println(current.data);
            if(current.left != null){
                q.add(current.left);
            }
            if(current.right != null){
                q.add(current.right);
            }   
            q.remove();
        }
    }

    //Tree Traversal using Depth-First-Strategy
    public static void Preorder(BstNode root){
        if(root == null){
            return;
        }
        System.out.println(root.data);
        Preorder(root.left);
        Preorder(root.right);
    }

    public static void Inorder(BstNode root){
        if(root == null){
            return;
        }
        Inorder(root.left);
        System.out.println(root.data);
        Inorder(root.right);        
    }

    public static void Postorder(BstNode root){
        if(root == null){
            return;
        }
        Postorder(root.left);
        Postorder(root.right);
        System.out.println(root.data);
    }



}

/*-------------------------------------------------Searching------------------------------------------------------------*/
class Searching{
    
    //Time complexity: O(n)
    public static void LinearSearch(int[] array, int element){
        int size = array.length;
        for(int i=0; i<size;i++){
            if(array[i] == element){
                System.out.println(element+" found at index "+i);
                return;
            }
        }
    }
    
    //Time complexity: O(log n)
    public static void BinarySearch(int[] array, int element){
        int size = array.length;
        int start= 0, end = size-1;
        
        while(start<=end){
            int mid = (start+end)/2 ;
            if(array[mid] == element ){
                System.out.println(element+" found at index "+mid);
                return;
            }
            else if(element<array[mid]){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        System.out.println("The element doesnot exist");
    }
}

/*--------------------------------------------------Sorting-------------------------------------------------------------*/
class Sorting{
  
    //Time Complexity: O(n^2)
    public static void SelectionSort(int[] arr){
        int size = arr.length;      
        for(int i=0; i<size-1; i++)
        {
            int Min = i;                      
            for(int j=i+1; j<size;j++)
            {
                if(arr[j] < arr[Min])
                {  
                  Min = j;
                }
            }            
            int temp = arr[i];
            arr[i] = arr[Min];
            arr[Min] = temp;
        }
    }



    //------------------------------------------------------------------------
    //Time Complexity: O(n^2)
    public static void BubbleSort(int[] A){
        int size = A.length;

        for(int i=0; i<size; i++)
        {
            for(int j=0; j<size-1;j++ )
            {
                if(A[j] > A[j+1])
                {
                    //swap
                    int temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp;
                }
            }
        }
    }


    //------------------------------------------------------------------------
    //Time Complexity: O(n^2)
    public static void InsertionSort(int[] arr){
        int size = arr.length;

        for(int i=1;i<size;i++)
        {
            int key=arr[i];
            int j = i-1;

            while(j>=0 && arr[j]>key)
            {
                arr[j+1] = arr[j];
                j=j-1;
            }
            arr[j+1] = key; 
        }
    }



    //------------------------------------------------------------------------
    //Time Complexity of MergeSort: O(nlogn)

    //Merge Sort
    public static void MergeSort(int A[]){
        int ArraySize = A.length;
        if(ArraySize<2){
            return;
        }
        int mid = ArraySize/2;

        int[] left = new int[mid];
        int[] right = new int[ArraySize-mid];
        
        for(int i=0; i<mid ;i++){
            left[i] = A[i];
        }
        for(int i=mid; i<ArraySize ;i++){
            right[i-mid] = A[i];  
        }

        MergeSort(left);
        MergeSort(right);
        merge(left,right,A);
    }

        //Function for merging two array 
    static void merge(int Left[],int Right[],int A[]){
        int nL = Left.length;  //Left Array
        int nR = Right.length; //Right Array         

        // i->left , j->right , k->Array
        int i = 0;  
        int j = 0;
        int k = 0;

        while(i<nL && j<nR){
            if(Left[i] <= Right[j]){
                A[k] = Left[i];
                k++;
                i++;
            }
            else{
                A[k] = Right[j];
                k++;
                j++;
            }            
        }
        while(i<nL){
            A[k] = Left[i];
            i++;
            k++;
        }
        while(j<nR){
            A[k] = Right[j];
            j++;
            k++;
        }
    }



    //------------------------------------------------------------------------
    //Time Complexity of QuickSort: O(n^2)
    public static void QuickSort(int arr[], int start, int end)
    {
        if (start < end) 
        {            
            // pi is partitioning index, arr[p]
            // is now at right place 
            int pi = Partition(arr, start, end);
    
            // Separately sort elements before
            // partition and after partition
            QuickSort(arr, end, pi - 1);
            QuickSort(arr, pi + 1, end);
        }
    }   
    
    /* This function takes last element as pivot, places
       the pivot element at its correct position in sorted
       array, and places all smaller (smaller than pivot)
       to left of pivot and all greater elements to right
       of pivot */

    static int Partition(int arr[], int low, int high)
    {
        int pivot = arr[high];

        // Index of smaller element and indicates the right position
        // of pivot found so far
        int i = (low - 1); 

        for(int j = low; j <= high - 1; j++)
        {          
            // If current element is smaller 
            // than the pivot
            if (arr[j] < pivot) 
            {            
                // Increment index of 
                // smaller element
                i++; 
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    // A utility function to swap two elements
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    

    
    //------------------------------------------------------------------------
    //Time Complexity of HeapSort: O(nlogn)
    public static void HeapSort(int[] arr){
        int n = arr.length;
 
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
 
        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
 
            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }


    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    static void heapify(int arr[], int n, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2
 
        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;
 
        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;
 
        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
 
            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    
    //--------------------------------Print Sorted Array-----------------------------------
    public static void PrintArray(int[] arr){
        System.out.print("Sorted Array: ");
        for(int i=0; i<arr.length; i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

}

/*---------------------------------------------------Graph--------------------------------------------------------------*/
class Graph{

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

}


/*-------------------------------------------------Main Class-----------------------------------------------------------*/
public class Test {    
    public static void main(String[] args) {     

     
        Pow(2, 0);

    }    

    static void Pow(int num, int pow){
        int res = 1;

        for(int i=0; i<pow; i++){
            res = res * num;
        }

        System.out.println(res);
    }

    
    
}
