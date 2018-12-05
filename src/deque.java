
import java.util.ArrayList;
import java.util.List;

public class deque<T> {
    private List<T> deque = new ArrayList<T>();

    public void setDeque(List<T> deque) {
        this.deque = deque;
    }
    
    public void push_front(T item){
        //adds element at the start of the queue
        deque.add(0,item);
    }
     
    public void push_back(T item){
        //adds element at the back of the queue
        deque.add(item);
    }
     
    public void pop_front(){
        if(deque.isEmpty()){
            return;
        }
        //removes an item from the start of the queue
        T rem = deque.remove(0);
    }
    
    public boolean empty(){
        return deque.isEmpty();
    }
    
    public void pop_rear(){
        if(deque.isEmpty()){
            return;
        }
        //removes an item from the start of the queue
        T rem = deque.remove(deque.size()-1);
    }
     
    public T front(){
        //element from the front without removing it
        T item = deque.get(0);
        return item;
    }
     
    public T peakRear(){
        //element from the back without removing it
        T item = deque.get(deque.size()-1);
        return item;
    }
       
    public List<T> getList(){
        return deque;
    }
    
    public void erase(int idx){
        deque.remove(idx);
    }
}
