package com.example.kunnu;

public class question {
    private int ansId;
    private boolean ans;

    public question(int ansId,boolean ans) {
        this.ans = ans;
        this.ansId=ansId;
    }

    public int getAnsId() {
        return ansId;
    }

    public void setAnsId(int ansId) {
        this.ansId = ansId;
    }

    public boolean isAns() {
        return ans;
    }

    public void setAns(boolean ans) {
        this.ans = ans;
    }
}
