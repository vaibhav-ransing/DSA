public  class firstClass{

    private static class Node{
        int data;
        Node next;

    }
    private static class LinkedList{
        Node head;
        Node tail;
        int size;
        int size(){
            return size;
        }

        void addLast(int val){
            Node n = new Node();
            n.data = val;
            if(size==0){
                tail=head=n;
                size++;
            }else{
                tail.next = n;
                tail = n;
                size++;
            }
        }
        public void addAt(int idx, int val){
            // write your code here
            Node n = new Node();
            n.data = val;
            if(idx<0 || idx>size){
              System.out.println("Invalid arguments");
              return;
            }
            if(idx==0){
                n.next = head;
                head =n;
      
            }else if(idx==size){
              addLast(val);
            }
            else{
                Node temp = head;
                while(idx!=1){
                    temp = temp.next;
                    idx--;
                }
                Node tempNext = temp.next;
                temp.next = n;
                n.next =tempNext;
            }
            size++;
          }
          public void removeLast(){
            // write your code here
            if(size==0){
                System.out.println("List is empty");
            }else{
                Node temp = head;
                while(temp.next!=tail){
                    temp = temp.next;

                }
                temp.next = null;
                tail = temp;
                size--;
            }
          }
        void display(){
            Node temp = this.head;
            while(temp!=null){
                System.out.print(temp.data+" ");
                temp= temp.next;
            }
            System.out.println();
        }
        public void addFirst(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = head;
            head = temp;
      
            if (size == 0) {
              tail = temp;
            }
      
            size++;
          }

        // isse k-reverse ho gaya but next time l1.addFist() and l1.addLast() karne pe alag hi linkedlist ban rahi hai 
        public void kReverse(int k) {
            LinkedList prev = new LinkedList();
      
            while(size>0){
                LinkedList curr = new LinkedList();
                if(this.size>=k){
                    int n =k;
                    while(n!=0){
                        curr.addFirst(this.head.data);
                        head = head.next;
                        size--;
                        n--;
                    }
                }else{
                    int n =k;
                    while(n!=0 && this.head!=null){
                        curr.addLast(this.head.data);
                        head = head.next;
                        size--;
                        n--;
                    }
                }
                if(prev.head==null){
                  prev.head = curr.head;
                  prev.tail = curr.tail;
                }else{
                  prev.tail.next = curr.head;
                  prev.tail = curr.tail;
                }
            }
              this.head = prev.head;
              this.tail = prev.tail;
              this.size = prev.size;
        }
        // public void kReverse(int k) {
        //     // write your code here
        //     LinkedList prev = null;
        //     LinkedList curr = new LinkedList();
      
        //     while(this.size() > 0){
        //         if(this.size() < k){
        //           int sz = this.size();
      
        //           for(int i = 0; i < sz; i++){
        //               int val = this.getFirst();
        //               this.removeFirst();
        //               curr.addLast(val);
        //           }
        //         } else {
        //           for(int i = 0; i < k; i++){
        //               int val = this.getFirst();
        //               this.removeFirst();
        //               curr.addFirst(val);
        //           }
        //         }
      
      
        //         if(prev == null){
        //             prev = curr;
        //             curr = new LinkedList();
        //         } else {
        //             prev.tail.next = curr.head;
        //             prev.tail = curr.tail;
        //             prev.size += curr.size;
        //             curr = new LinkedList();
        //         }
        //     }
      
        //     this.head = prev.head;
        //     this.tail = prev.tail;
        //     this.size = prev.size;
        //   }
        

        //  Self written please review
        public void dataRecursiveHelper(Node n , int s){
            if(n==null)
                return;
            dataRecursiveHelper(n.next, s+1);
            
            if(size/2>=s){
                return;
            }else{
                int temp = head.data;
                head.data = n.data;
                n.data = temp;
                head = head.next;
            }
        }
        public void dataRecursive(){
            Node h = head;
            dataRecursiveHelper(this.head, 0);
            this.head = h;
        }
        
        public boolean palRec(Node n, int s, boolean ans){
            if(n==null)
                return ans;
            boolean res = palRec(n.next, s+1, ans);
            if(size/2>=s){
                return ans;
            }
            if(res==false){
                return false;
            }
            else{
                if(head.data!=n.data){
                    ans = false;
                }
                head = head.next;
                return ans;
            }
        }
        public boolean IsPalindrome() {
          Node temp = head;
          boolean ans = true;
          ans = palRec(head, 0 , ans);
          head = temp;
          return ans;
        }

        // add linked list
        public static int carry=0;
        public static void addLLhelper(Node one, Node two){
            if(one==null && two==null)
                return;
            if(one!=null && two!=null)
                addLLhelper(one.next, two.next);
            else if(one!=null && two==null)
                addLLhelper(one.next, two);
            else if(one==null && two!=null)
                addLLhelper(one, two.next);
            
            int sum=0;
            if(one!=null && two!=null)
                sum = carry+one.data+two.data;
            else if(one==null && two!=null)
                sum = carry+two.data;
            else if(one!=null && two==null)
                sum = carry+one.data;

            carry = sum/10;
            if(sum%10==0){
                sumLL.addLast(sum);
            }else{
                sumLL.addLast(sum%10);
            }
        }
        public static LinkedList sumLL;
        public static LinkedList addTwoLists(LinkedList one, LinkedList two) {
            // write your code here
             sumLL = new LinkedList();
             addLLhelper(one.head, two.head);
            return sumLL;   
        }
        public int stopIdx;
        public void foldHelper(Node n, int pos){
            if(n==null)
                return;
            foldHelper(n.next, pos+1);
            
            if(size/2<=stopIdx)
                return;
            if(pos==size){
                int idx = 1;
                int val = this.tail.data;
                stopIdx = 1;
                this.addAt(idx, val);
                this.removeLast();
            }else{
                int idx = size-pos+2;
                int val  = this.tail.data;
                stopIdx = idx;
                this.addAt(idx, val);
                this.removeLast();
            }
        }
        public void fold() {
            Node h = head;
            foldHelper(h, 1);
        }

        public static int findIntersection(LinkedList one, LinkedList two){
            Node tempOne = one.head;
            Node tempTwo = two.head;
            if(one.size>two.size){
                int size1 = one.size;
                while(size1!=two.size){
                    one.head = one.head.next;
                    size1--;
                }
            }else{
                int size2 = two.size;
                while(size2!=two.size){
                    two.head = two.head.next;
                    size2--;
                }
            }
            int val = Integer.MAX_VALUE;
            while(one!=null && two!=null){
                if(one.head.data == two.head.data){
                    val = one.head.data;
                    break;
                }
                one.head = one.head.next;
                two.head = two.head.next;
            }
            one.head = tempOne;
            two.head = tempTwo;
            return val;
            
          }

    }

    public static void main(String[] args) {
        // LinkedList l = new LinkedList();
        // l.addLast(10);
        // l.addLast(20);
        // l.addLast(30);
        // l.addLast(40);
        // l.addLast(50);
        // l.addLast(60);
        // l.addLast(70);
        // // l.addLast(80);
        // l.display();
        // l.dataRecursive();

        // l.display();
        System.out.println(10%10);
        
    }
}