class DinnerPlates {
    Map<Integer, Stack<Integer>> map;
    int cap, pushIndex, popIndex;

    public DinnerPlates(int capacity) {
        cap=capacity;
        map=new HashMap<>();
        pushIndex=0;
        popIndex=0;
        map.put(pushIndex, new Stack<>());
    }
    
    public void push(int val) {
        while(map.containsKey(pushIndex) && map.get(pushIndex).size()==cap)
            pushIndex++;
        if(!map.containsKey(pushIndex))
            map.put(pushIndex, new Stack<>());
        map.get(pushIndex).push(val);
        popIndex=Math.max(popIndex, pushIndex);
    }
    
    public int pop() {
        if(map.size()==0)
            return -1;
        while(popIndex>=0 && map.get(popIndex).size()==0)
            popIndex--;
        if(popIndex==-1)
            return -1;
        pushIndex=Math.min(pushIndex, popIndex);
        return map.get(popIndex).pop();
    }
    
    public int popAtStack(int index) {
        if(map.size()<index+1 || map.get(index).size()==0)
            return -1;
        pushIndex=Math.min(pushIndex, index);
        return map.get(index).pop();
    }
}

/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAtStack(index);
 */