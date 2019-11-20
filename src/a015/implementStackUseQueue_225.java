package a015;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 225.
 * Implement Stack using Queues
 * Difficulty
 * Easy

 * Implement the following operations of a stack using queues.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * Example:
 *
 * MyStack stack = new MyStack();
 *
 * stack.push(1);
 * stack.push(2);
 * stack.top();   // returns 2
 * stack.pop();   // returns 2
 * stack.empty(); // returns false
 * Notes:
 *
 * You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
 * Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
 * You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 */
public class implementStackUseQueue_225 {
    class MyStack {

        Deque<Integer> q1 = new ArrayDeque<>();
        Deque<Integer> q2 = new  ArrayDeque<>();
        /** Initialize your data structure here. */
        public MyStack() {

        }

        /** Push element x onto stack. */
        public void push(int x) {
           q1.offer(x);

        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            if(q1.size() == 0){
                return 0;
            }
            while(q1.size() > 1){
                q2.offer(q1.poll());
            }
            int res = q1.poll();
            Deque<Integer> tmp = new ArrayDeque<>();
            tmp = q2;
            q2 = q1;
            q1 = tmp;

            return res;
        }

        /** Get the top element. */
        public int top() {
            if(q1.size() == 0){
                return 0;
            }
            while(q1.size() > 1){
                q2.offer(q1.poll());
            }
            int res = q1.poll();
            q2.offer(res);
            Deque<Integer> tmp = new ArrayDeque<>();
            tmp = q2;
            q2 = q1;
            q1 = tmp;
            return res;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return q1.isEmpty() && q2.isEmpty();

        }
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
}
