package DSA.StackQueue.Easy;

public class MinStack {
    class MinStackNode
    {
        int data;
        MinStackNode next;
        MinStackNode(int a)
        {
            data = a;
            next = null;
        }
    }
    MinStackNode front;
    MinStackNode rear;

        public void push(int val) {
            MinStackNode newNode = new MinStackNode(val);
            if(front == null){
                rear = front = newNode;
            } else {
                if(front.data>=val){
                    newNode.next = front;
                    front = newNode;
                }
                MinStackNode i = front;
                while(i!= null && i.next)
            }

        }

        public void pop() {
            if(front == null) return;
            MinStackNode minStackNode = front;
            front = front.next;
            minStackNode.next = null;
        }

        public int top() {
            return front.data;
        }

        public int getMin() {

        }

}
