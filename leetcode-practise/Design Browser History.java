//1472. Design Browser History
//https://leetcode.com/problems/design-browser-history/description/
//Leetcode daily Challenge - 18/3/2023

class BrowserHistory {
    DLL head;
    DLL ptr;
    DLL forward;
    DLL back;
    public BrowserHistory(String homepage) {
        head = new DLL(homepage);
        forward = head;
        back = head;
        ptr = head;
    }
    
    public void visit(String url) {
        DLL newVisit = new DLL(url);
        ptr.next = newVisit;
        newVisit.back = ptr;
        ptr = newVisit;
    }
    
    public String back(int steps) {
        int count = 0;
        while(count < steps && ptr != head){
            ptr = ptr.back;
            count++;
        }
        return ptr.val;
    }
    
    public String forward(int steps) {
        int count = 0;
        while(count < steps && ptr != null && ptr.next != null){
            ptr = ptr.next;
            count++;
        }
        return ptr.val;
    }
}

class DLL {
    String val;
    DLL next;
    DLL back;
    public DLL(String val){
        this.val = val;
        this.next = null;
        this.back = null;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
