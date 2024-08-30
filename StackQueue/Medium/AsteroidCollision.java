package DSA.StackQueue.Medium;

import java.util.Stack;

public class AsteroidCollision {
    /// previous solution
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int i =0; i<asteroids.length; i++){
            if(!st.isEmpty() && colliding(st.peek(), asteroids[i])){
                while(!st.isEmpty() && colliding(st.peek(), asteroids[i]) && st.peek()<(asteroids[i]*(-1))) st.pop();
                if(!st.isEmpty() && colliding(st.peek(), asteroids[i]) && st.peek()==(asteroids[i]*(-1))){
                    st.pop();
                    continue;
                }
                else if(!st.isEmpty() &&
                        (nonColliding(st.peek(), asteroids[i]) || isSameDir(st.peek(), asteroids[i]))) st.push(asteroids[i]);
                else if(st.isEmpty()) st.push(asteroids[i]);

            }
            else st.push(asteroids[i]);
        }
        int[] ans = new int[st.size()];
        int index = st.size()-1;
        while(st.size()>0) ans[index--] = st.pop();
        return ans;
    }
    public boolean colliding(int peekAsteroids , int newAsteroids){
        return peekAsteroids>0 && newAsteroids<0;
    }
    public boolean isSameDir(int a1, int a2){
        return (a1>0 && a2>0) || (a1<0 && a2<0);
    }
    public boolean nonColliding(int peekAsteroids, int newAsteroids){
        return peekAsteroids<0 && newAsteroids>0;
    }

}
