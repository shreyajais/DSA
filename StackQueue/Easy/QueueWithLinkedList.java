package DSA.StackQueue.Easy;



public class QueueWithLinkedList {
    class QueueNode
    {
        int data;
        QueueNode next;
        QueueNode(int a)
        {
            data = a;
            next = null;
        }
    }
    class MyQueue
    {
        QueueNode front, rear;

        //Function to push an element into the queue.
        void push(int a)
        {
            if(front == null){
                front = rear = new QueueNode(a);
            }else {
                QueueNode qn = new QueueNode(a);
                rear.next = qn;
                rear = rear.next;
            }
        }

        //Function to pop front element from the queue.
        int pop()
        {
            QueueNode qn = front;
            if(front == rear){
                front = rear = null;
            } else {
                front = front.next;
            }
            return qn.data;
        }
    }

}
